package tcc.dominio.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dominio.Curso;


public class CursoDados {

    
  public void salvarCurso(Curso curso)throws  SQLException{
        Connection conexao =  Conexao.get();
        String sql = "Insert into Curso(titulo,area) Values(?,?)";

        PreparedStatement insert = conexao.prepareStatement(sql);
        
        insert.setString(1, curso.getTitulo());
        insert.setString(2, curso.getArea());

        insert.execute();
        
    }
    
    public List<Curso> listarCursos()throws SQLException{
        Connection conexao = Conexao.get();
        String sql = "SELECT * FROM curso order by titulo";
        
        PreparedStatement select = conexao.prepareStatement(sql);
        
        ResultSet rs = select.executeQuery(sql);
        List<Curso> cursos = new ArrayList<>();
        while (rs.next()) {
           Curso curso = new Curso();
           curso.setCodigo(rs.getInt("codcurso"));
           curso.setArea(rs.getString("area"));
           curso.setTitulo(rs.getString("titulo"));
           
           cursos.add(curso);
    }
        return cursos;
    }
    
    public Curso obterCurso(int codigo){
        return new Curso();
    }
    
    private void inserirCurso(Curso curso){
        //
    }
    
    private void atualizarCurso(Curso curso){
        //
    }
    
    // ---------------------------------------------- \\
    public List<Curso> buscarCursoPorTitulo(String titulo){
        if(titulo == null || titulo.isEmpty())
            return null;
        
        return new ArrayList<Curso>();
    }
}
