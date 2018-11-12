/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrica;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author aluno
 */
public class ConectorMYSQL {
    private static String status = "OFFLINE";
    
    private static final String local = "localhost";
    private static final String user = "root";
    private static final String password = "";
    private static final String database = "sistemacantina";
    
    public static Connection getConnection(){
        Connection conexao = null;
        
        String url = "jdbc:mysql://" + local + "/" + database;
        
        try{
            conexao = DriverManager.getConnection(url, user, password);
            
            status = "ONLINE";
                    
        }
        catch(Exception e){
            status = "OFFLINE";
            
            e.printStackTrace();          
        }
        
        return conexao;
    }
    
    public static String getStatus(){
        return status;
}
}
