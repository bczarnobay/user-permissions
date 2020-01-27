package src.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import src.model.*;

public class UserController {

    static UserController instance;
    List<User> users = new ArrayList<>();
    HashMap<String, User> usersHash = new HashMap<>();

	public void createUser(String email, List<UserPermissions> permissions) {
        this.usersHash.put(email,new User(email, permissions));
        this.users.add(new User(email, permissions));
    }
    
    public List<User> getUserList(){
        return this.users;
    }

    public HashMap<String, User> getUserListHash(){
        return this.usersHash;
    }

	public static UserController getInstance() {
        if(instance == null){
            instance = new UserController();            
        }
		return instance;
    }
}
