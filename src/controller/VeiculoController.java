/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import main.Main;
import mapeamento.Veiculo;
import util.TextFieldFormatter;

/**
 *
 * @author Ale
 */
public class VeiculoController implements Initializable {

    @FXML
    private TextField tx_modelo;
    @FXML
    private TextField tx_placa_carro;
    @FXML
    private TextField tx_marca;
    @FXML
    private TextField tx_km;
    @FXML
    private TextField tx_ano;
    @FXML
    private TextField tx_cor;
    @FXML
    private TextField tx_chassi;

    
    @FXML
    private Button bt_cadastrar;
    @FXML
    private Button bt_cancelar;

    private static Veiculo veiculo;
    private DAO dao = new DAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void cadastrarVeiculo(ActionEvent event) {
        veiculo = new Veiculo();

        if (tx_placa_carro.getText().equals("")) {
            tx_placa_carro.requestFocus();
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("O campo Placa é obrigatório!");
            alert.showAndWait();
            return;
        }
        if (tx_modelo.getText().equals("")) {
            tx_modelo.requestFocus();
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("O campo Modelo é obrigatório!");
            alert.showAndWait();
            return;
        }
        if (tx_marca.getText().equals("")) {
            tx_marca.requestFocus();
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("O campo Marca é obrigatório!");
            alert.showAndWait();
            return;
        }
        if (tx_ano.getText().equals("")) {
            tx_ano.requestFocus();
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("O campo Ano é obrigatório!");
            alert.showAndWait();
            return;
        }
        if (tx_cor.getText().equals("")) {
            tx_cor.requestFocus();
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("O campo Cor é obrigatório!");
            alert.showAndWait();
            return;
        }

        try {
            veiculo.setModelo_carro(tx_modelo.getText());
            veiculo.setPlaca_carro(tx_placa_carro.getText());
            veiculo.setMarca_carro(tx_marca.getText());
            veiculo.setKm_carro(tx_km.getText());
            veiculo.setAno_carro(tx_ano.getText());
            veiculo.setCor_carro(tx_cor.getText());
            veiculo.setChassi_carro(tx_chassi.getText());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "falta algo");
        }
        dao.salvar(veiculo);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Mensagem");
        alert.setHeaderText(null);
        alert.setContentText("Cadastrado com sucesso!");
        alert.showAndWait();        
        ClearText();
    }

    private void ClearText() {
        tx_modelo.clear();
        tx_placa_carro.clear();
        tx_marca.clear();
        tx_km.clear();
        tx_ano.clear();
        tx_cor.clear();
        tx_chassi.clear();
    }

    @FXML
    private void tfPlacaMask() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("UUU-####");
        tff.setTf(tx_placa_carro);
        tff.formatter();
    }

    @FXML
    private void tfKmMask() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###############");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(tx_km);
        tff.formatter();
    }

    @FXML
    private void tfAnoMask() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(tx_ano);
        tff.formatter();
    }

    @FXML
    private void excluirVeiculo(ActionEvent event) {
        dao.delete(veiculo);

    }
    
	 @FXML
	    private void voltar(){
	    	try{
	    		Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja voltar ao menu principal?", ButtonType.YES, ButtonType.NO);
	    		alert.setTitle("Logout");
				alert.showAndWait();
				if (alert.getResult() == ButtonType.YES) {
					Main.trocarTela("main");
				}
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}

	    } 
}
