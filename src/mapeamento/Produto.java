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
 * @author Marcos
 */

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="produto_seq", sequenceName="produto_seq", allocationSize=1)
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produto_seq")
    @Column( updatable = false)
    private int id_produto;

    @Column
    private String nome_produto;

    @Column
    private float quantidade;

    @Column
    private float preco_custo;

    @Column
    private float preco_venda;
    
    @Column
    private boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Column
    private String ref_produto;

    @Column
    private float porcentagem_lucro_produto;

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

     public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(float preco_custo) {
        this.preco_custo = preco_custo;
    }

    public float getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(float preco_venda) {
        this.preco_venda = preco_venda;
    }

    public String getReferencia_produto() {
        return ref_produto;
    }

    public void setReferencia_produto(String ref_produto) {
        this.ref_produto = ref_produto;
    }

    public float getPorcentagem_lucro_produto() {
        return porcentagem_lucro_produto;
    }

    public void setPorcentagem_lucro_produto(float porcentagem_lucro_produto) {
        this.porcentagem_lucro_produto = porcentagem_lucro_produto;
    }

}
