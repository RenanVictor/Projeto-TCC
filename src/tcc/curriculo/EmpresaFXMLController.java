package tcc.curriculo;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import tcc.dominio.Empresa;
import tcc.dominio.Uteis;
import tcc.dominio.dados.EmpresaDados;

public class EmpresaFXMLController implements Initializable {
    
    EmpresaDados empresadados = new EmpresaDados();
    
    @FXML private TextField TxtFantasia;
    @FXML private TextField TxtRazaoSocial;
    @FXML private TextField Txtcodigo;
 
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
        
    
            
    public void BtnOk (ActionEvent evento){

    }
    
    public void BtnCancelar (ActionEvent evento){
        
    }
    
    public void BtnSalvar (ActionEvent evento){
        Empresa empresa = new Empresa();
        empresa.setFantasia(TxtFantasia.getText());
        empresa.setRazao(TxtRazaoSocial.getText());
        try {
            empresadados.salvarEmpresa(empresa);
            Uteis.mensagemSalvo();
        } catch (SQLException ex) {
            Uteis.mensagemNaoSalvo();
            ex.printStackTrace();
        }
    }
    
}
