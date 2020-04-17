package com.company;

/**
 * Created by dev on 11/10/2015.
 */
public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null) {
            // The list was empty, so this item becomes the head of the list
            this.root = newItem;
            System.out.println("k");
            return true;
        }
        ListItem currentItem = this.root;
        System.out.println("l");
        while(currentItem != null) {
            System.out.println("a");
            int comparison = (currentItem.compareTo(newItem));          //都是用currentItem 在做比較，也就是用root在做比較
            if(comparison <0) {
                System.out.println("b");
                // newItem is greater, move right if possible
                if(currentItem.next() != null) {
                    System.out.println("c");
                    currentItem = currentItem.next();
                } else {
                    // there is no next, so insert at end of list
                    System.out.println("d");
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            } else if(comparison >0) {
                System.out.println("e");
                // newItem is less, insert before
                if(currentItem.previous() != null) {                     //遞進的問題是由 line 35 - line 37 處理
                    System.out.println("f");
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                } else {
                    // the node with a previous is the root
                    System.out.println("g");
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
//                System.out.println("Comparison:  " + comparison);
                System.out.println("h");
                return true;
//                System.out.println("a");

            } else {
                // equal
                System.out.println("i");
                System.out.println(newItem.getValue() + " is already present, not added.");
                return false;
            }
        }
        System.out.println("j");
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item != null) {
            System.out.println("Deleting item " + item.getValue());
        }

        ListItem currentItem = this.root;
        while(currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if(comparison == 0) {
                // found the item to delete
                if(currentItem == this.root) {
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if(currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if(comparison <0) {
                currentItem = currentItem.next();
            } else { // comparison > 0
                // We are at an item greater than the one to be deleted
                // so the item is not in the list
                return false;
            }
        }

        // We have reached the end of the list
        // Without finding the item to delete
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }

    }
}
