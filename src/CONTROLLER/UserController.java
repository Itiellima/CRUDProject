
package CONTROLLER;

import JDBC_DAO.User_DAO;
import java.sql.SQLException;


public class UserController {
        private User_DAO login_DAO;
        
        public UserController() {
        this.login_DAO = new User_DAO();
    }
    
        public void inserirUser (String login, String senha) throws SQLException{
            
            login_DAO.AdicionarUser(login, senha);
        }
        
        public void removerUser (int id_user) throws SQLException{
            
            login_DAO.RmUser(id_user);
        }
        
        public void alterarUser (int id_user, String login, String senha) throws SQLException{
            
            login_DAO.AtUser(id_user, login, senha);
        }
        
        public boolean verificarLogin(String login, String senha) {
            try {
            return login_DAO.LoginCheck(login, senha);
        } catch (SQLException e) {
            return false;
        }
    
    }
}
