package org.vikram.iteratordesignpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

class Song {
    private final String title;
    private final String artist;
    private final int duration;
    private final boolean isFavorite;

    public Song(String title, String artist, int duration, boolean isFavorite) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.isFavorite = isFavorite;
    }

    // Getters
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getDuration() { return duration; }
    public boolean isFavorite() { return isFavorite; }
}
interface PlaylistIterator{
    boolean hasNext();
    Song next();
}

class Playlist{
    private final List<Song> songs;

    public Playlist() {
        songs = new ArrayList<>();
    }

    public void addSongToPlaylist(Song song){
        songs.add(song);
    }

    public PlaylistIterator getNormalIterator() {
        return new NormalIterator();
    }

    public PlaylistIterator getFavoritesIterator() {
        return new FavoritesIterator();
    }

    private class NormalIterator implements PlaylistIterator{
        private int currentIndex=0;
        @Override
        public boolean hasNext() {
            return currentIndex < songs.size();
        }

        @Override
        public Song next() {
            if(hasNext()){
                return songs.get(currentIndex++);
            }
            throw new NoSuchElementException();
        }
    }

    private class FavoritesIterator implements PlaylistIterator {
        private final List<Song> favoriteSongs;
        private int currentIndex = 0;

        public FavoritesIterator() {
            favoriteSongs = songs.stream()
                    .filter(Song::isFavorite)
                    .collect(Collectors.toList());
        }

        @Override
        public boolean hasNext() {
            return currentIndex < favoriteSongs.size();
        }

        @Override
        public Song next() {
            if (hasNext()) {
                return favoriteSongs.get(currentIndex++);
            }
            throw new NoSuchElementException();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addSongToPlaylist(new Song("Shape of You", "Ed Sheeran", 235, true));
        playlist.addSongToPlaylist(new Song("Blinding Lights", "The Weeknd", 200, true));
        playlist.addSongToPlaylist(new Song("Dance Monkey", "Tones and I", 210, false));
        playlist.addSongToPlaylist(new Song("Someone Like You", "Adele", 285, true));

        System.out.println("Normal Playback:");
        PlaylistIterator normalIterator = playlist.getNormalIterator();
        while (normalIterator.hasNext()) {
            Song song = normalIterator.next();
            System.out.println(song.getTitle() + " - " + song.getArtist());
        }

        System.out.println("\nFavorites Playback:");
        PlaylistIterator favoritesIterator = playlist.getFavoritesIterator();
        while (favoritesIterator.hasNext()) {
            Song song = favoritesIterator.next();
            System.out.println(song.getTitle() + " - " + song.getArtist());
        }
    }
}
