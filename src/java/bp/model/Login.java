package bp.model;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class Login{

        public static String page;
	public String pwd;
	public String user;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

    /**
     * @param aPage the page to set
     */
    public static void setPage(String aPage) {
        page = aPage;
    }

    /**
     * @return the page
     */
    public static String getPage() {
        return page;
    }
        
        
   
		
	
}
