
package CONTROLLER.DAO;

import MySQLConnector.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login_DAO {
    
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
}
