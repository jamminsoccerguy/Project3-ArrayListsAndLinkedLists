package project3;

/**
 * Created by Mike Plucker
 * Date: 3/8/2016
 * Class: CSCI 1933-12
 */
public class Node {

    //instance variables
    private Object data; //data carried by this node
    private Node next; //the next node in the data structure or null if there isn't one

    //constructors
    public Node(){

    }

    public Node(Object o) {
        data = o;
        next = null;
    }

    public Node(Object o, Node link){
        data = o;
        next = link;
    }

    //selectors
    public Object getData(){
        return data;
    }

    public void setData(Object o){
        data = o;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node link){
        next = link;
    }
}
