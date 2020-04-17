# Inner-and-Abstract-Classes-and-Interfaces-

1. InterfaceTest: 

        (1) Create a simple interface (tip: name it Saveable or ISaveable). That interface allows an object to be saved to some sort of storage medium. (tip: use arraylist). The exact type of medium is not known to the interface (nor to the classes that implement it). The interface will just specify two methods, one to return an ArrayList of values to be saved and the other to populate the object's fields from an ArrayList (parameter).

        (2) Create a few sample classes that implement your Saveable interface (we've used the idea of a game, with Players and Monsters, but you can create any type of classes that you want). Override the toString() method for each of your classes so that they can be easily printed to enable the program to be tested easier.

        (3) In Main, write a method that takes an object that implements the interface as a parameter and "saves" the values e.g. calls the method defined in the interface. We haven't covered I/O yet, so your method should just print the values to the screen. Also in the Main class, write a method that restores the values to a Saveable object e.g. calls the method from the interface for populating fields (see above). Again, we are not going to use Java file I/O; instead use the readValues() method below to simulate getting values from a file – this allows you to type as many values as your class requires, and returns an ArrayList.
 
2. InnerClassTest: 

        (1) Modify the playlist challenge so that the Album class uses an inner class. Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList  The inner SongList class will use an ArrayList and will provide a method to add a song.
 
        (2) It will also provide findSong() methods which will be used by the containing Album class to add songs to the playlist. Neither the Song class or the Main class should be changed.
        
