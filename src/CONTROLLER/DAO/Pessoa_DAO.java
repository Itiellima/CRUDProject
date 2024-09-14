
package CONTROLLER.DAO;

import MySQLConnector.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Pessoa_DAO {
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
    
    public void RmPessoa(int id_pessoa) throws SQLException{
        conn = (Connection) new ConnectionFactory().getConnection();
        PreparedStatement st = null;
        
        st = conn.prepareStatement("DELETE FROM pessoa WHERE id_pessoa = ?");
        st.setInt(1, id_pessoa);
        
        st.execute();
        
        st.close();
        conn.close();
    }
        
    public void AtPessoa(int id_pessoa, String nome, String cpf, String dataNasc, String idade, long contatoTel, String consultaReal) throws SQLException {
        conn = (Connection) new ConnectionFactory().getConnection();
        PreparedStatement st = null;
        
        
        st = conn.prepareStatement( "UPDATE pessoa SET nome = ?, cpf = ?, dataNasc = ?, idade = ?, contatoTel = ?, consultaReal = ? WHERE id_pessoa = ?");
        
            st.setString(1, nome);
            st.setString(2, cpf);
            st.setString(3, dataNasc);
            st.setString(4, idade);
            st.setLong(5, contatoTel);
            st.setString(6, consultaReal);
            st.setInt(7, id_pessoa);
            st.executeUpdate();

            st.close();
            conn.close();
        
}
}
