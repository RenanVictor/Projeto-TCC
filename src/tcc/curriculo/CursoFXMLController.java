package tcc.curriculo;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import tcc.dominio.Curso;
import tcc.dominio.Uteis;
import tcc.dominio.dados.CursoDados;

public class CursoFXMLController implements Initializable {

    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtArea;

    Curso curso = new Curso();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public void btnSalvar() {
        CursoDados cursodados = new CursoDados();
        try {
            curso.setArea(txtTitulo.getText());
            curso.setTitulo(txtArea.getText());
        } catch (Exception e) {
            Uteis.mensagemPreencherCampos();
            e.printStackTrace();
        }
        try {
            cursodados.salvarCurso(curso);
            Uteis.mensagemSalvo();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Uteis.mensagemNaoSalvo();
        }
    }

}
