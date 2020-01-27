package src.model;

// import src.model.enums.String;

public class UserPermissions {
    String userType;
    String idCondominio;

    public UserPermissions(String userType, String idCondominio) {
        this.userType = userType;
        this.idCondominio = idCondominio; 
    }

	public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(String idCondominio) {
        this.idCondominio = idCondominio;
    }

    
    
}