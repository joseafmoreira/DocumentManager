package dev.joseafmoreira.project;

import java.util.NoSuchElementException;

import dev.joseafmoreira.exceptions.EmptyProjectException;
import dev.joseafmoreira.exceptions.InvalidDocumentException;
import pt.ipp.estg.fpoo.document.DocumentType;
import pt.ipp.estg.fpoo.document.IDocument;
import pt.ipp.estg.fpoo.project.IProject;

/**
 * Concrete implementation of the {@code IProject} interface.
 * 
 * <h3>Project</h3>
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see IProject
 */
public class Project implements IProject {
    /**
     * The default capacity of this project array
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * The array containing the elements of this project
     */
    private IDocument[] array;
    /**
     * The number of documents in this list
     */
    private int size;

    /**
     * Constructs an empty Project with a default capacity.
     */
    public Project() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty Project with a specified initial capacity.
     * 
     * @param initialCapacity the initial capacity (Minimum value is 0)
     */
    public Project(int initialCapacity) {
        array = new IDocument[(initialCapacity < 0) ? 0 : initialCapacity];
        size = 0;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException if the document is null
     * @throws InvalidDocumentException if the document can't be added to this project
     */
    @Override
    public void add(IDocument document) throws NullPointerException {
        if (document == null) throw new NullPointerException("Document is null");
        if (document.getFileSizeMb() > 2) throw new InvalidDocumentException("Document can't have more than 2 MB");
        if (!document.getFileExtension().equals("pdf")) throw new InvalidDocumentException("Document file extension needs to be pdf");
        for (int i = 0; i < size(); i++) {
            if (array[i].getId() == document.getId() && 
                array[i].getVersion() >= document.getVersion())
                    throw new InvalidDocumentException("There's already a newer or equal version of this document in this project");
        }

        if (size == array.length) expandCapacity();
        array[size++] = document;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int removeOldVersions() {
        boolean[] latestDocuments = new boolean[size()];
        for (int i = 0; i < size(); i++) {
            latestDocuments[i] = true;
            for (int j = 0; j < size(); j++) {
                if (i != j && array[i].getId() == array[j].getId() && array[i].getVersion() < array[j].getVersion()) {
                    latestDocuments[i] = false;
                    break;
                }
            }
        }
        IDocument[] newArray = new IDocument[array.length];
        int newSize = 0, removedVersions;
        for (int i = 0; i < size(); i++) {
            if (latestDocuments[i]) {
                newArray[newSize++] = array[i];
            }
        }
        array = newArray;
        removedVersions = size() - newSize;
        size = newSize;

        return removedVersions;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException if the document is null
     * @throws EmptyProjectException is this project is empty
     * @throws NoSuchElementException if the document isn't on this project
     */
    @Override
    public void remove(IDocument document) throws NullPointerException, NoSuchElementException {
        if (document == null) throw new NullPointerException("Document is null");
        if (isEmpty()) throw new EmptyProjectException();

        if (array[0].equals(document)) {
            for (int i = 0; i < size() - 1; i++) array[i] = array[i + 1];
            array[--size] = null;

            return;
        } else if (array[size() - 1].equals(document)) {
            array[--size] = null;

            return;
        } else {
            for (int i = 1; i < size() - 1; i++) {
                if (array[i].equals(document)) {
                    array[i] = null;
                    for (int j = i; j < size() - 1; j++) {
                        array[j] = array[j + 1];
                    }
                    array[--size] = null;
    
                    return;
                }
            }
        }   

        throw new NoSuchElementException("Document not found");
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NoSuchElementException if the document with this id isn't on this project
     */
    @Override
    public IDocument get(int id) throws NoSuchElementException {
        IDocument document = null;
        for (int i = 0; i < size; i++)
            if (array[i].getId() == id && 
                (document == null || array[i].getVersion() > document.getVersion())) 
                    document = array[i];
        if (document == null) throw new NoSuchElementException("Document not found");

        return document;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException if the document is null
     */
    @Override
    public IDocument[] getDocumentsByType(DocumentType type) throws NullPointerException {
        if (type == null) throw new NullPointerException("Type is null");

        IDocument[] tempArray = new IDocument[size()];
        int tempSize = 0;
        for (int i = 0; i < size(); i++) {
            if (array[i].getType().equals(type)) {
                tempArray[tempSize++] = array[i];
            }
        }
        IDocument[] result = new IDocument[tempSize];
        for (int i = 0; i < tempSize; i++) result[i] = tempArray[i];

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IDocument[] toArray() {
        IDocument[] resultDocuments = new IDocument[size()];
        for (int i = 0; i < size(); i++) resultDocuments[i] = array[i];

        return resultDocuments;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException if the document is null
     */
    @Override
    public boolean contains(IDocument document) throws NullPointerException {
        if (document == null) throw new NullPointerException("Document is null");

        for (int i = 0; i < size(); i++) if (array[i].equals(document)) return true;
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
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
        size = 0;
        array = new IDocument[size()];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for (int i = 0; i < size(); i++) result = prime * result + array[i].hashCode();
        result = prime * result + size();

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
        if (size() != otherProject.size()) return false;
        for (int i = 0; i < size(); i++) if (!array[i].equals(otherProject.array[i])) return false;
        
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("(" + size() + ")[");
        for (int i = 0; i < size(); i++) result.append(array[i]).append((i == size() - 1) ? "" : ", ");
        result.append("]");

        return result.toString();
    }

    /**
     * Expands the capacity of the array used to store the documents in this project.
     * If the current array length is 0 or 1, a new array with a capacity of the old length + 1 is created.
     * Otherwise, a new array with a capacity increased by half of the current array's length is created.
     * The elements from the current array are copied to the new array.
     */
    protected void expandCapacity() {
        IDocument[] newArray = new IDocument[(array.length < 2) ? array.length + 1 : array.length + (array.length / 2)];
        for (int i = 0; i < size(); i++) newArray[i] = array[i];
        array = newArray;
    }
}
