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
        itemHolder.mes = (TextView) view.findViewById(R.id.mesFatura);
        itemHolder.valor = (TextView) view.findViewById(R.id.valorFatura);
        view.setTag(itemHolder);

        final Fatura fatura = itens.get(position);
        itemHolder.mes.setText(fatura.getStringMesVencimento());

        itemHolder.valor.setText(String.format("%.2f", fatura.getValorTotal()));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contexto, Fatura.class);
                intent.putExtra("fatura", fatura);
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