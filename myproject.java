package lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class myproject {
	static final String errormessage = "error";
	static Scanner scanner = new Scanner(System.in);
	final static String FOLDER = "C:\\Users\\Admin\\eclipse\\java-2021-12\\lockedme\\";

	public static void main(String[] args) {
		  welcomeScreen();
	        menupage();
	}

	public static void welcomeScreen() {
		System.out.println("=======================================");
		System.out.println("Welcome to LockedMe");
		System.out.println("Developer: Subramani T");
		System.out.println("========================================");
	}

	public static void menupage() {
		System.out.println("please select your choice ?");
		System.out.printf("1. view files" + "%n" + "2. Business operation " + "%n" + "3. Exit Application" + "%n");
		String mainMenuSelection = scanner.nextLine();

		switch (mainMenuSelection) {
		case "1":
			showFiles();
			break;
		case "2":
			operationsMenu();
			break;
		case "3":
			System.out.println("Thanks for using LockedMe");
			System.exit(0);
		default:
			System.out.println("Invalid selection, please try again");
			menupage();
			break;
		}

	}

	public static void operationsMenu() {
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*" + "\n" + "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*" + "\n" + "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*" );
		System.out.printf("1. Add a file" + "%n" + "2. Delete a file" + "%n" + "3. Search for a file" + "%n"
				+ "4. Return to main menu" + "%n");
		String operationsSelection = scanner.nextLine();
		switch (operationsSelection) {
		case "1":
			addFile();
			break;
		case "2":
			System.out.println("Please enter file name");
			deleteFile();
			break;
		case "3":
			System.out.println("Please enter file name");
			searchFiles();
			break;
		case "4":
			menupage();
			break;
		default:
			System.out.println("Invalid selection, please try again");
			operationsMenu();
			break;
		}

	}

	public static Set<String> getFiles() {
		File[] files = new File(FOLDER).listFiles();

		Set<String> sorted = new TreeSet<>();

		for (File file : files) {
			sorted.add(file.getName());
		}
		return (sorted);
	}

	public static void showFiles() {
		System.out.println("Showing files in ascending order:");
		getFiles().forEach(System.out::println);
		System.out.println("------------------");
		menupage();
	}

	public static void addFile() {
			
		try {

			
			String filename;
			System.out.println("Enter File Name");
			filename = scanner.nextLine();

			int linesCount;
			System.out.println("Enter how many line int file: ");
			linesCount = Integer.parseInt(scanner.nextLine());

			FileWriter myWriter = new FileWriter(FOLDER + "\\" + filename);

			for (int i = 1; i <= linesCount; i++) {
				System.out.println("Enter The File Line ");
				myWriter.write(scanner.nextLine());

			}

			System.out.println("file created successfully");
			myWriter.close();

		} catch (Exception ex) {

			System.out.println(errormessage);
		}
				operationsMenu();

	}

	public static void deleteFile() {
	
		try {
			String fileName;
			fileName = scanner.nextLine();
			System.out.println("Enter file name");
		
			File f = new File(FOLDER + "\\" + fileName); // file to be delete
			if (f.delete()) // returns Boolean value
			{
				System.out.println(f.getName() + " deleted"); // getting and printing the file name
			} else {
				System.out.println("file is not found for deleting");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		operationsMenu();
	}

	public static void  searchFiles() {
		Scanner obj = new Scanner(System.in);

		try {
			String fileName;
			System.out.println("========search file==============");
			fileName = obj.nextLine();

			File folder = new File(FOLDER);
			File[] listofFiles = folder.listFiles();

			LinkedList<String>filenames = new LinkedList<String>();
			
			
			for (File f : listofFiles) {
				
			}
			
			
			
			for (File  l : listofFiles)
				filenames.add(l.getName());

			if (filenames.contains(fileName)) {
				System.out.println("file is found");

			} else {
				System.out.println("file is not found");

			}

		} catch (Exception ex) {
			System.out.println(errormessage);
		}

	}	

}
