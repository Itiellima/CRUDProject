
package JDBC_DAO;

import MySQLConnector.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class User_DAO {
    
    private Connection conn;
    
    public boolean LoginCheck(String login, String senha) throws SQLException{
        conn = (Connection) new ConnectionFactory().getConnection();
        boolean Check = false;
        PreparedStatement st = null;
        ResultSet rs = null;
        
            st = conn.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");

        st.setString(1, login);
        st.setString(2, senha);
        rs = st.executeQuery();
        if (rs.next()){
            Check = true;
        }

        st.close();
        conn.close();
        return Check;   
    }
    
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
   
    public void AtUser(int id_usuario, String login, String senha) throws SQLException {
        conn = (Connection) new ConnectionFactory().getConnection();
        PreparedStatement st = null;
        
        
        st = conn.prepareStatement( "UPDATE usuario SET login = ?, senha = ? WHERE id_pessoa = ?");
        
            st.setInt(1, id_usuario);
            st.setString(2, login);
            st.setString(3, senha);

            st.close();
            conn.close();
        
    }
}
