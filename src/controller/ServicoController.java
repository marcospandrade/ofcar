package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import dao.DAO;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import main.Main;
import mapeamento.Servico;
import util.MoedaValidation;
import util.ValidationFields;

public class ServicoController implements Initializable {

    @FXML
    private JFXTextField tx_nome_servico;

    @FXML
    private JFXTextField tx_valor_servico;

    @FXML
    private JFXTextArea ta_descicao_servico;

    @FXML
    private JFXButton bt_cancelar;

    @FXML
    private JFXButton bt_cadastrar_servico;

    @FXML
    private JFXButton bt_editar_servico;

    @FXML
    private JFXButton bt_excluir_servico;

    @FXML
    private TableColumn<Servico, String> tc_nome_servico;

    @FXML
    private TableColumn<Servico, String> tc_descricao_servico;

    @FXML
    private TableColumn<Servico, Float> tc_valor_servico;

    @SuppressWarnings("rawtypes")
    @FXML
    private TableView tv_servico;

    private ObservableList<Servico> listaServico;
    private DAO dao = new DAO();
    private static Servico servico;
    MoedaValidation mv = new MoedaValidation();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tv_servico.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //Carregando a tabela
        tc_nome_servico.setCellValueFactory(
                new PropertyValueFactory<>("nome_servico")
        );
        tc_descricao_servico.setCellValueFactory(
                new PropertyValueFactory<>("descricao_servico")
        );
        tc_valor_servico.setCellValueFactory(
                new PropertyValueFactory<>("valor_servico")
        );
        carregaDadosTabela();
    }

    @SuppressWarnings("unchecked")
    public void carregaDadosTabela() {
        listaServico = dao.consultar(Servico.class);
        tv_servico.setItems(listaServico);
    }

    @FXML
    private void eventoTabela(MouseEvent event) {
        servico = listaServico.get(tv_servico.getSelectionModel().getFocusedIndex());
        tx_nome_servico.setText(servico.getNome_servico());
        ta_descicao_servico.setText(servico.getDescricao_servico());
        tx_valor_servico.setText(String.valueOf(servico.getValor_servico()));
    }

    @FXML
    private void cadastrarServico() {
        ValidationFields.checkEmptyFields(tx_nome_servico, ta_descicao_servico, tx_valor_servico);
        if (checkCamposVazios()) {
            servico = new Servico();
            servico.setNome_servico(tx_nome_servico.getText());
            servico.setDescricao_servico(ta_descicao_servico.getText());
            servico.setValor_servico(Float.parseFloat(tx_valor_servico.getText()));
            dao.salvar(servico);
            carregaDadosTabela();
            emptyFields();
        }
    }

    private void emptyFields() {
        tx_nome_servico.setText("");
        ta_descicao_servico.setText("");
        tx_valor_servico.setText("");
    }

    private boolean checkCamposVazios() {
        if (tx_nome_servico.getText().isEmpty() || ta_descicao_servico.getText().isEmpty() || tx_valor_servico.getText().isEmpty()) {
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

    @FXML
    private void atualizarServico(ActionEvent event) {
        ValidationFields.checkEmptyFields(tx_nome_servico, ta_descicao_servico, tx_valor_servico);
        if (checkCamposVazios()) {
            servico.setNome_servico(tx_nome_servico.getText());
            servico.setDescricao_servico(ta_descicao_servico.getText());
            servico.setValor_servico(Float.parseFloat(tx_valor_servico.getText()));
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate empty fields");
            alert.setHeaderText(null);
            alert.setContentText("Algum campo vazio!");
            alert.showAndWait();
        }
        dao.update(servico);
        carregaDadosTabela();
    }

    @FXML
    private void excluirServico(ActionEvent event) {
        dao.delete(servico);
        carregaDadosTabela();

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
    private void tfValor() {
        MoedaValidation.monetaryField(tx_valor_servico);
    }

}
