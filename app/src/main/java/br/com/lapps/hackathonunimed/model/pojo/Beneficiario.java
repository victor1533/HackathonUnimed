package br.com.lapps.hackathonunimed.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;

import br.com.lapps.hackathonunimed.model.db.MyDataBase;

/**
 * Created by Orochi on 27/08/2016.
 */

@ModelContainer

@Table(database = MyDataBase.class)
public class Beneficiario extends BaseModel implements Serializable {


    @Expose
    @Column
    @PrimaryKey
    private Integer id;

    private Endereco localFatura;

    private Endereco endereco;

    @Expose
    @Column
    @SerializedName("num_cartao")
    private String numCartao;

    @Expose
    @Column
    private String nome;

    @Expose
    @Column
    private String rg;

    @Expose
    @Column
    private String cpf;

    public Beneficiario() {

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(String numCartao) {
        this.numCartao = numCartao;
    }
    public Endereco getLocalFatura() {
        return localFatura;
    }

    public void setLocalFatura(Endereco localFatura) {
        this.localFatura = localFatura;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
