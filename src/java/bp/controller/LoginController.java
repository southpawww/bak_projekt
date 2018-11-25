
package bp.controller;
import bp.model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import bp.model.LoggedUser;

import javax.faces.bean.SessionScoped;


/**
 *
 * @author marek
 */
@ManagedBean(name = "logincontroller")
@RequestScoped
public class LoginController {
        
       @ManagedProperty("#{login.user}")
       private String user;
       
       @ManagedProperty("#{login.pwd}")
       private String pwd;
     
       @ManagedProperty("#{loggeduser}")
        private LoggedUser loggeduser;
       
       @ManagedProperty("#{loggedusercontroller}")
        private LoggedUserController loggedusercontroller;
        
     	HttpSession session = SessionUtils.getSession();
       
       public String loginProcess() {
		boolean valid = validate(user,pwd);
		if (valid) {
		
			session.setAttribute("username", user);
			session.setAttribute("password", pwd);
                        
                        
                        loggeduser.setL_username(user);
                        loggedusercontroller.loadUserData(loggeduser);
                       
                        return Login.getPage();
                        
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "login";
		}
	}
    //logout session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}

     //valide user
     public boolean validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DatabaseConnection.getConnection();
			ps = con.prepareStatement("Select username, password, MS_ROLES.R_NAME from TM_USER "
                                + "join MS_ROLES on TM_USER.ID_ROLE = MS_ROLES.ID_ROLE"
                                + " where TM_USER.username = ? and TM_USER.password = ?");
                             
			ps.setString(1, user);
			ps.setString(2, password);
                        
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
                          Login.setPage(rs.getString("R_NAME"));
                          session.setAttribute("role", rs.getString("R_NAME"));
                          return true;
			}
		} catch (SQLException ex) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error "+ex.getMessage()));
  
			return false;
		} finally {
			DatabaseConnection.close(con); 
		}
		return false;
	}
  
    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @param loggeduser the loggeduser to set
     */
    public void setLoggeduser(LoggedUser loggeduser) {
        this.loggeduser = loggeduser;
    }

    /**
     * @param loggedusercontroller the loggedusercontroller to set
     */
    public void setLoggedusercontroller(LoggedUserController loggedusercontroller) {
        this.loggedusercontroller = loggedusercontroller;
    }

   

    

   
  
}
