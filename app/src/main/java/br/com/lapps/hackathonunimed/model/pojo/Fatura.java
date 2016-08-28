package br.com.lapps.hackathonunimed.model.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

/**
 * Created by Orochi on 28/08/2016.
 */
public class Fatura implements Serializable {
    private Float valorTotal;
    private Date dataEmissao;
    private Date dataVencimento;
    private List<ItemFatura> itens;
    private Beneficiario cliente;

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public List<ItemFatura> getItens() {
        return itens;
    }

    public void setItens(List<ItemFatura> itens) {
        this.itens = itens;
    }

    public String getStringMesVencimento(){
        Formatter f = new Formatter();
        return f.format("%tb", this.dataVencimento).toString();
    }

    public Beneficiario getCliente() {
        return cliente;
    }

    public void setCliente(Beneficiario cliente) {
        this.cliente = cliente;
    }
}
