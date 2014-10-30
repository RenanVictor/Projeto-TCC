package tcc.dominio;

import javax.swing.JOptionPane;

public class Uteis {
    public static void mensagemNaoSalvo(){
        JOptionPane.showMessageDialog(null, "Não foi possível salvar os dados!");
    }
    
    public static void mensagemPreencherCampos(){
        JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!");
    }
    
    public static void mensagemSalvo(){
        JOptionPane.showMessageDialog(null, "Dados salvo com sucesso!");
    }
    public static void mensagemNaoAbriuTela(){
        JOptionPane.showMessageDialog(null, "Não foi possivel carregar a janela!");
    }
    
    public static void mensagemBuscarDados(){
        JOptionPane.showMessageDialog(null, "Não foi possível carregar os dados");
    }
    
    public static void mensagemSenhaIncorreta(){
        JOptionPane.showMessageDialog(null, "Usuário ou senha incorreta");
    }
    
}
