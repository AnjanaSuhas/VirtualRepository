package solution;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
	
    public static void mainMenu() throws IOException 
    {
		//Main menu user interface
		System.out.println("\nUser Interaction Options:\n");
		System.out.println("1.List the File Names");
		System.out.println("2.Other File Options");
		System.out.println("3.Exit");
		System.out.println("Enter Option(1/2/3):");
		Scanner sc = new Scanner(System.in);
		int opt = sc.nextInt();
		switch(opt) {
		
		case 1: 
			FileOperations.listFilesAsc(); mainMenu(); break;
		case 2: 
			UserInterface.fileOperationsMenu(); break;
		case 3: 
			System.out.println("Closing the application"); break;
		default: 
			System.out.println("Invalid option selected"); mainMenu(); break;
		   
	}
	}
	
	
	
	public static void fileOperationsMenu() throws IOException
	{
		//Business level File operations menu
		System.out.println("\nFile Handling Options:\n");
		System.out.println("1.Add a File");
		System.out.println("2.Delete a File");
		System.out.println("3.Search a File");
		System.out.println("4.Go to Main Menu");
		Scanner sc = new Scanner(System.in);
		int opt = sc.nextInt();
		switch(opt) {
		case 1: 
			FileOperations.addFiles(); fileOperationsMenu(); break;
		case 2: 
			FileOperations.deleteFiles(); fileOperationsMenu(); break;
		case 3: 
			FileOperations.searchFiles(); fileOperationsMenu(); break;
		case 4: 
			mainMenu(); break;
		default: 
			System.out.println("Invalid option selected"); fileOperationsMenu(); break;
	}
	}

}
