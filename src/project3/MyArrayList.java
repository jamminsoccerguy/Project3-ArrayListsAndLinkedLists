package project3;

//imports
import java.util.Arrays;

/**
 * Created by Mike Plucker
 * Date: 4/1/2016
 * Class: CSCI 1933-12
 */
public class MyArrayList implements MyList {

    //instance variables
    private final int INITIALARRAYSIZE = 2;
    private int count; //the number of objects filled in the ArrayList (actual number of elements)


    //declare array
    protected Object [] list;


    //default constructor that creates an array of Objects that has a size of 2
    public MyArrayList(){
        list = new Object[INITIALARRAYSIZE]; //creates new array of objects that has a size of 2
        count = 0; //sets or resets count
    }


    // Adds the given object to the end of the list
    // Returns false if the input is null, true otherwise.
    @Override
    public boolean add(Object o) {
        if(o != null){ //if object is not null
            if(list.length - count == 0){ //if array is full
                increaseArraySize(); //call method to double the array size
            }
            list[count++] = o; //adds the given object to the end of the list
            return true; //object successfully added
        }
        System.out.println("\nAdd Error: Cannot add null object.");
        return false; //object isn't added
    }


    //creates a new array that is twice the size and copies the objects from the old array to the new array
    protected void increaseArraySize(){
        list = Arrays.copyOf(list, list.length * 2 + 1); //makes a new array twice the size and copies the elements to it
    }


    // Inserts the given object at the given index.
    // Shifts the element at the specified index and any subsequent elements (if any) towards the end of the list
    // So if you have a list of size n, you should be able to insert any object from indices 0 <= index < n.
    // The list should be able to grow if need be.
    // If an index is given not in the range 0 <= index < n, return false. If the given object is null, return false.
    @Override
    public boolean insert(int index, Object o) {

        if(index <= count && index >= 0 && o != null){ //if index is not out of bounds and object is not null
            if(list.length - count == 0){ //if array is full
                increaseArraySize(); //call method to double the array size
            }
            for(int i = count; i > index; i--){ //iterates from the last element to the index
                list[i] = list[i - 1]; //shifts each element to the right
            }
            list[index] = o; //adds the object at the index
            count++; //increment count (size of array increases one)
            return true; //object successfully inserted into array
        }
        System.out.println("\nInsert Error: Invalid index or null object.");
        return false; //object isn't inserted
    }


    // Clears all data from from the list.
    // In the Array implementation, set the underlying array to a new array of size 2.
    // In the Node implementation, set head.next to null.
    @Override
    public void clear() {

        //resets with new array
        list = new Object[INITIALARRAYSIZE]; //creates new array of objects that has a size of 2
        count = 0; //resets count
    }


    // If the given object is in the list, return true otherwise false. If the input object is null, also return false.
    @Override
    public boolean contains(Object o) {

        if(o != null){ //if object is not null
            for(Object obj: list){ //iterates through elements in array
                if(obj.equals(o)){ //if any element is equal to the object
                    return true; //list contains the object
                }
            }
        }
        return false; //array doesn't contain object or object is null
    }


