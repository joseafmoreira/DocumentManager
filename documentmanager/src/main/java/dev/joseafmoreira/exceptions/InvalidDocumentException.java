package dev.joseafmoreira.exceptions;

/**
 * Unchecked exception that can be thrown when adding an
 * invalid document to a project. <p>
 * 
 * The available constructors are the following: <p>
 * <ul>
 *  <li>{@link #InvalidDocumentException()}: Constructs a new InvalidDocumentException with a default message</li>
 *  <li>{@link #InvalidDocumentException(String)}: Constructs a new InvalidDocumentException with a custom message</li>
 * </ul>
 * 
 * <h3>InvalidDocumentException</h3>
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see RuntimeException
 */
public class InvalidDocumentException extends RuntimeException {
    /**
     * The default message of this exception
     */
    protected static final String DEFAULT_MESSAGE = "Invalid document";

    /**
     * Constructs a new InvalidDocumentException with a default message.
     */
    public InvalidDocumentException() {
        this(DEFAULT_MESSAGE);
    }

    /**
     * Constructs a new InvalidDocumentException with a custom message.
     * 
     * @param message the exception message
     */
    public InvalidDocumentException(String message) {
        super(message);
    }
}
