package MySQLConnector; // situa em qual package ou "pacote" está a classe 


import java.sql.Connection; // faz as importações de classes necessárias para o funcionamento do programa 
import java.sql.DriverManager; // conexão SQL para Java 
import java.sql.SQLException; // driver de conexão SQL para Java 
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory { // classe para tratamento de exceções 
    public Connection getConnection() {
		try {                                //"jdbc:mysql://localhost/nome_banco","root","senha_root"
                    return DriverManager.getConnection("jdbc:mysql://localhost/db_user","root","admin");
		 } 
		 catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
    }
    
    public static void closeConnection(Connection conn){
        try {
            if (conn != null){
                    conn.close();
            }
        }catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement st){
        
        closeConnection(conn);
        
        try {
            if (st != null){
                st.close();
            }

        }catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        public static void closeConnection(Connection conn, PreparedStatement st, ResultSet rs){
        
            closeConnection(conn, st);
        
        try {
            if (rs != null){
                rs.close();
            }

        }catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}