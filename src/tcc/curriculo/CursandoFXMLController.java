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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tcc.dominio.Cursando;
import tcc.dominio.Curso;
import tcc.dominio.Uteis;
import tcc.dominio.dados.CursandoDados;
import tcc.dominio.dados.CursoDados;

public class CursandoFXMLController implements Initializable{
    @FXML private TextField txtIngresso;
    @FXML private TextField txtConclusao;
    @FXML private TextField txtTitulo;
    @FXML private ComboBox<Curso> cmbCurso;
    @FXML private TextField txtArea;
    @FXML private ComboBox<String> cmbPeriodo;
    
    Cursando cursando = new Cursando();
    CursoDados cursodados = new CursoDados();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbPeriodo.getItems().add("Manhã");
        cmbPeriodo.getItems().add("Tarde");
        cmbPeriodo.getItems().add("Noite");
        try {
            cmbCurso.getItems().addAll(cursodados.listarCursos());
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Select falhou");
        }
       
    }
    
    
    private void preencher() {
        SimpleDateFormat dateFormats = new SimpleDateFormat("d/M/y");
        try {
            cursando.setIngresso(dateFormats.parse(txtIngresso.getText()));
            cursando.setConclusao(dateFormats.parse(txtConclusao.getText()));
            cursando.setPeriodo(cmbPeriodo.getSelectionModel().getSelectedItem());
            cursando.setCurso(cmbCurso.getSelectionModel().getSelectedItem());
            
        } catch (ParseException ex) {
            ex.printStackTrace();
            Uteis.mensagemPreencherCampos();
        }
    }
    
    private void PreencherCampos(){
        txtIngresso.setText("20/02/2000");
        txtConclusao.setText("20/02/2000");
        
    }
    
    @FXML
    public void btnNext(ActionEvent evento){
        PreencherCampos();
        preencher();
        CursandoDados cursandodados = new CursandoDados();
        try {
            cursandodados.salvarCursando(cursando);
            Uteis.mensagemSalvo();
            FXMLDocumentController principal = new FXMLDocumentController();
            PrincipalController.chamaTela("ExperienciaFXML.fxml");
           
            
        } catch (Exception e) {
            Uteis.mensagemNaoSalvo();
            e.printStackTrace();
        }
    }
            
            
}
