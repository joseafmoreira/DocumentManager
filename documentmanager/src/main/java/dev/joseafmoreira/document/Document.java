package dev.joseafmoreira.document;

import pt.ipp.estg.fpoo.document.DocumentType;
import pt.ipp.estg.fpoo.document.IDocument;

/**
 * Concrete implementation of the {@code IDocument} interface.
 * 
 * <h3>Document</h3>
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see IDocument
 */
public class Document implements IDocument {
    /**
     * This document's id
     */
    private final int id;
    /**
     * This document's title
     */
    private String title;
    /**
     * This document's version
     */
    private final int version;
    /**
     * This document's file name
     */
    private final String fileName;
    /**
     * This document's type
     */
    private DocumentType type;
    /**
     * This document's file size in MB
     */
    private final int fileSizeMb;
    /**
     * This document's file extension
     */
    private final String fileExtension;

    /**
     * Constructs a document with an id, title, version, fileName, 
     * type, fileSizeMb and fileExtension.
     * 
     * @param id the id of this document
     * @param title the title of this document
     * @param version the version of this document
     * @param fileName the file name of this document
     * @param type the type of this document
     * @param fileSizeMb the file size in MB of this document
     * @param fileExtension the file extension of this document
     */
    public Document(int id, String title, int version, String fileName, DocumentType type, int fileSizeMb, String fileExtension) {
        this.id = id;
        setTitle(title);
        this.version = version;
        this.fileName = fileName;
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
    public String getFileName() {
        return fileName;
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
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + version;
        result = prime * result + fileSizeMb;
        result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
        result = prime * result + ((fileExtension == null) ? 0 : fileExtension.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || getClass() != obj.getClass()) return false;

        Document otherDocument = (Document) obj;
        if (id != otherDocument.id) return false;
        if (version != otherDocument.version) return false;
        if (fileSizeMb != otherDocument.fileSizeMb) return false;
        if (fileName == null) if (otherDocument.fileName != null) return false;
        else if (!fileName.equals(otherDocument.fileName)) return false;
        if (fileExtension == null) if (otherDocument.fileExtension != null) return false;
        else if (!fileExtension.equals(otherDocument.fileExtension)) return false;
        if (title == null) if (otherDocument.title != null) return false;
        else if (!title.equals(otherDocument.title)) return false;
        if (type == null) if (otherDocument.type != null) return false;
        else if (!type.equals(otherDocument.type)) return false;

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Document [id=" + id + ", version=" + version + ", fileSizeMb=" + fileSizeMb + ", filename=" + fileName
                + ", fileExtension=" + fileExtension + ", title=" + title + ", type=" + type + "]";
    }
}
