package pojo;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface SavingsInterface {
    @GET("/savingsgoals")
    Single<SavingEndingPoint> getSavings();


}
