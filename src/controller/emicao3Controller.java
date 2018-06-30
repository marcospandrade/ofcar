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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main;
import mapeamento.Servico;

public class emicao3Controller implements Initializable {

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
    private TableColumn<Servico, Boolean> tc_select;

    @FXML
    private TableColumn<Servico, String> tc_nome_servico;

    @FXML
    private TableColumn<Servico, String> tc_descricao_servico;

    @FXML
    private TableColumn<Servico, Float> tc_valor_servico;

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
    @SuppressWarnings("rawtypes")
    @FXML
    private TableView tv_servico;

    private ObservableList<Servico> listaServico;
    private DAO dao = new DAO();
    private static Servico servico;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tv_servico.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tc_nome_servico.setCellValueFactory(
                new PropertyValueFactory<>("nome_servico")
        );
        tc_descricao_servico.setCellValueFactory(
                new PropertyValueFactory<>("descricao_servico")
        );
        tc_valor_servico.setCellValueFactory(
                new PropertyValueFactory<>("valor_servico")
        );
        tc_select.setCellValueFactory(
                new PropertyValueFactory<Servico, Boolean>("selected"));

        tc_select.setCellFactory(CheckBoxTableCell.forTableColumn(tc_select));
        carregaDadosTabela();
    }

    @SuppressWarnings("unchecked")
    public void carregaDadosTabela() {
        listaServico = dao.consultar(Servico.class);
        tv_servico.setItems(listaServico);
    }

    @FXML
    private void produto(ActionEvent event) throws IOException {
        Main.trocarTela("produto");
    }

    @FXML
    private void emicao(ActionEvent event) throws IOException {
        Main.trocarTela("emicao");
    }
    
    @FXML
    private void emicao2(ActionEvent event) throws IOException {
        Main.trocarTela("emicao2");
    }
    
    @FXML
    private void historico_veiculo(ActionEvent event) throws IOException {
        Main.trocarTela("historico_veiculo");
    }

    @FXML
    private void apontamento(ActionEvent event) throws IOException {
        Main.trocarTela("apontamento");
    }

    @FXML
    private void voltar() {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja voltar ao menu principal?", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Logout");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                Main.trocarTela("main");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
