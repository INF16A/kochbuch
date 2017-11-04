package de.dhbw.mosbach.inf16a.kochbuch.registration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Annika on 04.11.2017.
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
