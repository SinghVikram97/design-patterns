package org.vikram.bridgedesignpattern;

// Abstraction
abstract class View{
    protected Resource resource; // Note: Protected

    public View(Resource resource) {
        this.resource = resource;
    }

    abstract void render();
}

// Implementor
interface Resource{
    void snippet();
}


// Concrete abstractions
class LongFormView extends View {

    public LongFormView(Resource resource) {
        super(resource);
    }

    @Override
    void render() {
        resource.snippet();
    }
}

class ShortFormView extends View {
    public ShortFormView(Resource resource) {
        super(resource);
    }

    @Override
    void render() {
        resource.snippet();
    }
}

// Concrete implementors
class SongResource implements Resource{
    private Song song;
    @Override
    public void snippet() {
        song.displaySong();
    }
}

class PodcastResource implements Resource{
    private final Podcast podcast;

    public PodcastResource(Podcast podcast) {
        this.podcast = podcast;
    }

    @Override
    public void snippet() {
        podcast.displaySong();
    }
}

class Song {
    public void displaySong(){
        System.out.println("Display song using its internal details");
    }
}

class Podcast {
    public void displaySong(){
        System.out.println("Display podcast using its internal details");
    }
}

public class Main {
    public static void main(String[] args) {
        View longFormView = new LongFormView(new PodcastResource(new Podcast()));

        longFormView.render();
    }
}
