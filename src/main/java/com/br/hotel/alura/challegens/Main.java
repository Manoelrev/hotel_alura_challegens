package com.br.hotel.alura.challegens;

import com.br.hotel.alura.bancoDados.GenericAluraDAO;
import com.br.hotel.alura.grafico.TelaInicial;
public class Main {
    public static void main(String[] args) {
        new GenericAluraDAO();
        new TelaInicial().start();
    }
}