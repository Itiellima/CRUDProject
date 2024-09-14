package CONTROLLER.DAO;

import MySQLConnector.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableUpdater {
    
    public static void readJtable(JTable jTable) {
        DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
        modelo.setNumRows(0);
        
        jTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(20);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(10);
        jTable.getColumnModel().getColumn(5).setPreferredWidth(20);
        jTable.getColumnModel().getColumn(6).setPreferredWidth(40);
        
        try {
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM pessoa");
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDate(4),
                    rs.getString(5),
                    rs.getLong(6),
                    rs.getString(7),
                });
            }
            st.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados");
        }
    }
    
    public static void readJtable(JTable table, String cpf) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Limpa a tabela

        try (Connection conn = new ConnectionFactory().getConnection(); // obter a conexão com o banco de dados;
             PreparedStatement st = conn.prepareStatement("SELECT * FROM Pessoa WHERE cpf = ?")) {
            st.setString(1, cpf);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getInt("id_pessoa"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getDate("dataNasc").toString(),
                        rs.getInt("idade"),
                        rs.getString("contatoTel"),
                        rs.getString("consultaReal")
                    });
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de pesquisa");
        }
    }
    
}