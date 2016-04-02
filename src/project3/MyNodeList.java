package project3;

/**
 * Created by Mike Plucker
 * Date: 4/1/2016
 * Class: CSCI 1933-12
 */
public class MyNodeList implements MyList {

    private Node head; //first node in the list (is set to null)
    private int count; //the number of objects filled in the NodeList (actual number of elements)


    //default constructor that creates an empty list of Node objects that has a header node only
    public MyNodeList(){
        head = new Node(0, null); //creates header node with no data
        count = 0; //sets or resets count
    }


    // Adds the given object to the end of the list
    // Returns false if the input is null, true otherwise.
    @Override
    public boolean add(Object o) {

        if(o != null){ //if object is not null

            //local variables
            Node temp = new Node(o, null);
            Node current = head;

            while(current.getNext() != null){ //crawl to the end of the list
                current = current.getNext(); //go to next node
            }
            current.setNext(temp); //"adds" the new node by telling the last node's next variable to point to the new node
            count++; //increment count (size of list increases one)
            return true; //object successfully added
        }
        System.out.println("\nAdd Error: Cannot add null object.");
        return false; //object isn't added
    }


    // Inserts the given object at the given index.
    // Shifts the element at the specified index and any subsequent elements (if any) towards the end of the list
    // So if you have a list of size n, you should be able to insert any object from indices 0 <= index < n.
    // The list should be able to grow if need be.
    // If an index is given not in the range 0 <= index < n, return false. If the given object is null, return false.
    @Override
    public boolean insert(int index, Object o) {

        if(index <= count && index > 0 && o != null){ //if index is not out of bounds and object is not null

            //local variables
            Node temp = new Node(o, null);
            Node current = head;

            for(int i = 1; i < index; i++){ //crawl to the index
                current = current.getNext(); //go to next node
            }
            temp.setNext(current.getNext()); //sets the next variable for the new node to point to what the current node's next variable is pointing to
            current.setNext(temp); //sets the next variable for the current node to point to the new node
            count++; //increment count (size of list increases one)
            return true; //object successfully inserted into NodeList
        }
        System.out.println("\nInsert Error: Invalid index or null object");
        return false; //object isn't inserted
    }


    // Clears all data from from the list.
    // In the Array implementation, set the underlying array to a new array of size 2.
    // In the Node implementation, set head.next to null.
    @Override
    public void clear() {

        //resets with new header node
        head = new Node(0, null); //creates header node with no data
        count = 0; //resets count
    }


    // If the given object is in the list, return true otherwise false. If the input object is null, also return false.
    @Override
    public boolean contains(Object o) {

        if(o != null){ //if object is not null

            //local variable
            Node current = head;

            while(current.getNext() != null){ //crawl to the end of the list
                current = current.getNext(); //go to next node
                if(current.getData().equals(o)){ //if any element in the list is equal to the object
                    return true; //list contains the object
                }
            }
        }
        return false; //NodeList doesn't contain object
    }


    // Returns the object at a given index. Returns null if index is out of bounds.
    @Override
    public Object get(int index) {

        if(index <= count && index > 0){ //if index is in bounds

            //local variable
            Node current = head.getNext();

            for(int i = 1; i < index; i++){ //crawl to the index
                current = current.getNext(); //go to next node
            }
            return current.getData(); //returns the object at the index
        }
        System.out.println("\nGet Error: Index is out of Bounds.");
        return null; //index is out of bounds
    }


    // Returns the index of the input object in the list. Return -1 if the object is not found or is null.
    @Override
    public int indexOf(Object o) {

        if(isEmpty()){ //checks if list is empty by calling isEmpty() method
            System.out.println("\nindexOf Error: The list is empty!");
            return -2;
        }
        else{
            if(o != null){ //if object is not null

                //local variables
                Node current = head;
                int index = 1;

                while(current.getNext() != null){ //crawl to the end of the list
                    current = current.getNext(); //go to next node

                    if(current.getData().equals(o)){ //if any element in the list is equal to the object
                        return index; //returns index of the object
                    }
                    index++; //increment index
                }
            }
            return -1; //object is not in list or is null
        }
    }


    // Returns true if the list is empty and false otherwise.
    @Override
    public boolean isEmpty() {

        if(count == 0){ //list is empty if there are no elements
            return true;
        }
        return false; //list is not empty
    }


