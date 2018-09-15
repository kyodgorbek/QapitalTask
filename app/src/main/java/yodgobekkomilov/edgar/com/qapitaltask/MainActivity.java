package yodgobekkomilov.edgar.com.qapitaltask;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import adapter.SavingsAdapter;
import pojo.SavingGoals;
import pojo.SavingsClient;
import pojo.SavingsGoal;
import pojo.SavingsInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
private List<SavingGoals> savingGoals;
SavingsAdapter adapter;
Context context;
GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SavingsInterface api = SavingsClient.getApiService();
        Call<List<SavingGoals>> call = api.getSavings();
        call.enqueue(new Callback<List<SavingGoals>>() {
            @Override
            public void onResponse(Call<List<SavingGoals>> call, Response<List<SavingGoals>> response) {
                savingGoals  = response.body();
                gridView = findViewById(R.id.grid_View);
                adapter = new SavingsAdapter(savingGoals, context );
                gridView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<SavingGoals>> call, Throwable t) {

            }
        });





    }
}
