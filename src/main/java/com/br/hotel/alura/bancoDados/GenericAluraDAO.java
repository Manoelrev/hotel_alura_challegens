package com.br.hotel.alura.bancoDados;


import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import com.br.hotel.alura.bancoDados.util.JPAUtil;

public class GenericAluraDAO {
    private EntityManager entity;

    public GenericAluraDAO(){
        entity = JPAUtil.Factory().createEntityManager();
    }
    
    public void create(Object object){
        entity.getTransaction().begin();
        entity.persist(object);
        entity.getTransaction().commit();
    }

    public void delete(Reserva reserva){
        entity.getTransaction().begin();
        reserva = entity.merge(reserva);
        this.entity.remove(reserva);
        entity.getTransaction().commit();
    }
    public enum BandoDados {HOSPEDE, RESERVA, hospede, reserva};

    public void delete(String ID, BandoDados tipoBanco){
        if((tipoBanco == BandoDados.hospede) || (tipoBanco == BandoDados.HOSPEDE)){
            Hospede hospede = entity.find(Hospede.class, Long.valueOf(ID));
            entity.getTransaction().begin();
            hospede = entity.merge(hospede);
            entity.remove(hospede);
            entity.getTransaction().commit();
        } else {
            Reserva reserva = entity.find(Reserva.class, ID);
            entity.getTransaction().begin();
            reserva = entity.merge(reserva);
            entity.remove(reserva);
            entity.getTransaction().commit();
        }
    }

    public void updateHospede(Hospede hospede, String nome, String sobreNome, Date dataNascimento, String nacionalidade, String telefone){ 
        entity.getTransaction().begin();
        hospede = entity.merge(hospede);
        hospede.setNome(!nome.isEmpty() ? nome : hospede.getNome());
        hospede.setSobreNome(!sobreNome.isEmpty() ? sobreNome : hospede.getSobreNome());
        hospede.setDataNascimento(dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        hospede.setNacionalidade(nacionalidade);
        hospede.setTelefone(!telefone.isEmpty() ? telefone : hospede.getTelefone());
        entity.getTransaction().commit();
        
        entity.close();
    }
    
    public void updateReserva(Reserva reserva, Date dataEntrada, Date dataSaida, String formaPagamento, BigDecimal valor){ 
        entity.getTransaction().begin();
        reserva = entity.merge(reserva);
        reserva.setDataEntrada(dataEntrada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        reserva.setDataSaida(dataSaida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        reserva.setFormaPagamento(formaPagamento);
        reserva.setValor(valor);
        entity.getTransaction().commit();
        
        entity.close();
    }

    public List<Hospede> printHospede(){
        List<Hospede> query = entity.createQuery("SELECT p FROM Hospede p", Hospede.class).getResultList();
        entity.close();
        return query;
    }

    public List<Hospede> printHospede(String numeroReserva){
        List<Hospede> query = entity.createQuery("SELECT h FROM Hospede h where sobreNome = :sobreNome", Hospede.class)
        .setParameter("sobreNome", numeroReserva)
        .getResultList();
        entity.close();
        return query;
    }

    public List<Reserva> printReserva(){
        List<Reserva> query =  entity.createQuery("SELECT p FROM Reserva p", Reserva.class).getResultList();
        entity.close();
        return query;
    }
    
    public List<Reserva> printReserva(String numeroReserva){
        List<Reserva> query = entity.createQuery("SELECT r FROM Reserva r where id = :id", Reserva.class)
        .setParameter("id", numeroReserva)
        .getResultList();
        entity.close();
        return query;  
    }
    
    public Hospede findHospedeById(String id){
        return  entity.find(Hospede.class, Long.valueOf(id));
    }

    public Reserva findReservaById(String id){
        return  entity.find(Reserva.class, id);
    }

    public void close(){
        entity.close();
    }
}
