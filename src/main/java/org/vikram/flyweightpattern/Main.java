package org.vikram.flyweightpattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CharacterStyle {
    private final String font;
    private final int size;

    public CharacterStyle(String font, int size) {
        this.font = font;
        this.size = size;
    }

    // Getters
    public String getFont() { return font; }
    public int getSize() { return size; }
}

// Flyweight factory that manages character styles
class CharacterStyleFactory {
    private final Map<String, CharacterStyle> styles = new HashMap<>();

    public CharacterStyle getCharacterStyle(String font, int size) {
        // Create a key for the style combination
        String key = font + size;

        // Return existing style if it exists, otherwise create new one
        return styles.computeIfAbsent(key,
                k -> new CharacterStyle(font, size));
    }

    public int getStylesCount() {
        return styles.size();
    }
}

class TextCharacter {
    private final char symbol;              // Extrinsic state
    private final int position;             // Extrinsic state
    private final CharacterStyle style;     // Intrinsic state (shared)

    public TextCharacter(char symbol, int position, CharacterStyle style) {
        this.symbol = symbol;
        this.position = position;
        this.style = style;
    }

    public void render() {
        System.out.printf("Character '%c' at position %d with font %s, size %d ",
                symbol, position, style.getFont(), style.getSize());
    }
}

class Main{
    public static void main(String[] args) {
        CharacterStyleFactory styleFactory = new CharacterStyleFactory();
        List<TextCharacter> document = new ArrayList<>();

        // Create text with different styles
        CharacterStyle normalStyle = styleFactory.getCharacterStyle("Arial", 12);

        // Add characters to document
        String text = "Hello World!";
        for (int i = 0; i < text.length(); i++) {
            document.add(new TextCharacter(text.charAt(i), i, normalStyle));
        }

        // Render the document
        for (TextCharacter character : document) {
            character.render();
        }

        System.out.println("\nTotal unique styles created: " + styleFactory.getStylesCount());
    }
}