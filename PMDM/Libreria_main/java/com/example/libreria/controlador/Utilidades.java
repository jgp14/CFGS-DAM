package com.example.libreria.controlador;

import android.content.Context;

import android.content.res.Configuration;

import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.example.libreria.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {

    //Clase Utilidades con metodos de utilidad
    public Utilidades() {
    }

    //METODOS PARA MAIN ACTIVITY 2"

    // Metodo para imprimir un toast corto
    public void printToastShort(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    // Metodo para imprimir un toas largo
    public void printToastLong(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    // Metodo para verificar que los strings de los campos del email y contraseña son validos
    public boolean isValidUserLogin(Context context, String email, String password) {
        boolean valid = true;
        if (email.isEmpty()) {
            printToastShort(context, "Email es obligatorio. Ponlo");
            valid = false;
        } else if (!validFormatEmail(email)) {
            printToastShort(context, "Email con formato incorrecto. Reintroducelo");
            valid = false;
        } else if (password.isEmpty()) {
            printToastShort(context, "Contraseña es obligatorio. Ponlo");
            valid = false;
        }
        return valid;
    }

    // Metodo para comprobar el formato de email
    public boolean validFormatEmail(String email) {
        boolean validEmail = false;
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        if (mather.find())
            validEmail = true;
        return validEmail;
    }

    // METODOS PARA MAIN ACTIVITY 4
    // Metodo para validar si el autor y el titulo son validos
    public boolean isValidData(Context context, String autor, String titulo) {
        boolean valid = true;
        if (autor.isEmpty()) {
            printToastShort(context, "Autor es obligatorio. Ponlo");
            valid = false;
        }
        if (titulo.isEmpty()) {
            printToastShort(context, "Titulo es obligatorio. Ponlo");
            valid = false;
        }
        return valid;
    }

    // METODOS PARA MAIN ACTIVITY 5
    public boolean isValidDataPrestamo(Context context, String autor, String titulo, String fecha_prestamoS) {
        boolean valid = true;

        if (autor.isEmpty()) {
            printToastShort(context, "Campo autor es necesario");
            valid = false;
        }
        if (titulo.isEmpty()) {
            printToastShort(context, "Campo titulo es necesario");
            valid = false;
        }
        if (fecha_prestamoS.isEmpty()) {
            printToastShort(context, "Campo fecha de prestamo es necesaria");
            valid = false;
        }
        return valid;
    }

    // METODOS PARA MAIN ACTIVITY 7
    // Metodo para comprobar si un usuario es valido al registrarse
    public boolean isValidUserSignUP(Context context, String username, String email, String password, String check) {
        boolean valid = true;
        valid = isValidUserLogin(context, email, password);
        if (username.isEmpty()) {
            printToastShort(context, "Nombre de usuario es obligatorio. Ponlo");
            valid = false;
        } else if (check.isEmpty()) {
            printToastShort(context, "Introduce de nuevo la contraseña. Para verificarla");
        } else if (!check.equals(password)) {
            printToastShort(context, "Contraseña no coincide. Revisa");
            valid = false;
        }
        return valid;
    }

}
