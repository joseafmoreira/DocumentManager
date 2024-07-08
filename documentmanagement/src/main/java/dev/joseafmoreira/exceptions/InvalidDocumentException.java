package dev.joseafmoreira.exceptions;

/**
 * <h2>
 * InvalidDocumentException
 * </h2>
 * <p>
 * The <code>InvalidDocumentException</code> unchecked exception is thrown if a document is invalid.
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class InvalidDocumentException extends RuntimeException {
    public InvalidDocumentException(String message) {
        super(message);
    }
}
