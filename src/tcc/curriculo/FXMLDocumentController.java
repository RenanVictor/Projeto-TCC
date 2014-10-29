package tcc.curriculo;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
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
    Usuario usuario = new Usuario();

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

    }

    @FXML
    public void BtnOk(ActionEvent evento) {
        if (TxtLogin.getText().equals("adm") && TxtSenha.getText().equals("ab123")) {
            btnopcoes.setText("Cadastrar Usuario");
            btnopcoes.setVisible(true);
            TxtLogin.setEditable(false);
            TxtSenha.setEditable(false);
        } else {
            try {
                usuario.setLogin(TxtLogin.getText());
                usuario.setSenha(TxtSenha.getText());
                Usuario resultado = usuarios.buscarUsuarioSenha(usuario);
                if (TxtLogin.getText().equals(resultado.getLogin()) && TxtSenha.getText().equals(resultado.getSenha())) {
                    btnopcoes.setText("Dados do Usuário");
                    TxtLogin.setEditable(false);
                    TxtSenha.setEditable(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorreta!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                Uteis.mensagemPreencherCampos();
            }
        }
    }

    @FXML
    public void btnSair(ActionEvent e) {
        OpenWindows("fxml/Principal.fxml");
        Button botao = (Button) e.getTarget();
        Stage tela = (Stage) botao.getScene().getWindow();
        tela.close();
    }

    public void BtnCadastrarAluno(ActionEvent evento) {
        OpenWindows("fxml/CandidatoFXML.fxml");
        Uteis.mensagemBuscarDados();
    }

    public void BtnCadastrarEmpresa(ActionEvent evento) {
        OpenWindows("fxml/EmpresaFXML.fxml");
    }

    public void BtnCadastrarCurso(ActionEvent evento) {
        OpenWindows("fxml/ContratoFXML.fxml");
    }

    public void BtnPesquisar(ActionEvent evento) {
        OpenWindows("fxml/FormacaoFXML.fxml");
    }

    public void BtnOpcoes(ActionEvent evento) {
        if (btnopcoes.getText().equals("Cadastrar Usuario")) {
            OpenWindows("fxml/OperadorFXML.fxml");
        } else {
            OpenWindows("fxml/UsuarioFXML.fxml");
        }
    }
}
