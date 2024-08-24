package dev.joseafmoreira;

import java.util.Arrays;

import dev.joseafmoreira.document.Document;
import dev.joseafmoreira.project.Project;
import pt.ipp.estg.fpoo.document.DocumentType;
import pt.ipp.estg.fpoo.document.IDocument;
import pt.ipp.estg.fpoo.project.IProject;

public class Main {
    public static void main(String[] args) {
        IProject project = new Project(2);
        IDocument document1v1 = new Document(1, "Document1", 1, "doc1", DocumentType.INFRASTRUCTURE, 2, "pdf"),
                  document1v2 = new Document(1, "Document1", 2, "doc1", DocumentType.INFRASTRUCTURE, 1, "pdf"),
                  document2v1 = new Document(2, "Document2", 1, "doc2", DocumentType.INFRASTRUCTURE, 1, "pdf");

        System.out.println("Initial project initialization");
        project.add(document1v1);
        project.add(document1v2);
        project.add(document2v1);
        System.out.println(project + "\n");

        System.out.println("Remove old versions");
        project.removeOldVersions();
        System.out.println(project + "\n");

        System.out.println("Get documents by type");
        System.out.println(Arrays.toString(project.getDocumentsByType(DocumentType.INFRASTRUCTURE)) + "\n");

        System.out.println("Remove a document and print result array");

        project.remove(document1v2);
        System.out.println(Arrays.toString(project.toArray()) + "\n");

        System.out.println("Get Document from project");
        System.out.println(project.get(2));
        System.out.println("Contains " + document2v1.getTitle() + "? " + project.contains(document2v1) + "\n");

        System.out.println("Clears project and prints result");
        project.clear();
        System.out.println(project);
    }
}
