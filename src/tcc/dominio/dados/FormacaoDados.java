package tcc.dominio.dados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dominio.Formacao;

public class FormacaoDados {

        public void salvarFormacao(Formacao formacao) throws SQLException{
            Connection conexao =  Conexao.get();
        String sql = "Insert into formacao(escola,inicio,termino,titulo) Values(?,?,?,?)";

        PreparedStatement insert = conexao.prepareStatement(sql);
        
        insert.setString(1,formacao.getEscola());
        insert.setDate(2,new Date(formacao.getInicio().getTime()));
        insert.setDate(3,new Date(formacao.getTermino().getTime()));
        insert.setString(4, formacao.getTitulo());
       
        insert.execute();

            
            
    }
    
    public List<Formacao> listarFormacoes(){
        return new ArrayList<Formacao>();
    }
    
    public Formacao obterFormacao(int codigo){
        return new Formacao();
    }
    
    private void inserirFormacao(Formacao formacao){
        //
    }
    
    private void atualizarFormacao(Formacao formacao){
        //
    }
    
    // ---------------------------------------------- \\
    public List<Formacao> buscarFormacaoPorTitulo(String titulo){
        if(titulo == null || titulo.isEmpty())
            return listarFormacoes();
        
        return new ArrayList<Formacao>();
    }
}
