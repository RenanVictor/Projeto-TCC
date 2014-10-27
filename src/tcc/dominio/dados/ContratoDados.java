

package tcc.dominio.dados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tcc.dominio.Contrato;

public class ContratoDados {
    
    public void salvarContrato(Contrato contrato) throws SQLException{
        
        Connection conexao =  Conexao.get();
        String sql = "Insert into contrato(modalidade,inicio,termino,seguro,codigo) Values(?,?,?,?,?)";

        PreparedStatement insert = conexao.prepareStatement(sql);
        
        insert.setString(1, contrato.getModalidade());
        insert.setDate(2,new Date(contrato.getInicio().getTime()));
        insert.setDate(3,new Date(contrato.getTermino().getTime()));
        insert.setString(4, contrato.getSeguro().name());
        insert.setInt(5, contrato.getEmpresa().getCodigo());

        insert.execute();
    
    }
}
