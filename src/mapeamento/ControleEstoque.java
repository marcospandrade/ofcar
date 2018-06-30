/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeamento;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import mapeamento.Fornecedor;

/**
 *
 * @author Marcos
 */

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="estoque_seq", sequenceName="estoque_seq", allocationSize=1)
public class ControleEstoque implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="estoque_seq")
    @Column( updatable = false)
    private int id_estoque;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;

    @Column
    private Date data_lancamento;

    @Column
    private String cod_nota;

    @Column
    private float quantidade;

    @Column
    private float valor_unit;

    @Column
    private float valor_total;



    public int getId_estoque() {
        return id_estoque;
    }

    public void setId_estoque(int id_estoque) {
        this.id_estoque = id_estoque;
    }

     public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fornecedor getFornecedor(){
    	return fornecedor;
    }
    public void setFornecedor(Fornecedor fornecedor){
    	this.fornecedor = fornecedor;
    }

    public Date getData_lancamento(){
    	return data_lancamento;
    }

    public void setData_lancamento(Date data_lancamento){
    	this.data_lancamento = data_lancamento;
    }

    public String getCod_nota() {
        return cod_nota;
    }

    public void setCod_nota(String cod_nota) {
        this.cod_nota = cod_nota;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor_unit() {
        return valor_unit;
    }

    public void setValor_unit(float valor_unit) {
        this.valor_unit = valor_unit;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

}
