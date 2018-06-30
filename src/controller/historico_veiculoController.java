package controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import main.Main;

public class historico_veiculoController implements Initializable{

    @FXML
    private TableColumn<?, ?> colu_cod_os;

    @FXML
    private TableColumn<?, ?> colun_placa;

    @FXML
    private TableColumn<?, ?> colun_modelo_veiculo;

    @FXML
    private TableColumn<?, ?> colun_data_entrada;

    @FXML
    private TableColumn<?, ?> colun_cod_cliente;

    @FXML
    private TableColumn<?, ?> colun_nome_cliente;

    @FXML
    private TableColumn<?, ?> colun_data_saida;

    @FXML
    private TableColumn<?, ?> colun_valor_total;

    @FXML
    private JFXButton bt_visualizar;

    @FXML
    private JFXButton bt_voltar;

    @FXML
    private Menu mn_hist_veiculo;

    @FXML
    private Menu mn_cad_veic;
    
    @FXML
    private TableView tv_hist_veiculo;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
           tv_hist_veiculo.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
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
