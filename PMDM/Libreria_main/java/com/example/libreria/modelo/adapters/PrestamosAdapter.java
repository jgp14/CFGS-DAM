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
import com.example.libreria.modelo.entity.Prestamo;
import com.squareup.picasso.Picasso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PrestamosAdapter extends ArrayAdapter<Prestamo> {

    private ArrayList<Prestamo> prestamos;
    private Context context;
    private boolean mIsDarkTheme;
    private static final int nMeses = 3;

    public PrestamosAdapter(Context context, ArrayList<Prestamo> prestamos, boolean isDarkTheme) {
        super(context, 0, prestamos);
        this.prestamos = prestamos;
        this.context = context;
        this.mIsDarkTheme = isDarkTheme;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.item_prestamo, parent, false);
        }

        Prestamo prestamo = prestamos.get(position);

        TextView autor = listItem.findViewById(R.id.bookAuthor);
        autor.setText(prestamo.getLibro().getAutor());
        setTextViewColor(autor);

        TextView titulo = listItem.findViewById(R.id.bookTitle);
        titulo.setText(prestamo.getLibro().getTitulo());
        setTextViewColor(titulo);

        TextView genero = listItem.findViewById(R.id.bookGenre);
        genero.setText(prestamo.getLibro().getGenero());
        setTextViewColor(genero);

        TextView fechaPrestamo = listItem.findViewById(R.id.bookDate);
        String fechaPrestamoS = prestamo.getFechaPrestamo();
        fechaPrestamo.setText(fechaPrestamoS);
        setTextViewColor(fechaPrestamo);

        TextView fechaTopePrestamo = listItem.findViewById(R.id.bookDateTop);
        String fechaTopePrestamoS = prestamo.getFechaPrestamo();
        fechaTopePrestamo.setText(calculeFechaDevolucion(fechaTopePrestamoS));
        setTextViewColor(fechaTopePrestamo);

        ImageView ivImagen = listItem.findViewById(R.id.bookImage);
        String rutaImagen = "https://gcdnb.pbrd.co/images/PfZZRBEQoCdu.png";
        if (!prestamo.getLibro().getRutaImagen().isEmpty())
            rutaImagen = prestamo.getLibro().getRutaImagen();
        Picasso.get()
                .load(rutaImagen)
                .error(R.drawable.image_libro3).into(ivImagen);
        return listItem;
    }

    public void actualizarPrestamos(ArrayList<Prestamo> nuevosPrestamos) {
        prestamos.clear();
        prestamos.addAll(nuevosPrestamos);
        notifyDataSetChanged();
    }

    private String calculeFechaDevolucion(String fechaPrestamo) {
        LocalDate fechaTope = LocalDate.parse(fechaPrestamo).plusMonths(nMeses);
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        String fechaTopeDevolucion = fechaTope.format(dtf);
        return fechaTopeDevolucion;
    }

    private void setTextViewColor(TextView textView) {
        if (mIsDarkTheme) {
            textView.setTextColor(ContextCompat.getColor(context, R.color.white));
        } else {
            textView.setTextColor(ContextCompat.getColor(context, R.color.black));
        }
    }
}
