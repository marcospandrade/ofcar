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
@SequenceGenerator(name="orcamento_seq", sequenceName="orcamento_seq", allocationSize=1)
public class Orcamento implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orcamento_seq")
    @Column
    private int id_orcamento;
    @Column
    private String cliente_orcamento;
    @Column
    private String funcionario_orcamento;
    @Column
    private String veiculo_orcamento;
    @Column
    private String placa_orcamento;
    @Column
    private Float total_orcamento;
    @Column
    private String situacao;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getId_orcamento() {
        return id_orcamento;
    }

    public void setId_orcamento(int id_orcamento) {
        this.id_orcamento = id_orcamento;
    }

    public String getCliente_orcamento() {
        return cliente_orcamento;
    }

    public void setCliente_orcamento(String cliente_orcamento) {
        this.cliente_orcamento = cliente_orcamento;
    }

    public String getFuncionario_orcamento() {
        return funcionario_orcamento;
    }

    public void setFuncionario_orcamento(String funcionario_orcamento) {
        this.funcionario_orcamento = funcionario_orcamento;
    }

    public String getVeiculo_orcamento() {
        return veiculo_orcamento;
    }

    public void setVeiculo_orcamento(String veiculo_orcamento) {
        this.veiculo_orcamento = veiculo_orcamento;
    }

    public String getPlaca_orcamento() {
        return placa_orcamento;
    }

    public void setPlaca_orcamento(String placa_orcamento) {
        this.placa_orcamento = placa_orcamento;
    }

    public Float getTotal_orcamento() {
        return total_orcamento;
    }

    public void setTotal_orcamento(Float total_orcamento) {
        this.total_orcamento = total_orcamento;
    }


}
