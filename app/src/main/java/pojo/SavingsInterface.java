package pojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SavingsInterface {
    @GET("/savingsgoals")
    Call<SavingEndingPoint> getSavings();




}
