package br.com.lapps.hackathonunimed.model.pojo;

import com.google.gson.annotations.Expose;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;

import br.com.lapps.hackathonunimed.model.db.MyDataBase;

/**
 * Created by Orochi on 28/08/2016.
 */
@ModelContainer
@Table(database = MyDataBase.class)
public class Atividade extends BaseModel implements Serializable {
    @PrimaryKey
    @Expose
    @Column
    private Integer id;

    @Expose
    @Column
    private String nome;

    @Expose
    @Column
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
