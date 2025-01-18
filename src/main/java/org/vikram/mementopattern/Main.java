package org.vikram.mementopattern;

import java.util.ArrayList;
import java.util.List;

// Memento -> Stores state of text editor
class TextEditorMemento{
    private final String content;
    private final int cursorPosition;

    public TextEditorMemento(String content, int cursorPosition) {
        this.content = content;
        this.cursorPosition = cursorPosition;
    }

    public String getContent() {
        return content;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }
}

// Originator -> The texteditor whose state we have to keep track of
class TextEditor{
    private String content;
    private int cursorPosition;

    public TextEditor() {
        this.content="";
        this.cursorPosition=0;
    }

    // Create memento
    public TextEditorMemento createMemento(){
        return new TextEditorMemento(content, cursorPosition);
    }

    // Restore state from memento
    public void restore(TextEditorMemento textEditorMemento){
        this.content = textEditorMemento.getContent();
        this.cursorPosition = textEditorMemento.getCursorPosition();
    }

    // Editor operations -> Not related to memento
    public void type(String text) {
        String beforeCursor = content.substring(0, cursorPosition);
        String afterCursor = content.substring(cursorPosition);
        this.content = beforeCursor + text + afterCursor;
        this.cursorPosition += text.length();
    }

    public void delete() {
        if (cursorPosition > 0) {
            String beforeCursor = content.substring(0, cursorPosition - 1);
            String afterCursor = content.substring(cursorPosition);
            this.content = beforeCursor + afterCursor;
            this.cursorPosition--;
        }
    }

    public void moveCursor(int position) {
        if (position >= 0 && position <= content.length()) {
            this.cursorPosition = position;
        }
    }

    public String getContent() {
        return content;
    }
}

// Caretaker -> Manages history ie list of memento
class TextEditorHistory{
    private final TextEditor textEditor;
    private final List<TextEditorMemento> history;
    private int currentIndex;

    public TextEditorHistory(TextEditor textEditor) {
        this.textEditor = textEditor;
        this.history = new ArrayList<>();
        this.currentIndex = -1;
    }

    public void backup(){
        // remove any redoable states
        while(history.size() > currentIndex + 1){
            history.remove(history.size() - 1);
        }

        history.add(textEditor.createMemento());
        currentIndex++;
    }

    public void undo() {
        if (currentIndex > 0) {
            currentIndex--;
            TextEditorMemento memento = history.get(currentIndex);
            textEditor.restore(memento);
        }
    }

    public void redo() {
        if (currentIndex < history.size() - 1) {
            currentIndex++;
            TextEditorMemento memento = history.get(currentIndex);
            textEditor.restore(memento);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        TextEditorHistory history = new TextEditorHistory(editor);

        // Type some text and save state
        editor.type("Hello ");
        history.backup();
        System.out.println("After typing 'Hello ': " + editor.getContent());

        // Type more text and save state
        editor.type("World!");
        history.backup();
        System.out.println("After typing 'World!': " + editor.getContent());

        // Delete some text and save state
        editor.moveCursor(5);
        editor.delete();
        history.backup();
        System.out.println("After deleting at position 5: " + editor.getContent());

        // Undo the delete
        history.undo();
        System.out.println("After undo: " + editor.getContent());

        // Undo again to get back to first state
        history.undo();
        System.out.println("After second undo: " + editor.getContent());

        // Redo to get back to 'Hello World!'
        history.redo();
        System.out.println("After redo: " + editor.getContent());
    }
}

/*
Redo:
Consider this sequence of actions in a text editor:

Type "Hello" (State A)
Type "World" (State B)
Type "!" (State C)
Undo twice to get back to "Hello" (State A)

At this point, the history looks like this:
CopyHistory: [State A, State B, State C]
currentIndex: 0 (pointing to State A)
Now, if the user types something new, say "There" (creating State D), we need to:

Remove States B and C because they are no longer valid for redo
Add the new State D

Without the cleanup code:
CopyHistory: [State A, State B, State C, State D]  // Wrong! B and C are no longer valid
With the cleanup code:
CopyHistory: [State A, State D]  // Correct! Old alternative states are remove
 */