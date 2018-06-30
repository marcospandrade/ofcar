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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.Main;
import mapeamento.Laudo;
import util.TextFieldFormatter;
import util.ValidationFields;

/**
 *
 * @author Ale
 */
public class LaudoController implements Initializable {

    @FXML
    private Button bt_cadastrar;
    @FXML
    private Button bt_cancelar;

    @FXML
    private TextField tx_cliente;

    @FXML
    private TextField tx_placa;

    @FXML
    private TextField tx_data;

    @FXML
    private TextArea txLaudoReclamacao;

    private static Laudo laudo;
    private DAO dao = new DAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void cadastrarLaudo(ActionEvent event) {
        ValidationFields.checkEmptyFields(tx_cliente, tx_placa, tx_data, txLaudoReclamacao);

        laudo = new Laudo();
        if (checkCamposVazios()) {
            laudo.setLaudo_cliente(tx_cliente.getText());
            laudo.setLaudo_placa(tx_placa.getText());
            laudo.setLaudo_data(tx_data.getText());
            laudo.setLaudo_reclamacao(txLaudoReclamacao.getText());
            dao.salvar(laudo);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inclusão de Laudo");
            alert.setContentText("Laudo inserido com sucesso!");
            alert.showAndWait();
            emptyFields();
        }
    }

	 @FXML
	    private void voltar(){
	    	try{
	    		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja voltar ao menu principal?", ButtonType.YES, ButtonType.NO);
	    		alert.setTitle("Logout");
				alert.showAndWait();
				if (alert.getResult() == ButtonType.YES) {
					Main.trocarTela("main");
				}
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}

	    }

    @FXML
    private void tfPlacaMask() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("UUU-####");
        tff.setTf(tx_placa);
        tff.formatter();
    }

    private void emptyFields() {
        tx_cliente.setText("");
        tx_placa.setText("");
        tx_data.setText("");
        txLaudoReclamacao.setText("");
    }

    private boolean checkCamposVazios() {
        if (tx_cliente.getText().isEmpty() || tx_placa.getText().isEmpty() || txLaudoReclamacao.getText().isEmpty() || tx_data.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate empty fields");
            alert.setHeaderText(null);
            alert.setContentText("Algum campo vazio!");
            alert.showAndWait();

            return false;
        } else {
            return true;
        }

    }
}
