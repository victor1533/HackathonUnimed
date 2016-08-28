package br.com.lapps.hackathonunimed.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import br.com.lapps.hackathonunimed.model.Aplicacao;
import br.com.lapps.hackathonunimed.model.pojo.Beneficiario;
import br.com.lapps.hackathonunimed.model.webservice.retrofit.listener.BeneficiarioListener;
import br.com.lapps.hackathonunimed.model.webservice.retrofit.listener.RetrofitBeneficiario;
import br.com.lapps.hackathonunimed.view.LoginActivity;
import br.com.lapps.hackathonunimed.view.PainelActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Orochi on 27/08/2016.
 */
public class LoginController {
    private LoginActivity activity;
    private Aplicacao app;

    public LoginController(LoginActivity activity) {
        this.activity = activity;
    }

    public void logar(){
        BeneficiarioListener listener= new RetrofitBeneficiario().getListener();
        final Call<Beneficiario> call = listener.getByCartao(activity.getNumCartao());
        activity.openDialog(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                call.cancel();
            }
        });

        call.enqueue(new Callback<Beneficiario>() {
            @Override
            public void onResponse(Call<Beneficiario> call, Response<Beneficiario> response) {
                activity.closeDialog();

                if (response.isSuccessful() && response.body() != null) { // Caso tenha sido um sucesso
                    Beneficiario beneficiario = response.body();
                    beneficiario.save();

                    Toast.makeText(activity, "Sucesso!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(activity, PainelActivity.class);
                    intent.putExtra("beneficiario", beneficiario);
                    activity.startActivity(intent);

                }else{
                    Toast.makeText(activity, "Erro!", Toast.LENGTH_LONG).show();

                }
            }
            @Override
            public void onFailure(Call<Beneficiario> call, Throwable t) {
                Toast.makeText(activity, "Por favor verifique sua conexão com a internet!", Toast.LENGTH_LONG).show();

            }
        });
    }
}
