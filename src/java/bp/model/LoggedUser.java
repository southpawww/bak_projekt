
package bp.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author marek
 */
@ManagedBean(name="loggeduser")
@SessionScoped
public class LoggedUser {
    
    public String l_name;
    public String l_surname;
    public String l_username;
    public String l_email;
    public String l_role;
    public String profile_pic;

    /**
     * @return the l_name
     */
    public String getL_name() {
        return l_name;
    }

    /**
     * @param l_name the l_name to set
     */
    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    /**
     * @return the l_surname
     */
    public String getL_surname() {
        return l_surname;
    }

    /**
     * @param l_surname the l_surname to set
     */
    public void setL_surname(String l_surname) {
        this.l_surname = l_surname;
    }

    /**
     * @return the l_username
     */
    public String getL_username() {
        return l_username;
    }

    /**
     * @param l_username the l_username to set
     */
    public void setL_username(String l_username) {
        this.l_username = l_username;
    }

    /**
     * @return the l_email
     */
    public String getL_email() {
        return l_email;
    }

    /**
     * @param l_email the l_email to set
     */
    public void setL_email(String l_email) {
        this.l_email = l_email;
    }

    /**
     * @return the l_role
     */
    public String getL_role() {
        return l_role;
    }

    /**
     * @param l_role the l_role to set
     */
    public void setL_role(String l_role) {
        this.l_role = l_role;
    }

    /**
     * @return the profile_pic
     */
    public String getProfile_pic() {
        return profile_pic;
    }

    /**
     * @param profile_pic the profile_pic to set
     */
    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }
    
  
    
    
    
    
}
