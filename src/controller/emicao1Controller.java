package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.DAO;
import dao.DAOFuncionario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TextArea;
import main.Main;
import mapeamento.Ordem_aberta;
import mapeamento.Funcionario;
import util.TextFieldFormatter;
import util.ValidationFields;

public class emicao1Controller implements Initializable {

  //  @FXML
  // private JFXComboBox<Funcionario> cb_func;
            
    @FXML
    private JFXTextField tx_funcio_emic_os;

    @FXML
    private JFXTextField tx_cliente_emic_os;

    @FXML
    private JFXTextField tx_tele_cliente_emic_os;

    @FXML
    private JFXTextField tx_placa_emic_os;

    @FXML
    private JFXTextField tx_veiculo_emic_os;

    @FXML
    private JFXTextField tx_odometro_emic_os;

    @FXML
    private JFXTextField tx_ano_veic_emic_os1;

    @FXML
    private TextArea ta_problema_emic_os;

    @FXML
    private TextArea ta_pare_tecn_emic_os;

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
    private Menu mb_dados_emic_os;

    @FXML
    private Menu mb_prod_serv_emic_os;

    @FXML
    private MenuItem mi_produto_emic_os;

    @FXML
    private MenuItem mi_servico_emic_os;

    @FXML
    private Menu mb_fechamento_emic_os;

    private Ordem_aberta ordem;
    private DAO dao = new DAO();
    private DAOFuncionario daofunc = new DAOFuncionario();
    private ObservableList<Funcionario> listaFuncionario;
    private Funcionario funcionario;
    private List<Funcionario> listFunc = new ArrayList<>();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //listaFuncionario = dao.consultar(Funcionario.class);
        //listFunc = daofunc.getNomeFuncionario("ale");
        //listaFuncionario = FXCollections.observableArrayList(listFunc);
        //listaFuncionario = FXCollections.observableArrayList(listaFuncionario);
        //cb_func.setItems(listaFuncionario);
    }

        @FXML 
    private void produto(ActionEvent event) throws IOException{
    	Main.trocarTela("produto");
    }  

    @FXML 
    private void servico(ActionEvent event) throws IOException{
    	Main.trocarTela("servico");
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
    private void emicao2(ActionEvent event) throws IOException{
    	Main.trocarTela("emicao2");
    }  

    @FXML 
    private void emicao3(ActionEvent event) throws IOException{
    	Main.trocarTela("emicao3");
    }  
    
    @FXML
    private void cadastrarDados() {
        ValidationFields.checkEmptyFields(tx_funcio_emic_os, tx_cliente_emic_os, tx_tele_cliente_emic_os, tx_placa_emic_os, tx_veiculo_emic_os, ta_problema_emic_os);
        ordem = new Ordem_aberta();
        if (checkCamposVazios()) {
            ordem.setFuncionario_ordem_aberta(tx_funcio_emic_os.getText());
            ordem.setCliente_ordem_aberta(tx_cliente_emic_os.getText());
            ordem.setTelefone_ordem_aberta(tx_tele_cliente_emic_os.getText());
            ordem.setPlaca_ordem_aberta(tx_placa_emic_os.getText());
            ordem.setVeiculo_ordem_aberta(tx_veiculo_emic_os.getText());
            ordem.setOdometro_ordem_aberta(tx_odometro_emic_os.getText());
            ordem.setAno_ordem_aberta(tx_ano_veic_emic_os1.getText());
            ordem.setProblema_ordem_aberta(ta_problema_emic_os.getText());
            ordem.setParecer_ordem_aberta(ta_pare_tecn_emic_os.getText());
            dao.salvar(ordem);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inclusão de Ordem");
            alert.setContentText("Ordem inserida com sucesso!");
            alert.showAndWait();
            emptyFields();
        }
    }

    private void emptyFields() {
        tx_funcio_emic_os.setText("");
        tx_cliente_emic_os.setText("");
        tx_tele_cliente_emic_os.setText("");
        tx_placa_emic_os.setText("");
        tx_veiculo_emic_os.setText("");
        tx_odometro_emic_os.setText("");
        tx_ano_veic_emic_os1.setText("");
        ta_problema_emic_os.setText("");
        ta_pare_tecn_emic_os.setText("");
    }

    private boolean checkCamposVazios() {
        if (tx_funcio_emic_os.getText().isEmpty() || tx_cliente_emic_os.getText().isEmpty() || tx_tele_cliente_emic_os.getText().isEmpty() || tx_placa_emic_os.getText().isEmpty() || tx_veiculo_emic_os.getText().isEmpty() || ta_problema_emic_os.getText().isEmpty()) {
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
    private void tfKmMask() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###############");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(tx_odometro_emic_os);
        tff.formatter();
    }

    @FXML
    private void tfAnoMask() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(tx_ano_veic_emic_os1);
        tff.formatter();
    }

    @FXML
    private void tfPlacaMask() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("UUU-####");
        tff.setTf(tx_placa_emic_os);
        tff.formatter();
    }

    @FXML
    private void tfTelefoneMask() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("(##)#####-####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(tx_tele_cliente_emic_os);
        tff.formatter();
    }
}
