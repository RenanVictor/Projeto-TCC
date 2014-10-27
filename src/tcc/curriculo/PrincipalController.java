/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tcc.curriculo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import tcc.curriculo.fxml.JanelaUtil;

/**
 * FXML Controller class
 *
 * @author aluno
 */
public class PrincipalController implements Initializable {

    @FXML private static Pane painel;
   
    public static void chamaTela(String fxml){
        Node tela = JanelaUtil.carregaTela(fxml);
        
        //remove a tela que está sendo exibida no momento
        painel.getChildren().clear();
        
        //adiciona a nova tela...
        painel.getChildren().add(tela);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }   
    
    public void  abrirCandidato(ActionEvent event){
        chamaTela("CandidatoFXML.fxml");
    }
    
    public void abrirEmpresa(ActionEvent event){
        chamaTela("EmpresaFXML.fxml");
    }
    public void abrirCurso(ActionEvent event){
        chamaTela("CursoFXML.fxml");
    }
    public void  abrirOperador(ActionEvent event){
        chamaTela("OperadorFXML.fxml");
    }
}
