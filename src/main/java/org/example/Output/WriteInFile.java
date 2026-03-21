package org.example.Output;
import java.util.*;
import java.io.*;

public class WriteInFile implements OutputData{
	public void output(List<String> lines) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/org/example/Data/output.txt", true))) {
			for (String line : lines) {
  	    writer.write(line);
  	    writer.newLine();
  	  }
  	
  	  System.out.println("Файл успешно записан");
		} catch (IOException e) {
		  System.out.println("Ошибка записи в файл");
		}
	}
}
