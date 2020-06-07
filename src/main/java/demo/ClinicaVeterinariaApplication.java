package demo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import demo.domain.Animal;
import demo.domain.Cliente;
import demo.domain.Consulta;
import demo.domain.Especie;
import demo.domain.Veterinario;
import demo.domain.enums.TipoSexo;
import demo.repository.AnimalRepository;
import demo.repository.ClienteRepository;
import demo.repository.ConsultaRepository;
import demo.repository.EspecieRepository;
import demo.repository.VeterinarioRepository;

@SpringBootApplication
public class ClinicaVeterinariaApplication implements CommandLineRunner {
	SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	@Autowired
	EspecieRepository especieRepository;
	
	@Autowired
	AnimalRepository animalRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	VeterinarioRepository veterinarioRepository;
	
	@Autowired
	ConsultaRepository consultaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ClinicaVeterinariaApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception{
		Especie esp1 = new Especie(null, "Felino");
		Especie esp2 = new Especie(null, "Canis");
		this.especieRepository.saveAll(Arrays.asList(esp1, esp2));
		
		Cliente cliente1 = new Cliente(null, "Jucíleudo Arantes", "Rua 13 de maio, bela vista, 51", "3482-5677", "juju@gmail.com");
		Cliente cliente2 = new Cliente(null, "Carmelita Donca", "Av. General Sampaio", "3252-1258", "kaka@gmail.com");
		this.clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));
		
		Animal a1 = new Animal(null, "felix", 3, TipoSexo.MACHO, esp1, cliente1);
		Animal a2 = new Animal(null, "Tico", 2, TipoSexo.FÊMEA, esp1, cliente1);
		Animal a3 = new Animal(null, "Cicarelle", 5, TipoSexo.FÊMEA, esp2, cliente2);
		Animal a4 = new Animal(null, "Junior", 3, TipoSexo.MACHO, esp2, cliente2);
		this.animalRepository.saveAll(Arrays.asList(a1, a3, a2, a4));
		
		Veterinario v1 = new Veterinario(null, "Flávio Pinto", "12365654-45");
		Veterinario v2 = new Veterinario(null, "Michel Temer", "9876543-33");
		Veterinario v3 = new Veterinario(null, "Juciel Filho", "3434999-21");
		this.veterinarioRepository.saveAll(Arrays.asList(v1, v2, v3));
		
		Consulta con1 = new Consulta(null,data.parse("05/05/2020 13:45"), "Av Rui Barbosa, 100, Aldeota", "exame urina", a1, v1);
		Consulta con2 = new Consulta(null,data.parse("05/12/2019 10:45"), "Av Rui Barbosa, 100, Aldeota", "raio x torax", a2, v2);
		Consulta con3 = new Consulta(null,data.parse("25/05/2020 09:45"), "Av Rui Barbosa, 100, Aldeota", "Vacina Gripe", a3, v2);
		Consulta con4 = new Consulta(null,data.parse("05/11/2018 14:45"), "Av Rui Barbosa, 100, Aldeota", "cirurgia rabo", a4, v3);
		this.consultaRepository.saveAll(Arrays.asList(con1, con2, con3, con4));
	}

}