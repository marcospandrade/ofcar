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
@SequenceGenerator(name="veiculo_seq", sequenceName="veiculo_seq", allocationSize=1)
public class Veiculo implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="veiculo_seq")
    @Column(updatable = false)
    private int id_carro;

    @Column
    private String placa_carro;

    @Column
    private String km_carro;

    @Column
    private String ano_carro;

    @Column
    private String cor_carro;

    @Column
    private String marca_carro;

    @Column
    private String modelo_carro;
    
    @Column
    private String chassi_carro;

    public int getId_carro() {
        return id_carro;
    }

    public void setId_carro(int id_carro) {
        this.id_carro = id_carro;
    }

    public String getPlaca_carro() {
        return placa_carro;
    }

    public void setPlaca_carro(String placa_carro) {
        this.placa_carro = placa_carro;
    }

    public String getKm_carro() {
        return km_carro;
    }

    public void setKm_carro(String km_carro) {
        this.km_carro = km_carro;
    }

    public String getAno_carro() {
        return ano_carro;
    }

    public void setAno_carro(String ano_carro) {
        this.ano_carro = ano_carro;
    }

    public String getCor_carro() {
        return cor_carro;
    }

    public void setCor_carro(String cor_carro) {
        this.cor_carro = cor_carro;
    }

    public String getMarca_carro() {
        return marca_carro;
    }

    public void setMarca_carro(String marca_carro) {
        this.marca_carro = marca_carro;
    }

    public String getModelo_carro() {
        return modelo_carro;
    }

    public void setModelo_carro(String modelo_carro) {
        this.modelo_carro = modelo_carro;
    }

    public String getChassi_carro() {
        return chassi_carro;
    }

    public void setChassi_carro(String chassi_carro) {
        this.chassi_carro = chassi_carro;
    }


}
