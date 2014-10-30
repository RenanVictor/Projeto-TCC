package tcc.curriculo;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tcc.dominio.Usuario;
import tcc.dominio.Uteis;
import tcc.dominio.dados.UsuarioDados;

public class FXMLDocumentController implements Initializable {

    @FXML
    TextField TxtLogin;
    @FXML
    TextField TxtSenha;
    @FXML
    Button btncadastraraluno;
    @FXML
    Button btncadastrarempresa;
    @FXML
    Button btncadastrarcurso;
    @FXML
    Button btnpesquisar;
    @FXML
    Button btnopcoes;

    UsuarioDados usuarios = new UsuarioDados();

    public void OpenWindows(String tela) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(tela));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            Uteis.mensagemNaoAbriuTela();
            e.printStackTrace();
        }
    }

    public void CloseWindows(String tela) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(tela));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.close();
        } catch (Exception e) {
            Uteis.mensagemNaoAbriuTela();
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        this.btncadastraraluno.setVisible(false);
        this.btncadastrarempresa.setVisible(false);
        this.btncadastrarcurso.setVisible(false);
        this.btnopcoes.setVisible(false);
        this.btnpesquisar.setVisible(false);

    }

    private void setVisible() {
        this.btncadastraraluno.setVisible(true);
        this.btncadastrarempresa.setVisible(true);
        this.btncadastrarcurso.setVisible(true);
        this.btnopcoes.setVisible(true);
        this.btnpesquisar.setVisible(true);
    }

    @FXML
    public void BtnOk(ActionEvent evento) throws SQLException {

        if (TxtLogin.getText().equals("adm") && TxtSenha.getText().equals("ab123")) {
            btnopcoes.setText("Cadastrar Usuario");
            setVisible();
        } else {
            Usuario usuario = usuarios.login(TxtLogin.getText(), TxtSenha.getText());

            if (usuario != null) {
                setVisible();
                btnopcoes.setText("Dados do Usuário");
            } else {
                Uteis.mensagemSenhaIncorreta();
            }
        }
    }

    public void BtnCadastrarAluno(ActionEvent evento) {
        OpenWindows("fxml/CandidatoFXML.fxml");

    }

    public void BtnCadastrarEmpresa(ActionEvent evento) {
        OpenWindows("fxml/EmpresaFXML.fxml");
    }

    public void BtnCadastrarCurso(ActionEvent evento) {
        OpenWindows("fxml/CursoFXML.fxml");
    }

    public void BtnPesquisar(ActionEvent evento) {
        //OpenWindows("fxml/FormacaoFXML.fxml");

    }

    public void BtnOpcoes(ActionEvent evento) {
        if (btnopcoes.getText().equals("Cadastrar Usuario")) {
            OpenWindows("fxml/OperadorFXML.fxml");
        } else {
            OpenWindows("fxml/UsuarioFXML.fxml");
        }
    }

}
