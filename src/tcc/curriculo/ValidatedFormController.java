/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.curriculo;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import tcc.validacao.CampoObrigatorio;

/**
 *
 * @author Etec
 */
public class ValidatedFormController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    protected void validarCamposObrigatorios() throws Exception {
        for (Field campo : getClass().getFields()) {
            if (campo.isAnnotationPresent(CampoObrigatorio.class) && campo.getType().equals(TextField.class)) {
                try {
                    TextField campoTexto = (TextField) campo.get(this);
                    if (campoTexto.getText().isEmpty()) {
                        CampoObrigatorio obr = campo.getAnnotation(CampoObrigatorio.class);
                        throw new Exception("CAMPO " + obr.nomeParaUsuario() + " NÃO PODE SER VAZIO");
                    }
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(OperadorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(OperadorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
