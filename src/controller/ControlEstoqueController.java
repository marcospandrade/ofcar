package controller;

import dao.DAO;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main;
import mapeamento.ControleEstoque;
import mapeamento.Fornecedor;
import mapeamento.Produto;
import util.MoedaValidation;



public class ControlEstoqueController implements Initializable {
    @FXML
    private JFXTextField tx_fornecedor;

    @FXML
    private DatePicker dt_data_estoque;

    @FXML
    private JFXTextField tx_cod_nota;

    @FXML
    private JFXButton bt_editar;

    @FXML
    private JFXButton bt_excluir;

    @FXML
    private TableColumn <ControleEstoque, String> coluna_id_produto;

    @FXML
    private TableColumn <ControleEstoque, String> coluna_nome;

    @FXML
    private TableColumn <ControleEstoque, Fornecedor> coluna_fornecedor;

    @FXML
    private TableColumn<ControleEstoque, Float> coluna_quantidade_produto;

    @FXML
    private TableColumn<ControleEstoque, Float> coluna_valor_uni;

    @FXML
    private TableColumn<ControleEstoque, Float> coluna_valor_total;

    @FXML
    private Label label_porcentagem_lucro;

    @SuppressWarnings("rawtypes")
	@FXML
    private TableView tv_entrada_produto;

    @SuppressWarnings("rawtypes")
	@FXML
    private JFXComboBox cb_fornecedor;

    private ObservableList<Produto> listaEstoque;
    private ObservableList<Fornecedor> listaFornecedores;
    private DAO dao = new DAO();
    private Produto produto = new Produto();
    MoedaValidation mv = new MoedaValidation();

    @SuppressWarnings({ "unchecked", "unused" })
	@Override
    public void initialize(URL location, ResourceBundle resources) {

    	listaFornecedores = dao.consultar(Fornecedor.class);
    	cb_fornecedor.setItems(listaFornecedores);
    	cb_fornecedor.setValue("Escolha um fornecedor");

        //Carregando a tabela
    	coluna_id_produto.setCellValueFactory(
                new PropertyValueFactory<>("id_estoque")
        );
    	coluna_nome.setCellValueFactory(
                new PropertyValueFactory<>("nome_produto")
        );
    	coluna_fornecedor.setCellValueFactory(
                new PropertyValueFactory<>("fornecedor")
        );
    	coluna_quantidade_produto.setCellValueFactory(
                new PropertyValueFactory<>("quantidade")
        );
    	coluna_valor_uni.setCellValueFactory(
                new PropertyValueFactory<>("preco_custo")
        );
    	coluna_valor_total.setCellValueFactory(
                new PropertyValueFactory<>("preco_venda")
        );
        carregaDadosTabela();
    }

    @SuppressWarnings("unchecked")
	public void carregaDadosTabela() {
    	listaEstoque = dao.consultar(Produto.class);
    	tv_entrada_produto.setItems(listaEstoque);
    }

    @FXML
    public void eventoTabela(){
    	 produto = listaEstoque.get(tv_entrada_produto.getSelectionModel().getFocusedIndex());
    }
    @FXML
    protected void atualizarLista(ActionEvent e){
    	carregaDadosTabela();
    }

    @FXML
    protected void voltar(ActionEvent ev){
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

    @FXML
    private void telaFornecedor(){
    	try{
    		Main.trocarTela("fornecedor");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

}
