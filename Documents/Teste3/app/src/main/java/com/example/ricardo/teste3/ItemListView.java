package com.example.ricardo.teste3;

import android.widget.ImageView;

/**
 * Created by Ricardo on 30/06/2016.
 */
public class ItemListView {
    private String texto;
    private int iconRid;

    public ItemListView(){
        this.texto = "";
        this.iconRid = -1;
    }

    public ItemListView(String texto, int iconRid) {
        this.texto = texto;
        this.iconRid = iconRid;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getIconRid() {
        return iconRid;
    }

    public void setIconRid(int iconRid) {
        this.iconRid = iconRid;
    }
}
