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
public class Comentario {
    private int idComentario;
    
    private String comentario;
    
    private double nota;
    
    private String usuario;
    
    private int filme;
    
    public Comentario (int idComentario, String comentario, double nota, String usuario, int filme) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.nota = nota;
        this.usuario = usuario;
        this.filme = filme;
    }
    
    public Comentario (String comentario, double nota, String usuario, int filme) {
        this.comentario = comentario;
        this.nota = nota;
        this.usuario = usuario;
        this.filme = filme;
    }

    /**
     * @return the idComentario
     */
    public int getIdComentario() {
        return idComentario;
    }

    /**
     * @param idComentario the idComentario to set
     */
    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the nota
     */
    public double getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(double nota) {
        this.nota = nota;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    /**
     * @return the filme
     */
    public int getFilme() {
        return filme;
    }

    /**
     * @param filme the filme to set
     */
    public void setFilme(int filme) {
        this.filme = filme;
    }
    
    
}
