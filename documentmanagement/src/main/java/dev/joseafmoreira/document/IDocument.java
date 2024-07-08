package dev.joseafmoreira.document;

/**
 * <h2>
 * IDocument
 * </h2>
 * <p>
 * The interface <code>IDocument</code> that specifies the behavior of a document.
 * </p>
 * <p>
 * Author: ESTG-FPOO-2122
 * </p>
 */
public interface IDocument {
    /**
     * Returns the ID of this document.
     *
     * @return the ID of this document
     */
    int getId();

    /**
     * Returns the title of this document.
     *
     * @return the title of this document
     */
    String getTitle();

    /**
     * Sets the title of this document.
     *
     * @param title the new title for this document
     */
    void setTitle(String title);

    /**
     * Returns the version of this document.
     *
     * @return the version of this document
     */
    int getVersion();

    /**
     * Returns the filename of this document.
     *
     * @return the filename of this document
     */
    String getFilename();

    /**
     * Returns the type of this document.
     *
     * @return this document's type
     */
    DocumentType getDocumentType();

    /**
     * Sets the document type of this document.
     *
     * @param documentType the document type to be set
     */
    void setDocumentType(DocumentType documentType);

    /**
     * Returns the file size in megabytes.
     *
     * @return the file size in megabytes
     */
    int getFileSizeMb();

    /**
     * Returns the file extension of this document.
     *
     * @return the file extension of this document
     */
    String getFileExtension();
}
