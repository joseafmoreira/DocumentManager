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
    void addDocument(IDocument document);

    /**
     * Removes a document from this project.
     * @param document the document to be removed
     * @throws NullPointerException if the specified document is null.
     * @throws DocumentNotFoundException if the {@link IDocument document} doesn't exist in this project
     */
    void removeDocument(IDocument document) throws DocumentNotFoundException;

    /**
     * Remove all versions of a document except the most recent version.
     * @return the number of removed documents
     */
    int removeOldVersions();

    /**
     * Obtain the documents of a certain {@link DocumentType type}
     * @param type the document type
     * @return an array of documents with the specified type
     */
    IDocument[] getDocuments(DocumentType type);
}
