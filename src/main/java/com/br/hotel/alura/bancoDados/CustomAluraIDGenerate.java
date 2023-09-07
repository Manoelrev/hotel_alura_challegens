package com.br.hotel.alura.bancoDados;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDGenerator;

public class CustomAluraIDGenerate extends UUIDGenerator {
    private static int numero = 0;
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        numero++;
        return "ALURA" + numero;
    }
}
