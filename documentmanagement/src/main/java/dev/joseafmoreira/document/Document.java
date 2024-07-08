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
    private static int NUMBER_DOCUMENTS = 0;
    private final int id, version, fileSizeMb;
    private final String filename, fileExtension;
    private String title;
    private DocumentType type;

    public Document(String title, int version, String filename, DocumentType type, int fileSizeMb, String fileExtension) {
        id = ++NUMBER_DOCUMENTS;
        setTitle(title);
        this.version = version;
        this.filename = filename;
        setType(type);
        this.fileSizeMb = fileSizeMb;
        this.fileExtension = fileExtension;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getVersion() {
        return version;
    }

    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public DocumentType getType() {
        return type;
    }

    @Override
    public void setType(DocumentType type) {
        this.type = type;
    }

    @Override
    public int getFileSizeMb() {
        return fileSizeMb;
    }

    @Override
    public String getFileExtension() {
        return fileExtension;
    }
}
