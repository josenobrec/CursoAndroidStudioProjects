package com.cursoandroid.instagram.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cursoandroid.instagram.R;

import java.util.List;

public class AdapterGrid extends ArrayAdapter<String> {

    private Context context;
    private int layoutResource;
    private List<String> urlFotos;

    public AdapterGrid(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutResource = resource;
        this.urlFotos = objects;
    }

    public class ViewHolder{
        ImageView imagem;
        ProgressBar progressBar;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        //caso a view não esteja inflada, precisamos inflar
        if(convertView != null){

            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layoutResource, parent, false);
            viewHolder.imagem = convertView.findViewById(R.id.imageGridPerfil);
            viewHolder.progressBar = convertView.findViewById(R.id.progressGridPerfil);

            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }
}
