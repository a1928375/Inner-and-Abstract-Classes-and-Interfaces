package com.company;

import java.util.ArrayList;

public class Album {

    private Song songs;

    private SongList myAlbum = new SongList();

    public boolean addSong (String title, double duration) {

        return myAlbum.addSong(new Song(title, duration));
    }

    public Song getSongs() {
        return songs;
    }

    public SongList getMyAlbum() {
        return myAlbum;
    }

    public class SongList {

        public ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        public boolean addSong (Song song) {

            if (songs.contains(song)) {

                return false;
            }

            songs.add(song);
            return true;
        }
    }

}