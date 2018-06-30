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
@SequenceGenerator(name="servico_seq", sequenceName="servico_seq", allocationSize=1)
public class Servico implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="servico_seq")
    @Column
    private int id_servico;

    @Column
    private String nome_servico;
    
    @Column
    private float valor_servico;

    @Column
    private String descricao_servico;
    
    @Column
    private boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public String getNome_servico() {
        return nome_servico;
    }

    public void setNome_servico(String nome_servico) {
        this.nome_servico = nome_servico;
    }

    public float getValor_servico() {
        return valor_servico;
    }

    public void setValor_servico(float valor_servico) {
        this.valor_servico = valor_servico;
    }

    public String getDescricao_servico() {
        return descricao_servico;
    }

    public void setDescricao_servico(String descricao_servico) {
        this.descricao_servico = descricao_servico;
    }



}
