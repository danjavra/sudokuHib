/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuHib;

import entities.Historial;
import entities.Sudoku;
import entities.Usuario;
import exceptions.MisExcepciones;
import java.util.List;
import persistence.SudokuDAO;

/**
 *
 * @author DAM
 */
public class SudokuHib {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       System.out.println("*==============================================================================================================================================================================================*");
       System.out.println("*==============================================================================================================================================================================================*"); 
       System.out.println("Primer ejemplo con Hibernate");
       System.out.println("*==============================================================================================================================================================================================*");
       System.out.println("Estableciendo conexión...");
       SudokuDAO sudokuDAO = new SudokuDAO();
       System.out.println("Conexión establecida"); 
       Sudoku s = new Sudoku(4,"Medium (Level 4)","27....4.6.687...915..61..2....8.791...7.6.2...821.4....5..83..214...685.8.3....69","271395486368742591594618327635827914417569238982134675756983142149276853823451769");
       System.out.println("Dando de alta un sudoku..."); 
        try {
            sudokuDAO.insertarSudoku(s);
            System.out.println("Sudoku dado de alta");

        } catch (MisExcepciones ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("*==============================================================================================================================================================================================*");
        System.out.println("Mostrar un sudoku según su Id...");
        System.out.println("Prueba de muestra de un sudoku existente en la bbdd");
        System.out.println("Mostrar sudoku con Id = 3");
        try {
            Sudoku x = sudokuDAO.mostrarSudokuById(5);
            System.out.println(x);

        } catch (MisExcepciones ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Prueba de muestra de un sudoku que no existente en la bbdd");
        System.out.println("Mostrar sudoku con Id = 200");
        try {
            Sudoku x = sudokuDAO.mostrarSudokuById(200);
            System.out.println(x);

        } catch (MisExcepciones ex) {
            System.out.println(ex.getMessage());
        }       
        System.out.println("*==============================================================================================================================================================================================*");
        System.out.println("Mostrar la lista de todos los sudokus...");
        List<Sudoku> ss = sudokuDAO.getListaSudokus();
        for (Sudoku p: ss){
            System.out.println(p);
        }
        System.out.println("*==============================================================================================================================================================================================*");
        System.out.println("*==============================================================================================================================================================================================*");
        System.out.println("Dando de alta un usuario nuevo...");
        Usuario j = new Usuario("usu1","Jordi","123456");
        try {
            sudokuDAO.insertarUsuario(j);
            System.out.println("Usuario dado de alta");

        } catch (MisExcepciones ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("*==============================================================================================================================================================================================*");
        System.out.println("*==============================================================================================================================================================================================*");
        System.out.println("Probando validar un usuario existente");
        System.out.println("Validar un usuario con su username y contraseña...");
        try{
            sudokuDAO.validateUserByPassword(j);
            System.out.println("Usuario validado");
        } catch (MisExcepciones ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Probando validar un usuario inexistente");
        System.out.println("Validar un usuario con su username y contraseña...");
        Usuario o = new Usuario("nadie","Pepe","root");
        try{
            sudokuDAO.validateUserByPassword(o);
            System.out.println("Usuario validado");
        } catch (MisExcepciones ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("*==============================================================================================================================================================================================*");
        System.out.println("*==============================================================================================================================================================================================*");
        System.out.println("Modificar el perfil de un usuario existente...");
        try{
            sudokuDAO.modificarPerfilUsuario(j, "Ramon");
            System.out.println("Usuario modificado con éxito");
        } catch (MisExcepciones ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Prueba de modificar un usuario que no existe...");
        Usuario ns = new Usuario("usu2","Nadie","123456");
        try{
            sudokuDAO.modificarPerfilUsuario(ns, "Ramon");
            System.out.println("Usuario modificado con éxito");
        } catch (MisExcepciones ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("*==============================================================================================================================================================================================*");
        System.out.println("*==============================================================================================================================================================================================*");
        System.out.println("Cambiar la contraseña de un usuario existente...");
        try{
            sudokuDAO.modificarPasswordUsuario(j, "112233");
            System.out.println("Password modificado con éxito");
        } catch (MisExcepciones ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Prueba de modificar el password de un usuario que no existe...");
        try{
            sudokuDAO.modificarPasswordUsuario(ns, "112233");
            System.out.println("Usuario modificado con éxito");
        } catch (MisExcepciones ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("*==============================================================================================================================================================================================*");
        System.out.println("*==============================================================================================================================================================================================*");
        System.out.println("Eliminar un usuario...");
        try{
            sudokuDAO.borrarUsuario(j);
            System.out.println("Usuario borrado con éxito");
        } catch (MisExcepciones ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Prueba de eliminar un usuario que no existe...");
        try{
            sudokuDAO.borrarUsuario(ns);
            System.out.println("Usuario borrado con éxito");
        } catch (MisExcepciones ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("*==============================================================================================================================================================================================*");
        System.out.println("*==============================================================================================================================================================================================*");
        System.out.println("Insertar una partida finalizada considerando el Sudoku jugado y el tiempo de\n" +
        "juego total...");
        System.out.println("Insertando sudoku y usuario nuevos para la prueba");
        Sudoku s4 = new Sudoku(4,"Medium (Level 4)","27....4.6.687...915..61..2....8.791...7.6.2...821.4....5..83..214...685.8.3....69","271395486368742591594618327635827914417569238982134675756983142149276853823451769");
        Usuario u = new Usuario("usu5","Marta","123456");
        
        try {
            sudokuDAO.insertarUsuario(u);
            System.out.println("Usuario dado de alta");

        } catch (MisExcepciones ex) {
            System.out.println(ex.getMessage());
        }
        try {
            sudokuDAO.insertarSudoku(s4);
            System.out.println("Sudoku dado de alta");

        } catch (MisExcepciones ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Insertando nuevo historial");
        Historial h1 = new Historial(s4, u, 36541);
        try {
            sudokuDAO.insertarHistorial(h1);
            System.out.println("Historial registrado");

        } catch (MisExcepciones ex) {
            System.out.println(ex.getMessage());
        }
        
        
        System.out.println("Cerrando sesión...");
        sudokuDAO.desconectar();
        System.out.println("Sesión cerrada.");
    }
    
}
