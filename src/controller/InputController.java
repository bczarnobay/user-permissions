package src.controller;

import java.util.Scanner;
import src.model.Permissions;
import src.model.UserPermissions;

import java.util.ArrayList;
import java.util.List;

public class InputController{    
	private UserController userController = UserController.getInstance();
    private GroupsController groupsController = GroupsController.getInstance();
    
	public Scanner prepareData(Scanner fileData){
		fileData.useDelimiter("\\;|\\n");
	
		while (fileData.hasNext()) {
			String tipo = fileData.next();

			if(tipo.equals("Usuario")){
				String email = fileData.next();
				String permissions = fileData.next();

				userController.createUser(email, prepareUserPermissions(permissions));
			}
			else if(tipo.equals("Grupo")){
				String userType = fileData.next();
				String idCondominio = fileData.next();
				String permissionLevel = fileData.next();

				groupsController.createGroup(userType, idCondominio, preparePermissionLevel(permissionLevel));
			}
		}
		return fileData;
	}

	private List<UserPermissions> prepareUserPermissions(String permission) {
		List<UserPermissions> list = new ArrayList<>();

		Scanner newPermissions = new Scanner(removeExtraCharacters(permission));
		newPermissions.useDelimiter("\\)\\,\\(");

		while(newPermissions.hasNext()){
			list.add(parseUserPermissions(newPermissions.next()));
		}
		
		newPermissions.close();
		return list;
	}

	private List<Permissions> preparePermissionLevel(String permissions){
		List<Permissions> list = new ArrayList<>();
		
		Scanner newPermissions = new Scanner(removeExtraCharacters(permissions));
		newPermissions.useDelimiter("\\)\\,\\(");

		while(newPermissions.hasNext()){
			list.add(parsePermissions(newPermissions.next()));
		}

		newPermissions.close();
		return list;
	}
	
	private String removeExtraCharacters(String input){		
		String str = input.replaceAll("\\[\\(", "");
		str = str.replaceAll("\\)\\]\\r", "");				
		str = str.replaceAll("\\)\\]", "");			
		return str;
	}

	private UserPermissions parseUserPermissions(String singlePermission){
		String[] permission = singlePermission.split(",");
		return new UserPermissions(permission[0], permission[1]);		
	}

	private Permissions parsePermissions(String permissions) {
		String[] groupPermissions = permissions.split(",");		
		return new Permissions(groupPermissions[0], groupPermissions[1]);
	}


}