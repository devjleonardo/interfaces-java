package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
	
	public static void main(String[] args) {
		List<String> nomes = new ArrayList<>();
		String path = "C:\\temp\\in.txt";
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			String nome = bufferedReader.readLine();
			
			while (nome != null) {
				nomes.add(nome);
				nome = bufferedReader.readLine();
			}
			
			Collections.sort(nomes);
			
			for (String s : nomes) {
				System.out.println(s);
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
}