package dev.joseafmoreira.project;

import dev.joseafmoreira.document.IDocument;
import dev.joseafmoreira.document.DocumentType;

/**
 * <h2>
 * IProject
 * </h2>
 * <p>
 * The interface <code>IProject</code> that specifies the available operations of this data structure used to store {@link IDocument documents}
 * </p>
 * <p>
 * Author: ESTG-FPOO-2122
 * </p>
 */
public interface IProject {
    /**
     * Adds a document to the project.
     *
     * @param document the document to be added        
     * @return <code>true</code> if the document was successfully added
     *         <code>false</code> if the {@link IDocument document} has
     *         <ul>
     *          <li>a file extension different from <code>pdf</code>;</li>
     *          <li>a file size greater than 2 MB;</li>
     *          <li>a version lower than the one that already exists in the project identified by it's id.</li>
     *         </ul>
     */
    boolean addDocument(IDocument document);

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
