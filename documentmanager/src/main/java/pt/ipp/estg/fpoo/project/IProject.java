package pt.ipp.estg.fpoo.project;

import pt.ipp.estg.fpoo.document.DocumentType;
import pt.ipp.estg.fpoo.document.IDocument;

/**
 * A project represents a collection of documents. <p>
 * 
 * The expected operations for a project include: <p>
 * <ul>
 *  <li>{@link #add(IDocument)}: Adds a document to this project</li>
 *  <li>{@link #removeOldVersions()}: Remove all versions of a document except the most recent version</li>
 *  <li>{@link #remove(IDocument)}: Removes a document from this project</li>
 *  <li>{@link #get(int)}: Retrieves the latest version of a document with the specified ID</li>
 *  <li>{@link #getDocumentsByType(DocumentType)}: Obtain all documents in this project of a certain type</li>
 *  <li>{@link #toArray()}: Returns an array containing all the documents in this project</li>
 *  <li>{@link #contains(IDocument)}: Checks if this project contains the specified document</li>
 *  <li>{@link #isEmpty()}: Checks if this project is empty</li>
 *  <li>{@link #size()}: Returns the size of this project</li>
 *  <li>{@link #clear()}: Clear all documents from this project</li>
 *  <li>
 *      {@link #hashCode()}: Returns a hash code value for this project. This method is used by the Java
        hashing algorithms when storing objects in hash-based data structures such
        as HashMap
 *  </li>
 *  <li>
 *      {@link #equals(Object)}: Compares this project with the specified object for equality.
        Returns true if the given object is also a project and has the same
        documents and size as this project
    </li>
 *  <li>{@link #toString()}: Returns a string representation of this project</li>
 * </ul>
 * 
 * <h3>IProject</h3>
 * @since 1.0
 * @version 1.0
 * @author ESTG-FPOO
 * @see IDocument
 * @see DocumentType
 */
public interface IProject {
    /**
     * Adds a document to this project.
     * 
     * @param document the document to be added
     */
    void add(IDocument document);

    /**
     * Remove all versions of a document except the most recent version.
     * 
     * @return the number of removed documents
     */
    int removeOldVersions();

    /**
     * Removes a document from this project.
     * 
     * @param document the document to be removed
     */
    void remove(IDocument document);

    /**
     * Retrieves the latest version of a document with the specified ID.
     *
     * @param id the ID of the document to retrieve
     * @return the latest version of a document with the specified ID
     */
    IDocument get(int id);

    /**
     * Obtain all documents in this project of a certain type.
     * 
     * @param type the document type
     * @return an array of documents with the specified type
     */
    IDocument[] getDocumentsByType(DocumentType type);

    /**
     * Returns an array containing all the documents in this project.
     *
     * @return an array of type IDocument containing all the documents in this project
     */
    IDocument[] toArray();

    /**
     * Checks if this project contains the specified document.
     *
     * @param document the document to check
     * @return true if this project contains the document, false otherwise
     * @throws NullPointerException if the specified document is null.
     */
    boolean contains(IDocument document);

    /**
     * Checks if this project is empty.
     *
     * @return true if this project is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the size of this project.
     *
     * @return the size of this project
     */
    int size();

    /**
     * Clear all documents from this project.
     */
    void clear();

    /**
     * Returns a hash code value for this project. This method is used by the Java
     * hashing algorithms when storing objects in hash-based data structures such
     * as HashMap.
     *
     * @return the hash code value for this project.
     */
    @Override int hashCode();

    /**
     * Compares this project with the specified object for equality.
     * Returns true if the given object is also a project and has the same
     * documents and size as this project.
     *
     * @param obj the object to compare with this project
     * @return true if the given object is equal to this project, false otherwise
     */
    @Override boolean equals(Object obj);

    /**
     * Returns a string representation of this project.
     * 
     * @return a string representation of this project
     */
    @Override String toString();
}
