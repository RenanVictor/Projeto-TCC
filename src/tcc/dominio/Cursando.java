package tcc.dominio;

import java.util.Date;

public class Cursando {
    
    private Integer codigo;
    private Curso curso;
    private String periodo;
    private Date ingresso;
    private Date conclusao;
    private Candidato candidato;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Date getIngresso() {
        return ingresso;
    }

    public void setIngresso(Date ingresso) {
        this.ingresso = ingresso;
    }

    public Date getConclusao() {
        return conclusao;
    }

    public void setConclusao(Date conclusao) {
        this.conclusao = conclusao;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    
    
    
}
