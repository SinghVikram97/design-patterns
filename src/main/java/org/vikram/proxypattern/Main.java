package org.vikram.proxypattern;

// Subject Interface
interface Document {
    void read();
    void write(String content);
}

// Real Subject
class RealDocument implements Document {
    private String content = "Initial Content";

    @Override
    public void read() {
        System.out.println("Reading Document: " + content);
    }

    @Override
    public void write(String content) {
        this.content = content;
        System.out.println("Document updated to: " + this.content);
    }
}

// Proxy - IS-A and HAS-A
class DocumentProxy implements Document {
    private RealDocument realDocument;
    private String userRole;

    public DocumentProxy(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public void read() {
        if (realDocument == null) {
            realDocument = new RealDocument();
        }
        realDocument.read();
    }

    @Override
    public void write(String content) {
        if (!userRole.equalsIgnoreCase("admin")) {
            System.out.println("Access denied. Only admins can write to the document.");
            return;
        }
        if (realDocument == null) {
            realDocument = new RealDocument();
        }
        realDocument.write(content);
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        Document adminDoc = new DocumentProxy("admin");
        Document userDoc = new DocumentProxy("user");

        System.out.println("Admin attempting to read and write:");
        adminDoc.read();
        adminDoc.write("Admin's Content");

        System.out.println("\nUser attempting to read and write:");
        userDoc.read();
        userDoc.write("User's Content");
    }
}
