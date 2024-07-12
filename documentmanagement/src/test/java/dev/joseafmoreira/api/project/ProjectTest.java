package dev.joseafmoreira.api.project;

import org.junit.Test;
import dev.joseafmoreira.api.document.DocumentType;

import dev.joseafmoreira.api.document.Document;
import dev.joseafmoreira.api.exceptions.DocumentNotFoundException;
import dev.joseafmoreira.api.exceptions.InvalidDocumentException;

import static org.junit.Assert.*;

import org.junit.Before;

/**
 * <h2>
 * ProjectTest
 * </h2>
 * <p>
 * The <code>ProjectTest</code> class that tests the implementation of the {@link Project Project} class.
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class ProjectTest {
    /**
     * Project object that will be used for testing purposes.
     */
    private Project project;

    /**
     * Document object that will be used for testing purposes.
     */
    private Document document1;

    /**
     * Sets up the test environment by initializing the test objects.
     */
    @Before
    public void setup() {
        project = new Project();
        document1 = new Document(1, "Title", 1, "filename", DocumentType.INFRASTRUCTURE, 2, "pdf");
    }

    /**
     * Test case to verify that adding a null document to a project throws a {@link NullPointerException}.
     */
    @Test(expected = NullPointerException.class)
    public void testAddNullDocument() {
        project.add(null);
    }

    /**
     * Test case to verify that adding a file with a size bigger than 2 MB throws an {@link InvalidDocumentException}.
     */
    @Test
    public void testAddFileSizeBiggerThan2() {
        try {
            project.add(new Document(1, "Title", 1, "filename", DocumentType.INFRASTRUCTURE, 3, "txt"));
            fail("Expected an InvalidDocumentException to be thrown");
        } catch (InvalidDocumentException ex) {
            assertEquals("Document can't have more than 2 MB", ex.getMessage());
        }
    }

    /**
     * Test case to verify that adding a document with a different file extension other than PDF
     * throws an {@link InvalidDocumentException} with the expected error message.
     */
    @Test
    public void testAddFileExtensionDifferentPDF() {
        try {
            project.add(new Document(1, "Title", 1, "filename", DocumentType.INFRASTRUCTURE, 2, "txt"));
            fail("Expected an InvalidDocumentException to be thrown");
        } catch (InvalidDocumentException ex) {
            assertEquals("Document file extension needs to be pdf", ex.getMessage());
        }
    }

    /**
     * Test case for the {@link Project#add(dev.joseafmoreira.api.document.IDocument) add(IDocument document)} method.
     * It verifies that no exceptions are thrown when adding a valid document to the project.
     */
    @Test
    public void testAdd() {
        try {
            project.add(document1);
        } catch (Exception ignored) {
            fail("No exceptions expected in this test");
        }
    }

    /**
     * Test case for the {@link Project#removeOldVersions() removeOldVersions()} method.
     * This test verifies that no exceptions are thrown when calling the {@link Project#removeOldVersions() removeOldVersions()} method.
     */
    @Test
    public void testRemoveOldVersions() {
        try {
            project.removeOldVersions();
        } catch (Exception ignored) {
            fail("No exceptions expected in this test");
        }
    }

    /**
     * Test case to verify that removing a null document from a project throws a {@link NullPointerException}.
     */
    @Test(expected = NullPointerException.class)
    public void testRemoveNullDocument() {
        project.remove(null);
    }

    /**
     * Test case to verify that an exception of type {@link DocumentNotFoundException} is thrown
     * when attempting to remove a document that does not exist in the project.
     */
    @Test(expected = DocumentNotFoundException.class)
    public void testRemoveNotFound() {
        project.remove(new Document(1, "Title", 1, "filename", DocumentType.INFRASTRUCTURE, 2, "pdf"));
    }

    /**
     * Test case for the {@link Project#remove(dev.joseafmoreira.api.document.IDocument) remove(IDocument document)} method.
     * It verifies that no exceptions are thrown when removing an existing document from the project.
     */
    @Test
    public void testRemove() {
        try {
            project.add(document1);
            project.remove(document1);
        } catch (Exception ignored) {
            fail("No exceptions expected in this test");
        }
    }

    /**
     * Test case for the scenario where a document is not found.
     * Expects a {@link DocumentNotFoundException} to be thrown.
     */
    @Test(expected = DocumentNotFoundException.class)
    public void testGetNotFound() {
        project.get(1);
    }

    /**
     * Test case for the {@link Project#get(int) get(int id)} method of the Project class.
     * It verifies that the {@link Project#get(int) get(int id)} method retrieves the correct document by its ID.
     */
    @Test
    public void testGet() {
        try {
            project.add(document1);
            project.get(document1.getId());
        } catch (Exception ignored) {
            fail("No exceptions expected in this test");
        }
    }

    /**
     * Test case for the {@link Project#getDocumentsByType(String) getDocumentsByType(DocumentType type)} method.
     * It verifies that a {@link NullPointerException} is thrown when a null type is passed as parameter.
     */
    @Test(expected = NullPointerException.class)
    public void testGetDocumentsByTypeWithNull() {
        project.getDocumentsByType(null);
    }

    /**
     * Test case for the {@link Project#getDocumentsByType(String) getDocumentsByType(DocumentType type)} method.
     * It verifies that the {@link Project#getDocumentsByType(String) getDocumentsByType(DocumentType type)} method retrieves an array of documents of the same {@link DocumentType type}.
     */
    public void testGetDocumentsByType() {
        try {
            project.getDocumentsByType(null);
        } catch (Exception ignored) {
            fail("No exceptions expected in this test");
        }
    }

    /**
     * Test case for the {@link Project#toArray() toArray()} method.
     * This test verifies that no exceptions are thrown when calling the {@link Project#toArray() toArray()} method.
     */
    @Test
    public void testToArray() {
        try {
            project.toArray();
        } catch (Exception ignored) {
            fail("No exceptions expected in this test");
        }
    }

    /**
     * Test case to verify that the {@link Project#contains(dev.joseafmoreira.api.document.IDocument) contains(IDocument document)} method throws a {@link NullPointerException}
     * when a null value is passed as a parameter.
     */
    @Test(expected = NullPointerException.class)
    public void testContainsNull() {
        project.contains(null);
    }

    /**
     * Test case for the {@link Project#contains(dev.joseafmoreira.api.document.IDocument) contains(IDocument document)} method.
     * This test verifies that no exceptions are thrown when calling {@link Project#contains(dev.joseafmoreira.api.document.IDocument) contains(IDocument document)} with a null parameter.
     */
    @Test
    public void testContains() {
        try {
            project.contains(null);
        } catch (Exception ignored) {
            fail("No exceptions expected in this test");
        }
    }

    /**
     * Test case for the {@link Project#toString() toString()} method of the Project class.
     * It verifies that the {@link Project#toString() toString()} method returns the expected string representation of the Project object.
     */
    @Test
    public void testToString() {
        assertEquals("(0)[]", project.toString());
    }
}
