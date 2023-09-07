package com.br.hotel.alura.bancoDados;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "updateHospede", query = "update Hospede h set h.nome = :nome, h.sobreNome = :sobrenome, h.dataNascimento = :datanascimento, h.nacionalidade = :nacionalidade, h.telefone = :telefone where id = :id")
@Table (name = "Hospede")
public class Hospede {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String sobreNome;
    private LocalDate dataNascimento;
    private String nacionalidade;
    private String telefone;
    @ManyToOne 
    private Reserva reserva;

    public Hospede(){

    }
    public Hospede(String nome, String sobreNome, Date dataNascimento, String nacionalidade, String telefone, Reserva reserva){
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.dataNascimento = dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.nacionalidade = nacionalidade;
        this.telefone = telefone;
        this.reserva = reserva;
    }
    
    public Reserva getReserva() {
        return reserva;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }
    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }
    
    public String getNacionalidade() {
        return nacionalidade;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString(){
        return id + "|" + nome + "|"+ sobreNome +"|"+ dataNascimento + "|" + nacionalidade +"|" + telefone + "|"+ 20;
        
    }
}
