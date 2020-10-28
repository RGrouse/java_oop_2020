/*
 * Разработать консольное приложение, позволяющее просматривать файлы и 
 * каталоги файловой системы, а также создавать и удалять текстовые файлы. 
 * Для работы с текстовыми файлами необходимо реализовать функциональность 
 * записи (дозаписи) в файл.
*/

package l6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Main {	
	public static void main(String[]args)
    {        
		Scanner scanner = new Scanner(System.in);
		File curDir = new File(".");
		File selectedFile = null;
		
		do {	
			File[] filesList = curDir.listFiles();
			
			switch (scanner.nextLine()) {
			case "..": {
				File parent = curDir.getParentFile();
				if (parent != null)
					curDir = parent;
				break;
			}
			case "ls": {
				System.out.println(curDir.getAbsolutePath());
				printFiles(filesList, selectedFile);
				break;
			}
			case "s": {
				System.out.print("File to select: ");
				String selectedFilename = scanner.nextLine();
				Optional<File> optional = Arrays.stream(filesList)
		                .filter(x -> x.getName().startsWith(selectedFilename))
		                .findFirst();
				selectedFile = optional.orElse(null);
				break;
			}
			case "cd": {
				if (selectedFile != null && selectedFile.isDirectory()) 
					curDir = selectedFile;
				else 
					System.out.println("Directory is not selected");
				break;
			}
			case "cat": {
				if (selectedFile != null && selectedFile.isFile()) {
					try(Scanner fin = new Scanner(selectedFile)) {
						while(fin.hasNextLine()) {
							System.out.println(fin.nextLine());
						}
					} catch (Exception e) {
						System.out.printf("Can't read file %s:\n", selectedFile.getName());
						e.printStackTrace();
					}
				} else {
					System.out.println("File is not selected");
				}
				break;
			}
			case "a": {
				if (selectedFile != null) {
					System.out.print("Your text: ");
					String text = scanner.nextLine();
					try {
					    Files.write(selectedFile.toPath(), text.getBytes(), StandardOpenOption.APPEND);
					} catch (IOException e) {
						System.out.printf("Can't append text to file %s:\n", selectedFile.getName());
						e.printStackTrace();
					}
				} else {
					System.out.println("File is not selected");
				}
				break;
			}
			case "q": {
				System.out.println("Bye");
				scanner.close();
				return;
			}
			default:
				System.out.println("Unknown command");
			}
		} while (true);
       
    }
	
    private static void printFiles(File[] files, File selectedFile) {
        for(File f : files){
        	if (f.equals(selectedFile))
        		System.out.print(">\t");
        	else 
        		System.out.print("\t");
        	
            if(f.isDirectory())
            	if(f.list().length == 0)
            		System.out.println("{ }\t"+ f.getName());
            	else
            		System.out.println("{*}\t"+ f.getName());
            if(f.isFile()){
                System.out.println("\t"+f.getName());
            }
        }

    }
    
}
