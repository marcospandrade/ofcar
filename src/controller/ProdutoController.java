package controller;

import dao.DAO;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import main.Main;
import mapeamento.Produto;
import util.MoedaValidation;
import util.ValidationFields;



public class ProdutoController implements Initializable {
	@FXML
    private JFXButton bt_cancelar;

    @FXML
    private JFXButton bt_salvar;

    @FXML
    private JFXTextField tx_nome_peca;

    @FXML
    private JFXTextField tx_ref_pecas;

    @FXML
    private JFXTextField tx_preco_custo;

    @FXML
    private JFXTextField tx_preco_venda;

    @FXML
    private JFXButton bt_editar;

    @FXML
    private JFXButton bt_excluir;

    @FXML
    private TableColumn <Produto, String> cl_nome_peca_cad_peca;

    @FXML
    private TableColumn <Produto, String> cl_ref_cad_pec;

    @FXML
    private TableColumn<Produto, Float> cl_preco_custo_cad_peca;

    @FXML
    private TableColumn<Produto, Float> cl_preco_vend_cad_peca;

    @FXML
    private TableColumn<Produto, Integer> cl_porc_lucro_cad_peca;

    @FXML
    private Label label_porcentagem_lucro;

    @SuppressWarnings("rawtypes")
	@FXML
    private TableView tv_produtos;

    private ObservableList<Produto> listaProduto;
    private DAO dao = new DAO();
    private static Produto produto;
    MoedaValidation mv = new MoedaValidation();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tv_produtos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //Carregando a tabela
    	cl_nome_peca_cad_peca.setCellValueFactory(
                new PropertyValueFactory<>("nome_produto")
        );
    	cl_ref_cad_pec.setCellValueFactory(
                new PropertyValueFactory<>("ref_produto")
        );
    	cl_preco_custo_cad_peca.setCellValueFactory(
                new PropertyValueFactory<>("preco_custo")
        );
    	cl_preco_vend_cad_peca.setCellValueFactory(
                new PropertyValueFactory<>("preco_venda")
        );
    	cl_porc_lucro_cad_peca.setCellValueFactory(
                new PropertyValueFactory<>("porcentagem_lucro_produto")
        );
        carregaDadosTabela();
    }

    @SuppressWarnings("unchecked")
	public void carregaDadosTabela() {
    	listaProduto = dao.consultar(Produto.class);
        tv_produtos.setItems(listaProduto);
    }

    @FXML
    private void eventoTabela(MouseEvent event) {
    	produto = listaProduto.get(tv_produtos.getSelectionModel().getFocusedIndex());
    	tx_nome_peca.setText(produto.getNome_produto());
    	tx_ref_pecas.setText(produto.getReferencia_produto());
    	tx_preco_custo.setText(String.valueOf(produto.getPreco_custo()));
    	tx_preco_venda.setText(String.valueOf(produto.getPreco_venda()));
    	label_porcentagem_lucro.setText(String.valueOf(produto.getPorcentagem_lucro_produto()));
    }

    @FXML
    private void cadastrarPeca() {
    	ValidationFields.checkEmptyFields(tx_nome_peca, tx_preco_custo, tx_preco_venda);
    	if(checkCamposVazios()){
        produto = new Produto();
        produto.setNome_produto(tx_nome_peca.getText());
        produto.setPreco_custo(Float.parseFloat(tx_preco_custo.getText()));
        produto.setPreco_venda(Float.parseFloat(tx_preco_venda.getText()));
        produto.setReferencia_produto(tx_ref_pecas.getText());
        if(!label_porcentagem_lucro.getText().isEmpty()){
        	produto.setPorcentagem_lucro_produto(Float.parseFloat(label_porcentagem_lucro.getText()));
        }
        dao.salvar(produto);
        carregaDadosTabela();
    	}
    	emptyFields();
    }

    @FXML
    private void atualizarPeca(ActionEvent event) {
    	ValidationFields.checkEmptyFields(tx_nome_peca, tx_preco_custo, tx_preco_venda);
    	if(checkCamposVazios()){
            produto.setNome_produto(tx_nome_peca.getText());
            produto.setPreco_custo(Float.parseFloat(tx_preco_custo.getText()));
            produto.setPreco_venda(Float.parseFloat(tx_preco_venda.getText()));
            produto.setReferencia_produto(tx_ref_pecas.getText());
            produto.setPorcentagem_lucro_produto(Float.parseFloat(label_porcentagem_lucro.getText()));
    	}else{
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Validate empty fields");
			alert.setHeaderText(null);
			alert.setContentText("Algum campo vazio!");
			alert.showAndWait();
    	}
            dao.update(produto);
            carregaDadosTabela();
    }

    @FXML
    private void excluirPeca(ActionEvent event) {
        dao.delete(produto);
        carregaDadosTabela();

    }

    private void emptyFields(){
    	tx_nome_peca.setText("");
    	tx_ref_pecas.setText("");
    	tx_preco_custo.setText("");
    	tx_preco_venda.setText("");
    	label_porcentagem_lucro.setText("");
    }

    private boolean checkCamposVazios(){
		if(tx_nome_peca.getText().isEmpty() || tx_preco_custo.getText().isEmpty() || tx_preco_venda.getText().isEmpty()){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Validate empty fields");
			alert.setHeaderText(null);
			alert.setContentText("Algum campo vazio!");
			alert.showAndWait();

			return false;
		}else{
			return true;
		}

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


    @FXML
    private void tfPreco_custo(){
    	MoedaValidation.monetaryField(tx_preco_custo);
    }

    @FXML
    private void tfPreco_venda(){
    	MoedaValidation.monetaryField(tx_preco_venda);
    }

    @FXML
    private void calculaPorcentagem(){
    	try{
    		float preco_custo = Float.parseFloat(tx_preco_custo.getText());
        	float preco_venda = Float.parseFloat(tx_preco_venda.getText());
        	float lucro = preco_venda - preco_custo;

        	float result = ((lucro/preco_venda)*100);

        	//tfCPF.getText().replaceAll("[\\-\\.]","");
        	label_porcentagem_lucro.setText(String.valueOf(result));
    	}catch(Exception e){
    		e.printStackTrace();
    	}


    }

}
