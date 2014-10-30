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
    public Usuario login(String login, String senha) throws SQLException {
        Connection conexao = Conexao.get();
        String sql = "SELECT * FROM usuario where login = '"+login+"' and senha = '"+senha+"';";
        PreparedStatement select = conexao.prepareStatement(sql);        

        ResultSet rs = select.executeQuery(sql);
        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            return usuario;
        }
        return null;
    }
}
