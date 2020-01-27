package src.model;

// import src.model.enums.UserTypes;
import src.model.Permissions;

import java.util.ArrayList;
import java.util.List;


public class GroupType {
    private String userType; 
    private String idCondominio;
    private List<Permissions> permissions = new ArrayList<>();

    public GroupType(String userType, String idCondominio, List<Permissions> permissions) {
        this.userType = userType;
        this.idCondominio = idCondominio;
        this.permissions = permissions;
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

    public List<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permissions> permissions) {
        this.permissions = permissions;
    }
}