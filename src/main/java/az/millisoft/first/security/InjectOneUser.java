package az.millisoft.first.security;

import az.millisoft.first.entity.Role;
import az.millisoft.first.entity.User;
import az.millisoft.first.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InjectOneUser {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Bean
    public void injectUser(){
        User user = new User();
        user.setId(1111);
        user.setRole(Role.ADMIN);
        user.setEmail("ugurkarimli1@gmail.com");
        user.setPassword(passwordEncoder.encode("ugur2003"));

        userRepository.save(user);
    }

}
