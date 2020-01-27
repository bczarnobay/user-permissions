package src.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class FileController {
	private Scanner fileData;

	public Scanner initialization(String input){
		if(input.equals("")){
           fileData = loadPreStoredData();
        }else{
			fileData = loadDataFromPath(input);
		}

		return fileData;
	};

	private Scanner loadDataFromPath(String input) {
		return loadData(input);
	}

	private Scanner loadPreStoredData() {
		try {
			return loadData("resources\\preloaddb.txt");
		}catch (Exception e) {
			try {
				return loadData("user-permissions\\resources\\preloaddb.txt");
			} catch(Exception ex){
				System.err.println("Falha ao carregar o arquivo: " + ex.getMessage());
			}
		}
		return null;
	}

	private Scanner loadData(String input){
		try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(input)));
            return scanner;
        } catch (IOException e) {
            System.err.println("Falha ao carregar o arquivo: " + e.getMessage());
        }
        return null;
	}

	
}
