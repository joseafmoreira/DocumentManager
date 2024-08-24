package pt.ipp.estg.fpoo.document;

/**
 * This enumerates the possible options for a document type. <p>
 * 
 * The available operations are: <p>
 * <ul>
 *  <li>{@link #toString()}: Returns a string representation of this document type</li>
 * </ul>
 * 
 * <h3>DocumentType</h3>
 * @since 1.0
 * @version 1.0
 * @author ESTG-FPOO
 * @see IDocument
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
     * Returns a string representation of this document type.
     *
     * @return a string representation of this document type.
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
