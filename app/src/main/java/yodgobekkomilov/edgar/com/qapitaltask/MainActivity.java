package yodgobekkomilov.edgar.com.qapitaltask;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import adapter.SavingsAdapter;
import pojo.SavingEndingPoint;

import pojo.SavingsClient;
import pojo.SavingsGoal;
import pojo.SavingsInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
public ArrayList<SavingsGoal> savingGoals;
public SavingsAdapter adapter;
Context context;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SavingsInterface api = SavingsClient.getApiService();
        Call <SavingEndingPoint> call = api.getSavings();
        call.enqueue(new Callback<SavingEndingPoint>() {
            @Override
            public void onResponse(Call <SavingEndingPoint> call, Response <SavingEndingPoint> response) {

              savingGoals  = (ArrayList<SavingsGoal>) response.body().getSavingsGoals();
                recyclerView = findViewById(R.id.recycler_view);
                adapter = new SavingsAdapter( savingGoals);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<SavingEndingPoint> call, Throwable t) {

            }
        });





    }
}
