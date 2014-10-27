package tcc.dominio;

import java.util.Date;
import tcc.dominio.dados.Status;


public class Contrato {
    private String modalidade;
    private Date inicio;
    private Date termino;
    private Status seguro;
    private Empresa empresa;

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public Status getSeguro() {
        return seguro;
    }

    public void setSeguro(Status seguro) {
        this.seguro = seguro;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    
    
}
