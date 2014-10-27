/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tcc.dominio;

/**
 *
 * @author Etec
 */
public enum Estado {
    
    SP("São Paulo"),
    MG("Minas Gerais"),
    GO("Goiás");
    
    private final String nomeCompleto;
    
    Estado(String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
    }

    /**
     * @return the nomeCompleto
     */
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    @Override
    public String toString() {
        return getNomeCompleto();
    }
}
