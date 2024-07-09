package dev.joseafmoreira.document;

/**
 * <h2>
 * IDocument
 * </h2>
 * <p>
 * The <code>IDocument</code> interface that specifies the behavior of a document.
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
    DocumentType getType();

    /**
     * Sets the document type of this document.
     *
     * @param type the document type to be set
     */
    void setType(DocumentType type);

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

    /**
     * Returns a hash code value for this document. This method is used by the Java
     * hashing algorithms when storing objects in hash-based data structures such
     * as HashMap.
     *
     * @return the hash code value for this document.
     */
    @Override int hashCode();

    /**
     * Compares this document with the specified object for equality.
     * Returns true if the given object is also a Document and has the same
     * id, version, fileSizeMb, filename, fileExtension, title, and type as this document.
     *
     * @param obj the object to compare with this document
     * @return true if the given object is equal to this document, false otherwise
     */
    @Override boolean equals(Object obj);

    /**
     * Returns a string representation of this document.
     * 
     * @return A string representation of this document, including its id, version, fileSizeMb, filename,
     *         fileExtension, title, and type.
     */
    @Override String toString();
}
