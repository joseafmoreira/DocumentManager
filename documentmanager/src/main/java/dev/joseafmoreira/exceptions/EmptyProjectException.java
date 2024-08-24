package dev.joseafmoreira.exceptions;

/**
 * Unchecked exception that can be thrown by some methods 
 * of a project indicating that it has no documents. <p>
 * 
 * The available constructors are the following: <p>
 * <ul>
 *  <li>{@link #EmptyProjectException()}: Constructs a new EmptyProjectException with a default message</li>
 *  <li>{@link #EmptyProjectException(String)}: Constructs a new EmptyProjectException with a custom message</li>
 * </ul>
 * 
 * <h3>EmptyProjectException</h3>
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see RuntimeException
 */
public class EmptyProjectException extends RuntimeException {
    /**
     * The default message of this exception
     */
    protected static final String DEFAULT_MESSAGE = "Project is empty";

    /**
     * Constructs a new EmptyCollectionException with a default message.
     */
    public EmptyProjectException() {
        this(DEFAULT_MESSAGE);
    }

    /**
     * Constructs a new EmptyCollectionException with a custom message.
     * 
     * @param message the exception message
     */
    public EmptyProjectException(String message) {
        super(message);
    }
}
