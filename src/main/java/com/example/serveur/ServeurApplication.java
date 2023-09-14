package com.example.serveur;

import com.example.serveur.entities.Server;
import com.example.serveur.enumeration.Status;
import com.example.serveur.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServeurApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServeurApplication.class, args);
	}


	@Bean
	CommandLineRunner run(ServerRepo serverRepo){
		return args -> {
			serverRepo.save(new Server(null , "192.169.32.12" , "Ubuntu linux", "16Gb" , "personnal PC" ,
					"http://localhost:9090/server/image/server1.png" , Status.SERVER_UP));

			serverRepo.save(new Server(null , "192.169.32.13" , "Windows", "32Gb" , "Server" ,
					"http://localhost:9090/server/image/server2.png" , Status.SERVER_UP));

			serverRepo.save(new Server(null , "192.169.32.40" , "Red HAT", "16Gb" , "personnal PC" ,
					"http://localhost:9090/server/image/server3.png" , Status.SERVER_DOWN));

			serverRepo.save(new Server(null , "192.169.32.50" , "Mac OS", "8Gb" , "personnal PC" ,
					"http://localhost:9090/server/image/server1.png" , Status.SERVER_UP));

		};
	}
}
