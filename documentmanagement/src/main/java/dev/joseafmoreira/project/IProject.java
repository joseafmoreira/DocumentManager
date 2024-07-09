package dev.joseafmoreira.project;

import dev.joseafmoreira.document.IDocument;
import dev.joseafmoreira.exceptions.DocumentNotFoundException;
import dev.joseafmoreira.exceptions.InvalidDocumentException;

import dev.joseafmoreira.document.DocumentType;

/**
 * <h2>
 * IProject
 * </h2>
 * <p>
 * The <code>IProject</code> interface that specifies the available operations of this data structure used to store {@link IDocument documents}
 * </p>
 * <p>
 * Author: ESTG-FPOO-2122
 * </p>
 */
public interface IProject {
    /**
     * Adds a document to this project.
     * @param document the document to be added
     * @throws NullPointerException if the specified document is null.
     * @throws InvalidDocumentException if the {@link IDocument document} 
     *                                  has a file extension different from <code>pdf</code>, 
     *                                  file size greater than 2 MB or 
     *                                  a version lower than the one added in this project identified by its id.
     */
    void add(IDocument document) throws NullPointerException, InvalidDocumentException;

    /**
     * Remove all versions of a document except the most recent version.
     * @return the number of removed documents
     */
    int removeOldVersions();

    /**
     * Removes a document from this project.
     * @param document the document to be removed
     * @throws NullPointerException if the specified document is null.
     * @throws DocumentNotFoundException if the {@link IDocument document} doesn't exist in this project
     */
    void remove(IDocument document) throws NullPointerException, DocumentNotFoundException;

    /**
     * Retrieves the latest version of a document with the specified ID.
     *
     * @param id the ID of the document to retrieve
     * @return the latest version of a document with the specified ID
     * @throws DocumentNotFoundException if the {@link IDocument document} doesn't exist in this project
     */
    IDocument get(int id) throws DocumentNotFoundException;

    /**
     * Obtain the documents of a certain {@link DocumentType type}
     * @param type the document type
     * @return an array of documents with the specified type
     * @throws NullPointerException if the specified type is null.
     */
    IDocument[] getDocumentsByType(DocumentType type) throws NullPointerException;

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
    boolean contains(IDocument document) throws NullPointerException;

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
     * Clear all documents from this project
     */
    void clear();
}
