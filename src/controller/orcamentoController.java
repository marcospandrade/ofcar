
package controller;

import com.jfoenix.controls.JFXButton;
import dao.DAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main;
import mapeamento.Orcamento;

public class orcamentoController implements Initializable{

    @FXML
    private JFXButton bt_novo_orcam;

    @FXML
    private JFXButton bt_editar_orcam;

    @FXML
    private JFXButton bt_excluir_orcam;

    @FXML
    private JFXButton bt_cancelar_orcam;

    @FXML
    private RadioButton rb_aberto_orcam;

    @FXML
    private ToggleGroup situacao;

    @FXML
    private RadioButton rb_fechado_orcam;

    @FXML
    private TableView<Orcamento> tv_tabela_orcam;

    @FXML
    private TableColumn<Orcamento, String> tb_situacao_orcam;

    @FXML
    private TableColumn<Orcamento, Integer> tc_cod_orcam;

    @FXML
    private TableColumn<Orcamento, String> tc_nome_clien;

    @FXML
    private TableColumn<Orcamento, String> tc_placa;

    @FXML
    private TableColumn<Orcamento, String> tc_veiculo;

    @FXML
    private TableColumn<Orcamento, String> tc_funcionario;

    @FXML
    private TableColumn<Orcamento, Float> tc_valor_totaal;

    @FXML
    private MenuBar mb_menu_orcam;

    @FXML
    private Menu mb_orcamentos_orcam;

    @FXML
    private Menu mb_apont_orcam;
    
    private ObservableList<Orcamento> listaOrcamento;
    private DAO dao = new DAO();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
        tv_tabela_orcam.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tb_situacao_orcam.setCellValueFactory(
                new PropertyValueFactory<>("situacao")
        );
        tc_cod_orcam.setCellValueFactory(
                new PropertyValueFactory<>("id_orcamento")
        );
        tc_nome_clien.setCellValueFactory(
                new PropertyValueFactory<>("cliente_orcamento")
        );
        tc_placa.setCellValueFactory(
                new PropertyValueFactory<>("placa_orcamento")
        );        
        tc_veiculo.setCellValueFactory(
                new PropertyValueFactory<>("veiculo_orcamento")
        ); 
        tc_funcionario.setCellValueFactory(
                new PropertyValueFactory<>("funcionario_orcamento")
        ); 
        tc_valor_totaal.setCellValueFactory(
                new PropertyValueFactory<>("total_orcamento")
        );         
        carregaDadosTabela();
    }
    
    @SuppressWarnings("unchecked")
    public void carregaDadosTabela() {
        listaOrcamento = dao.consultar(Orcamento.class);
        tv_tabela_orcam.setItems(listaOrcamento);
    }    
  
    @FXML 
    private void novo_orcamento(ActionEvent event) throws IOException{
    	Main.trocarTela("novo_orcamento");
    }  

    @FXML 
    private void apontamento(ActionEvent event) throws IOException{
    	Main.trocarTela("apontamento");
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
