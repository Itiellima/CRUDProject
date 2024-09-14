
package CONTROLLER.DAO;

import MySQLConnector.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Cadastrar_DAO {
    
        private Connection conn;
    
    public void AdicionarUser(String login, String senha) throws SQLException{
        
        conn = (Connection) new ConnectionFactory().getConnection();
        PreparedStatement st = null;
        
            st = conn.prepareStatement("INSERT INTO usuario (login, senha) VALUES (?,?)");
            st.setString(1, login);
            st.setString(2, senha);
            st.execute();

            st.close();
            conn.close();
    }
    
    public void RmUser(int id_usuario) throws SQLException{
        conn = (Connection) new ConnectionFactory().getConnection();
        PreparedStatement st = null;
        
        st = conn.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");
        st.setInt(1, id_usuario);
        
        st.execute();
        
        st.close();
        conn.close();
    }
}
