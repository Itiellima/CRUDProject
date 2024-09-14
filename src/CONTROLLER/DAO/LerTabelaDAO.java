
package CONTROLLER.DAO;


import java.util.ArrayList;
import java.util.List;
import MODEL.Pessoa;
import MySQLConnector.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LerTabelaDAO {        
    
            private Connection conn;
            public void LerTabela() throws SQLException{
                
                
            conn = (Connection) new ConnectionFactory().getConnection();
            PreparedStatement st = null;
            ResultSet rs = null;
            
            st = conn.prepareStatement("SELECT * FROM pessoa");
            rs = st.executeQuery();
            
            List<Pessoa> list = new ArrayList<>();
            
            
            
            
            
            st.close();
            conn.close();
            }
}
