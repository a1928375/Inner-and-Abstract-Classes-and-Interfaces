# Inner-and-Abstract-Classes-and-Interfaces-

1. InterfaceTest: 

        (1) Create a simple interface (tip: name it Saveable or ISaveable). That interface allows an object to be saved to some sort of storage medium. (tip: use arraylist). The exact type of medium is not known to the interface (nor to the classes that implement it). The interface will just specify two methods, one to return an ArrayList of values to be saved and the other to populate the object's fields from an ArrayList (parameter).

        (2) Create a few sample classes that implement your Saveable interface (we've used the idea of a game, with Players and Monsters, but you can create any type of classes that you want). Override the toString() method for each of your classes so that they can be easily printed to enable the program to be tested easier.

        (3) In Main, write a method that takes an object that implements the interface as a parameter and "saves" the values e.g. calls the method defined in the interface. We haven't covered I/O yet, so your method should just print the values to the screen. Also in the Main class, write a method that restores the values to a Saveable object e.g. calls the method from the interface for populating fields (see above). Again, we are not going to use Java file I/O; instead use the readValues() method below to simulate getting values from a file – this allows you to type as many values as your class requires, and returns an ArrayList.
 
2. InnerClassTest: 

        (1) Modify the playlist challenge so that the Album class uses an inner class. Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList  The inner SongList class will use an ArrayList and will provide a method to add a song.
 
        (2) It will also provide findSong() methods which will be used by the containing Album class to add songs to the playlist. Neither the Song class or the Main class should be changed.
        
3. AbstractClassTest: 

        (1) For this challenge, create an abstract class to define items that can be stored in a list. The class should contain 2 references to items which will represent the next and previous items (in the case of a linked list). I.e., if you call your abstract class ListItem, then it would have 2 member variables of type ListItem that will hold references to the next/right and previous/left ListItems.

        (2) The abstract class will also need to hold a value - try to be as flexible as possible when defining the type of this value. The class will also need methods to move to the next item and back to the previous item, and methods to set the next and previous items. You should also specify a compareTo() method that takes a parameter of the same type as the class and returns 0 if the values are equal, greater than zero if the value sorts greater than the parameter and less than zero if it sorts less than the parameter.

        (3) Create a concrete class from your abstract list item class and use this in a LinkedList class to implement a linked list that will add items in order (so that they are sorted alphabetically). Duplicate values are not added. Note that you are creating your own LinkedList class here, not using the built-in Java one..

        (4) The rules for adding an item to the linked list are:
      
                If the head of the list is null, make the head refer to the item to be added.
                
                If the item to be added is less than the current item in the list, add the item before the current item (i.e., make the previous item's "next" refer to the new item, and the new item's"next" refer to the current item).
                
                If the item to be added is greater than the current item, move onto the next item and compare again (if there is no next item then that is where the new item belongs).

                Care will be needed when inserting before the first item in the list (as it will not have a previous item).

                You will also need a method to remove an item from the list.

        (5) Hint: 
        
                (i) If you are creating classes with names such as List, LinkedList, Node etc, make sure that you create your classes before referring to them. In previous videos we have often referred to classes that we create later, but if you use names that IntelliJ recognises as Java classes (such as LinkedList) then it will create imports for them and possibly cause you problems later.
                
                (ii) to avoid typing loads of "addItem" lines, split a string into an array and create your list in a loop as in the example below.
                
                (iii) Create a string data array to avoid typing loads of addItem instructions: String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";

                        String[] data = stringData.split(" ");
                        for (String s : data) {
                        create new item with value set to the string s

    
        (6) Optional: create a class to use your concrete class to implement a Binary Search Tree:
                 
                 When adding items to a Binary Search Tree, if the item to be added is less than the current item then move to the left, if it is greater than the current item then move to the right.
                
                The new item is added when an attempt to move in the required direction would involve following anull reference.
                
                Once again, duplicates are not allowed.

