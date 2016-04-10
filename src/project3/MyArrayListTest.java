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


    @Test
    public void testAddNull() {
        MyList list = new MyArrayList();
        assertEquals(false,list.add(null));
    }

    @Test
    public void testAddGrowOnce() {
        MyList list = new MyArrayList();
        Puppy alice = new Puppy("Alice",5);
        Puppy batman = new Puppy("Batman",10);
        Puppy carlos = new Puppy("Carlos",15);
        assertTrue(list.add(alice));
        assertTrue(list.add(batman));
        assertTrue(list.add(carlos));
    }

    @Test
    public void testInsertMid() {
        MyList list = new MyArrayList();
        Puppy alice = new Puppy("Alice",5);
        Puppy batman = new Puppy("Batman",10);
        Puppy carlos = new Puppy("Carlos",15);
        Puppy draco = new Puppy("Draco",20);
        list.add(alice);
        list.add(batman);
        list.add(carlos);
        assertTrue(list.insert(2, draco));
    }

    @Test
    public void testClear() {
        MyList list = new MyArrayList();
        int rand = (int)(Math.random()*100)+20;
        for(int i = 0; i < rand; i++){
            list.add(new Puppy("p"+i,i));
        }
        list.clear();
        assertEquals(0,list.size());
    }

    @Test
    public void testContains() {
        MyList list = new MyArrayList();
        Puppy alice = new Puppy("Alice",5);
        Puppy batman = new Puppy("Batman",10);
        Puppy carlos = new Puppy("Carlos",15);
        list.add(alice);
        list.add(batman);
        list.add(carlos);
        assertTrue(list.contains(new Puppy(alice)));
        assertTrue(list.contains(new Puppy(batman)));
        assertTrue(list.contains(new Puppy(carlos)));
    }

    @Test
    public void testGet() {
        MyList list = new MyArrayList();
        Puppy p = new Puppy("Mal",10);
        list.add(p);
        assertNotNull(list.get(0));
        assertTrue((new Puppy(p)).equals(list.get(0)));
    }

    @Test
    public void testIndexOf() {
        MyList list = new MyArrayList();
        int rand = (int)(Math.random()*100)+20;
        Puppy[] puppyMill = new Puppy[rand];
        for(int i = 0; i < puppyMill.length; i++){
            puppyMill[i] = new Puppy("p"+i,i);
            list.add(new Puppy("p"+i,i));
        }
        int r = (int)(Math.random()*rand);
        assertEquals(r,list.indexOf(puppyMill[r]));
    }

    @Test
    public void testIsNotEmpty() {
        MyList list = new MyArrayList();
        list.add(new Puppy("pup",12));
        assertFalse(list.isEmpty());
    }

    @Test
    public void testRemoveIntEmpty() {
        MyList list = new MyArrayList();
        assertNull(list.remove(0));
    }

    @Test
    public void testRemoveObjectEmpty() {
        MyList list = new MyArrayList();
        Puppy p = new Puppy("Jayne",9001);
        assertFalse(list.remove(p));
    }

    @Test
    public void testSetSuccess() {
        MyList list = new MyArrayList();
        Puppy p = new Puppy("Jayne",9001);
        list.add(p);
        Puppy p3 = new Puppy("Kaylee",1337);
        Puppy p2 = (Puppy)list.get(0);
        list.set(0,p3);
        assertEquals(p3,list.get(0));
        assertNotEquals(p2,list.get(0));
    }

    @Test
    public void testSizeAddAndClear() {
        MyList list = new MyArrayList();
        int rand = (int)(Math.random()*100)+20;
        for(int i = 0; i < rand; i++){
            list.add(new Puppy("p"+i,i));
        }
        list.clear();
        assertEquals(0,list.size());
    }
}