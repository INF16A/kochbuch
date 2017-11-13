package de.dhbw.mosbach.inf16a.kochbuch.registration;

import de.dhbw.mosbach.inf16a.kochbuch.authentication.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Annika Schatz
 * @author Tobias Bloch
 * @author Irina Eurich
 * @author Endrit Çallaki
 */
@Service
public class RegistrationService implements IRegistrationService {
    @Autowired
    private RegistrationRepository repository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerNewUserAccount(final UserDTO accountDto) {
        if (emailExist(accountDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + accountDto.getEmail());
        }
        if (usernameExist(accountDto.getUserName())) {
            throw new UserAlreadyExistException("There is an account with that username: " + accountDto.getUserName());
        }
        final User user = new User();

        user.setUsername(accountDto.getUserName());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        return repository.save(user);
    }
    private boolean emailExist(String email) {
        User user = repository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
    private boolean usernameExist(String username) {
        User user = repository.findByUsername(username);
        if (user != null) {
            return true;
        }
        return false;
    }
}
