package tcc.dominio.dados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dominio.Candidato;

public class CandidatoDados {
    
    
    public void salvarCandidato(Candidato candidato)throws SQLException{
        Connection conexao =  Conexao.get();
        String sql = "Insert into CANDIDATO(Nome,endereco,cpf,numero,bairro,cidade,estado,"
                + "DATA_NASCIMENTO,EMAIL,Tel_Residencial,"
                + "Tel_Celular,Statuscursando,estadocivil) Values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement insert = conexao.prepareStatement(sql);
        
        insert.setString(1, candidato.getNome());
        insert.setString(2, candidato.getEndereco());
        insert.setString(3, candidato.getCpf());
        insert.setInt(4, candidato.getNumero());
        insert.setString(5, candidato.getBairro());
        insert.setString(6, candidato.getCidade());
        insert.setString(7, candidato.getEstado().name());
        insert.setDate(8, new Date(candidato.getDataDeNascimento().getTime()));
        insert.setString(9,candidato.getEmail());
        insert.setString(10, candidato.getTelefoneResidencial());
        insert.setString(11, candidato.getCelular());
        insert.setString(12, candidato.getStatus().name());
        insert.setString(13, candidato.getEstadoCivil().name());

        insert.execute();
        
        
        /* if(candidato.getCodigo() == null)
            inserirCandidato(candidato);
        else
            atualizarCandidato(candidato);*/
    }
    
    public List<Candidato> listarCandidatos(){
        return new ArrayList<Candidato>();
    }
    
    public Candidato obterCandidato(int codigo){
        return new Candidato();
    }
    
    private void inserirCandidato(Candidato candidato){
        //
    }
    
    private void atualizarCandidato(Candidato candidato){
        //
    }
    
    // ---------------------------------------------- \\
    public List<Candidato> buscarCandidatosPorNome(String nome){
        if(nome == null || nome.isEmpty())
            return listarCandidatos();
        
        return new ArrayList<Candidato>();
    }
        
    
    
}
