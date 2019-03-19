package com.example.ricardo.teste3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ricardo on 30/06/2016.
 */
public class AdapterListView extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<ItemListView> itens;

    public AdapterListView(Context context, List<ItemListView> itens) {
        this.mInflater = LayoutInflater.from(context);
        this.itens = itens;
    }

    public void addItem(ItemListView item){
        itens.add(item);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ItemSuporte itemHolder;
        //se a view estiver nula (nunca criada), inflamos o layout nela.
        if (view == null) {
            //infla o layout para podermos pegar as views
            view = mInflater.inflate(R.layout.item_list, null);

            //cria um item de suporte para não precisarmos sempre
            //inflar as mesmas informacoes
            itemHolder = new ItemSuporte();
            itemHolder.txtTitle = ((TextView) view.findViewById(R.id.text));
            itemHolder.imgIcon = ((ImageView) view.findViewById(R.id.imagemview));

            //define os itens na view;
            view.setTag(itemHolder);
        } else {
            //se a view já existe pega os itens.
            itemHolder = (ItemSuporte) view.getTag();
        }

        //pega os dados da lista
        //e define os valores nos itens.
        ItemListView item = itens.get(position);
        itemHolder.txtTitle.setText(item.getTexto());

        itemHolder.imgIcon.setImageResource(R.drawable.fiora);

        //retorna a view com as informações
        return view;
    }

    private class ItemSuporte {

        ImageView imgIcon;
        TextView txtTitle;
    }
}
