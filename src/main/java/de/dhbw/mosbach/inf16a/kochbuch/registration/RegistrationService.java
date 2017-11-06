package de.dhbw.mosbach.inf16a.kochbuch.registration;

import de.dhbw.mosbach.inf16a.kochbuch.authentication.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Annika Schatz
 * @author Tobias Bloch
 * @author Irina Eurich
 */
@Service
public class RegistrationService implements IRegistrationService {
    @Autowired
    private RegistrationRepository repository;

    @Override
    public User registerNewUserAccount(final UserDTO accountDto) {
        if (emailExist(accountDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + accountDto.getEmail());
        }
        final User user = new User();

        user.setUsername(accountDto.getUserName());
        user.setPassword(accountDto.getPassword());
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
}
