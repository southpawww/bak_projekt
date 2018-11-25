
package bp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;

/**
 *
 * @author marek
 */
@ManagedBean(name = "validateinput")
@RequestScoped
public class ValidateInput {

private static String v_email;
private static String v_username;
private String val_mail=v_email;
 
//not complete yet
public static boolean validateEmail(String input_email){
       if(input_email.contains("@"))
           return true;
       else
       {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid email adress!"));
           return false;   
       }
    }
    
public static boolean validateUsername(String input_username){
         Connection con=null;
         PreparedStatement ps;
         try{
         con =DatabaseConnection.getConnection();
         ps = con.prepareStatement("Select USERNAME from TM_USER where USERNAME = ?");
         ps.setString(1, input_username);
         ResultSet rs = ps.executeQuery();
         if(rs.next())
         {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username already exist!"));
          return false;
         }
         
         }
         catch(SQLException ex){
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error "+ex.getMessage()));
         }
         finally{
             DatabaseConnection.close(con);
        
         }
         return true;
}

    /**
     * @return the v_email
     */
    public static String getV_email() {
        return v_email;
    }

    /**
     * @param aV_email the v_email to set
     */
    public static void setV_email(String aV_email) {
        v_email = aV_email;
    }

    /**
     * @return the v_username
     */
    public static String getV_username() {
        return v_username;
    }

    /**
     * @param aV_username the v_username to set
     */
    public static void setV_username(String aV_username) {
        v_username = aV_username;
    }

    /**
     * @return the val_mail
     */
    public String getVal_mail() {
        return val_mail;
    }

    /**
     * @param val_mail the val_mail to set
     */
    public void setVal_mail(String val_mail) {
        this.val_mail = val_mail;
    }
}
