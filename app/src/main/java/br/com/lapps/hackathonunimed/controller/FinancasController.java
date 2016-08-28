package br.com.lapps.hackathonunimed.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.lapps.hackathonunimed.model.Aplicacao;
import br.com.lapps.hackathonunimed.model.pojo.Fatura;
import br.com.lapps.hackathonunimed.model.webservice.retrofit.RetrofitFatura;
import br.com.lapps.hackathonunimed.model.webservice.retrofit.listener.FaturaListener;
import br.com.lapps.hackathonunimed.view.FinancasActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Orochi on 28/08/2016.
 */
public class FinancasController {
    private FinancasActivity activity;
    private List<Fatura> faturas;
    private Aplicacao sessao;
    public FinancasController(FinancasActivity activity) {
        this.activity = activity;
    }

    public void preencheListas(){
        sessao = (Aplicacao) activity.getApplication();
        FaturaListener listener = new RetrofitFatura().getListener();
        Call<ArrayList<Fatura>> call = listener.getAll(sessao.getBeneficiario().getId());
        call.enqueue(new Callback<ArrayList<Fatura>>() {
            @Override
            public void onResponse(Call<ArrayList<Fatura>> call, Response<ArrayList<Fatura>> response) {
                if(response.isSuccessful() && response.body() != null){
                    ArrayList<Fatura> faturas = response.body();

                }else{

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Fatura>> call, Throwable t) {

            }
        });

    }
}
