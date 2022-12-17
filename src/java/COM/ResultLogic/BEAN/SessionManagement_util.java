package COM.ResultLogic.BEAN;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class SessionManagement_util {
 
    public static HttpSession getSession(){   
        
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }///end of the method
    
   public static HttpServletRequest getRequest(){
               return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

   }//end of the method
    
    
}//end of the class
