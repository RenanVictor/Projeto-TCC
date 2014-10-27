package tcc.dominio.dados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dominio.Cursando;


public class CursandoDados {
    
    public void salvarCursando(Cursando cursando) throws SQLException{
        Connection conexao =  Conexao.get();
        String sql = "Insert into cursando(ingresso,conclusao,periodo,codcurso) Values(?,?,?,?)";

        PreparedStatement insert = conexao.prepareStatement(sql);
        
        insert.setDate(1,new Date(cursando.getIngresso().getTime()));
        insert.setDate(2,new Date(cursando.getConclusao().getTime()));
        insert.setString(3,cursando.getPeriodo());
        insert.setInt(4, cursando.getCurso().getCodigo());
        
        insert.execute();
    }
    
    public List<Cursando> listarCursandos(){
        return new ArrayList<Cursando>();
    }
    
    public Cursando obterCursando(int codigo){
        return new Cursando();
    }
    
    private void inserirCursando(Cursando cursando){
        //
    }
    
    private void atualizarCursando(Cursando cursando){
        //
    }
    
    // ---------------------------------------------- \\
    public List<Cursando> buscarCursandoPorCurso(String curso){
        if(curso == null || curso.isEmpty())
            return listarCursandos();
        
        return new ArrayList<Cursando>();
    }
    
}
