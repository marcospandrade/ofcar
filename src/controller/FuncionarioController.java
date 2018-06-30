package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
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
import mapeamento.Funcionario;
import util.TextFieldFormatter;
import util.ValidationFields;

public class FuncionarioController implements Initializable {

    @FXML
    private JFXTextField tx_nome_cad_funci;

    @FXML
    private JFXTextField tx_cpf_cad_funci;

    @FXML
    private JFXTextField tx_telefone_cad_funci;

    @FXML
    private JFXTextField tx_endereco_cad_funci;

    @FXML
    private JFXDatePicker dp_data_nac_cad_funci;

    @FXML
    private JFXButton bt_cancelar_cad_funci;

    @FXML
    private JFXButton bt_salvar_cad_funci;

    @FXML
    private JFXButton bt_editar_cad_funci;

    @FXML
    private JFXButton bt_excluir_cad_funci;

    @FXML
    private JFXTextField tx_cargo_cad_funci;

    @FXML
    private TableColumn<Funcionario, String> cl_nome_funci_cad_funci;

    @FXML
    private TableColumn<Funcionario, String> cl_cpf_cad_funci;

    @FXML
    private TableColumn<Funcionario, String> cl_telefone_cad_funci;

    @FXML
    private TableColumn<Funcionario, String> cl_endereco_cad_funci;

    @FXML
    private TableColumn<Funcionario, String> cl_cargo_cad_funci;

    @SuppressWarnings("rawtypes")
    @FXML
    private TableView tv_funcionario;

    private ObservableList<Funcionario> listaFuncionario;
    private DAO dao = new DAO();
    private static Funcionario funcionario;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tv_funcionario.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //Carregando a tabela
        cl_nome_funci_cad_funci.setCellValueFactory(
                new PropertyValueFactory<>("nome_func")
        );
        cl_cpf_cad_funci.setCellValueFactory(
                new PropertyValueFactory<>("cpf_func")
        );
        cl_telefone_cad_funci.setCellValueFactory(
                new PropertyValueFactory<>("tel_func")
        );
        cl_endereco_cad_funci.setCellValueFactory(
                new PropertyValueFactory<>("endereco_func")
        );
        cl_cargo_cad_funci.setCellValueFactory(
                new PropertyValueFactory<>("cargo_func")
        );
        carregaDadosTabela();
    }

    @SuppressWarnings("unchecked")
    public void carregaDadosTabela() {
        listaFuncionario = dao.consultar(Funcionario.class);
        tv_funcionario.setItems(listaFuncionario);
    }

    @FXML
    private void eventoTabela(MouseEvent event) {
        funcionario = listaFuncionario.get(tv_funcionario.getSelectionModel().getFocusedIndex());
        tx_nome_cad_funci.setText(funcionario.getNome_func());
        tx_cpf_cad_funci.setText(funcionario.getCpf_func());
        tx_telefone_cad_funci.setText(funcionario.getTel_func());
        tx_endereco_cad_funci.setText(funcionario.getEndereco_func());
        tx_cargo_cad_funci.setText(funcionario.getCargo_func());
    }

    @FXML
    private void cadastrarFuncionario() {
        ValidationFields.checkEmptyFields(tx_nome_cad_funci, tx_cpf_cad_funci, tx_telefone_cad_funci, tx_endereco_cad_funci, tx_cargo_cad_funci);
        if (checkCamposVazios()) {
            funcionario = new Funcionario();
            funcionario.setNome_func(tx_nome_cad_funci.getText());
            funcionario.setCpf_func(tx_cpf_cad_funci.getText());
            funcionario.setTel_func(tx_telefone_cad_funci.getText());
            funcionario.setEndereco_func(tx_endereco_cad_funci.getText());
            funcionario.setCargo_func(tx_cargo_cad_funci.getText());
            dao.salvar(funcionario);
            
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Inclusão de Funcionário");
			alert.setContentText("Funcionário inserido com sucesso!");
			alert.showAndWait();            
            carregaDadosTabela();
            emptyFields();
        }
    }

    private void emptyFields() {
        tx_nome_cad_funci.setText("");
        tx_cpf_cad_funci.setText("");
        tx_telefone_cad_funci.setText("");
        tx_endereco_cad_funci.setText("");
        tx_cargo_cad_funci.setText("");
    }

    private boolean checkCamposVazios() {
        if (tx_nome_cad_funci.getText().isEmpty() || tx_cpf_cad_funci.getText().isEmpty() || tx_telefone_cad_funci.getText().isEmpty() || tx_endereco_cad_funci.getText().isEmpty() || tx_cargo_cad_funci.getText().isEmpty()) {
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
    private void atualizarFuncionario(ActionEvent event) {
        ValidationFields.checkEmptyFields(tx_nome_cad_funci, tx_cpf_cad_funci, tx_telefone_cad_funci, tx_endereco_cad_funci, tx_cargo_cad_funci);
        if (checkCamposVazios()) {
            funcionario.setNome_func(tx_nome_cad_funci.getText());
            funcionario.setCpf_func(tx_cpf_cad_funci.getText());
            funcionario.setTel_func(tx_telefone_cad_funci.getText());
            funcionario.setEndereco_func(tx_endereco_cad_funci.getText());
            funcionario.setCargo_func(tx_cargo_cad_funci.getText());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate empty fields");
            alert.setHeaderText(null);
            alert.setContentText("Algum campo vazio!");
            alert.showAndWait();
        }
        dao.update(funcionario);
        carregaDadosTabela();
    }

    @FXML
    private void excluirFuncionario(ActionEvent event) {
        dao.delete(funcionario);
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
    private void tfTelefoneMask() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("(##)#####-####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(tx_telefone_cad_funci);
        tff.formatter();
    }

    @FXML
    private void tfCpfMask() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###.###.###-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(tx_cpf_cad_funci);
        tff.formatter();

    }
}
