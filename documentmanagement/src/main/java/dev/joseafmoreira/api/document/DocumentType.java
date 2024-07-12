package dev.joseafmoreira.api.document;

/**
 * <h2>
 * DocumentType
 * </h2>
 * <p>
 * The <code>DocumentType</code> enum that represents the available document types.
 * </p>
 * <p>
 * Author: ESTG-FPOO-2122
 * </p>
 */
public enum DocumentType {
    /**
     * Machine document type
     */
    MACHINE,
    /**
     * Worker document type
     */
    WORKER,
    /**
     * Infrastructure document type
     */
    INFRASTRUCTURE;

    /**
     * Returns a string representation of the document type.
     *
     * @return The string representation of the document type.
     */
    @Override
    public String toString() {
        return switch (this) {
            case MACHINE -> "Machine";
            case WORKER -> "Worker";
            case INFRASTRUCTURE -> "Infrastructure";
        };
    }
}
