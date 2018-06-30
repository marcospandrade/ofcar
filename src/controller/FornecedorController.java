package controller;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import main.Main;
import mapeamento.Fornecedor;
import util.TextFieldFormatter;
import util.ValidationFields;
import util.CNPJ;

public class FornecedorController implements Initializable {

	@FXML
	private TextField tx_nome;
	@FXML
	private TextField tx_cnpj;
	@FXML
	private TextField tx_telefone;
	@FXML
	private TextField tx_email;
	@FXML
	private TextField tx_endereco;
	@FXML
	private Button cadastrar;
	@FXML
	private ComboBox<String> cb_tipodoc;

	private DAO dao = new DAO();
	private static Fornecedor fornecedor;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
			/*ObservableList<String> options = FXCollections
				.observableArrayList("TIPO", "CPF","CNPJ");

		   cb_tipodoc.setItems(options);*/
	}

	public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
	    return java.sql.Date.valueOf(dateToConvert);
	}

	@FXML
	private void cadastrarFornecedor() {
		if(ValidationFields.checkEmptyFields(tx_nome, tx_email, tx_cnpj, tx_telefone,tx_endereco)){
			fornecedor = new Fornecedor();
			if(validateEmail() & validateCNPJ()){
				fornecedor.setNome_fornecedor(tx_nome.getText());
				fornecedor.setEmail_fornecedor(tx_email.getText());
				fornecedor.setCnpj_fornecedor(tx_cnpj.getText());
				fornecedor.setTel_fornecedor(tx_telefone.getText());
				fornecedor.setEndereco_fornecedor(tx_endereco.getText());
				dao.salvar(fornecedor);
				emptyFields();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Incluir fornecedor");
				alert.setContentText("Fornecedor inserido com sucesso!");
				alert.showAndWait();
			}
		}else{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Validate empty fields");
			alert.setHeaderText(null);
			alert.setContentText("Algum campo vazio!");
			alert.showAndWait();
		}
	}

	@FXML
	private void excluirFornecedor() {
		dao.delete(fornecedor);

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
	private void tfCnpjMask() {
		TextFieldFormatter tff = new TextFieldFormatter();
		tff.setMask("##.###.###/####-##");
		tff.setCaracteresValidos("0123456789");
		tff.setTf(tx_cnpj);
		tff.formatter();

	}
	/*@FXML
	private void alternarComboBox(ActionEvent evt){
		TextFieldFormatter tff = new TextFieldFormatter();
		int tipoDoc = cb_tipodoc.getSelectionModel().getSelectedIndex();
		cb_tipodoc.setValue(null);
		switch (tipoDoc) {
		case 0:
			JOptionPane.showMessageDialog(null, "Selecione um tipo de documento!");
			break;
		case 1:
			tff.setMask("###.###.###-##");
			tff.setCaracteresValidos("0123456789");
			tff.setTf(tx_cpf);
			tff.formatter();
			break;
		case 2:
			tff.setMask("##.###.###/####-##");
			tff.setCaracteresValidos("0123456789");
			tff.setTf(tx_cpf);
			tff.formatter();
			break;
		}
	}*/

	private boolean validateEmail(){
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(tx_email.getText());
		if(m.find() && m.group().equals(tx_email.getText())){
			return true;
		}else{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Validate email");
			alert.setHeaderText(null);
			alert.setContentText("Email incorreto!");
			alert.showAndWait();

			return false;
		}
	}
	private boolean validateCNPJ(){
		CNPJ pj = new CNPJ (tx_cnpj.getText());
		if(pj.isCNPJ()){
			return true;
		}else{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Validate cnpj");
			alert.setHeaderText(null);
			alert.setContentText("CNPJ incorreto!");
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
	  private void emptyFields(){
		  tx_nome.setText("");
		  tx_cnpj.setText("");
		  tx_email.setText("");
		  tx_telefone.setText("");
		  tx_endereco.setText("");

	    }
}
