package src.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import src.model.Permissions;

public class MainController {
    InputController inputController = new InputController();
    FileController fileController = new FileController();
    SearchController searchController = new SearchController();
    HashMap<String, List<Permissions>> searchResult = new HashMap<>();
    Scanner fileData;

    public void loadData(String input) throws Exception{
        try {
            this.fileData = fileController.initialization(input);
        } catch (Exception ex) {
            System.err.println("Falha ao carregar o arquivo: " + ex.getMessage());
        }
    }

    public Scanner getData(){
       return inputController.prepareData(fileData);
    }

	public List<String> searchUser(String email) {
        searchResult = searchController.searchUser(email);        
        return OutputController.formatResult(searchResult);
    }
    
    
}
