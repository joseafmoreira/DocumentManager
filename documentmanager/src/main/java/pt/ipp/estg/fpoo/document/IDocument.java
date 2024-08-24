package pt.ipp.estg.fpoo.document;

/**
 * A document represents an object with an id, title, version, filename, type, fileSizeMb and fileExtension. <p>
 * 
 * The expected operations for a document include: <p>
 * <ul>
 *  <li>{@link #getId()}: Returns the id of this document</li>
 *  <li>{@link #getTitle()}: Returns the title of this document</li>
 *  <li>{@link #setTitle(String)}: Sets the title of this document</li>
 *  <li>{@link #getVersion()}: Returns the version of this document</li>
 *  <li>{@link #getFileName()}: Returns the file name of this document</li>
 *  <li>{@link #getType()}: Returns the type of this document</li>
 *  <li>{@link #setType(DocumentType)}: Sets the document type of this document</li>
 *  <li>{@link #getFileSizeMb()}: Returns the file size in megabytes</li>
 *  <li>{@link #getFileExtension()}: Returns the file extension of this document</li>
 *  <li>
 *      {@link #hashCode()}: Returns a hash code value for this document. This method is used by the Java
        hashing algorithms when storing objects in hash-based data structures such
        as HashMap.
 *  </li>
 *  <li>
 *      {@link #equals(Object)}: Compares this document with the specified object for equality.
        Returns true if the given object is also a document and has the same
        id, title, version, filename, type, fileSizeMb and fileExtension as this document.
    </li>
 *  <li>{@link #toString()}: Returns a string representation of this document.</li>
 * </ul>
 * 
 * <h3>IDocument</h3>
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see DocumentType
 */
public interface IDocument {
    /**
    * Returns the id of this document.
    *
    * @return the id of this document
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
    * Returns the file name of this document.
    *
    * @return the file name of this document
    */
   String getFileName();

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
    * id, title, version, fileName, type, fileSizeMb and fileExtension as this document.
    *
    * @param obj the object to compare with this document
    * @return true if the given object is equal to this document, false otherwise
    */
   @Override boolean equals(Object obj);

   /**
    * Returns a string representation of this document.
    * 
    * @return a string representation of this document.
    */
   @Override String toString();
}
