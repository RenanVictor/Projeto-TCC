package tcc.curriculo;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tcc.dominio.Experiencia;
import tcc.dominio.Uteis;
import tcc.dominio.dados.ExperienciaDados;


public class ExperienciaFXMLController implements Initializable{
    @FXML private TextField txtEmpresa;
    @FXML private TextField txtCargo;
    @FXML private TextField txtFuncao;
    @FXML private TextField txtEntrada;
    @FXML private TextField txtSaida;

    Experiencia experiencia = new Experiencia();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    private void PreencherCampos(){
        txtCargo.setText("Teste");
        txtEmpresa.setText("Teste");
        txtFuncao.setText("Teste");
        txtEntrada.setText("25/11/2014");
        txtSaida.setText("12/12/2014");
    }
    
    private void preencher(){
        
        SimpleDateFormat dateFormats = new SimpleDateFormat("d/M/y");
        try {
            experiencia.setEmpresas(txtEmpresa.getText());
            experiencia.setCargo(txtCargo.getText());
            experiencia.setFuncao(txtFuncao.getText());
            experiencia.setEntrada(dateFormats.parse(txtEntrada.getText()));
            experiencia.setSaida(dateFormats.parse(txtSaida.getText()));
        } catch (Exception e) {
            Uteis.mensagemPreencherCampos();
            e.printStackTrace();
        }
        
    }
    
    private void salvarDados(){
        try {
            PreencherCampos();
            ExperienciaDados experienciadados = new ExperienciaDados();
            preencher();
            experienciadados.salvarExperiencia(experiencia);
            Uteis.mensagemSalvo();
        } catch (Exception e) {
            e.printStackTrace();
            Uteis.mensagemNaoSalvo();
        }
    }
    
    @FXML
    public void btnNovaExperiencia(ActionEvent evento){
        salvarDados();
        
        
    }
    
    @FXML
    public void btnNext(ActionEvent evento){
        salvarDados();
        FXMLDocumentController principal = new FXMLDocumentController();
        principal.OpenWindows("fxml/ContratoFXML.fxml");
        Button botao = (Button) evento.getTarget();
            Stage tela = (Stage) botao.getScene().getWindow();
            tela.close();
    }
    
}
