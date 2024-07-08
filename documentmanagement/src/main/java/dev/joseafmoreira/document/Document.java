package dev.joseafmoreira.document;

/**
 * <h2>
 * Document
 * </h2>
 * <p>
 * The <code>Document</code> class that implements the {@link IDocument IDocument} interface.
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class Document implements IDocument {
    /**
     * The total number of created documents incremented every time a new document is instantiated
     */
    private static int NUMBER_DOCUMENTS = 0;
    /**
     * This document's id is defined using the {@link #NUMBER_DOCUMENTS total number of created documents}
     */
    private final int id;
    /**
     * This document's title is specified in the constructor
     */
    private String title;
    /**
     * This document's version is specified in the constructor
     */
    private final int version;
    /**
     * This document's file name is specified in the constructor
     */
    private final String filename;
    /**
     * This document's type is specified in the constructor
     */
    private DocumentType type;
    /**
     * This document's file size in MB is specified in the constructor
     */
    private final int fileSizeMb;
    /**
     * This document's file extension is specified in the constructor
     */
    private final String fileExtension;

    /**
     * Instantiate a new document object
     * 
     * @param title the title of this document
     * @param version the version of this document
     * @param filename the file name of this document
     * @param type the type of this document
     * @param fileSizeMb the file size in MB of this document
     * @param fileExtension the file extension of this document
     */
    public Document(String title, int version, String filename, DocumentType type, int fileSizeMb, String fileExtension) {
        id = ++NUMBER_DOCUMENTS;
        setTitle(title);
        this.version = version;
        this.filename = filename;
        setType(type);
        this.fileSizeMb = fileSizeMb;
        this.fileExtension = fileExtension;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getVersion() {
        return version;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFilename() {
        return filename;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DocumentType getType() {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setType(DocumentType type) {
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFileSizeMb() {
        return fileSizeMb;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFileExtension() {
        return fileExtension;
    }

    /**
     * Returns a hash code value for this document. This method is used by the Java
     * hashing algorithms when storing objects in hash-based data structures such
     * as HashMap.
     *
     * @return the hash code value for this document.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + version;
        result = prime * result + fileSizeMb;
        result = prime * result + ((filename == null) ? 0 : filename.hashCode());
        result = prime * result + ((fileExtension == null) ? 0 : fileExtension.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    /**
     * Compares this document with the specified object for equality.
     * Returns true if the given object is also a Document and has the same
     * id, version, fileSizeMb, filename, fileExtension, title, and type as this document.
     *
     * @param obj the object to compare with this document
     * @return true if the given object is equal to this document, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || getClass() != obj.getClass()) return false;

        Document otherDocument = (Document) obj;
        if (id != otherDocument.id) return false;
        if (version != otherDocument.version) return false;
        if (fileSizeMb != otherDocument.fileSizeMb) return false;
        if (filename == null) if (otherDocument.filename != null) return false;
        else if (!filename.equals(otherDocument.filename)) return false;
        if (fileExtension == null) if (otherDocument.fileExtension != null) return false;
        else if (!fileExtension.equals(otherDocument.fileExtension)) return false;
        if (title == null) if (otherDocument.title != null) return false;
        else if (!title.equals(otherDocument.title)) return false;
        if (type == null) if (otherDocument.type != null) return false;
        else if (!type.equals(otherDocument.type)) return false;

        return true;
    }

    /**
     * Returns a string representation of this document.
     * 
     * @return A string representation of this document, including its id, version, fileSizeMb, filename,
     *         fileExtension, title, and type.
     */
    @Override
    public String toString() {
        return "Document [id=" + id + ", version=" + version + ", fileSizeMb=" + fileSizeMb + ", filename=" + filename
                + ", fileExtension=" + fileExtension + ", title=" + title + ", type=" + type + "]";
    }
}
