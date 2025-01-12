package org.vikram.compositepattern;

import java.util.ArrayList;
import java.util.List;

// Component
interface FileSystemComponent{
    void display();
    int getSize();
}

// Leaf node : File
class File implements FileSystemComponent{
    private final String name;
    private final int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println("File Name: "+name);
    }

    @Override
    public int getSize() {
        return size;
    }
}

// Composite
class Directory implements FileSystemComponent{
    private final List<FileSystemComponent> children;
    private final String name;

    public Directory(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addComponent(FileSystemComponent fileSystemComponent){
        children.add(fileSystemComponent);
    }

    @Override
    public void display() {
        System.out.println("Directory Name: "+name);
        children.forEach(FileSystemComponent::display);
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : children) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create root directory
        Directory root = new Directory("Root");

        // Create subdirectories
        Directory documents = new Directory("Documents");
        Directory pictures = new Directory("Pictures");

        // Create files
        File resume = new File("resume.pdf", 500);
        File notes = new File("notes.txt", 10);
        File photo1 = new File("vacation.jpg", 2000);
        File photo2 = new File("family.jpg", 1500);

        // Build directory structure
        documents.addComponent(resume);
        documents.addComponent(notes);

        pictures.addComponent(photo1);
        pictures.addComponent(photo2);

        root.addComponent(documents);
        root.addComponent(pictures);

        // Display entire file system
        root.display();
    }
}
