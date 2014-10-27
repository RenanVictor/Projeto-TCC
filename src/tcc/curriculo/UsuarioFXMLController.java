/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.curriculo;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import tcc.dominio.Usuario;
import tcc.dominio.Uteis;
import tcc.dominio.dados.UsuarioDados;

public class UsuarioFXMLController implements Initializable {

    UsuarioDados usuariodados = new UsuarioDados();

    @FXML
    public TextField txtemail;
    @FXML
    public TextField txtnome;
    @FXML
    public TextField txtlogin;
    @FXML
    public TextField txttelefone;
    @FXML
    public TextField txtsenha;

    Usuario usuario = new Usuario();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void atribuirValores() {
        try{
        usuario.setNome(txtnome.getText());
        usuario.setEmail(txtemail.getText());
        usuario.setTelefone(txttelefone.getText());
        usuario.setLogin(txtlogin.getText());
        usuario.setSenha(txtsenha.getText());
        }
        catch(Exception e){
            e.printStackTrace();
            Uteis.mensagemPreencherCampos();
        }
    }

    @FXML
    public void btnSalvar(ActionEvent evento) {
        atribuirValores();
        try {
            usuariodados.salvarUsuario(usuario);
            Uteis.mensagemSalvo();
        } catch (SQLException ex) {
            Uteis.mensagemNaoSalvo();
            ex.printStackTrace();
        }

    }
}
