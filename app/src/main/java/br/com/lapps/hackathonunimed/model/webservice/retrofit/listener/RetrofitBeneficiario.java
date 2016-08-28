package br.com.lapps.hackathonunimed.model.webservice.retrofit.listener;

import com.google.gson.GsonBuilder;

import java.util.Date;

import br.com.lapps.hackathonunimed.model.webservice.retrofit.RetrofitUtils;
import br.com.lapps.hackathonunimed.model.webservice.retrofit.deserializer.DateDeserializer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Orochi on 27/08/2016.
 */
public class RetrofitBeneficiario {

    public BeneficiarioListener getListener(){
        Retrofit retrofit = new RetrofitUtils().getRetrofit(this.GsonConverterFactoryBeneficiario());
        return retrofit.create(BeneficiarioListener.class);
    }

    private GsonConverterFactory GsonConverterFactoryBeneficiario(){
        GsonConverterFactory factory = GsonConverterFactory.create(
                new GsonBuilder()
                        .excludeFieldsWithoutExposeAnnotation()
                        .setDateFormat("yyyy-MM-dd")
                        .registerTypeAdapter(Date.class, new DateDeserializer())
                        .create());
        return factory;
    }
}
