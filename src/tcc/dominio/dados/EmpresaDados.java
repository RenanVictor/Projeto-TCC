package tcc.dominio.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dominio.Empresa;

public class EmpresaDados {
    
   private static List<Empresa> empresas = new ArrayList<Empresa>();
    
    public void salvarEmpresa(Empresa empresa) throws SQLException{
        
        Connection conexao =  Conexao.get();
        String sql = "Insert into EMPRESA(FANTASIA, RAZAO) Values(?,?)";

        PreparedStatement insert = conexao.prepareStatement(sql);
        
        insert.setString(1, empresa.getFantasia());
        insert.setString(2, empresa.getRazao());

        insert.execute();
        
    }
    
    public List<Empresa> listarEmpresas()throws SQLException{
        Connection conexao = Conexao.get();
        String sql = "SELECT * FROM EMPRESA order by fantasia";
        
        PreparedStatement select = conexao.prepareStatement(sql);
        
        ResultSet rs = select.executeQuery(sql);
        List<Empresa> empresas = new ArrayList<>();
        while (rs.next()) {
           Empresa empresa = new Empresa();
           empresa.setCodigo(rs.getInt("codigo"));
           empresa.setFantasia(rs.getString("fantasia"));
           empresa.setRazao(rs.getString("razao"));
           
           empresas.add(empresa);
            
        }
        
        return empresas;
        
        
    }
    
    public Empresa obterEmpresa(int codigo){
        return new Empresa();
    }
    
    private void inserirEmpresa(Empresa empresa){
        //
    }
    
    private void atualizarEmpresa(Empresa empresa){
        //
    }
    
    // ---------------------------------------------- \\
    public List<Empresa> buscarEmpresaPorNome(String fantasia) throws SQLException{
        if(fantasia == null || fantasia.isEmpty())
            return listarEmpresas();
        
        return new ArrayList<Empresa>();
    }
    
    public String[] toArray(){
        List<String> empresaslistadas = new ArrayList<String>();
        
        for(Empresa empresa : empresas){
            empresaslistadas.add(empresa.getFantasia());
        }
        
        
        return (String[])empresaslistadas.toArray();
}
    

    
    
}
