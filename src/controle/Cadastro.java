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
                comentario = new Comentario();
                comentario.setIdComentario(rs.getInt("idComentario"));
                comentario.setComentario(rs.getString("comentario"));
                comentario.setNota(rs.getDouble("notaComentario"));
                comentario.setUsuario(rs.getString("usuarioComentario"));                
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
            
            if (rs.next()) {
                comentario = new Comentario();
                comentario.setIdComentario(rs.getInt("idComentario"));
                comentario.setComentario(rs.getString("comentario"));
                comentario.setNota(rs.getDouble("notaComentario"));
                comentario.setUsuario(rs.getString("usuarioComentario"));                
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
                            "(comentario, notaComentario, usuarioComentario) " + 
                            "values (?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            
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
                            "comentario = ?, notaComentario = ?, usuarioComentario = ? " + 
                            "where idComentario = ?");
            st.setString(i++, comentario.getComentario());
            st.setDouble(i++, comentario.getNota());
            st.setString(i++, comentario.getUsuario());
            
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
                filme = new Filme();
                filme.setIdFilme(rs.getInt("idFilme"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setAno(rs.getString("ano"));
                filme.setDiretor(rs.getString("diretor"));
                filme.setPais(rs.getString("pais"));
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
            
            if (rs.next()) {
                filme = new Filme();
                filme.setIdFilme(rs.getInt("idFilme"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setAno(rs.getString("ano"));
                filme.setDiretor(rs.getString("diretor"));
                filme.setPais(rs.getString("pais"));                
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
                            "(titulo, ano, diretor, pais) " + 
                            "values (?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            
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
                            "titulo = ?, ano = ?, diretor = ?, pais = ? " + 
                            "where idFilme = ?");
            st.setString(i++, filme.getTitulo());
            st.setString(i++, filme.getAno());
            st.setString(i++, filme.getDiretor());
            st.setString(i++, filme.getPais());            
            
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
            
            if (rs.next()) {
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
            
            System.out.println("oie");
            
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
