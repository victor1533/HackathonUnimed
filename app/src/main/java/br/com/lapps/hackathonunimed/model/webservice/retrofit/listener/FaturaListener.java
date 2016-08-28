package br.com.lapps.hackathonunimed.model.webservice.retrofit.listener;

import java.util.ArrayList;

import br.com.lapps.hackathonunimed.model.pojo.Fatura;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Orochi on 28/08/2016.
 */
public interface FaturaListener {

    @GET("faturas")
    Call<ArrayList<Fatura>> getAll(@Query("beneficiario_id") Integer beneficiario_id);

    @GET("faturas/{id}")
    Call<Fatura> get(@Path("fatura_id") Integer fatura_id);
}
