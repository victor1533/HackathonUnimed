package br.com.lapps.hackathonunimed.model.webservice.retrofit;

import com.google.gson.GsonBuilder;

import java.util.Date;

import br.com.lapps.hackathonunimed.model.webservice.retrofit.deserializer.DateDeserializer;
import br.com.lapps.hackathonunimed.model.webservice.retrofit.listener.BeneficiarioListener;
import br.com.lapps.hackathonunimed.model.webservice.retrofit.listener.FaturaListener;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by marco on 28/08/16.
 */
public class RetrofitFatura{

    public FaturaListener getListener(){
        Retrofit retrofit = new RetrofitUtils().getRetrofit(this.GsonConverterFactoryFatura());
        return retrofit.create(FaturaListener.class);
    }

    private GsonConverterFactory GsonConverterFactoryFatura(){
        GsonConverterFactory factory = GsonConverterFactory.create(
                new GsonBuilder()
                        .excludeFieldsWithoutExposeAnnotation()
                        .setDateFormat("yyyy-MM-dd")
                        .registerTypeAdapter(Date.class, new DateDeserializer())
                        .create());
        return factory;
    }
}
