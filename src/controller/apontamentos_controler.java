package controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import main.Main;

public class apontamentos_controler implements Initializable{

    @FXML
    private JFXButton bt_verificar;

    @FXML
    private JFXButton bt_excluir;

    @FXML
    private JFXButton bt_cancelar;

    @FXML
    private TableView<?> tv_bebela_apontamentos;

    @FXML
    private TableColumn<?, ?> tc_descricao_apontamentos;

    @FXML
    private TableColumn<?, ?> tc_cod_clien;

    @FXML
    private TableColumn<?, ?> tc_nome_clien;

    @FXML
    private TableColumn<?, ?> tc_veiculo;

    @FXML
    private TableColumn<?, ?> tc_placa;

    @FXML
    private TableColumn<?, ?> tc_valor_total;

    @FXML
    private MenuBar mb_menu_orcam;

    @FXML
    private Menu mb_orcamentos_orcam;

    @FXML
    private Menu mb_apont_orcam;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        tv_bebela_apontamentos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    
    @FXML 
    private void orcamento(ActionEvent event) throws IOException{
    	Main.trocarTela("orcamento");
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
}
