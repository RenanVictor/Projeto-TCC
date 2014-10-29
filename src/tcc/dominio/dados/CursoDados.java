package tcc.dominio.dados;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import tcc.dominio.Curso;

public class CursoDados {

    private EntityManager em;

    public CursoDados() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TCC-CurriculoPU");
        em = factory.createEntityManager();
    }

    public void salvarCurso(Curso curso) throws SQLException {
        EntityTransaction entTrans = em.getTransaction();
        try {
            entTrans.begin();
            em.persist(curso);
            entTrans.commit();
        }catch(Exception e){
            entTrans.rollback();
            throw new SQLException(e);
        }
    }

    public List<Curso> listarCursos() throws SQLException {
        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Curso> query = cBuilder.createQuery(Curso.class);

        query.from(Curso.class);

        return em.createQuery(query).getResultList();
    }

    public Curso obterCurso(int codigo) {
        return em.find(Curso.class, codigo);
    }

    private void inserirCurso(Curso curso) {
        //
    }

    private void atualizarCurso(Curso curso) {
        //
    }

    // ---------------------------------------------- \\
    public List<Curso> buscarCursoPorTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            return null;
        }

        return new ArrayList<Curso>();
    }
}
