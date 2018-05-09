package com;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class FileCompare {
	public static void main(String[] args) throws IOException {
		listFiles("C:\\Users\\Toshiba-PC\\Desktop\\TASK 2\\TASK_2");
		createFileUsingFileClass();
	}

	private static void createFileUsingFileClass() throws IOException {
		File file = new File("C:\\Users\\Toshiba-PC\\Desktop\\TASK 2\\TASK_2\\testFile4.txt");

		// Create the file
		if (file.createNewFile()) {
			System.out.println("File is created!");
		} else {
			System.out.println("File already exists.");
		}

		// Write Content
		FileWriter writer = new FileWriter(file);
		writer.write("File creation in java");
		writer.close();
		if (!Desktop.isDesktopSupported()) {
			System.out.println("Desktop is not supported");
			return;
		}

		Desktop desktop = Desktop.getDesktop();
		if (file.exists()) {
			desktop.open(file);
			String nodeValue = "i am neethu";
			BufferedWriter wtr = new BufferedWriter(new OutputStreamWriter(System.out));

			String[] words = nodeValue.split(" ");
			for (String word : words) {
				wtr.write(word);
				wtr.newLine();
			}
			wtr.close();
		}
	}

	public static void listFiles(String File_2) {
		File directory = new File(File_2);
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isFile()) {
				System.out.println(file.getName());
			}
		}

		PrintWriter pw = null;
		try {

			File file = new File("C:\\Users\\Toshiba-PC\\Desktop\\TASK 2\\TASK_2\\testFile4.txt");
			FileWriter fw = new FileWriter(file, true);
			pw = new PrintWriter(fw);
			pw.println("Fubars rule!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}

	}
}
