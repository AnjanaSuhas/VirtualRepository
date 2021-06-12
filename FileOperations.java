package solution;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class FileOperations {
	
	public static void listFilesAsc()
	{
		//Function to return the file names in ascending order
		System.out.println("Listing files in ascending order\n");
		File file = new File(Driver.root);
		File[] files = file.listFiles();
		Arrays.sort(files);
		for(File eachFile : files) {
			if(eachFile.isDirectory()) {
				File[] folderFiles = eachFile.listFiles();
				for(File fl : folderFiles) {
					System.out.println(fl.getName());
				}
			} 
			else 
				System.out.println(eachFile.getName());
		}
		System.out.println("No. of Files : " + files.length);
	}
	
	public static void addFiles() throws IOException
	{
		//Function to add files
		System.out.println("Enter file name to be created:");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		File file = new File(Driver.root, name);
		try {
			boolean createFile = file.createNewFile();
			if(createFile) System.out.println("File Created");
			else  System.out.println("File already exists");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public static void deleteFiles() throws IOException
	{
		//Function to delete files
		System.out.println("Enter file name to be deleted:");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		String fname = Driver.root +"\\"+ name;
		Path path = Paths.get(fname);
		try{
			Files.delete(path);
			System.out.println("File Deleted");
		}
		 catch (NoSuchFileException e) {
			// TODO Auto-generated catch block
			 System.out.println("File does not exist");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void searchFiles() throws IOException
	{
		//Function to Search a user specified file
		System.out.println("Enter file name to be searched:");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		String fname = Driver.root +"\\"+ name;
		File file = new File(fname);
		
		if(file.exists())
		{
			System.out.println("File exists");
		    System.out.println("File name: " + file.getName());
	        System.out.println("Absolute path: " + file.getAbsolutePath());
	        System.out.println("Writeable: " + file.canWrite());
	        System.out.println("Readable " + file.canRead());
	        System.out.println("File size in bytes " + file.length());
		}
		
		else
			System.out.println("File does not exist");
	}
}
