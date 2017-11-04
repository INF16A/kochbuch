package de.dhbw.mosbach.inf16a.kochbuch.registration;

/**
 * @author Annika Schatz
 * @author Tobias Bloch
 * @author Irina Eurich
 */
@SuppressWarnings("serial")
public class EmailExistsException extends Throwable {

    public EmailExistsException(final String message) {
        super(message);
    }

}
