package dev.joseafmoreira.exceptions;

/**
 * <h2>
 * DocumentNotFoundException
 * </h2>
 * <p>
 * The <code>DocumentNotFoundException</code> unchecked exception is thrown if a document isn't in a project.
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class DocumentNotFoundException extends RuntimeException {
    public DocumentNotFoundException() {
        super("Document not found");
    }
}
