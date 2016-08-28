package br.com.lapps.hackathonunimed.model;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by Orochi on 27/08/2016.
 */
public class Aplicacao extends Application{
    private Beneficiario beneficiario;

    @Override
    public void onCreate() {
        super.onCreate();

        beneficiario = new Beneficiario();
        FlowManager.init(new FlowConfig.Builder(this).build());

    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }




}
