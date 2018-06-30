/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOUsuario;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import mapeamento.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import main.Main;
/**
 *
 * @author Marcos
 */
public class LoginController {

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private TextField username;

    @FXML
    private PasswordField senha;

    static DAOUsuario usuarioDAO = new DAOUsuario();

    public static Usuario buscaUsuario(String username, String senha) {
        try {

            // AQUI MANDO LA PARA CLASSE DAO
            // E ELE ME RETORNA UM OBJETO QUE DEVE TER O LOGIN E SENHA
            // PASSADOS POR PARAMETRO
            // O USUÁRIO SÓ PE UNICO SE HAVER
            // LOGIN E SENHA 
            Usuario usuario = usuarioDAO.getUsuarioLoginSenha(username, senha);

            // AQUI SE FOR DIFERENTE DE NULL, ENTÃO ACHOO O USUARIO
            if (usuario != null) {

                // RETORNA O USUARIO ENCONTRADO
                return usuario;
            }
        } catch (Exception e) {
            System.out.println("ErrooO !! " + e.getMessage());
        }

        JOptionPane.showMessageDialog(null, "Usuario não encontrado !! Login ou Senhas incorretos !");
        return null;
    }

    @FXML
    public void logar(ActionEvent event) throws IOException {

        Usuario user;
        user = new Usuario();

        user = buscaUsuario(username.getText(), senha.getText());

        if (user == null) {
            JOptionPane.showMessageDialog(null, "Deu erro");
        } else {
        	Main.trocarTela("main");
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
    public void handleClose(){
        System.exit(0);
    }
}
