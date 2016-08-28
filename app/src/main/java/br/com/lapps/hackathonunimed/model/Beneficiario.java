package br.com.lapps.hackathonunimed.model;

/**
 * Created by Orochi on 27/08/2016.
 */
public class Beneficiario {

    private Endereco localFatura;
    private Endereco endereco;
    private String login;
    private String senha;
    private String nome;
    private String rg;
    private String cpf;

    public Beneficiario() {

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
