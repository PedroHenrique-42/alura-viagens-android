package br.com.pedro.aluraviagens.utils;

import androidx.annotation.NonNull;

public class DiasUtil {
    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    @NonNull
    public static String formataEmTexto(int qtDias) {
        if (qtDias > 1) {
           return qtDias + PLURAL;
        }
        return qtDias + SINGULAR;
    }
}
