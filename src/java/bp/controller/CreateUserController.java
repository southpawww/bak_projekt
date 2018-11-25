
package bp.controller;
import bp.model.CreateUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author marek
 */
@ManagedBean(name = "createusercontroller")
@RequestScoped
public class CreateUserController {
    
    @ManagedProperty("#{createuser}")
    private CreateUser createuser;
    private Map<String,String> roles =new HashMap<String,String>();
    
    //init. combobox for user roles in create form
    @PostConstruct
    public void init(){
    Connection con =null;
    PreparedStatement ps;
    try{
    con = DatabaseConnection.getConnection();
    ps= con.prepareStatement("Select R_NAME, ID_ROLE FROM MS_ROLES");
    ResultSet rs = ps.executeQuery();
    while(rs.next())
    {
     String role_value =Integer.toString(rs.getInt("ID_ROLE"));
     
                getRoles().put(rs.getString("R_NAME"),role_value);
  
    }
    }
    catch(SQLException ex) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getMessage()));
   
    }finally {
			DatabaseConnection.close(con); 
	     }
  
    }
     
    // connect to database and create new user
    public void register() {
    Connection con = null;
    PreparedStatement ps;
    
    
    boolean vEmail= ValidateInput.validateEmail(createuser.u_email);
    boolean vUsername = ValidateInput.validateUsername(createuser.u_username);
    if(vUsername && vEmail){
    try {
    con = DatabaseConnection.getConnection();
    String insert_query="INSERT INTO TM_USER(Name,Surname,Username,Email,Password,Id_role) VALUES(?,?,?,?,?,?)";
    ps =con.prepareStatement(insert_query);
    ps.setString(1, createuser.u_name);
    ps.setString(2, createuser.u_surname);
    ps.setString(3, createuser.u_username);
    ps.setString(4, createuser.u_email);
    ps.setString(5, createuser.u_password);
    createuser.u_ro = Integer.parseInt(createuser.u_role);
    ps.setInt(6,createuser.u_ro);
    
    ps.executeUpdate();
  
   
     setDefaultProfPict(createuser,con);
     resetUserField(createuser);
     
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Account has been created"));
    
     
    } catch (SQLException ex) {
	
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getMessage()));
			
    } finally {
			DatabaseConnection.close(con); 
		}
   }
   
   }
  //clean fields 
public  void resetUserField(CreateUser user){
    user.u_name=null;
    user.u_surname=null;
    user.u_username=null;
    user.u_email=null;
    user.u_role=null;
    user.u_password=null;
 }

//this is only test, final logic will be changed.
public void setDefaultProfPict(CreateUser cu,Connection con){
   PreparedStatement ps1;
   PreparedStatement pss;
   ResultSet rss;
   try{ 
   pss= con.prepareStatement("Select ID FROM TM_USER where USERNAME = ?");
    pss.setString(1, createuser.u_username);
    rss=pss.executeQuery(); 
     if (rss.next())
     {
            
      int id =rss.getInt("ID");
      ps1= con.prepareStatement("INSERT INTO PROFILE_PIC(PIC_NAME, USER_ID_PIC) VALUES(?,?)");
      ps1.setString(1, "defaultprof.png");
      ps1.setInt(2, id);
      ps1.executeUpdate();
     
     }
   }catch(SQLException ex){
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getMessage())); 
   }
 }


    /**
     * @param user the user to set
     */
    public void setUser(CreateUser user) {
        this.setCreateuser(user);
    }

    /**
     * @return the roles
     */
    public Map<String,String> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Map<String,String> roles) {
        this.roles = roles;
    }

    /**
     * @param createuser the createuser to set
     */
    public void setCreateuser(CreateUser createuser) {
        this.createuser = createuser;
    }
     
 
}
