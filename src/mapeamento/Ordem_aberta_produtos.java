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
@SequenceGenerator(name="ordem_aberta_produto_seq", sequenceName="ordem_aberta_produto_seq", allocationSize=1)
public class Ordem_aberta_produtos implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ordem_aberta_produto_seq")
    @Column
    private int id_ordem_aberta_produto;     
    
    @Column
    private int cod_produto_aberta;    
    @Column
    private String desc_produto_aberta;  
    @Column
    private int qtd_produto_aberta;  
    @Column
    private float valor_produto_aberta;  
    @Column
    private float total_produto_aberta;      

    public int getId_ordem_aberta_produto() {
        return id_ordem_aberta_produto;
    }

    public void setId_ordem_aberta_produto(int id_ordem_aberta_produto) {
        this.id_ordem_aberta_produto = id_ordem_aberta_produto;
    }

    public int getCod_produto_aberta() {
        return cod_produto_aberta;
    }

    public void setCod_produto_aberta(int cod_produto_aberta) {
        this.cod_produto_aberta = cod_produto_aberta;
    }

    public String getDesc_produto_aberta() {
        return desc_produto_aberta;
    }

    public void setDesc_produto_aberta(String desc_produto_aberta) {
        this.desc_produto_aberta = desc_produto_aberta;
    }

    public int getQtd_produto_aberta() {
        return qtd_produto_aberta;
    }

    public void setQtd_produto_aberta(int qtd_produto_aberta) {
        this.qtd_produto_aberta = qtd_produto_aberta;
    }

    public float getValor_produto_aberta() {
        return valor_produto_aberta;
    }

    public void setValor_produto_aberta(float valor_produto_aberta) {
        this.valor_produto_aberta = valor_produto_aberta;
    }

    public float getTotal_produto_aberta() {
        return total_produto_aberta;
    }

    public void setTotal_produto_aberta(float total_produto_aberta) {
        this.total_produto_aberta = total_produto_aberta;
    }
}
