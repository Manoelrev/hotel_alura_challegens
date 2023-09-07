package com.br.hotel.alura.bancoDados.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("AluraHotel");

    public static EntityManagerFactory Factory(){
        return factory;
    }
}
