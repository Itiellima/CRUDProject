
package CONTROLLER.DAO;


import MySQLConnector.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class CadastrarPessoa_DAO {
            private Connection conn;
    
    public void AdPessoa(String nome, String cpf, String dataNasc, String idade, long contatoTel, String consultaReal) throws SQLException{
        conn = (Connection) new ConnectionFactory().getConnection();
        PreparedStatement st = null;
        
        st = conn.prepareStatement("INSERT INTO pessoa (nome, cpf, dataNasc, idade, contatoTel, consultaReal) VALUES (?,?,?,?,?,?)");
        st.setString(1, nome);
        st.setString(2, cpf);
        st.setString(3, dataNasc);
        st.setString(4, idade);
        st.setLong(5, contatoTel);
        st.setString(6, consultaReal);
        
        st.execute();
        
        
        st.close();
        conn.close();
    }
}
