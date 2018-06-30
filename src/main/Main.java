/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private static Stage stage;

    private static Scene mainScene;

    private static Scene fornecedorScene;

    private static Scene estoqueScene;

    private static Scene clienteScene;

    private static Scene funcionarioScene;

    private static Scene produtoScene;

    private static Scene servicoScene;

    private static Scene usuarioScene;

    private static Scene veiculoScene;

    private static Scene loginScene;

    private static Scene emicaoScene;

    private static Scene emicaoScene2;

    private static Scene emicaoScene3;

    private static Scene orcamentoScene;

    private static Scene laudoScene;

    private static Scene apontamentoScene;

    private static Scene historico_veiculoScene;

    private static Scene novo_orcamentoScene;



    @Override
    public void start(Stage primaryStage) throws Exception {
    	stage = primaryStage;

    	Parent TelaPrincipal = FXMLLoader.load(getClass().getResource("/view/tela_principal.fxml"));
        mainScene = new Scene (TelaPrincipal);

        Parent CadastroFornecedor = FXMLLoader.load(getClass().getResource("/view/cadastro_fornecedor.fxml"));
        fornecedorScene = new Scene (CadastroFornecedor);

        Parent ControleEstoque = FXMLLoader.load(getClass().getResource("/view/control_estoque.fxml"));
        estoqueScene = new Scene (ControleEstoque);

        Parent CadastroCliente = FXMLLoader.load(getClass().getResource("/view/cadastro_cliente.fxml"));
        clienteScene = new Scene (CadastroCliente);

        Parent CadastroFuncionario = FXMLLoader.load(getClass().getResource("/view/cadastro_funcionario.fxml"));
        funcionarioScene = new Scene (CadastroFuncionario);

        Parent CadastroProduto = FXMLLoader.load(getClass().getResource("/view/cadastro_produto.fxml"));
        produtoScene = new Scene (CadastroProduto);

        Parent CadastroServico = FXMLLoader.load(getClass().getResource("/view/cadastro_servico.fxml"));
        servicoScene = new Scene (CadastroServico);

        Parent CadastroUsuario = FXMLLoader.load(getClass().getResource("/view/cadastro_usuario.fxml"));
        usuarioScene = new Scene (CadastroUsuario);

        Parent CadastroVeiculo = FXMLLoader.load(getClass().getResource("/view/cadastro_veiculo.fxml"));
        veiculoScene = new Scene (CadastroVeiculo);

        Parent Login = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        loginScene = new Scene (Login);

        Parent Emicao = FXMLLoader.load(getClass().getResource("/view/tela_emicao1.fxml"));
        emicaoScene = new Scene (Emicao);

        Parent Orcamento = FXMLLoader.load(getClass().getResource("/view/orcamento.fxml"));
        orcamentoScene = new Scene (Orcamento);

        Parent Emicao2 = FXMLLoader.load(getClass().getResource("/view/tela_emicao2.fxml"));
        emicaoScene2 = new Scene (Emicao2);

        Parent Emicao3 = FXMLLoader.load(getClass().getResource("/view/tela_emicao3.fxml"));
        emicaoScene3 = new Scene (Emicao3);

        Parent Laudo = FXMLLoader.load(getClass().getResource("/view/LaudoEntrada.fxml"));
        laudoScene = new Scene (Laudo);

        Parent Apontamento = FXMLLoader.load(getClass().getResource("/view/apontamentos.fxml"));
        apontamentoScene = new Scene (Apontamento);

        Parent Historico_veiculo = FXMLLoader.load(getClass().getResource("/view/historico_veiculo.fxml"));
        historico_veiculoScene = new Scene (Historico_veiculo);

        Parent Novo_Orcamento = FXMLLoader.load(getClass().getResource("/view/novo_orcamento.fxml"));
        novo_orcamentoScene = new Scene (Novo_Orcamento);


        stage.getIcons().add(new Image("/imagem/Logo OfCar.png"));

        stage.initStyle(StageStyle.UNDECORATED);

        stage.setScene(mainScene);

        stage.setTitle("OfCar");

        stage.show();
    }

       public static void trocarTela(String tela){

	   switch(tela){
	   		case "main":
	   			stage.setScene(mainScene);
	   			stage.centerOnScreen();
	   			break;
	   		case "fornecedor":
	   			stage.setScene(fornecedorScene);
	   			stage.centerOnScreen();
	   			break;
	   		case "estoque":
	   			stage.setScene(estoqueScene);
	   			stage.centerOnScreen();
	   			break;
	   		case "cliente":
	   			stage.setScene(clienteScene);
	   			stage.centerOnScreen();
	   			break;
	   		case "funcionario":
	   			stage.setScene(funcionarioScene);
	   			stage.centerOnScreen();
	   			break;
	   		case "produto":
	   			stage.setScene(produtoScene);
	   			stage.centerOnScreen();
	   			break;
	   		case "servico":
	   			stage.setScene(servicoScene);
	   			stage.centerOnScreen();
	   			break;
	   		case "usuario":
	   			stage.setScene(usuarioScene);
	   			stage.centerOnScreen();
	   			break;
	   		case "veiculo":
	   			stage.setScene(veiculoScene);
	   			stage.centerOnScreen();
	   			break;
	   		case "login":
	   			stage.setScene(loginScene);
	   			stage.centerOnScreen();
	   			break;
	   		case "emicao":
	   			stage.setScene(emicaoScene);
	   			stage.centerOnScreen();
	   			break;
	   		case "emicao2":
	   			stage.setScene(emicaoScene2);
	   			stage.centerOnScreen();
	   			break;
	   		case "emicao3":
	   			stage.setScene(emicaoScene3);
	   			stage.centerOnScreen();
	   			break;
	   		case "orcamento":
	   			stage.setScene(orcamentoScene);
	   			stage.centerOnScreen();
	   			break;
            case "novo_orcamento":
	   			stage.setScene(novo_orcamentoScene);
	   			stage.centerOnScreen();
	   			break;
	   		case "laudo":
	   			stage.setScene(laudoScene);
	   			stage.centerOnScreen();
	   			break;
	   		case "apontamento":
	   			stage.setScene(apontamentoScene);
	   			stage.centerOnScreen();
	   			break;
	   		case "historico_veiculo":
	   			stage.setScene(historico_veiculoScene);
	   			stage.centerOnScreen();
	   			break;

	   }
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