    // Removes and returns object at the given index.
    @Override
    public Object remove(int index) {

        if(index <= count && index > 0){ //if index is in bounds

            //local variables
            Node current = head;
            Node temp = head.getNext();

            for(int i = 1; i < index; i++){ //crawl to the index
                current = current.getNext(); //go to next node
                temp = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            count--; //decrement count (size of list decreases one)
            return temp.getData(); //returns the object that was removed
        }
        System.out.println("\nRemove Error: Index is out of Bounds.");
        return null; //index is out of bounds
    }


    // Removes the first instance of the input object from the list.
    // Return true if successful and false if the object is not found.
    @Override
    public boolean remove(Object o) {

        //local variables
        int index = indexOf(o); //call indexOf() method to find the index of the first occurrence of the specified element in the list
        Node current = head;

        if(index > 0){ //if element is in the list
            for(int i = 1; i < index; i++){ //crawl to the index
                current = current.getNext(); //go to next node
            }
            current.setNext(current.getNext().getNext());
            count--; //decrement count (size of list decreases one)
            return true; //object is successfully removed
        }
        return false; //object is not removed
    }


    // Replaces the object at the given instance with the given object.
    // If the index is out of bounds or the object is null, do nothing.
    @Override
    public void set(int index, Object o) {

        if(index <= count && index > 0 && o != null){ //if index is in bounds and object is not null

            //local variable
            Node current = head;

            for(int i = 0; i < index; i++){ //crawl to the index
                current = current.getNext(); //go to next node
            }
            current.setData(o); //replaces data at the index with new data (o)
        }
        else{
            System.out.println("\nSet Error: Invalid index or null object.");
        }
    }


    // Returns the size of the list.
    @Override
    public int size() {
        return count; //returns the length of the list (the number of elements contained in the list)
    }


    //prints out LinkedList
    public void printNodeList(){

        //local variables
        Node current = head;
        int index = 0;

        //print out elements in NodeList
        System.out.println("\nIndex \tObject"); //header
        System.out.println("--------------");

        while(current != null){ //iterates over objects in list
            System.out.println("  " + index + "\t\t " + current.getData());
            current = current.getNext(); //go to next node
            index++;
        }
    }



    //tests MyNodeList class
    public static void main(String[] args) {

        MyNodeList nl = new MyNodeList(); //creates new NodeList


        System.out.println("List Size: " + nl.size());
        nl.printNodeList();

        System.out.println("\nNow adding Objects.");

        //add nodes to NodeList
        nl.add(new String("One"));
        nl.add(new String("Two"));
        nl.add(new String("Three"));
        nl.add(new String("Four"));
        nl.add(new String("Five"));
        nl.add(new String("Six"));
        nl.add(new String("Seven"));
        nl.add(new String("Eight"));
        nl.add(new String("Three"));

        System.out.println("\nObjects in NodeList are:");

        //print NodeList and size
        nl.printNodeList();
        System.out.println("\nList Size: " + nl.size());


        //test get() method
        System.out.println("\nElement at Index 4 = " + nl.get(4));


        //test contains() method
        System.out.println("\nChecking if the list contains 'Six':");
        if(nl.contains("Six")){
            System.out.println("Yes! The list does contain that object");
        }
        else{
            System.out.println("No! The list does Not contain that object");
        }


        //test indexOf() method
        System.out.println("\nThe first index of 'Three' is: " + nl.indexOf("Three"));


        //test remove(int index) method
        System.out.println("\nRemoving element at index 2: " + nl.remove(2));


        //print NodeList and size
        nl.printNodeList();
        System.out.println("\nList Size: " + nl.size());


        //test indexOf() method
        System.out.println("\nThe first index of 'Three' is: " + nl.indexOf("Three"));


        //test set() method
        System.out.println("\nReplace Object: 'Three' with 'Two'");
        nl.set(2, "Two");


        //print NodeList and size
        nl.printNodeList();
        System.out.println("\nList Size: " + nl.size());


        //test isEmpty() method
        System.out.println("\nChecking if NodeList is empty: ");
        if(nl.isEmpty()){
            System.out.println("Yes, the NodeList is empty");
        }
        else{
            System.out.println("No, the NodeList is not empty");
        }


        //test insert() method
        System.out.println("\nNow Insert 'Thirty' at element: '3'");
        nl.insert(3, "Thirty");


        //print NodeList and size
        nl.printNodeList();
        System.out.println("\nList Size: " + nl.size());


        //test indexOf() method
        System.out.println("\nThe first index of 'Three' is: " + nl.indexOf("Three"));


        //test remove(Object o) method
        System.out.println("\nRemoving 'Thirty' = " + nl.remove("Thirty"));


        //print NodeList and size
        nl.printNodeList();
        System.out.println("\nList Size: " + nl.size());


        //test clear() method
        System.out.println("\nNow Clearing NodeList!");
        nl.clear();


        //print NodeList and size
        nl.printNodeList();
        System.out.println("\nList Size: " + nl.size());


        //test isEmpty() method
        System.out.println("\nChecking if NodeList is empty: ");
        if(nl.isEmpty()){
            System.out.println("Yes, the NodeList is empty");
        }
        else{
            System.out.println("No, the NodeList is not empty");
        }
    }
}
