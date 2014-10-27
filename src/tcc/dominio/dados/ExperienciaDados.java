package tcc.dominio.dados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dominio.Experiencia;

public class ExperienciaDados {
   
    public void salvarExperiencia(Experiencia experiencia)throws SQLException{
       Connection conexao =  Conexao.get();
        String sql = "Insert into EXPERIENCIA(empresa,cargo,funcoes,entrada,saida) Values(?,?,?,?,?)";

        PreparedStatement insert = conexao.prepareStatement(sql);
        
        insert.setString(1, experiencia.getEmpresas());
        insert.setString(2,experiencia.getCargo());
        insert.setString(3,experiencia.getFuncao());
        insert.setDate(4,new Date(experiencia.getEntrada().getTime()));
        insert.setDate(5,new Date(experiencia.getSaida().getTime()));
        
        insert.execute();
        
        
        /* if(experiencia.getCodigo() == null)
            inserirExperiencia(experiencia);
        else
            atualizarExperiencia(experiencia);*/
    }
    
    public List<Experiencia> listarExperiencias(){
        return new ArrayList<Experiencia>();
    }
    
    public Experiencia obterExperiencia(int codigo){
        return new Experiencia();
    }
    
    private void inserirExperiencia(Experiencia experiencia){
        //
    }
    
    private void atualizarExperiencia(Experiencia experiencia){
        //
    }
    
    // ---------------------------------------------- \\
    public List<Experiencia> buscarExperienciaPorFuncao(String funcao){
        if(funcao == null || funcao.isEmpty())
            return listarExperiencias();
        
        return new ArrayList<Experiencia>();
    }
}
