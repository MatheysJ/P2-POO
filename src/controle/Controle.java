/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import entidades.Comentario;
import java.util.List;

/**
 *
 * @author mathe
 */
public class Controle {
    
    private Cadastro cadastro = new Cadastro();
    
    public void salvarComentario(Comentario comentario) {
        if (comentario.getIdComentario() == 0) {
            cadastro.salvarComentario(comentario);
        } else {
            cadastro.atualizarComentario(comentario);
        }
    }
    
    public List consultarComentarios() {
        return cadastro.consultarComentarios();
    }
    
    public List consultarFilmes() {
        return cadastro.consultarFilmes();
    }
    
    public List consultarGeneros() {
        return cadastro.consultarGeneros();
    }
    
    /* Os outros métodos não foram declarados aqui na DOC, verificar se é isso mesmo */
}
