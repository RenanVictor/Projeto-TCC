package tcc.dominio.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dominio.Usuario;

public class UsuarioDados {
    
    
        public void salvarUsuario(Usuario usuario) throws SQLException{
            
        Connection conexao =  Conexao.get();
        String sql = "Insert into USUARIO(NOME,TELEFONE,EMAIL,SENHA,LOGIN) Values(?,?,?,?,?)";

        PreparedStatement insert = conexao.prepareStatement(sql);
        
        insert.setString(1, usuario.getNome());
        insert.setString(2, usuario.getTelefone());
        insert.setString(3, usuario.getEmail());
        insert.setString(4, usuario.getSenha());
        insert.setString(5, usuario.getLogin());
       
        insert.execute();

    }
    
    public List<Usuario> listarUsuarios()throws SQLException{
        Connection conexao = Conexao.get();
        String sql = "SELECT * FROM usuario";
        
        PreparedStatement select = conexao.prepareStatement(sql);
        
        ResultSet rs = select.executeQuery(sql);
        List<Usuario> usuarios = new ArrayList<>();
        while (rs.next()) {
           Usuario usuario = new Usuario();
           usuario.setCodigo(rs.getInt("codusuario"));
           usuario.setNome(rs.getString("nome"));
           usuario.setTelefone(rs.getString("telefone"));
           usuario.setEmail(rs.getString("email"));
           usuario.setSenha(rs.getString("senha"));
           usuario.setLogin(rs.getString("login"));
           
           usuarios.add(usuario);
        
    }
        return usuarios;
    }
    
    public Usuario obterUsuario(int codigo){
        
        
        return new Usuario();
    }
    
    private void inserirUsuario(Usuario usuario){
        //
    }
    
    private void atualizarUsuario(Usuario usuario){
        //
    }
    
    // ---------------------------------------------- \\
    public Usuario buscarUsuarioSenha(Usuario usuario) throws SQLException{
        Connection conexao = Conexao.get();
        String sql = "SELECT * FROM usuario where login = ? and senha = ? or nome = ?"
                +" or email = ?;";
        PreparedStatement select = conexao.prepareStatement(sql);
        
        select.setString(1, usuario.getLogin());
        select.setString(2, usuario.getSenha());
        select.setString(3, usuario.getNome());
        select.setString(4, usuario.getEmail());
        
        ResultSet rs = select.executeQuery();
        Usuario resultadoUsuario = new Usuario();
        while (rs.next()) {           
           resultadoUsuario.setLogin(rs.getString("login"));
           resultadoUsuario.setSenha(rs.getString("senha"));
           resultadoUsuario.setEmail(rs.getString("email"));
           resultadoUsuario.setNome(rs.getString("nome"));
           resultadoUsuario.setCodigo(rs.getInt("codusuario"));
           
    }
        return resultadoUsuario;
}
     public List<Usuario> buscarUsuario(Usuario usuario) throws SQLException{
        Connection conexao = Conexao.get();
        String sql = "SELECT * FROM usuario where login = ? or email = ?;";
        PreparedStatement select = conexao.prepareStatement(sql);
        
        select.setString(1, usuario.getLogin());        
        select.setString(2, usuario.getEmail());
        
        ResultSet rs = select.executeQuery();
        List<Usuario> resultadoUsuario = new ArrayList<>();
        while (rs.next()) {
            Usuario us = new Usuario();
           us.setLogin(rs.getString("login"));
           us.setSenha(rs.getString("senha"));
           us.setEmail(rs.getString("email"));
           us.setNome(rs.getString("nome"));
           resultadoUsuario.add(us);
    }
        return resultadoUsuario;
}
}
