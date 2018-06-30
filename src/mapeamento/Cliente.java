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


@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="cliente_seq", sequenceName="cliente_seq", allocationSize=1)
public class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_seq")
    @Column( updatable = false)
    private int id_cliente;

    @Column
    private String nome_cliente;

    @Column
    private String cpf_cliente;

     @Column
    private Date datanasc_cliente;

    @Column
    private String tel_cliente;

    @Column
    private String email_cliente;

    @Column
    private String endereco_cliente;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public Date getDataNasc_Cliente() {
        return datanasc_cliente;
    }

    public void setDataNasc_Cliente(Date datanasc_cliente) {
        this.datanasc_cliente = datanasc_cliente;
    }

    public String getTel_cliente() {
        return tel_cliente;
    }

    public void setTel_cliente(String tel_cliente) {
        this.tel_cliente = tel_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getEndereco_cliente() {
		return endereco_cliente;
	}

	public void setEndereco_cliente(String endereco_cliente) {
		this.endereco_cliente = endereco_cliente;
	}

	public void insereCliente(int id, String nome, String cpf, String email, String telefone, Date data){
        setId_cliente(id);
        setNome_cliente(nome);
        setCpf_cliente(cpf);
        setEmail_cliente(email);
        setTel_cliente(telefone);
        setDataNasc_Cliente(data);
    }
}
