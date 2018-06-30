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
import javax.persistence.Table;

/**
 *
 * @author Ale
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "Laudo")
@SequenceGenerator(name="laudo_seq", sequenceName="laudo_seq", allocationSize=1)
public class Laudo implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="laudo_seq")
    @Column(name = "id_laudo")
    private int id_laudo;

    @Column(name = "laudo_cliente")
    private String laudo_cliente;

    @Column(name = "laudo_placa")
    private String laudo_placa;

    @Column(name = "laudo_data")
    private String laudo_data;

    @Column(name = "laudo_reclamacao")
    private String laudo_reclamacao;

    public int getId_laudo() {
        return id_laudo;
    }

    public void setId_laudo(int id_laudo) {
        this.id_laudo = id_laudo;
    }

    public String getLaudo_cliente() {
        return laudo_cliente;
    }

    public void setLaudo_cliente(String laudo_cliente) {
        this.laudo_cliente = laudo_cliente;
    }

    public String getLaudo_placa() {
        return laudo_placa;
    }

    public void setLaudo_placa(String laudo_placa) {
        this.laudo_placa = laudo_placa;
    }

    public String getLaudo_data() {
        return laudo_data;
    }

    public void setLaudo_data(String laudo_data) {
        this.laudo_data = laudo_data;
    }

    public String getLaudo_reclamacao() {
        return laudo_reclamacao;
    }

    public void setLaudo_reclamacao(String laudo_reclamacao) {
        this.laudo_reclamacao = laudo_reclamacao;
    }


}
