/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeamento;

import java.io.Serializable;
import java.sql.Date;
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
@SequenceGenerator(name="funcionario_seq", sequenceName="funcionario_seq", allocationSize=1)
public class Funcionario implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="funcionario_seq")
    @Column(updatable = false)
    private int id_funcionario;

    @Column
    private String nome_func;

    @Column
    private String cpf_func;

    @Column
    private String tel_func;
    
    @Column
    private String endereco_func;
     
    @Column
    private String cargo_func;   
    
    @Column
    private Date datanasc_func;

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome_func() {
        return nome_func;
    }

    public void setNome_func(String nome_func) {
        this.nome_func = nome_func;
    }

    public String getCpf_func() {
        return cpf_func;
    }

    public void setCpf_func(String cpf_func) {
        this.cpf_func = cpf_func;
    }

    public String getTel_func() {
        return tel_func;
    }

    public void setTel_func(String tel_func) {
        this.tel_func = tel_func;
    }

    public String getEndereco_func() {
        return endereco_func;
    }

    public void setEndereco_func(String endereco_func) {
        this.endereco_func = endereco_func;
    }

    public String getCargo_func() {
        return cargo_func;
    }

    public void setCargo_func(String cargo_func) {
        this.cargo_func = cargo_func;
    }

    public Date getDatanasc_func() {
        return datanasc_func;
    }

    public void setDatanasc_func(Date datanasc_func) {
        this.datanasc_func = datanasc_func;
    }


}
