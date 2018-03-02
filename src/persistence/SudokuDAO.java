/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entities.Historial;
import entities.Sudoku;
import entities.Usuario;
import exceptions.MisExcepciones;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DAM
 */
public class SudokuDAO {
    
    Session sesion;
    Transaction tx;
    
    public SudokuDAO() {
        sesion = HibernateUtil.getSessionFactory().openSession();
    }
  
    public void insertarSudoku(Sudoku s) throws MisExcepciones {
        
        tx = sesion.beginTransaction();
        sesion.save(s);
        tx.commit();
    }
    
    public void insertarUsuario(Usuario u) throws MisExcepciones {
        Usuario aux = getUsuarioByUsername(u.getUsername());
        if (aux != null){
            throw new MisExcepciones("Este usuario ya está registrado");
        }
        tx = sesion.beginTransaction();
        sesion.save(u);
        tx.commit();
        
    }
    
    public boolean validateUserByPassword(Usuario u) throws MisExcepciones {
        
        Query q = sesion.createQuery("from Usuario p where p.username = :username and p.password = :password");
        q.setParameter("username", u.getUsername());
        q.setParameter("password", u.getPassword());
        if (q.uniqueResult() != null ){
            return true;
        } 
        throw new MisExcepciones("Usuario o contraseña incorrectos");

    }
    
    public Sudoku  getSudokuById(Integer idSudoku) {
        return (Sudoku) sesion.get(Sudoku.class, idSudoku);
        
    }
    
    public Sudoku mostrarSudokuById(Integer s) throws MisExcepciones {
        Sudoku aux = getSudokuById(s);
        if (aux == null) {
            throw new MisExcepciones("No existe un sudoku con ese Id");
        }
        return aux;
       
    }
    
    public void modificarPerfilUsuario(Usuario c, String nuevoNombre) throws MisExcepciones {
        
        Usuario aux = getUsuarioByUsername(c.getUsername());
        if (aux == null) {
            throw new MisExcepciones("No existe este usuario");
        }
        tx = sesion.beginTransaction();
        aux.setNombre(nuevoNombre);
        sesion.update(aux);
        tx.commit();
    }
    
    public void modificarPasswordUsuario(Usuario c, String nuevoPassword) throws MisExcepciones {
        
        Usuario aux = getUsuarioByUsername(c.getUsername());
        if (aux == null) {
            throw new MisExcepciones("No existe este usuario");
        }
        tx = sesion.beginTransaction();
        aux.setPassword(nuevoPassword);
        sesion.update(aux);
        tx.commit();
    }
    
    public void borrarUsuario(Usuario u) throws MisExcepciones  {
        Usuario aux = (Usuario) sesion.get(Usuario.class, u.getUsername());
        if (aux != null) {
            tx = sesion.beginTransaction();
            sesion.delete(aux);
            tx.commit();
        } else {
            throw new MisExcepciones("No existe el usuario");
        }
    }
    
    public void insertarHistorial(Historial h) throws MisExcepciones {
        tx = sesion.beginTransaction();
        sesion.save(h);
        tx.commit();
    }
    
    public List<Sudoku> getListaSudokus(){
        Query q = sesion.createQuery("select p from Sudoku p");
        return q.list();
    }
    
    public Usuario getUsuarioByUsername(String username) {
        return (Usuario) sesion.get(Usuario.class, username);
    }
    
    public Usuario getUsuarioByPassword(String password) {
        return (Usuario) sesion.get(Usuario.class, password);
    }
    
    public void desconectar() {
        sesion.close();
        HibernateUtil.close();
    }
    
}
