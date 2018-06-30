/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeamento;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Ale
 */
@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="ordem_aberta_seq", sequenceName="ordem_aberta_seq", allocationSize=1)
public class Ordem_aberta implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ordem_aberta_seq")
    @Column
    private int id_ordem_aberta;    
    
    @Column
    private String funcionario_ordem_aberta;

    @Column
    private String cliente_ordem_aberta;
    @Column
    private String telefone_ordem_aberta;
    @Column
    private String placa_ordem_aberta;
    @Column
    private String veiculo_ordem_aberta;
    @Column
    private String problema_ordem_aberta;
    @Column
    private String odometro_ordem_aberta;
    @Column
    private String ano_ordem_aberta;
    @Column
    private String parecer_ordem_aberta;

    public String getOdometro_ordem_aberta() {
        return odometro_ordem_aberta;
    }

    public void setOdometro_ordem_aberta(String odometro_ordem_aberta) {
        this.odometro_ordem_aberta = odometro_ordem_aberta;
    }

    public String getAno_ordem_aberta() {
        return ano_ordem_aberta;
    }

    public void setAno_ordem_aberta(String ano_ordem_aberta) {
        this.ano_ordem_aberta = ano_ordem_aberta;
    }

    public String getParecer_ordem_aberta() {
        return parecer_ordem_aberta;
    }

    public void setParecer_ordem_aberta(String parecer_ordem_aberta) {
        this.parecer_ordem_aberta = parecer_ordem_aberta;
    }

    
    public int getId_ordem_aberta() {
        return id_ordem_aberta;
    }

    public void setId_ordem_aberta(int id_ordem_aberta) {
        this.id_ordem_aberta = id_ordem_aberta;
    }

    public String getFuncionario_ordem_aberta() {
        return funcionario_ordem_aberta;
    }

    public void setFuncionario_ordem_aberta(String funcionario_ordem_aberta) {
        this.funcionario_ordem_aberta = funcionario_ordem_aberta;
    }

    public String getCliente_ordem_aberta() {
        return cliente_ordem_aberta;
    }

    public void setCliente_ordem_aberta(String cliente_ordem_aberta) {
        this.cliente_ordem_aberta = cliente_ordem_aberta;
    }

    public String getTelefone_ordem_aberta() {
        return telefone_ordem_aberta;
    }

    public void setTelefone_ordem_aberta(String telefone_ordem_aberta) {
        this.telefone_ordem_aberta = telefone_ordem_aberta;
    }

    public String getPlaca_ordem_aberta() {
        return placa_ordem_aberta;
    }

    public void setPlaca_ordem_aberta(String placa_ordem_aberta) {
        this.placa_ordem_aberta = placa_ordem_aberta;
    }

    public String getVeiculo_ordem_aberta() {
        return veiculo_ordem_aberta;
    }

    public void setVeiculo_ordem_aberta(String veiculo_ordem_aberta) {
        this.veiculo_ordem_aberta = veiculo_ordem_aberta;
    }

    public String getProblema_ordem_aberta() {
        return problema_ordem_aberta;
    }

    public void setProblema_ordem_aberta(String problema_ordem_aberta) {
        this.problema_ordem_aberta = problema_ordem_aberta;
    }



}
