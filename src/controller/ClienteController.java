package controller;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import dao.DAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import main.Main;
import mapeamento.Cliente;
import util.TextFieldFormatter;
import util.ValidationFields;
import util.CPF;

public class ClienteController implements Initializable {

	@FXML
	private TextField tx_nome;
	@FXML
	private TextField tx_cpf;
	@FXML
	private TextField tx_telefone;
	@FXML
	private TextField tx_email;
	@FXML
	private TextField tx_endereco;
	@FXML
	private DatePicker dp_datanasc;
	@FXML
	private Button cadastrar;

	@SuppressWarnings("rawtypes")
	@FXML
	private TableView tv_cliente;

	@FXML
    private TableColumn<Cliente, String> tc_nome_clien;

    @FXML
    private TableColumn<Cliente, String> tc_telefone_clien;

    @FXML
    private TableColumn<Cliente, String> tc_email_clien;

    @FXML
    private TableColumn<Cliente, String> tc_endereco;

    @FXML
    private TableColumn<Cliente, String> tc_cpf;

        private ObservableList<Cliente> listaCliente;
	private DAO dao = new DAO();
	private static Cliente cliente;
	Date dateDate;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
				tc_nome_clien.setCellValueFactory(
                new PropertyValueFactory<>("nome_cliente")
        );
		tc_telefone_clien.setCellValueFactory(
                new PropertyValueFactory<>("tel_cliente")
        );
		tc_email_clien.setCellValueFactory(
                new PropertyValueFactory<>("email_cliente")
        );
		tc_endereco.setCellValueFactory(
                new PropertyValueFactory<>("endereco_cliente")
        );
		tc_cpf.setCellValueFactory(
                new PropertyValueFactory<>("cpf_cliente")
        );
        carregaDadosTabela();
	}
	@SuppressWarnings("unchecked")
	public void carregaDadosTabela() {
    	listaCliente = dao.consultar(Cliente.class);
    	tv_cliente.setItems(listaCliente);
    }

	public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
	    return java.sql.Date.valueOf(dateToConvert);
	}

	 @FXML
	    private void eventoTabela(MouseEvent event) {
	    	cliente = listaCliente.get(tv_cliente.getSelectionModel().getFocusedIndex());
	    	tx_nome.setText(cliente.getNome_cliente());
	    	tx_cpf.setText(cliente.getCpf_cliente());
	    	tx_telefone.setText(cliente.getTel_cliente());
	    	tx_email.setText(cliente.getEmail_cliente());
	    	tx_endereco.setText(cliente.getEndereco_cliente());
	    }

	 @FXML
	    private void atualizarCliente(ActionEvent event) {
		 ValidationFields.checkEmptyFields(tx_nome, tx_email, tx_cpf, tx_telefone,tx_endereco,dp_datanasc);
	    	if(checkCamposVazios()){
	    		cliente.setNome_cliente(tx_nome.getText());
	    		cliente.setEmail_cliente(tx_email.getText());
	    		cliente.setCpf_cliente(tx_cpf.getText());
	    		cliente.setTel_cliente(tx_telefone.getText());
	    		cliente.setEndereco_cliente(tx_endereco.getText());
	    		cliente.setDataNasc_Cliente(convertToDateViaSqlDate(dp_datanasc.getValue()));
	    	}else{
	    		Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Validate empty fields");
				alert.setHeaderText(null);
				alert.setContentText("Algum campo vazio!");
				alert.showAndWait();
	    	}
	            dao.update(cliente);
	            carregaDadosTabela();
	    }

	@FXML
	private void cadastrarCliente() {
		ValidationFields.checkEmptyFields(tx_nome, tx_email, tx_cpf, tx_telefone,tx_endereco,dp_datanasc);
		cliente = new Cliente();
		if(validateEmail() & validateCPF() & checkCamposVazios()){
			cliente.setNome_cliente(tx_nome.getText());
			cliente.setEmail_cliente(tx_email.getText());
			cliente.setCpf_cliente(tx_cpf.getText());
			cliente.setDataNasc_Cliente(convertToDateViaSqlDate(dp_datanasc.getValue()));
			cliente.setTel_cliente(tx_telefone.getText());
			cliente.setEndereco_cliente(tx_endereco.getText());
			dao.salvar(cliente);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Inclusão de cliente");
			alert.setContentText("Cliente inserido com sucesso!");
			alert.showAndWait();
		}
	}

	@FXML
	private void excluirCliente(ActionEvent event) {
		dao.delete(cliente);

	}

	@FXML
	private void tfTelefoneMask() {
		TextFieldFormatter tff = new TextFieldFormatter();
		tff.setMask("(##)#####-####");
		tff.setCaracteresValidos("0123456789");
		tff.setTf(tx_telefone);
		tff.formatter();
	}
	@FXML
	private void tfCpfMask() {
		TextFieldFormatter tff = new TextFieldFormatter();
		tff.setMask("###.###.###-##");
		tff.setCaracteresValidos("0123456789");
		tff.setTf(tx_cpf);
		tff.formatter();

	}

	private boolean checkCamposVazios(){
		if(tx_nome.getText().isEmpty() || tx_cpf.getText().isEmpty() || tx_email.getText().isEmpty() || tx_telefone.getText().isEmpty() || dp_datanasc.getValue().equals(null) || tx_endereco.getText().isEmpty()){
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
	private boolean validateEmail(){
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(tx_email.getText());
		if(m.find() && m.group().equals(tx_email.getText())){
			return true;
		}else{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Validate email");
			alert.setHeaderText(null);
			alert.setContentText("Email inv�lido!");
			alert.showAndWait();

			return false;
		}
	}
	private boolean validateCPF(){
		CPF pf = new CPF (tx_cpf.getText());
		if(pf.isCPF()){
			return true;
		}else{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Validate cpf");
			alert.setHeaderText(null);
			alert.setContentText("CPF inv�lido!");
			alert.showAndWait();
			return false;
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
}
