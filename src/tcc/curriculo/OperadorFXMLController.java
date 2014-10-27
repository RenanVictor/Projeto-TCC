package tcc.curriculo;

import java.sql.SQLException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import tcc.dominio.Usuario;
import tcc.dominio.Uteis;
import tcc.dominio.dados.UsuarioDados;
import tcc.validacao.CampoObrigatorio;

public class OperadorFXMLController extends ValidatedFormController {

    @FXML
    @CampoObrigatorio(nomeParaUsuario = "E-MAIL")
    public TextField txtemail;
    @FXML
    @CampoObrigatorio(nomeParaUsuario = "NOME")
    public TextField txtnome;
    @FXML
    @CampoObrigatorio(nomeParaUsuario = "Login")
    public TextField txtlogin;
    @FXML
    @CampoObrigatorio(nomeParaUsuario = "Telefone")
    public TextField txttelefone;
    @FXML
    @CampoObrigatorio(nomeParaUsuario = "Usuário")
    public TextField txtsenha;

    UsuarioDados usuariodados = new UsuarioDados();
    Usuario usuario = new Usuario();

    private void atribuirValores() {
        try {
            usuario.setNome(txtnome.getText());
            usuario.setEmail(txtemail.getText());
            usuario.setTelefone(txttelefone.getText());
            usuario.setLogin(txtlogin.getText());
            usuario.setSenha(txtsenha.getText());
        } catch (Exception e) {
            e.printStackTrace();
            Uteis.mensagemPreencherCampos();
        }
    }

    private void limpar() {
        txtnome.clear();
        txtemail.clear();
        txttelefone.clear();
        txtlogin.clear();
        txtsenha.clear();
    }

    public void BtnCancelar(ActionEvent evento) {

    }

    private void validarSeJaExisteEmailOuLogin() throws SQLException, Exception {
        List<Usuario> usuariosAux = usuariodados.buscarUsuario(usuario);
        for (Usuario usuarioAux : usuariosAux) {
            if (usuarioAux.getEmail().equals(usuario.getEmail())) {
                throw new Exception("Já existe um usuário com esse e-mail");
            }
            if (usuarioAux.getLogin().equals(usuario.getLogin())) {
                throw new Exception("Já existe um usuário com esse login");
            }
        }
    }

    @FXML
    public void btnSalvar(ActionEvent evento) {
        try {
            validarCamposObrigatorios();
            atribuirValores();
            validarSeJaExisteEmailOuLogin();
            usuariodados.salvarUsuario(usuario);
            Uteis.mensagemSalvo();
            limpar();
        } catch (SQLException ex) {
            Uteis.mensagemNaoSalvo();
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
