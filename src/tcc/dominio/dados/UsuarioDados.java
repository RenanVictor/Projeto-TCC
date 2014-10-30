package tcc.dominio.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import tcc.dominio.Usuario;

public class UsuarioDados {

    private EntityManager em;

    public UsuarioDados() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TCC-CurriculoPU");
        em = factory.createEntityManager();
    }

    public void salvarUsuario(Usuario usuario) throws SQLException {
        EntityTransaction entTrans = em.getTransaction();
        try {
            entTrans.begin();
            em.persist(usuario);
            entTrans.commit();
        } catch (Exception e) {
            entTrans.rollback();
            throw new SQLException(e);
        }
    }

    public List<Usuario> listarUsuarios() throws SQLException {
        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Usuario> query = cBuilder.createQuery(Usuario.class);

        query.from(Usuario.class);

        return em.createQuery(query).getResultList();
    }

    public Usuario obterUsuario(int codigo) {

        return new Usuario();
    }

    private void inserirUsuario(Usuario usuario) {
        //
    }

    private void atualizarUsuario(Usuario usuario) {
        //
    }

    // ---------------------------------------------- \\
    public Usuario buscarUsuarioSenha(Usuario usuario) throws SQLException {
        Connection conexao = Conexao.get();
        String sql = "SELECT * FROM usuario where login = ? and senha = ? or nome = ?"
                + " or email = ?;";
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

    public List<Usuario> buscarUsuario(Usuario usuario) throws SQLException {
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
