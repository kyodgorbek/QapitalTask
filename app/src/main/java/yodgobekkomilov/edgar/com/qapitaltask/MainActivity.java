package yodgobekkomilov.edgar.com.qapitaltask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import adapter.SavingsAdapter;
import database.SavingsRoomDatabase;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import pojo.SavingEndingPoint;
import pojo.SavingsClient;
import pojo.SavingsGoal;
import pojo.SavingsInterface;

public class MainActivity extends AppCompatActivity {
    public SavingsAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new SavingsAdapter(getBaseContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        SavingsInterface api = SavingsClient.getApiService();
        api.getSavings().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SavingEndingPoint>() {
                    @Override
                    public void accept(SavingEndingPoint savingEndingPoint) throws Exception {
                        SavingsRoomDatabase.getDatabase(MainActivity.this).savingsGoalDao().deleteAll();
                        for (SavingsGoal sg : savingEndingPoint.getSavingsGoals())
                            SavingsRoomDatabase.getDatabase(MainActivity.this).savingsGoalDao().insertAll(sg);
                        adapter.refreshData();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

    }
}
