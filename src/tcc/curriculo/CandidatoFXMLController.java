package tcc.curriculo;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tcc.dominio.Candidato;
import tcc.dominio.Estado;
import tcc.dominio.EstadoCivil;
import tcc.dominio.Uteis;
import tcc.dominio.dados.CandidatoDados;
import tcc.dominio.dados.Status;

public class CandidatoFXMLController implements Initializable {
    
    @FXML private TextField TxtNome;
    @FXML private TextField TxtCPF;
    @FXML private TextField TxtDatanasc;
    @FXML private TextField TxtEndereço;
    @FXML private TextField TxtNumend;
    @FXML private TextField TxtBairo;
    @FXML private TextField TxtNatural;
    @FXML private TextField TxtEmail;
    @FXML private TextField TxtCidade;
    @FXML private ComboBox<Estado> CmbEstado;
    @FXML private ComboBox<EstadoCivil> CmbEstadoCivil;
    @FXML private TextField TxtTelefone;
    @FXML private TextField TxtCelular;
    @FXML private ComboBox<Status> cmbStatusCursando;
    
    
    CandidatoDados candidatodados = new CandidatoDados();
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CmbEstadoCivil.getItems().addAll(EstadoCivil.values());
        CmbEstado.getItems().addAll(Estado.values());
        cmbStatusCursando.getItems().addAll(Status.values());
        
    }    
    
    private void limpar(){
        TxtNome.clear();
        TxtEndereço.clear();
        TxtCidade.clear();
        TxtEmail.clear();
        TxtCPF.clear();
        TxtNumend.clear();
        TxtNatural.clear();
        TxtTelefone.clear();
        TxtCelular.clear();
        TxtDatanasc.clear();
        TxtBairo.clear();
    }
    
    private void PreencherCampos(){
        TxtNome.setText("Teste");
        TxtEndereço.setText("Teste");
        TxtCidade.setText("Teste");
        TxtEmail.setText("Teste");
        TxtCPF.setText("123152135");
        TxtNumend.setText("166");
        TxtNatural.setText("Teste");
        TxtTelefone.setText("33849725");
        TxtCelular.setText("92584852");
        TxtDatanasc.setText("02/02/2002");
        TxtBairo.setText("Teste");
        
    }
    //Candidato->Formação->Cursando->Experiencia->Contrato
    @FXML
    public void BtnNext(ActionEvent evento){
        //PreencherCampos();
        ;
        Candidato candidato = new Candidato();
        SimpleDateFormat dateFormats = new SimpleDateFormat("d/M/y");
        try{
            candidato.setNome(TxtNome.getText());
            candidato.setEndereco(TxtEndereço.getText());
            candidato.setCidade(TxtCidade.getText());
            candidato.setEmail(TxtEmail.getText());
            candidato.setCpf(TxtCPF.getText());
            candidato.setNumero(Integer.parseInt(TxtNumend.getText()));
            candidato.setNatural(TxtNatural.getText());
            candidato.setTelefoneResidencial(TxtTelefone.getText());
            candidato.setCelular(TxtCelular.getText());
            candidato.setDataDeNascimento(dateFormats.parse(TxtDatanasc.getText()));
            candidato.setBairro(TxtBairo.getText());
            candidato.setEstado(CmbEstado.getSelectionModel().getSelectedItem());
            candidato.setEstadoCivil(CmbEstadoCivil.getSelectionModel().getSelectedItem());
            candidato.setStatus(cmbStatusCursando.getSelectionModel().getSelectedItem());
            candidatodados.salvarCandidato(candidato);
            Uteis.mensagemSalvo();
            FXMLDocumentController principal = new FXMLDocumentController();
            principal.OpenWindows("fxml/FormacaoFXML.fxml"); 
            Button botao = (Button) evento.getTarget();
            Stage tela = (Stage) botao.getScene().getWindow();
            tela.close();
        }
        catch(Exception ex){
            Uteis.mensagemPreencherCampos();
            ex.printStackTrace();
        }
        
    }
    
    @FXML
    public void BtnOk (ActionEvent evento){
        //empresas.setRazao("Teste");
        
        
    }
    
    @FXML
    public void BtnCancelar (ActionEvent evento){
        
    }
}
