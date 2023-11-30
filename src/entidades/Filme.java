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
public class Filme {
    private int idFilme;
    
    private String titulo;
    
    private String ano;
    
    private String diretor;
    
    private String pais;
    
    private int genero;
    
    
    public Filme (int idFilme, String titulo, String ano, String diretor, String pais, int genero) {
        this.idFilme = idFilme;
        this.titulo = titulo;
        this.ano = ano;
        this.diretor = diretor;
        this.pais = pais;
        this.genero = genero;
    }
    
    public Filme (String titulo, String ano, String diretor, String pais, int genero) {
        this.titulo = titulo;
        this.ano = ano;
        this.diretor = diretor;
        this.pais = pais;
        this.genero = genero;
    }
    
    /**
     * @return the idFilme
     */
    public int getIdFilme() {
        return idFilme;
    }

    /**
     * @param idFilme the idFilme to set
     */
    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * @return the diretor
     */
    public String getDiretor() {
        return diretor;
    }

    /**
     * @param diretor the diretor to set
     */
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    /**
     * @return the genero
     */
    public int getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(int genero) {
        this.genero = genero;
    }
    
    @Override
    public String toString () {
        return getTitulo();
    }
    
    
}
