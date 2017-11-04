package de.dhbw.mosbach.inf16a.kochbuch.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * Created by Annika on 04.11.2017.
 */
@Service
public class RegistrationService implements IRegistartionService {
    @Autowired
    private UserRepository repository;

    @Transactional
    @Override
    public SecurityProperties.User registerNewUserAccount(UserDTO accountDto)
            throws EmailExistsException {

        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            +  accountDto.getEmail());
        }
        SecurityProperties.User user = new SecurityProperties.User();
        user.setName(accountDto.getUserName());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
        user.setRole(Arrays.asList("ROLE_USER"));
        return repository.save(user);
    }
    private boolean emailExist(String email) {
        SecurityProperties.User user = repository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
