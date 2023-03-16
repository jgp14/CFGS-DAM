package com.example.libreria.modelo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.libreria.R;
import com.example.libreria.modelo.entity.Libro;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LibrosAdapter extends ArrayAdapter<Libro> {

    private ArrayList<Libro> libros;
    private Context context;
    private boolean mIsDarkTheme;

    public LibrosAdapter(Context context, ArrayList<Libro> libros, boolean isDarkTheme) {
        super(context, 0, libros);
        this.libros = libros;
        this.context = context;
        this.mIsDarkTheme = isDarkTheme;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.item_libro, parent, false);
        }

        Libro libro = libros.get(position);

        TextView autor = listItem.findViewById(R.id.bookAuthorTextView);
        autor.setText(libro.getAutor());

        TextView titulo = listItem.findViewById(R.id.bookTitleTextView);
        titulo.setText(libro.getTitulo());
        setTextViewColor(titulo);

        TextView genero = listItem.findViewById(R.id.bookGenreTextView);
        genero.setText(libro.getGenero());


        ImageView ivImagen = listItem.findViewById(R.id.bookCoverImageView);
        String rutaImagen = "https://gcdnb.pbrd.co/images/PfZZRBEQoCdu.png";
        if (!libro.getRutaImagen().isEmpty())
            rutaImagen = libro.getRutaImagen();
        Picasso.get()
                .load(rutaImagen)
                .error(R.drawable.image_libro3).into(ivImagen);

        return listItem;
    }

    public void actualizarLibros(ArrayList<Libro> nuevosLibros) {
        libros.clear();
        libros.addAll(nuevosLibros);
        notifyDataSetChanged();
    }

    private void setTextViewColor(TextView textView) {
        if (mIsDarkTheme) {
            textView.setTextColor(ContextCompat.getColor(context, R.color.white));
        } else {
            textView.setTextColor(ContextCompat.getColor(context, R.color.black));
        }
    }

}
