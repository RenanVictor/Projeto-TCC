package tcc.curriculo;

import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tcc.dominio.Contrato;
import tcc.dominio.Empresa;
import tcc.dominio.Uteis;
import tcc.dominio.dados.ContratoDados;
import tcc.dominio.dados.EmpresaDados;
import tcc.dominio.dados.Status;

public class ContratoFXMLController implements Initializable{
    @FXML private TextField txtModalidade;
    @FXML private TextField txtInicio;
    @FXML private TextField txtTermino;
    @FXML private ComboBox<Status> cmbSeguro;
    @FXML private ComboBox<Empresa> cmbEmpresa;
    EmpresaDados empresa = new EmpresaDados();
    Contrato contrato = new Contrato();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbSeguro.getItems().addAll(Status.values());
        try {
            cmbEmpresa.getItems().addAll(empresa.listarEmpresas());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Uteis.mensagemBuscarDados();
        } 
    }
      
    private void inserirValores(){
        txtInicio.setText("25/12/2014");
        txtTermino.setText("12/12/2015");
        txtModalidade.setText("Teste sei la"); 
    }
    
    private void preencher(){
        SimpleDateFormat dateFormats = new SimpleDateFormat("d/M/y");
        try {
            contrato.setModalidade(txtModalidade.getText());
            contrato.setInicio(dateFormats.parse(txtInicio.getText()));
            contrato.setTermino(dateFormats.parse(txtTermino.getText()));
            contrato.setSeguro(cmbSeguro.getSelectionModel().getSelectedItem());
            contrato.setEmpresa(cmbEmpresa.getSelectionModel().getSelectedItem());    
        } catch (ParseException ex) {
            ex.printStackTrace();
            Uteis.mensagemPreencherCampos();
        }  
    }
    
    @FXML
    public void btnFinalizar(ActionEvent evento){
        inserirValores();
        preencher();
        ContratoDados contratodados = new ContratoDados();
        try {
            contratodados.salvarContrato(contrato);
            Uteis.mensagemSalvo();
            Button botao = (Button) evento.getTarget();
            Stage tela = (Stage) botao.getScene().getWindow();
            tela.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Uteis.mensagemNaoSalvo();
        }   
    }
}
