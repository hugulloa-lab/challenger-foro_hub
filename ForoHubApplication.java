package com.hugoulloa.foro_hub;

import com.hugoulloa.foro_hub.model.Usuario;
import com.hugoulloa.foro_hub.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ForoHubApplication {

    @Bean
    CommandLineRunner init(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {
            if (usuarioRepository.findByEmail("hugo@mail.com").isEmpty()) {
                Usuario u = new Usuario();
                u.setEmail("hugo@mail.com");
                u.setNombre("Hugo");
                u.setPassword(passwordEncoder.encode("1234"));

                usuarioRepository.save(u);
                System.out.println("✅ Usuario creado correctamente");
            }
        };
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ForoHubApplication.class, args);
    }
}