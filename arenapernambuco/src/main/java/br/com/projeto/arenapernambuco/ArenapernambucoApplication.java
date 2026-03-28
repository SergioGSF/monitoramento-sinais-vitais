package br.com.projeto.arenapernambuco;

<<<<<<< HEAD
<<<<<<< HEAD
import br.com.projeto.arenapernambuco.model.User;
import br.com.projeto.arenapernambuco.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
=======
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
>>>>>>> 021efe57436934dc59377bea1290920604152e63

@SpringBootApplication
public class ArenapernambucoApplication {

<<<<<<< HEAD
    public static void main(String[] args) {
        SpringApplication.run(ArenapernambucoApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.count() == 0) {
                User admin = new User();
                admin.setName("Admin Arena");
                admin.setEmail("admin@arenapernambuco.com");
                
                admin.setPassword(passwordEncoder.encode("admin123"));
                
                admin.setRole(User.Role.admin);
                
                userRepository.save(admin);
                
                System.out.println("--------------------------------------");
                System.out.println("Usuário ADMIN criado com sucesso!");
                System.out.println("Login: admin@arenapernambuco.com");
                System.out.println("Senha: admin123");
                System.out.println("--------------------------------------");
            }
        };
    }
}
=======
	public static void main(String[] args) {
		SpringApplication.run(ArenapernambucoApplication.class, args);
	}


}
>>>>>>> 021efe57436934dc59377bea1290920604152e63
=======
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArenapernambucoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArenapernambucoApplication.class, args);
    }
}
>>>>>>> 2dca80b (Cadastro)
