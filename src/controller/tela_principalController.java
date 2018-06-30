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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import main.Main;
import mapeamento.Ordem_aberta;

public class tela_principalController implements Initializable{

    @FXML
    private JFXButton bt_ordem_servi_trla_principal;

    @FXML
    private JFXButton bt_laudo_entrada_tela_principal1;

    @FXML
    private JFXButton bt_orcamentos_tela_princi;

    @FXML
    private JFXButton bt_estoque_tela_princi;

    @FXML
    private JFXButton bt_entrada_produtos_tela_princi;

    @FXML
    private JFXButton bt_veiculo_tela_princi;

    @FXML
    private JFXButton bt_cliente_tela_princi;

    @FXML
    private JFXButton bt_produtos_tela_princi;

    @FXML
    private JFXButton bt_servicos_tela_princi;

    @FXML
    private JFXButton bt_funcionarios_tela_princi;

    @FXML
    private JFXButton bt_fornecedor_tela_princi;

    @FXML
    private TableColumn<Ordem_aberta, Integer> cl_codigo_os_tela_princi;

    @FXML
    private TableColumn<Ordem_aberta, String> cl_func_tela_princi;

    @FXML
    private TableColumn<Ordem_aberta, String> cl_nome_client_tela_principal;

    @FXML
    private TableColumn<Ordem_aberta, String> cl_placa_tela_princi;

    @FXML
    private TableColumn<Ordem_aberta, String> cl_veiculo_tela_princi;

    @FXML
    private TableColumn<Ordem_aberta, ?> cl_total_tela_princi;

    @FXML
    private ToggleGroup situacao;

    @FXML
    private ImageView img_sair_tela_princi;
    
    @FXML
    private TableView tv_os;
    
    private DAO dao = new DAO();
    private ObservableList<Ordem_aberta> listaOrdem;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

           tv_os.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        cl_codigo_os_tela_princi.setCellValueFactory(
                new PropertyValueFactory<>("id_ordem_aberta")
        );
    	cl_func_tela_princi.setCellValueFactory(
                new PropertyValueFactory<>("funcionario_ordem_aberta")
        );
    	cl_nome_client_tela_principal.setCellValueFactory(
                new PropertyValueFactory<>("cliente_ordem_aberta")
        );    

    	cl_placa_tela_princi.setCellValueFactory(
                new PropertyValueFactory<>("placa_ordem_aberta")
        ); 
    	cl_veiculo_tela_princi.setCellValueFactory(
                new PropertyValueFactory<>("veiculo_ordem_aberta")
        );         
    	cl_total_tela_princi.setCellValueFactory(
                new PropertyValueFactory<>("")
        );         
        carregaDadosTabela();
           
    }    

    @SuppressWarnings("unchecked")
	public void carregaDadosTabela() {
    	listaOrdem = dao.consultar(Ordem_aberta.class);
        tv_os.setItems(listaOrdem);
    }     
    
    @FXML 
    private void emicao(ActionEvent event) throws IOException{
    	Main.trocarTela("emicao");
    }  
    
    @FXML 
    private void orcamento(ActionEvent event) throws IOException{
    	Main.trocarTela("orcamento");
    }
    
    @FXML 
    private void laudo(ActionEvent event) throws IOException{
    	Main.trocarTela("laudo");
    }  
    
    @FXML 
    private void fornecedor(ActionEvent event) throws IOException{
    	Main.trocarTela("fornecedor");
    }      
    
    @FXML
    private void funcionario(ActionEvent event) throws IOException{
    	Main.trocarTela("funcionario");
    }

    @FXML
    private void veiculo(ActionEvent event) throws IOException{
    	Main.trocarTela("veiculo");
    }

    @FXML
    private void servico(ActionEvent event) throws IOException{
    	Main.trocarTela("servico");
    }

    @FXML
    private void peca(ActionEvent event) throws IOException{
        Main.trocarTela("produto");
    }

    @FXML
    protected void cliente(ActionEvent ev) {
        try {
            Main.trocarTela("cliente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void telaEstoque(ActionEvent e) {
        try {
        	Main.trocarTela("estoque");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @FXML
    private void logout() {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja sair?", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Logout");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                Main.trocarTela("login");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
