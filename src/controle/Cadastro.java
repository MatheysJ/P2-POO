/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import entidades.Comentario;
import entidades.Filme;
import entidades.Genero;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathe
 */
public class Cadastro {
    private Conexao conexao = new Conexao();
    
    public Comentario consultarComentario(int id) {
        PreparedStatement st;
        ResultSet rs;
        Comentario comentario = null;
        
        try {
            st = conexao.getConexao().prepareStatement("select * from comentario where idComentario = ? ");
            st.setInt(1, id);
            
            rs = st.executeQuery();
            
            if (rs.next()) {
                comentario = new Comentario(
                        rs.getInt("idComentario"), 
                        rs.getString("comentario"), 
                        rs.getDouble("notaComentario"), 
                        rs.getString("usuarioComentario"),
                        rs.getInt("filme")
                );                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Comentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return comentario;
    }
    
    public List consultarComentarios() {
        PreparedStatement st;
        ResultSet rs;
        List lista = new LinkedList();
        Comentario comentario = null;
        
        try {
            st = conexao.getConexao().prepareStatement("select * from comentario");
            
            rs = st.executeQuery();
            
            while (rs.next()) {
                comentario = new Comentario(
                        rs.getInt("idComentario"), 
                        rs.getString("comentario"), 
                        rs.getDouble("nota"), 
                        rs.getString("usuario"),
                        rs.getInt("filme")
                );
                lista.add(comentario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Comentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public void salvarComentario(Comentario comentario) {
        PreparedStatement st;
        ResultSet rs;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement(
                    "insert into comentario " + 
                            "(comentario, nota, usuario, filme) " + 
                            "values (?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(i++, comentario.getComentario());
            st.setDouble(i++, comentario.getNota());
            st.setString(i++, comentario.getUsuario());
            st.setInt(i++, comentario.getFilme());
            
            st.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Comentario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizarComentario(Comentario comentario) {
        PreparedStatement st;
        ResultSet rs;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement(
                    "update comentario set " + 
                            "comentario = ?, nota = ?, usuario = ?, filme = ? " + 
                            "where idComentario = ?");
            st.setString(i++, comentario.getComentario());
            st.setDouble(i++, comentario.getNota());
            st.setString(i++, comentario.getUsuario());
            st.setInt(i++, comentario.getFilme());
            
            st.setInt(i++, comentario.getIdComentario());
            
            st.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Comentario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* Filme */
    
    public Filme consultarFilme(int id) {
        PreparedStatement st;
        ResultSet rs;
        Filme filme = null;
        
        try {
            st = conexao.getConexao().prepareStatement("select * from filme where idFilme = ? ");
            st.setInt(1, id);
            
            rs = st.executeQuery();
            
            if (rs.next()) {
                int idFilme = rs.getInt("idFilme");
                String titulo = rs.getString("titulo");
                String ano = rs.getString("ano");
                String diretor = rs.getString("diretor");
                String pais = rs.getString("pais");
                int genero = rs.getInt("genero");
                filme = new Filme(idFilme, titulo, ano, diretor, pais, genero);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Filme.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return filme;
    }
    
    public List consultarFilmes() {
        PreparedStatement st;
        ResultSet rs;
        List lista = new LinkedList();
        Filme filme = null;
        
        try {
            st = conexao.getConexao().prepareStatement("select * from filme");
            
            rs = st.executeQuery();
            
            while (rs.next()) {               
                int idFilme = rs.getInt("idFilme");
                String titulo = rs.getString("titulo");
                String ano = rs.getString("ano");
                String diretor = rs.getString("diretor");
                String pais = rs.getString("pais");
                int genero = rs.getInt("genero");
                filme = new Filme(idFilme, titulo, ano, diretor, pais, genero);
                lista.add(filme);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Filme.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public void salvarFilme(Filme filme) {
        PreparedStatement st;
        ResultSet rs;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement(
                    "insert into filme " + 
                            "(titulo, ano, diretor, pais, genero) " + 
                            "values (?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(i++, filme.getTitulo());
            st.setString(i++, filme.getAno());
            st.setString(i++, filme.getDiretor());
            st.setString(i++, filme.getPais());
            st.setInt(i++, filme.getGenero());
            
            st.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Filme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizarFilme(Filme filme) {
        PreparedStatement st;
        ResultSet rs;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement(
                    "update filme set " + 
                            "titulo = ?, ano = ?, diretor = ?, pais = ?, genero = ? " + 
                            "where idFilme = ?");
            st.setString(i++, filme.getTitulo());
            st.setString(i++, filme.getAno());
            st.setString(i++, filme.getDiretor());
            st.setString(i++, filme.getPais());
            st.setInt(i++, filme.getGenero());
            st.setInt(i++, filme.getIdFilme());            
            
            st.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Filme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* Gênero */
    
    public Genero consultarGenero(int id) {
        PreparedStatement st;
        ResultSet rs;
        Genero genero = null;
        
        try {
            st = conexao.getConexao().prepareStatement("select * from genero where idGenero = ? ");
            st.setInt(1, id);
            
            rs = st.executeQuery();
            
            if (rs.next()) {
                genero = new Genero(rs.getInt("idGenero"), rs.getString("descricao"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Genero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return genero;
    }
    
    public List consultarGeneros() {
        PreparedStatement st;
        ResultSet rs;
        List lista = new LinkedList();
        Genero genero = null;
        
        try {
            st = conexao.getConexao().prepareStatement("select * from genero");
            
            rs = st.executeQuery();
            
            while (rs.next()) {
                genero = new Genero(rs.getInt("idGenero"), rs.getString("descricao"));
                lista.add(genero);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Genero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public void salvarGenero(Genero genero) {
        PreparedStatement st;
        ResultSet rs;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement(
                    "insert into genero " + 
                            "(descricao) " + 
                            "values (?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(i++, genero.getDescricao());
            
            st.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Genero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizarGenero(Genero genero) {
        PreparedStatement st;
        ResultSet rs;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement(
                    "update genero set " + 
                            "descricao = ? " + 
                            "where idGenero = ?");
            st.setString(i++, genero.getDescricao());
            
            st.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Comentario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
