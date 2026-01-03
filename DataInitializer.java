package com.hugoulloa.foro_hub.config;


import com.hugoulloa.foro_hub.model.Usuario;
import com.hugoulloa.foro_hub.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {

            if (usuarioRepository.findByEmail("nuevo@mail.com").isEmpty()) {

                Usuario usuario = new Usuario();
                usuario.setEmail("nuevo@mail.com");
                usuario.setNombre("Usuario JWT");
                usuario.setPassword(passwordEncoder.encode("1234"));

                usuarioRepository.save(usuario);

                System.out.println("✅ Usuario creado: nuevo@mail.com / 1234");
            }
        };
    }
}
