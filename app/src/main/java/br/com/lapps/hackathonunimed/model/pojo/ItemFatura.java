package br.com.lapps.hackathonunimed.model.pojo;

import java.util.Date;

/**
 * Created by Orochi on 28/08/2016.
 */
public class ItemFatura {

    private Float valor;
    private String descricao;
    private Date data;
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
