package com.br.hotel.alura.bancoDados;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Entity
@Table (name = "Reservas")
public class Reserva {
    
    @Id
    @GeneratedValue(generator = "custom-generator", strategy = GenerationType.IDENTITY)  
    @GenericGenerator(name = "custom-generator", strategy = "com.br.hotel.alura.bancoDados.CustomAluraIDGenerate")
    @Column(name="id")
    private String id;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private BigDecimal valor;
    private String formaPagamento;
    
    public Reserva(){

    }

    public Reserva(Date dataEntrada, Date dataSaida, BigDecimal valor, String formaPagamento){
        this.dataEntrada = dataEntrada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.dataSaida = dataSaida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public String getId() {
        return id;
    }
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }
    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
