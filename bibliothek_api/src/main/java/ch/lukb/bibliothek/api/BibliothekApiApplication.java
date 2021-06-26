package ch.lukb.bibliothek.api;

import ch.lukb.bibliothek.api.misc.InitialLoad;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliothekApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliothekApiApplication.class, args);
	}

}
