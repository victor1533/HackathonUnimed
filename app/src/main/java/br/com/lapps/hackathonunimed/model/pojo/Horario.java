package br.com.lapps.hackathonunimed.model.pojo;

import com.google.gson.annotations.Expose;
import com.raizlabs.android.dbflow.annotation.Column;

import java.sql.Time;

/**
 * Created by Orochi on 28/08/2016.
 */
public class
Horario {

    private Integer dia;
    private Time hora;

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }
}
