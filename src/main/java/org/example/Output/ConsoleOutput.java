package org.example.Output;
import java.util.*;

public class ConsoleOutput implements OutputData{
	public void output(List<String> lines) {
		System.out.println("Отсортированный список:");

  	for (String line : lines) {
    	System.out.println(line);
    }
	}
}
