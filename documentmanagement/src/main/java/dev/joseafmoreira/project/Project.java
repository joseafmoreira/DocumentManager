package dev.joseafmoreira.project;

import dev.joseafmoreira.document.DocumentType;
import dev.joseafmoreira.document.IDocument;
import dev.joseafmoreira.exceptions.DocumentNotFoundException;
import dev.joseafmoreira.exceptions.InvalidDocumentException;

/**
 * <h2>
 * Project
 * </h2>
 * <p>
 * The <code>Project</code> class that implements the {@link IProject IProject} interface.
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class Project implements IProject {
    /**
     * This data structure default capacity
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * This project's documents array
     */
    private IDocument[] documents;
    /**
     * This project's number of documents
     */
    private int size;

    /**
     * Instantiates a new project object with a specified default capacity
     */
    public Project() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Instantiates a new project object
     * 
     * @param initialCapacity The specified initial capacity of this project (Minimum size is 2)
     */
    public Project(int initialCapacity) {
        initialCapacity = Math.max(2, initialCapacity);
        documents = new IDocument[initialCapacity];
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(IDocument document) throws NullPointerException, InvalidDocumentException {
        if (document == null) throw new NullPointerException("Document is null");
        if (size == documents.length) expandCapacity();
        if (document.getFileSizeMb() > 2) throw new InvalidDocumentException("Document can't have more than 2 MB");
        if (!document.getFileExtension().equals("pdf")) throw new InvalidDocumentException("Document file extension needs to be pdf");
        for (int i = 0; i < size; i++) {
            if (documents[i].getId() == document.getId() && 
                documents[i].getVersion() >= document.getVersion())
                    throw new InvalidDocumentException("There's already a newer or equal version of this document in this project");
        }

        documents[size++] = document;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int removeOldVersions() {
        boolean[] latestDocuments = new boolean[size];
        for (int i = 0; i < size; i++) {
            latestDocuments[i] = true;
            for (int j = 0; j < size; j++) {
                if (i != j && documents[i].getId() == documents[j].getId() && documents[i].getVersion() < documents[j].getVersion()) {
                    latestDocuments[i] = false;
                    break;
                }
            }
        }
        IDocument[] newDocuments = new IDocument[documents.length];
        int newSize = 0, removedVersions;
        for (int i = 0; i < size; i++) {
            if (latestDocuments[i]) {
                newDocuments[newSize++] = documents[i];
            }
        }
        documents = newDocuments;
        removedVersions = size - newSize;
        size = newSize;

        return removedVersions;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(IDocument document) throws NullPointerException, DocumentNotFoundException {
        if (document == null) throw new NullPointerException("Document is null");

        for (int i = 0; i < size; i++) {
            if (documents[i].equals(document)) {
                for (int j = i; j < (size - 1); j++) documents[j] = documents[j + 1];
                documents[--size] = null;

                return;
            }
        }   

        throw new DocumentNotFoundException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IDocument get(int id) throws DocumentNotFoundException {
        IDocument document = null;
        for (int i = 0; i < size; i++)
            if (documents[i].getId() == id && 
                (document == null || documents[i].getVersion() > document.getVersion())) 
                    document = documents[i];
        if (document == null) throw new DocumentNotFoundException();

        return document;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IDocument[] getDocumentsByType(DocumentType type) throws NullPointerException {
        if (type == null) throw new NullPointerException("Type is null");

        IDocument[] tempArray = new IDocument[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (documents[i].getType().equals(type)) {
                tempArray[count++] = documents[i];
            }
        }
        IDocument[] result = new IDocument[count];
        for (int i = 0; i < count; i++) result[i] = tempArray[i];

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IDocument[] toArray() {
        IDocument[] resultDocuments = new IDocument[size];
        for (int i = 0; i < size; i++) resultDocuments[i] = documents[i];

        return resultDocuments;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(IDocument document) throws NullPointerException {
        if (document == null) throw new NullPointerException("Document is null");

        for (int i = 0; i < size; i++) if (documents[i].equals(document)) return true;
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        documents = new IDocument[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for (int i = 0; i < size; i++) result = prime * result + documents[i].hashCode();
        result = prime * result + size;

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Project otherProject = (Project) obj;
        if (size != otherProject.size) return false;
        for (int i = 0; i < size; i++) if (!documents[i].equals(otherProject.documents[i])) return false;
        
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("(" + size() + ")[");
        for (int i = 0; i < size; i++) result.append(documents[i]).append((i == size - 1) ? "" : ", ");
        result.append("]");

        return result.toString();
    }

    /**
     * Expands the capacity of the documents array
     */
    private void expandCapacity() {
        IDocument[] newDocuments = new IDocument[documents.length + (documents.length / 2)];
        for (int i = 0; i < size; i++) newDocuments[i] = documents[i];
        documents = newDocuments;
    }
}
