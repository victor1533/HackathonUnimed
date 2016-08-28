package br.com.lapps.hackathonunimed.model.webservice.retrofit.listener;

import br.com.lapps.hackathonunimed.model.Beneficiario;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Orochi on 27/08/2016.
 */
public interface BeneficiarioListener {
    @GET("beneficiarios/{id}.json")
    Call<Beneficiario> get(@Path("id") Integer id);

    @GET("beneficiarios.json")
    Call<Beneficiario> getByCartao(@Query("num_cartao") String num_cartao);


}
