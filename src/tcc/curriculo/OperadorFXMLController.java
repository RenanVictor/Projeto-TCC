package tcc.curriculo;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import tcc.dominio.Usuario;
import tcc.dominio.Uteis;
import tcc.dominio.dados.UsuarioDados;

public class OperadorFXMLController implements Initializable {

    @FXML public TextField txtemail;
    @FXML public TextField txtnome;
    @FXML public TextField txtlogin;
    @FXML public TextField txttelefone;
    @FXML public TextField txtsenha;
    
    UsuarioDados usuariodados = new UsuarioDados();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void BtnCancelar (ActionEvent evento){
        
        
        
    }
    
    @FXML
    public void btnSalvar(ActionEvent evento){
        Usuario usuario = new Usuario();
        usuario.setNome(txtnome.getText());
        usuario.setEmail(txtemail.getText());
        usuario.setTelefone(txttelefone.getText());
        usuario.setLogin(txtlogin.getText());
        usuario.setSenha(txtsenha.getText());
    try {
            usuariodados.salvarUsuario(usuario);
            Uteis.mensagemSalvo();
            PrincipalController.limparTela();
        } catch (SQLException ex) {
            Uteis.mensagemNaoSalvo();
            ex.printStackTrace();
        }
        
        
    }
    
}
