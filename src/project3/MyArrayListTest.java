package project3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mike Plucker
 * Date: 4/1/2016
 * Class: CSCI 1933-12
 */
public class MyArrayListTest {

    @Test
    public void addTest() {

        MyArrayList al = new MyArrayList(); //creates new ArrayList

        al.add("One");
        al.add("Two");
        al.add("Three");
        al.add("Four");
        al.add("Five");
        al.add("Six");

        //test null object
        al.add(null);

        Object[] array = new Object[] {"One", "Two", "Three", "Four", "Five", "Six", null, null, null, null, null};

        assertArrayEquals(" ", array, al.list);
    }


    @Test
    public void increaseArraySizeTest(){

        MyArrayList al = new MyArrayList(); //creates new ArrayList

        Object[] array = new Object[11];

        al.increaseArraySize(); //array length should be 5
        al.increaseArraySize(); //array length should be 11

        assertArrayEquals(" ", array, al.list);
    }


    @Test
    public void insertTest(){

        MyArrayList al = new MyArrayList(); //creates new ArrayList

        Object[] array = new Object[] {"One", "Two", "Three", null, null};

        al.insert(0, "One");
        al.insert(1, "Two");
        al.insert(2, "Three");

        //test invalid indices and null object
        al.insert(-1, "Four");
        al.insert(6, "Five");
        al.insert(3, null);

        assertArrayEquals(" ", array, al.list);
    }


    @Test
    public void clearTest(){

        MyArrayList al = new MyArrayList(); //creates new ArrayList

        Object[] array = new Object[] {"One", "Two"};
        Object[] array2 = new Object[2];

        //first add elements to ArrayList and compare to array
        al.add("One");
        al.add("Two");
        assertArrayEquals(" ", array, al.list);

        //then clear ArrayList and compare to array2
        al.clear();
        assertArrayEquals(" ", array2, al.list);
    }


    @Test
    public void containsTest(){

        MyArrayList al = new MyArrayList(); //creates new ArrayList

        al.add("One");
        al.add("Two");

        assertEquals(true, al.contains("One"));

        assertEquals(false, al.contains("Three"));

        assertEquals(false, al.contains(null)); //test null object
    }


    @Test
    public void getTest(){

        MyArrayList al = new MyArrayList(); //creates new ArrayList

        al.add("One");
        al.add("Two");
        al.add("Three");
        al.add("Four");

        assertEquals("One", al.get(0));
        assertEquals("Three", al.get(2));

        //test invalid indices
        assertEquals(null, al.get(-1));
        assertEquals(null, al.get(4));
    }


    @Test
    public void indexOfTest(){

        MyArrayList al = new MyArrayList(); //creates new ArrayList

        assertEquals(-2, al.indexOf("Three")); //test if list is empty

        al.add("One");
        al.add("Two");
        al.add("Three");
        al.add("Four");

        assertEquals(0, al.indexOf("One"));
        assertEquals(2, al.indexOf("Three"));

        //test null object and object not in list
        assertEquals(-1, al.indexOf(null));
        assertEquals(-1, al.indexOf("Five"));
    }


    @Test
    public void isEmptyTest(){

        MyArrayList al = new MyArrayList(); //creates new ArrayList

        assertEquals(true, al.isEmpty()); //test when ArrayList is empty

        //test when ArrayList isn't empty
        al.add("One");
        al.add("Two");
        assertEquals(false, al.isEmpty());
    }


    @Test
    public void removeByIndexTest(){

        MyArrayList al = new MyArrayList(); //creates new ArrayList

        Object[] array = new Object[] {"One", "Two", "Three", "Four", null};
        Object[] array2 = new Object[] {"One", "Two", "Three", null, null};

        //first add elements to ArrayList and compare to array
        al.add("One");
        al.add("Two");
        al.add("Three");
        al.add("Four");
        assertArrayEquals(" ", array, al.list);


        //test invalid indices
        assertEquals(null, al.remove(-1));
        assertEquals(null, al.remove(4));

        //then remove "Four" from ArrayList and compare to array2
        assertEquals("Four", al.remove(3));
        assertArrayEquals(" ", array2, al.list);

        assertEquals("One", al.remove(0));
    }


    @Test
    public void removeByObjectTest(){

        MyArrayList al = new MyArrayList(); //creates new ArrayList

        Object[] array = new Object[] {"One", "Two", "Three", "Four", null};
        Object[] array2 = new Object[] {"One", "Two", "Four", null, null};

        //first add elements to ArrayList and compare to array
        al.add("One");
        al.add("Two");
        al.add("Three");
        al.add("Four");
        assertArrayEquals(" ", array, al.list);

        //test null object and object not in list
        assertEquals(false, al.remove(null));
        assertEquals(false, al.remove("Five"));

        //then remove "Three" from ArrayList and compare to array2
        assertEquals(true, al.remove("Three"));
        assertArrayEquals(" ", array2, al.list);
    }


    @Test
    public void setTest(){

        MyArrayList al = new MyArrayList(); //creates new ArrayList

        Object[] array = new Object[] {"One", "Two", "Five", "Four", null};

        al.add("One");
        al.add("Two");
        al.add("Three");
        al.add("Four");

        //test invalid indices and null object
        al.set(-1, "Five");
        al.set(4, "Five");
        al.set(2, null);

        //then set "Five" at index 2 and compare to array
        al.set(2, "Five");
        assertArrayEquals(" ", array, al.list);
    }


    @Test
    public void sizeTest(){

        MyArrayList al = new MyArrayList(); //creates new ArrayList

        al.add("One");
        al.add("Two");
        al.add("Three");
        al.add("Four");

        assertEquals(4, al.size());
    }
}