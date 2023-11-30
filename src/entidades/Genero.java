/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author fatec
 */
public class Genero {
    private int idGenero;
    
    private String descricao;
    
    public Genero (String descricao) {
        this.descricao = descricao;
    }
    
    public Genero (int idGenero, String descricao) {
        this.idGenero = idGenero;
        this.descricao = descricao;
    }
    
    /**
     * @return the idGenero
     */
    public int getIdGenero() {
        return idGenero;
    }

    /**
     * @param idGenero the idGenero to set
     */
    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString () { 
        return getDescricao();
    }
    
    
}
