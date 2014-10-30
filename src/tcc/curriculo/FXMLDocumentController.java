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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    private void CloseLoginOpenPrincipal(ActionEvent e, String fxml) {
        OpenWindows(fxml);
        Button botao = (Button) e.getTarget();
        Stage tela = (Stage) botao.getScene().getWindow();
        tela.close();
    }

    @FXML
    public void BtnOk(ActionEvent evento) {
        if (TxtLogin.getText().equals("adm") && TxtSenha.getText().equals("ab123")) {
            CloseLoginOpenPrincipal(evento,"fxml/OperadorFXML.fxml");
        } else {
            try {
                usuario.setLogin(TxtLogin.getText());
                usuario.setSenha(TxtSenha.getText());
                Usuario resultado = usuarios.buscarUsuarioSenha(usuario);
                if (TxtLogin.getText().equals(resultado.getLogin()) && TxtSenha.getText().equals(resultado.getSenha())) {
                    CloseLoginOpenPrincipal(evento,"fxml/Principal.fxml");
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
        Button botao = (Button) e.getTarget();
        Stage tela = (Stage) botao.getScene().getWindow();
        tela.close();
    }

}
