
package bp.controller;

import bp.model.LoggedUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author marek
 */
@ManagedBean(name="loggedusercontroller")
@RequestScoped
public class LoggedUserController {
    
 
     
    public void loadUserData(LoggedUser lg){
     Connection con = null;
     PreparedStatement ps = null;
  
		try {
			con = DatabaseConnection.getConnection();
			ps = con.prepareStatement("Select * from TM_USER "
                                + "join MS_ROLES on TM_USER.ID_ROLE = MS_ROLES.ID_ROLE"
                                +" join PROFILE_PIC on PROFILE_PIC.USER_ID_PIC = TM_USER.ID"
                                + " where TM_USER.username = ?");
                             
			ps.setString(1, lg.l_username);
			
                       
			ResultSet rs = ps.executeQuery();

			
                          if(rs.next())
                          {
                          lg.l_name =rs.getString("NAME");
                          lg.l_surname=rs.getString("SURNAME");
                          lg.l_username=rs.getString("USERNAME");
                          lg.l_email=rs.getString("EMAIL");
                          lg.l_role=rs.getString("R_NAME");
                          lg.profile_pic=rs.getString("PIC_NAME");
                          }
                       
		} catch (SQLException ex) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error "+ex.getMessage()));
  
			
		} finally {
			DatabaseConnection.close(con); 
		}
 
     }

}
