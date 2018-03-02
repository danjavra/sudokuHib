package entities;
// Generated 02-mar-2018 20:08:31 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private String username;
     private String nombre;
     private String password;
     private Set historials = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String username, String nombre, String password) {
        this.username = username;
        this.nombre = nombre;
        this.password = password;
    }
    public Usuario(String username, String nombre, String password, Set historials) {
       this.username = username;
       this.nombre = nombre;
       this.password = password;
       this.historials = historials;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Set getHistorials() {
        return this.historials;
    }
    
    public void setHistorials(Set historials) {
        this.historials = historials;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", nombre=" + nombre + ", password=" + password + ", historials=" + historials + '}';
    }




}

