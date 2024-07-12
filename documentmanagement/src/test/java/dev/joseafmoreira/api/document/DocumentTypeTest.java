package dev.joseafmoreira.api.document;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * <h2>
 * DocumentTypeTest
 * </h2>
 * <p>
 * The <code>DocumentTypeTest</code> class that tests the implementation of the {@link DocumentType DocumentType} enum.
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class DocumentTypeTest {
    /**
     * Test case for the {@link DocumentType#MACHINE} enum value.
     * It verifies that the {@link DocumentType#toString()} method returns the expected value.
     */
    @Test
    public void testMachine() {
        assertEquals("Machine", (DocumentType.MACHINE).toString());
    }

    /**
     * Test case for the {@link DocumentType#WORKER} enum value.
     * It verifies that the {@link DocumentType#toString()} method returns the expected value.
     */
    @Test
    public void testWorker() {
        assertEquals("Worker", (DocumentType.WORKER).toString());
    }

    /**
     * Test case for the {@link DocumentType#INFRASTRUCTURE} enum value.
     * It verifies that the {@link DocumentType#toString()} method returns the expected value.
     */
    @Test
    public void testInfrastructure() {
        assertEquals("Infrastructure", (DocumentType.INFRASTRUCTURE).toString());
    }
}
