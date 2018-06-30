package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import main.Main;
import util.TextFieldFormatter;

public class UsuarioController {

	@FXML
	private JFXTextField tx_nome_usuario;
	@FXML
	private JFXTextField tx_email_usuario;
	@FXML
	private JFXTextField tx_telefone_usuario;
	@FXML
	private JFXTextField tx_username_usuario;
	@FXML
	private JFXPasswordField pf_senha_usuario;
	@FXML
	private JFXTextField tx_resposta_usuario;

	@FXML
	protected void cadastrarUsuario(ActionEvent e){

	}
	@FXML
	protected void cancelar(){
		try{
    		Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja voltar?", ButtonType.YES, ButtonType.NO);
    		alert.setTitle("Cancelar");
			alert.showAndWait();
			if (alert.getResult() == ButtonType.YES) {
				Main.trocarTela("main");
			}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}

	@FXML
	private void tfTelefoneMask() {
		TextFieldFormatter tff = new TextFieldFormatter();
		tff.setMask("(##)#####-####");
		tff.setCaracteresValidos("0123456789");
		tff.setTf(tx_telefone_usuario);
		tff.formatter();
	}
}
