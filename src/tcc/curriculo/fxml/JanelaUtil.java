/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.curriculo.fxml;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author aluno
 */
public class JanelaUtil {

    public static Node carregaTela(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JanelaUtil.class.getResource(fxml));
            loader.setBuilderFactory(new JavaFXBuilderFactory());

            Node node = (Node) loader.load();

            return node;
        } catch (IOException e) {
            Logger.getLogger(JanelaUtil.class.getName()).log(Level.SEVERE, "Erro carregando FXML", e);
            throw new RuntimeException(e);
        }
    }
    
    public static void abreNovaJanela(String fxml){
        Node tela = carregaTela(fxml);
        
        Stage stage= new Stage();
        stage.setScene(new Scene((Parent) tela));
        stage.showAndWait();
    }
}
