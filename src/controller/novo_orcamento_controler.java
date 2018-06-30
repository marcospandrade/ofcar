package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main;
import mapeamento.Orcamento;
import mapeamento.Produto;
import mapeamento.Servico;
import util.MoedaValidation;
import util.TextFieldFormatter;
import util.ValidationFields;

public class novo_orcamento_controler implements Initializable {

    @FXML
    private JFXTextField tx_cliente_emic_os;

    @FXML
    private JFXTextField tx_funcio_novo_orcam;

    @FXML
    private JFXTextField tx_veiculo_novo_orca;

    @FXML
    private JFXTextField tx_placa_emic_os;

    @FXML
    private JFXTextField tx_total;

    @FXML
    private JFXButton bt_salvar_novo_orcam;

    @FXML
    private JFXButton bt_gerar_os;

    @FXML
    private JFXButton bt_imprimir_novo_orcame;

    @FXML
    private JFXButton bt_cancelar;

    @FXML
    private TabPane tp_prod_or_servi;

    @FXML
    private Tab t_produto;

    @FXML
    private TableView<Produto> tv_produtos;

    @FXML
    private TableColumn<Produto, Boolean> tc_select;

    @FXML
    private TableColumn<Produto, Integer> tc_cod_prod;

    @FXML
    private TableColumn<Produto, String> tc_descri_prod;

    @FXML
    private TableColumn<Produto, Integer> tc_quant_prod;

    @FXML
    private TableColumn<Produto, Float> tc_valor_unit;

    @FXML
    private TableColumn<Produto, Float> tc_valor_total;

    @FXML
    private TableView<Servico> tv_servico;

    @FXML
    private TableColumn<Servico, Boolean> tc_select_servico;

    @FXML
    private TableColumn<Servico, Integer> tc_cod_servico;

    @FXML
    private TableColumn<Servico, String> tc_descri_serv;

    @FXML
    private TableColumn<Servico, Integer> tc_quant_serv;

    @FXML
    private TableColumn<Servico, Float> tc_valor_unit_servi;

    @FXML
    private TableColumn<Servico, Float> tc_total_valor_servi;

    private ObservableList<Produto> listaProduto;
    private ObservableList<Servico> listaServico;
    private DAO dao = new DAO();
    private Orcamento orcamento;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tv_produtos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tv_servico.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tc_cod_prod.setCellValueFactory(
                new PropertyValueFactory<>("id_produto")
        );
        tc_descri_prod.setCellValueFactory(
                new PropertyValueFactory<>("nome_produto")
        );
        tc_quant_prod.setCellValueFactory(
                new PropertyValueFactory<>("quantidade")
        );
        tc_valor_unit.setCellValueFactory(
                new PropertyValueFactory<>("preco_custo")
        );
        tc_valor_total.setCellValueFactory(
                new PropertyValueFactory<>("preco_venda")
        );
        tc_select.setCellValueFactory(
                new PropertyValueFactory<Produto, Boolean>("selected"));

        tc_select.setCellFactory(CheckBoxTableCell.forTableColumn(tc_select));

        tc_cod_servico.setCellValueFactory(
                new PropertyValueFactory<>("id_servico")
        );
        tc_descri_serv.setCellValueFactory(
                new PropertyValueFactory<>("descricao_servico")
        );
        tc_valor_unit_servi.setCellValueFactory(
                new PropertyValueFactory<>("valor_servico")
        );
        tc_total_valor_servi.setCellValueFactory(
                new PropertyValueFactory<>("")
        );
        tc_select_servico.setCellValueFactory(
                new PropertyValueFactory<Servico, Boolean>("selected"));

        tc_select_servico.setCellFactory(CheckBoxTableCell.forTableColumn(tc_select_servico));

        carregaDadosTabela();
    }

    @SuppressWarnings("unchecked")
    public void carregaDadosTabela() {
        listaProduto = dao.consultar(Produto.class);
        tv_produtos.setItems(listaProduto);

        listaServico = dao.consultar(Servico.class);
        tv_servico.setItems(listaServico);
    }
    
    @FXML 
    private void orcamento(ActionEvent event) throws IOException{
    	Main.trocarTela("orcamento");
    }      

    @FXML
    private void cadastrarOrcamento(ActionEvent event) throws IOException {
        ValidationFields.checkEmptyFields(tx_cliente_emic_os,tx_funcio_novo_orcam,tx_veiculo_novo_orca,tx_placa_emic_os,tx_total);
        orcamento = new Orcamento();
        if (checkCamposVazios()) {
            orcamento.setCliente_orcamento(tx_cliente_emic_os.getText());
            orcamento.setFuncionario_orcamento(tx_funcio_novo_orcam.getText());
            orcamento.setVeiculo_orcamento(tx_veiculo_novo_orca.getText());
            orcamento.setPlaca_orcamento(tx_placa_emic_os.getText());
            orcamento.setTotal_orcamento(Float.parseFloat(tx_total.getText()));
            orcamento.setSituacao("aberta");
            dao.salvar(orcamento);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Inclusão de orçamento");
            alert.setContentText("Orçamento inserido com sucesso!");
            alert.showAndWait();
            emptyFields();
        }
    }
    
    private void emptyFields() {
        tx_cliente_emic_os.setText("");
        tx_funcio_novo_orcam.setText("");
        tx_veiculo_novo_orca.setText("");
        tx_placa_emic_os.setText("");
        tx_total.setText("");
    }    

    
    private boolean checkCamposVazios() {
        if (tx_cliente_emic_os.getText().isEmpty() || tx_funcio_novo_orcam.getText().isEmpty() || tx_veiculo_novo_orca.getText().isEmpty() || tx_placa_emic_os.getText().isEmpty() || tx_total.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Validate empty fields");
            alert.setHeaderText(null);
            alert.setContentText("Algum campo vazio!");
            alert.showAndWait();

            return false;
        } else {
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
    private void tfTotal(){
    	MoedaValidation.monetaryField(tx_total);
    }    
    
    @FXML
    private void tfPlacaMask() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("UUU-####");
        tff.setTf(tx_placa_emic_os);
        tff.formatter();
    }    
}
