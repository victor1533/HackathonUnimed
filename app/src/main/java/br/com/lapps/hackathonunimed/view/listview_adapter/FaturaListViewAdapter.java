package br.com.lapps.hackathonunimed.view.listview_adapter;

/**
 * Created by Orochi on 28/08/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import br.com.lapps.hackathonunimed.R;
import br.com.lapps.hackathonunimed.model.pojo.Fatura;


/**
 * Created by Chris on 25/09/2015.
 */
public class FaturaListViewAdapter extends BaseAdapter implements Serializable {
    private LayoutInflater mInflater;
    private List<Fatura> itens;
    private Context contexto;

    public FaturaListViewAdapter(Context contexto, List<Fatura> faturas) {
        this.itens = faturas;
        this.contexto = contexto;
        mInflater = LayoutInflater.from(contexto);
    }


    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Fatura getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ItemSuporte itemHolder;
        view = mInflater.inflate(R.layout.item_list_fatura, null);
        itemHolder = new ItemSuporte();
        itemHolder.mes = (TextView) view.findViewById(R.id.);
        itemHolder.hora = (TextView) view.findViewById(R.id.horarioPonto);
        itemHolder.turno = (TextView) view.findViewById(R.id.turnoPonto);
        view.setTag(itemHolder);

        final Ponto ponto = itens.get(position);
        itemHolder.dia.setText(Datas.DateToddMMyyyy(ponto.getCreatedAt()));
        itemHolder.hora.setText(Datas.DateToHHmm(ponto.getCreatedAt()));
        if(ponto.getTurno() != null){
            itemHolder.turno.setText(ponto.getTurno().getNome() + " / " + (ponto.isEntrada() ? "Entrada" : "Saida"));
        }else{
            itemHolder.turno.setText((ponto.isEntrada() ? "Entrada" : "Saida"));
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contexto, ComprovantePontoActivity.class);
                intent.putExtra("ponto", ponto);
                contexto.startActivity(intent);
            }
        });
        return view;
    }

    private class ItemSuporte {
        TextView valor;
        TextView mes;

    }

}