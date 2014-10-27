/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tcc.dominio.Formacao;
import tcc.dominio.Uteis;
import tcc.dominio.dados.FormacaoDados;

public class FormacaoFXMLController implements Initializable{
    @FXML private TextField txtTitulo;
    @FXML private TextField txtEscola;
    @FXML private TextField txtInicio;
    @FXML private TextField txtTermino;
    
    Formacao formacao = new Formacao();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    private void preencher(){
        SimpleDateFormat dateFormats = new SimpleDateFormat("d/M/y");
        try {
            formacao.setEscola(txtEscola.getText());
            formacao.setTitulo(txtTitulo.getText());
            formacao.setTermino(dateFormats.parse(txtTermino.getText()));            
            formacao.setInicio(dateFormats.parse(txtInicio.getText()));
        } catch (ParseException ex) {
            ex.printStackTrace();
            Uteis.mensagemPreencherCampos();
        }
    }
    
    private void PreencherCampos(){
        txtEscola.setText("Teste1");
        txtTitulo.setText("Teste1");
        txtTermino.setText("02/02/2000");
        txtInicio.setText("02/02/2000");
    }
 
    @FXML
    public void btnNext(ActionEvent ev){
        PreencherCampos();
        preencher();
        FormacaoDados formacaodados = new FormacaoDados();
        try {
            formacaodados.salvarFormacao(formacao);
            Uteis.mensagemSalvo();
            FXMLDocumentController principal = new FXMLDocumentController();
            principal.OpenWindows("fxml/CursandoFXML.fxml");
            Button botao = (Button) ev.getTarget();
            Stage tela = (Stage) botao.getScene().getWindow();
            tela.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Uteis.mensagemNaoSalvo();
        }
        
    }
}
