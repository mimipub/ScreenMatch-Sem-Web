package exercicio_contador;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tarefa.Avaliacao;
import tarefa.Tarefa;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class ContadorApplication implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Digite um numero: ");
		int numero = sc.nextInt();

		for (int i = 1; i <= numero; i++) {
			System.out.print(i +  " ");
		}

		Tarefa tarefa = new Tarefa( "qualquer", true, "descricao");
		ObjectMapper mapper = new ObjectMapper();

		// serialização.
		var json= mapper.writeValueAsString(tarefa);
		System.out.println(json);

		mapper.writeValue(new File("tarefa.json"),tarefa);
		Tarefa tarefa1 = mapper.readValue(new File("tarefa.json"),Tarefa.class);

		System.out.println(tarefa1);



		Avaliacao<Object> avaliacao = new Avaliacao<>("Notebook", 2, "produto excelente");
		System.out.println(avaliacao);

		avaliacao.calculoMedia();

		sc.close();
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ContadorApplication.class, args);

	}

}
