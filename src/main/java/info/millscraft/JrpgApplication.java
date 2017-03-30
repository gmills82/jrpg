package info.millscraft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JrpgApplication {

	private static final Logger log = LoggerFactory.getLogger(JrpgApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JrpgApplication.class, args);
	}
}
