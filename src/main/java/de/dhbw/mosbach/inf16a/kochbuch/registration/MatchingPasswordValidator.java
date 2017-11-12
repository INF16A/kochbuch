package de.dhbw.mosbach.inf16a.kochbuch.registration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Annika Schatz
 * @author Tobias Bloch
 * @author Irina Eurich
 * @author Endrit Çallaki
 */
public class MatchingPasswordValidator implements ConstraintValidator<MatchingPassword, Object> {

        @Override
        public void initialize(MatchingPassword constraintAnnotation) {
        }
        @Override
        public boolean isValid(Object obj, ConstraintValidatorContext context){
            UserDTO user = (UserDTO) obj;
            return user.getPassword().equals(user.getMatchingPassword());
        }
    }
