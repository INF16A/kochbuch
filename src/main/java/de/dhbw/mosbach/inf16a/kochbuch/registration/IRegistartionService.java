package de.dhbw.mosbach.inf16a.kochbuch.registration;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

/**
 * Created by Annika on 04.11.2017.
 */
public interface IRegistartionService {
    SecurityProperties.User registerNewUserAccount(UserDTO accountDto)
        throws EmailExistsException;
}
