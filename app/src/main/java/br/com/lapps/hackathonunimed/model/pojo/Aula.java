package br.com.lapps.hackathonunimed.model.pojo;

import java.util.List;

/**
 * Created by Orochi on 28/08/2016.
 */
public class Aula {

    private List<Beneficiario> presentes;
    private List<Horario> horario;
    private Atividade atividade;

    public List<Beneficiario> getPresentes() {
        return presentes;
    }

    public void setPresentes(List<Beneficiario> presentes) {
        this.presentes = presentes;
    }

    public List<Horario> getHorario() {
        return horario;
    }

    public void setHorario(List<Horario> horario) {
        this.horario = horario;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
}
