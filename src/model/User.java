package src.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private List<UserPermissions> permissions = new ArrayList<>();

    public User(String email, List<UserPermissions> permissions) {
        this.email = email;
        this.permissions = permissions;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserPermissions> getUserPermissions() {
        return permissions;
    }

    public void setUserPermissions(List<UserPermissions> permissions) {
        this.permissions = permissions;
    }
}