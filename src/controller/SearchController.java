package src.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.HashMap;

import src.model.*;

public class SearchController {
    private UserController userController = UserController.getInstance();
    private GroupsController groupsController = GroupsController.getInstance();
    private HashMap<String, List<Permissions>> userTypePermissions = new HashMap<>();

    public HashMap<String, List<Permissions>> searchUser(String email) {
        User userFound = userController.getUserListHash().get(email);
        
        if(userFound != null){
            searchUserPermission(userFound);
        }
        
        return this.userTypePermissions;
    }

    private void searchUserPermission(User user) {
        user.getUserPermissions().forEach(permission -> searchPermission(permission));
    }

    private Object searchPermission(UserPermissions permission) {
        List<GroupType> groups = groupsController.getGroupsHash().get(permission.getIdCondominio());

        List<GroupType> dbGroups = groups.stream().filter(group -> group.getUserType().equals(permission.getUserType()))
                .collect(Collectors.toList());

        if (this.userTypePermissions.containsKey(permission.getIdCondominio())) {
            this.userTypePermissions.put(permission.getIdCondominio(),
                    evaluatePermissions(userTypePermissions.get(permission.getIdCondominio()), dbGroups));
        } else {
            this.userTypePermissions.put(permission.getIdCondominio(), dbGroups.remove(0).getPermissions());
        }
        return groups;
    }

    private List<Permissions> evaluatePermissions(List<Permissions> userPermissions,
            List<GroupType> permissionsToBeInserted) {
        List<Permissions> newPermissions = new ArrayList<>();
        List<Permissions> permissionsToCompare = permissionsToBeInserted.remove(0).getPermissions();

        newPermissions.add(comparePermissions(userPermissions, permissionsToCompare, "Usuarios"));
        newPermissions.add(comparePermissions(userPermissions, permissionsToCompare, "Entregas"));
        newPermissions.add(comparePermissions(userPermissions, permissionsToCompare, "Reservas"));

        return newPermissions;
    }

    private Permissions comparePermissions(List<Permissions> userPermissions, List<Permissions> permissionsToCompare,
            String function) {
        Permissions toBeUpdated = new Permissions();
        toBeUpdated.setFunction(function);

        List<Permissions> singlePermission = userPermissions.stream()
                .filter(permisione -> permisione.getFunction().equals(function)).collect(Collectors.toList());

        String permissionLevelExistent = singlePermission.remove(0).getLevel();

        List<Permissions> singlePermissionToBeCompared = permissionsToCompare.stream()
                .filter(permisione -> permisione.getFunction().equals(function)).collect(Collectors.toList());

        String permissionLevelToBeCompared = singlePermissionToBeCompared.remove(0).getLevel();

        if (permissionLevelExistent.equals(permissionLevelToBeCompared)) {
            toBeUpdated.setLevel(permissionLevelExistent);
        } else if (permissionLevelExistent.equals("Escrita")) {
            toBeUpdated.setLevel(permissionLevelExistent);
        } else if (permissionLevelToBeCompared.equals("Escrita")) {
            toBeUpdated.setLevel("Escrita");
        } else if (permissionLevelExistent.equals("Nenhum") && permissionLevelToBeCompared.equals("Leitura")) {
            toBeUpdated.setLevel("Leitura");
        }
        return toBeUpdated;

    }
}