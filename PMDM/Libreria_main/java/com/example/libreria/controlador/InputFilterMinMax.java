package com.example.libreria.controlador;

import android.text.InputFilter;
import android.text.Spanned;

// Clase InputFilter que se le setea a un textInputEditText para restringir valores de entrada
public class InputFilterMinMax implements InputFilter {
    private long min, max;

    public InputFilterMinMax(long min, long max) {
        this.min = min;
        this.max = max;
    }

    public InputFilterMinMax(String min, String max) {
        this.min = Long.parseLong(min);
        this.max = Long.parseLong(max);
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            long input = Long.parseLong(dest.toString() + source.toString());
            if (isInRange(min, max, input))
                return null;
        } catch (NumberFormatException nfe) {
            // Do nothing
        }
        return "";
    }

    private boolean isInRange(long a, long b, long c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}
