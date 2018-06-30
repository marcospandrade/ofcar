package controller;

import com.jfoenix.controls.JFXButton;
import dao.DAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import main.Main;
import mapeamento.Ordem_aberta_produtos;
import mapeamento.Produto;

public class emicao2Controller implements Initializable{

    @FXML
    private JFXButton bt_salvar_emic_os;

    @FXML
    private JFXButton bt_fechar_emic_os;

    @FXML
    private JFXButton bt_imprimir_emic_os;

    @FXML
    private JFXButton bt_apont_orc_emic_os;

    @FXML
    private JFXButton bt_hist_placa_emic_os;
    
    @FXML
    private TableColumn <Produto, Boolean> tc_select;    

    @FXML
    private TableColumn<Produto, Integer> tc_cod_prod_emic_os;

    @FXML
    private TableColumn<Produto, String> tc_descri_prod_emic_os;

    @FXML
    private TableColumn<Produto, Integer> tc_quant_emic_os;

    @FXML
    private TableColumn<Produto, Float> tc_valor_uni_emic_os;

    @FXML
    private TableColumn<Produto, Float> tc_total_emic_os;

    @FXML
    private Menu mb_dados_emic_os;

    @FXML
    private Menu mb_prod_serv_emic_os;

    @FXML
    private MenuItem mi_produto_emic_os;

    @FXML
    private MenuItem mi_servico_emic_os;

    @FXML
    private Menu mb_fechamento_emic_os;

    @FXML
    private TableView tv_produto;
    
    private ObservableList<Produto> listaProduto;
    private Ordem_aberta_produtos ordem_produtos;
    private Produto produto;
    private DAO dao = new DAO();     
    
        @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        tv_produto.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        tc_cod_prod_emic_os.setCellValueFactory(
                new PropertyValueFactory<>("id_produto")
        ); 
        tc_descri_prod_emic_os.setCellValueFactory(
                new PropertyValueFactory<>("nome_produto")
        );
                tc_quant_emic_os.setCellValueFactory(
                new PropertyValueFactory<>("quantidade")
        );
        tc_valor_uni_emic_os.setCellValueFactory(
                new PropertyValueFactory<>("preco_custo")
        );   
        tc_total_emic_os.setCellValueFactory(
                new PropertyValueFactory<>("preco_venda")
        );      
        tc_select.setCellValueFactory(
                new PropertyValueFactory<Produto, Boolean>("selected"));
        
        tc_select.setCellFactory(CheckBoxTableCell.forTableColumn(tc_select));  
        carregaDadosTabela();  
    }    
    
public class CheckBoxCellFactory<S, T>
          implements Callback<TableColumn<S, T>, TableCell<S, T>> {
    @Override public TableCell<S, T> call(TableColumn<S, T> p) {
        return new CheckBoxTableCell<>();
    }
}    

    @SuppressWarnings("unchecked")
	public void carregaDadosTabela() {
    	listaProduto = dao.consultar(Produto.class);
        ObservableList<Produto> produtoList = FXCollections.observableArrayList();
        
        for(Produto bean : listaProduto){
                produtoList.add(bean);
            }
        tv_produto.setItems(produtoList);
   
    } 
    
    @FXML 
    private void emicao(ActionEvent event) throws IOException{
    	Main.trocarTela("emicao");
    }  
    
    @FXML 
    private void historico_veiculo(ActionEvent event) throws IOException{
    	Main.trocarTela("historico_veiculo");
    }  
     
    @FXML 
    private void apontamento(ActionEvent event) throws IOException{
    	Main.trocarTela("apontamento");
    }  

    @FXML 
    private void emicao3(ActionEvent event) throws IOException{
    	Main.trocarTela("emicao3");
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
