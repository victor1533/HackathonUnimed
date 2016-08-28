package br.com.lapps.hackathonunimed.model.webservice.retrofit;

import br.com.lapps.hackathonunimed.model.webservice.WebServiceConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Orochi on 27/08/2016.
 */
public class RetrofitUtils {

    public Retrofit getRetrofit(GsonConverterFactory factory){
        return this.getRetrofitBuilder(factory).build();
    }


    private Retrofit.Builder getRetrofitBuilder(GsonConverterFactory factory){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
        OkHttpClient client = httpClient.build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(WebServiceConfig.SERVIDOR_URL)
                .addConverterFactory(factory)
                .client(client);
        return builder;
    }
}

