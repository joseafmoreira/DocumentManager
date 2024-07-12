package dev.joseafmoreira.api.document;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

/**
 * <h2>
 * DocumentTest
 * </h2>
 * <p>
 * The <code>DocumentTest</code> class that tests the implementation of the {@link Document Document} class.
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class DocumentTest {
    /**
     * Document object that will be used for testing purposes.
     */
    private Document document1, document2, document3;

    /**
     * Sets up the test environment by initializing the test objects.
     */
    @Before
    public void setup() {
        document1 = new Document(1, "Title", 1, "filename", DocumentType.INFRASTRUCTURE, 10, "txt");
        document2 = new Document(2, "Title", 1, "filename", DocumentType.INFRASTRUCTURE, 10, "txt");
        document3 = new Document(1, "Title", 1, "filename", DocumentType.INFRASTRUCTURE, 10, "txt");
    }

    /**
     * Test case to verify that a {@link NullPointerException} is thrown when creating a Document without a filename.
     */
    @Test(expected = NullPointerException.class)
    public void testDocumentWithoutFilename1() {
        new Document(1, "Title", 1, null, DocumentType.INFRASTRUCTURE, 10, "txt");
    }

    /**
     * Test case to verify that a {@link NullPointerException} is thrown when creating a Document with an invalid filename.
     */
    @Test(expected = NullPointerException.class)
    public void testDocumentWithoutFilename2() {
        new Document(1, "Title", 1, "        ", DocumentType.INFRASTRUCTURE, 10, "txt");
    }

    /**
     * Test case to verify that a {@link NullPointerException} is thrown when creating a Document without a fileExtension.
     */
    @Test(expected = NullPointerException.class)
    public void testDocumentWithoutFileExtension1() {
        new Document(1, "Title", 1, "filename", DocumentType.INFRASTRUCTURE, 10, null);
    }

    /**
     * Test case to verify that a {@link NullPointerException} is thrown when creating a Document with an invalid fileExtension.
     */
    @Test(expected = NullPointerException.class)
    public void testDocumentWithoutFileExtension2() {
        new Document(1, "Title", 1, "filename", DocumentType.INFRASTRUCTURE, 10, "        ");
    }

    /**
     * Test case to verify the correctness of the {@link Document#hashCode() hashCode()} method.
     * It asserts that the hash codes of document1 and document3 are equal.
     */
    @Test
    public void testHashCodeEquals() {
        assertEquals(document1.hashCode(), document3.hashCode());
    }

    /**
     * Test case to verify the correctness of the {@link Document#hashCode() hashCode()} method.
     * It asserts that the hash codes of document1 and document2 aren't equal.
     */
    @Test
    public void testHashCodeNotEquals() {
        assertNotEquals(document1.hashCode(), document2.hashCode());
    }

    /**
     * Test case to verify the correctness of the {@link Document#equals() equals()} method.
     * It asserts that the hash codes of document1 and document3 are equal.
     */
    @Test
    public void testEquals() {
        assertEquals(document1, document3);
    }

    /**
     * Test case to verify the correctness of the {@link Document#equals() equals()} method.
     * It asserts that the hash codes of document1 and document2 aren't equal.
     */
    @Test
    public void testNotEquals() {
        assertNotEquals(document1, document2);
    }

    /**
     * Test case for the {@link Document#toString() toString()} method of the Document class.
     * It verifies that the {@link Document#toString() toString()} method returns the expected string representation of the Document object.
     */
    @Test
    public void testToString() {
        assertEquals("Document [id=1, version=1, fileSizeMb=10, filename=filename, fileExtension=txt, title=Title, type=Infrastructure]", document1.toString());
    }
}
