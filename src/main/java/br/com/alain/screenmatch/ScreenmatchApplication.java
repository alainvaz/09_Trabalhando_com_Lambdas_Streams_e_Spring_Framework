package br.com.alain.screenmatch;

// mvnrepository.com > buscar dependencias necessárias
import br.com.alain.screenmatch.model.DadosSerie;
import br.com.alain.screenmatch.service.ConsumoApi;
import br.com.alain.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		var key = "bdb1b12c";
		var endereco = "https://www.omdbapi.com/?t=gilmore+girls&apikey=" + key;

		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados(endereco);

		/* apenas para testes, pode apagar no futuro se quiser...*/
		ExibicaoDeTestes(json, consumoApi);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

		System.out.println("*********************************************");
		System.out.println("Dados: " + dados);

	}

	private static void ExibicaoDeTestes(String json, ConsumoApi consumoApi) {
		System.out.println(json);
		var json2 = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json2);
	}
}
