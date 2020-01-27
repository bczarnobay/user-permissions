package src.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import src.model.*;

public class GroupsController {
    static GroupsController instance;
    List<GroupType> groups = new ArrayList<>();

    HashMap<String, List<GroupType>> groupsHash = new HashMap<>();

    public void createGroup(String userType, String idCondominio, List<Permissions> permissionsLevel){
        List<GroupType> auxGroup = 
         !this.groupsHash.isEmpty() ?
                this.groupsHash.containsKey(idCondominio) ? 
                this.groupsHash.get(idCondominio):
                new ArrayList<>() : new ArrayList<>();

        auxGroup.add(new GroupType(userType, idCondominio, permissionsLevel));
        this.groupsHash.put(idCondominio, auxGroup);             
    }
    
    public List<GroupType> getGroups(){
        return this.groups;
    }

    public HashMap<String, List<GroupType>> getGroupsHash(){
        return this.groupsHash;
    }

	public static GroupsController getInstance() {
		if(instance == null){
            instance = new GroupsController();
        }
        return instance;
	}

}
