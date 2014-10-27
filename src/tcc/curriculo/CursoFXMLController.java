package tcc.curriculo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import tcc.dominio.Curso;

public class CursoFXMLController implements Initializable {
    @FXML private TextField txtTitulo;
    @FXML private TextField txtArea;

    Curso curso = new Curso();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
               
    }    
    
    
    
    public void btnSalvar(){
        curso.setArea(txtTitulo.getText());
        
        
        
        
    }
    
}
