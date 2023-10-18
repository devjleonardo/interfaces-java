package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Funcionario;

public class Program {
	
	public static void main(String[] args) {
		List<Funcionario> funcionarios = new ArrayList<>();
		String path = "C:\\temp\\funcionarios.csv";
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			String funcionarioCsv = bufferedReader.readLine();
			
			while (funcionarioCsv != null) {
				String[] campos = funcionarioCsv.split(",");
				
				funcionarios.add(new Funcionario(campos[0], Double.parseDouble(campos[1])));
				
				funcionarioCsv = bufferedReader.readLine();
			}
			
			Collections.sort(funcionarios);
			
			for (Funcionario funcionario : funcionarios) {
				System.out.println(funcionario.getNome() + ", " + String.format("%.2f", funcionario.getSalario()));
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
}