package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static Album onceInARedMoon = new Album();
    private static Album winterMagic = new Album();
    private static LinkedList<Song> playList = new LinkedList<Song>();
    public static String temp;

    public static void main(String[] args) {

        onceInARedMoon.addSong("Awakening", 3.92);
        onceInARedMoon.addSong("You Raise Me Up", 5.07);
        onceInARedMoon.addSong("Silent Wings", 3.70);
        onceInARedMoon.addSong("Greenwaves", 4.75);
        onceInARedMoon.addSong("Invitation", 3.97);
        onceInARedMoon.addSong("Duo", 3.95);
        onceInARedMoon.addSong("Belonging", 3.97);
        onceInARedMoon.addSong("Gates of Dawn", 4.448);
        onceInARedMoon.addSong("The Promise", 3.33);
        onceInARedMoon.addSong("Fairytale", 3.45);
        onceInARedMoon.addSong("Once in a Red Moon", 5.02);
        onceInARedMoon.addSong("Elegie", 5.58);
//        onceInARedMoon.addSong("You Raise Me Up", 5.07);

        winterMagic.addSong("Little Road to Bethlehem", 2);
        winterMagic.addSong("Carol of the Bells", 2.25);
        winterMagic.addSong("Christmas Song", 2.5);
        winterMagic.addSong("Veni Veni Emmanuel", 2.75);
        winterMagic.addSong("Christmas Morning", 3);
        winterMagic.addSong("Sleigh Ride", 3.25);
        winterMagic.addSong("River", 3.5);
        winterMagic.addSong("Little Drummer Boy", 3.75);
        winterMagic.addSong("All with You", 4);
        winterMagic.addSong("Coventry Carol", 4.25);
        winterMagic.addSong("Winter's Dream", 4.5);

        addToList(onceInARedMoon, "You Raise Me Up");
        addToList(winterMagic, "Carol of the Bells");
        addToList(onceInARedMoon, "Gates of Dawn");
        addToList(winterMagic, "All with You");
        addToList(onceInARedMoon, "The Promise");
        addToList(winterMagic, "Winter's Dream");
//        addToList(onceInARedMoon, "You Raise Me Up");
//        addToList(new Album(), "aaa");

        Scanner scanner = new Scanner(System.in);

        boolean goingForward = true;

        boolean quit = false;

        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.isEmpty()) {

            System.out.println("No song in the playlist");

        } else {

            System.out.println("Now playing  " + listIterator.next().getTitle());

            menu();
        }

        while (!quit) {

            if (goingForward){

                if (listIterator.hasPrevious()) {

                    temp = listIterator.previous().getTitle();

                    listIterator.next();

                } else if (! listIterator.hasPrevious() && listIterator.hasNext()) {

                    temp = listIterator.next().getTitle();

                    listIterator.previous();

                } else {                                                                                                //deals with 0 element

                    System.out.println("No song left in this playlist");
                    temp = "None";

                }

            } else {

                if (listIterator.hasNext()) {

                    temp = listIterator.next().getTitle();

                    listIterator.previous();

                } else if (! listIterator.hasNext() && listIterator.hasPrevious()) {

                    temp = listIterator.previous().getTitle();
                    listIterator.next();

                } else {                                                                                                //deals with 0 element

                    System.out.println("No song left in this playlist");
                    temp = "None";
                }
            }

            System.out.println("\nPlease enter the choice: " + "    (Now playing " + temp + ")");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 0:
                    menu();
                    break;

                case 1:

                    if (!goingForward) {

                        if (listIterator.hasNext()) {

                            listIterator.next();
                        }

                        goingForward = true;
                    }

                    if (listIterator.hasNext()) {

                        System.out.println("Now playing  " + listIterator.next().getTitle());

                    } else {

                        System.out.println("Reached the end of the play list");
                        listIterator.previous();
                        goingForward = false;
                    }
                    break;

                case 2:

                    if (goingForward) {

                        if (listIterator.hasPrevious()) {

                            listIterator.previous();
                        }
                        goingForward = false;
                    }

                    if (listIterator.hasPrevious()) {

                        System.out.println("Now playing  " + listIterator.previous().getTitle());


                    } else {

                        System.out.println("At the start of the plat list");
                        listIterator.next();
                        goingForward = true;
                    }
                    break;

                case 3:

                    if (goingForward){

                        if (listIterator.hasPrevious()) {

                            System.out.println("Now playing  " + listIterator.previous().getTitle());
                            listIterator.next();

                        } else {

                            System.out.println("Now playing  " + listIterator.next().getTitle());
                            listIterator.previous();
                        }

                    } else {

                        if (listIterator.hasNext()) {

                            System.out.println("Now playing  " + listIterator.next().getTitle());
                            listIterator.previous();

                        } else {

                            System.out.println("Now playing  " + listIterator.previous().getTitle());
                            listIterator.next();
                        }
                    }

                    break;

                case 4:

                    if (playList.size() > 0) {

                        listIterator.remove();

                        System.out.println("The current song has been removed");

                    } else {

                        System.out.println("No song left in this playlist");
                    }

                    break;

                case 5:

                    Iterator<Song> iterator = playList.iterator();                                                        //不要用現有的listIterator => 再create一個新的iterator
                                                                                                                          //就不用考慮如何用迴圈，並且不用找原始 開頭
                                                                                                                          //不用考慮以下的old code

                    int i = 0;
                    while (iterator.hasNext()) {

                        i++;
                        System.out.println("The #" + i + " song in the playlist is " + iterator.next().getTitle());
                    }

                    break;

                case 6:
                    System.out.println("The playlist is finished");
                    quit = true;
                    break;
            }
        }

    }

    public static void menu () {

        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To skip forward to the next song.");
        System.out.println("\t 2 - To skip backward to the previous song.");
        System.out.println("\t 3 - To replay the current song.");
        System.out.println("\t 4 - To remove the current song from playlist.");
        System.out.println("\t 5 - To show the playlist.");
        System.out.println("\t 6 - To quit the mobile phone.");

        }

    public static boolean addToList (Album album, String title) {

        for (int i = 0; i < playList.size(); i++) {

            if (playList.get(i).getTitle().equals(title)) {

                System.out.println("The song exists in this playlist");
                return false;
            }
        }

        if (album.getMyAlbum().songs.isEmpty()) {

            System.out.println("Cannot find this album");
            return false;
        }

        for (int i = 0; i < album.getMyAlbum().songs.size(); i++) {

            if (album.getMyAlbum().songs.get(i).getTitle().equals(title)){

                playList.add(album.getMyAlbum().songs.get(i));
                return true;
            }
        }

        System.out.println("Cannot find the " + title + " in this album");
        return false;
    }
}