    // Returns the object at a given index. Returns null if index is out of bounds.
    @Override
    public Object get(int index) {

        if(index < count && index >= 0){ //if index is in bounds
            return list[index]; //returns the element at the specified position
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
                for(int i = 0; i < count; i++){ //iterates through elements in array
                    if(list[i].equals(o)){ //if any element is equal to the object
                        return i; //return that index
                    }
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

        if(index < count && index >= 0){ //if index is in bounds

            //local variable
            Object temp = list[index]; //saves object at that index in temp variable

            for(int i = index; i < count; i++){ //iterates from the index to the last element
                list[i] = list[i + 1]; //shifts each element to the left
                list[i + 1] = null; //removes right element after it's shifted left
            }
            count--; //decrement count (size of array decreases one)
            return temp; //returns the object that was removed
        }
        System.out.println("\nRemove Error: Index is out of Bounds.");
        return null; //index is out of bounds
    }


    // Removes the first instance of the input object from the list.
    // Return true if successful and false if the object is not found.
    @Override
    public boolean remove(Object o) {

        int index = indexOf(o); //call indexOf() method to find the index of the first occurrence of the specified element in the list

        if(index >= 0){ //if element is in the list

            for(int i = index; i < count; i++){ //iterates from the index to the last element
                list[i] = list[i + 1]; //shifts each element to the left
                list[i + 1] = null;  //removes right element after it's shifted left
            }
            count--; //decrement count (size of array decreases one)
            return true; //object is successfully removed
        }
        return false; //object is not removed
    }


    // Replaces the object at the given instance with the given object.
    // If the index is out of bounds or the object is null, do nothing.
    @Override
    public void set(int index, Object o) {

        if(index < count && index >= 0 && o != null){ //if index is in bounds and object is not null
            list[index] = o; //replaces the element at the specified position with the specified element
        }
        else{
            System.out.println("\nSet Error: Invalid Index or null object.");
        }
    }


    // Returns the size of the list.
    @Override
    public int size() {
        return count; //returns the length of the list (the number of elements contained in the list)
    }


    //prints out ArrayList
    public void printArrayList(){

        //print out elements in ArrayList
        System.out.println("\nIndex \tObject"); //header
        System.out.println("--------------");
        for(int i = 0; i < count; i++){ //iterates over objects in array
            System.out.println("  " + i + "\t\t " + get(i));
        }
    }



    //tests MyArrayList class
    public static void main(String[] args) {

        MyArrayList al = new MyArrayList(); //creates new ArrayList


        System.out.println("List Size: " + al.size());
        al.printArrayList();

        System.out.println("\nNow adding Objects.");

        //add elements to ArrayList
        al.add(new String("Zero"));
        al.add(new String("One"));
        al.add(new String("Two")); //array doubles in size to 4
        al.add(new String("Three"));
        al.add(new String("Four")); //array doubles in size to 8
        al.add(new String("Five"));

        al.add(new String("Six"));
        al.add(new String("Seven"));
        al.add(new String("Eight")); //array doubles in size to 16
        al.add(new String("Three"));


        System.out.println("\nObjects in ArrayList are:");

        //print ArrayList and size
        al.printArrayList();
        System.out.println("\nList Size: " + al.size());


        //test get() method
        System.out.println("\nElement at Index 4 = " + al.get(4));


        //test contains() method
        System.out.println("\nChecking if the list contains 'Six':");
        if(al.contains("Six")){
            System.out.println("Yes! The list does contain that object");
        }
        else{
            System.out.println("No! The list does Not contain that object");
        }


        //test indexOf() method
        System.out.println("\nThe first index of 'Three' is: " + al.indexOf("Three"));


        //test remove(int index) method
        System.out.println("\nRemoving element at index 2: " + al.remove(2));

        //print ArrayList and size
        al.printArrayList();
        System.out.println("\nList Size: " + al.size());


        //test indexOf() method
        System.out.println("\nThe first index of 'Three' is: " + al.indexOf("Three"));


        //test set() method
        System.out.println("\nReplace Object: 'Three' with 'Two'");
        al.set(2, "Two");

        //print ArrayList and size
        al.printArrayList();
        System.out.println("\nList Size: " + al.size());


        //test isEmpty() method
        System.out.println("\nChecking if ArrayList is empty: ");
        if(al.isEmpty()){
            System.out.println("Yes, the ArrayList is empty");
        }
        else{
            System.out.println("No, the ArrayList is not empty");
        }


        //test insert() method
        System.out.println("\nNow Insert 'Thirty' at element: '3'");
        al.insert(3, "Thirty");

        //print ArrayList and size
        al.printArrayList();
        System.out.println("\nList Size: " + al.size());

        //test indexOf() method
        System.out.println("\nThe first index of 'Three' is: " + al.indexOf("Three"));

        //test remove(Object o) method
        System.out.println("\nRemoving 'Thirty' = " + al.remove("Thirty"));

        //print ArrayList and size
        al.printArrayList();
        System.out.println("\nList Size: " + al.size());


        //test clear() method
        System.out.println("\nNow Clearing ArrayList!");
        al.clear();

        //print ArrayList and size
        al.printArrayList();
        System.out.println("\nList Size: " + al.size());


        //test isEmpty() method
        System.out.println("\nChecking if ArrayList is empty: ");
        if(al.isEmpty()){
            System.out.println("Yes, the ArrayList is empty");
        }
        else{
            System.out.println("No, the ArrayList is not empty");
        }
    }
}
