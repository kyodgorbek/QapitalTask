package pojo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SavingsClient {

    private static final String ROOT_URL = "https://qapital-ios-testtask.herokuapp.com";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static SavingsInterface getApiService() {
        return getRetrofitInstance().create(SavingsInterface.class);
    }
}


