package bp.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



/**
 *
 * @author marek
 */
@ManagedBean(name = "createuser")
@RequestScoped
public class CreateUser {

   
    
    public String u_name;
    public String u_surname;
    public String u_username;
    public String u_email;
    public String u_role;
    public String u_password;
    public int u_ro;

    /**
     * @return the u_name
     */
    public String getU_name() {
        return u_name;
    }

    /**
     * @param u_name the u_name to set
     */
    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    /**
     * @return the u_surname
     */
    public String getU_surname() {
        return u_surname;
    }

    /**
     * @param u_surname the u_surname to set
     */
    public void setU_surname(String u_surname) {
        this.u_surname = u_surname;
    }

    /**
     * @return the u_username
     */
    public String getU_username() {
        return u_username;
    }

    /**
     * @param u_username the u_username to set
     */
    public void setU_username(String u_username) {
        this.u_username = u_username;
    }

    /**
     * @return the u_email
     */
    public String getU_email() {
        return u_email;
    }

    /**
     * @param u_email the u_email to set
     */
    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    /**
     * @return the u_position
     */
    public String getU_role() {
        return u_role;
    }

    /**
     * @param u_position the u_position to set
     */
    public void setU_position(String u_position) {
        this.setU_role(u_position);
    }

    /**
     * @return the u_password
     */
    public String getU_password() {
        return u_password;
    }

    /**
     * @param u_password the u_password to set
     */
    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    /**
     * @param u_role the u_role to set
     */
    public void setU_role(String u_role) {
        this.u_role = u_role;
    }

     /**
     * @return the u_ro
     */
    public int getU_ro() {
        return u_ro;
    }

    /**
     * @param u_ro the u_ro to set
     */
    public void setU_ro(int u_ro) {
        this.u_ro = u_ro;
    }
    
}
