package project3;

/**
 * Created by Mike Plucker
 * Date: 4/1/2016
 * Class: CSCI 1933-12
 */
public class ContactLinkedList {

    //instance variable
    private int ptr; //holds the index of the most recent contact referenced

    MyNodeList list = new MyNodeList(); //creates new NodeList


    //constructor
    public ContactLinkedList(){
        ptr = -1; //NodeList is initially empty
    }


    //insert a new Contact into the ArrayList and return true if successful
    public boolean add(Contact contact){

        if(contact != null){ //if contact is not null
            list.add(contact); //adds the contact to the end of the NodeList
            ptr++; //move ptr ahead to next contact
            return true; //contact successfully added
        }
        System.out.println("\nError: Cannot add null contact.");
        return false; //contact isn't added
    }


    //removes the "current" contact pointed to and returns it
    public Contact remove(){

        if(list.isEmpty()){ //NodeList is empty
            System.out.println("\nNo contacts found in Contact List.");
            return null;
        }
        else{
            Contact current = (Contact)list.remove(ptr);
            ptr--; //move ptr back to previous contact
            return current;
        }
    }


    //returns the first contact found, relative to the current position in the NodeList...using the contains() method
    public Contact find(String name){

        //local variables
        Contact contact;
        String contactName;

        //search for a name match
        for(int i = 1; i <= list.size(); i++){ //iterates over contacts in list

            contact = (Contact)list.get(i);
            contactName = contact.getName();

            if(contactName.contains(name)){
                ptr = i; //sets ptr to the contact referenced
                return contact;
            }
        }
        return null; //no contact found
    }


    //returns the contact currently pointed to
    public Contact getCurrent(){

        if(list.isEmpty()){ //NodeList is empty
            System.out.println("\nNo contacts found in Contact List.");
            return null;
        }
        else{
            return (Contact)list.get(ptr); //return current contact
        }
    }


    //returns the contact at the location represented by int
    public Contact get(int index){

        if(list.isEmpty()){ //NodeList is empty
            System.out.println("\nNo contacts found in Contact List.");
            return null;
        }
        else{
            ptr = index; //sets ptr to index passed in thru parameter
            return (Contact)list.get(ptr); //returns contact at that index
        }
    }


    //moves ptr ahead to the next contact and returns the contact
    public Contact next(){

        if(list.isEmpty()){ //NodeList is empty
            System.out.println("\nNo contacts found in Contact List.");
            return null;
        }
        else if(ptr == list.size()){ //if ptr is at end of list
            ptr = 1; //set ptr to first contact
            return (Contact)list.get(ptr); //return first contact
        }
        else{
            ptr++; //move ptr ahead to next contact
            return (Contact)list.get(ptr); //return next contact
        }
    }


    //moves ptr back to the previous contact and returns the contact
    public Contact previous(){

        if(list.isEmpty()){ //NodeList is empty
            System.out.println("\nNo contacts found in Contact List.");
            return null;
        }
        else if(ptr == 1){ //if ptr is at the start of the list
            ptr = list.size(); //set ptr to the last contact
            return (Contact)list.get(ptr); //return last contact
        }
        else{
            ptr--; //move ptr back to previous contact
            return (Contact)list.get(ptr); //return previous contact
        }
    }


    //sorts the ContactList according to the name attribute (bubble sort)
    public void sort(){

        //local variables
        boolean finished = true; //determines when the sort is finished
        Contact firstContact, secondContact;

        while(finished){
            finished = false; //ends loop once all contacts are sorted

            for(int i = 1; i <= list.size() - 1; i++){ //iterates over contacts in list

                firstContact = (Contact)list.get(i); //gets object from NodeList and casts to a contact
                secondContact = (Contact)list.get(i + 1); //gets object from NodeList and casts to a contact

                //ascending sort
                if(firstContact.getName().compareToIgnoreCase(secondContact.getName()) > 0){ //if firstContact is greater than secondContact

                    //swap contacts
                    list.set(i, secondContact); //replaces firstContact with secondContact
                    list.set(i + 1, firstContact); //replaces secondContact with firstContact
                    finished = true; //goes to check next contact
                }
            }
        }
    }


    //inserts a Contact or NewContact into the contacts array in alphabetical order
    public boolean addInOrder(Contact contact){

        Contact compareContact;

        if(contact != null){
            for(int i = 1; i <= list.size(); i++){ //iterates over contacts in list

                compareContact = (Contact)list.get(i); //gets object from NodeList and casts to a contact

                if(compareContact.getName().compareToIgnoreCase(contact.getName()) < 0){ //if compareContact is less than contact
                    continue; //go to check next element
                }
                list.insert(i, contact); //inserts the contact at the index
                return true; //contact successfully added
            }
            add(contact); //adds contact to end of NodeList
            return true; //contact successfully added
        }
        return false; //contact isn't added
    }


    //prints out the contacts in the ArrayList to the console
    public void printToConsole(){

        for(int i = 1; i <= list.size(); i++){ //iterates over contacts in list
            Contact contact = (Contact)list.get(i); //gets object from ArrayList and casts to a contact
            System.out.println(contact); //prints the contacts to the console
        }
    }



    //tests ContactLinkedList class
    public static void main(String[] args) {

        ContactLinkedList nl = new ContactLinkedList();


        //create Contact objects
        Contact mike = new Contact("Mike", 8309991234L, "1234 Pleasent Street", "Cool dude");
        Contact greg = new Contact("Greg", 9521231234L, "1324 Main Street"); //no comments
        Contact allen = new Contact("Allen", 6123258594L); //no address or comments
        Contact bill = new Contact("Bill", 7639874343L, "14 Central Way", "Classmate"); //won't get added initially, because list will be full

        NewContact sarah = new NewContact("Sarah", 9528553242L, "125 Apache St", "Girlfriend", "sarahp@gmail.com", "UofM", "Peaches");
        NewContact catherine = new NewContact("Catherine", 6129871534L, "8342 Studio Ln", "", "cathyp@hotmail.com", "UofM", "Cathy"); //no comments
        NewContact ashley = new NewContact("Ashley", 7638984635L, "ahsleyp@gmail.com");


        System.out.println("The length of the Contact List is: " + nl.list.size() + "\n");
        nl.remove(); //tests remove method when there are no contacts (error message)


        System.out.println("\nNow adding Contacts.");

        //add contacts to Contact List
        nl.add(mike);
        nl.add(greg);
        nl.add(allen);
        nl.add(sarah);
        nl.add(catherine);
        nl.add(bill);
        nl.add(ashley);


        System.out.println("\nContacts in Contact List: ");
        nl.printToConsole();  //print out all contacts in list
        System.out.println("\nThe length of the Contact List is: " + nl.list.size());


        //test sort method
        System.out.println("\nContacts in List are now sorted alphabetically!");
        nl.sort(); //sort contacts alphabetically
        nl.printToConsole(); //print out all contacts in list
        System.out.println("\nThe length of the Contact List is: " + nl.list.size());


        //check whether Mike is found in the contact list or not (works!)
        String name1 = "Mike";
        Contact check1 = nl.find(name1); //test find method

        if(check1 != null){
            System.out.println("\nSearch Found: " + check1);
        }
        else{
            System.out.println("\n" + name1 + " is not found in the Contact List.");
        }


        //check whether Susan is found in the contact list or not (doesn't work!)
        String name2 = "Susan";
        Contact check2 = nl.find(name2); //test find method

        if(check2 != null){
            System.out.println("\nSearch Found: " + check2);
        }
        else{
            System.out.println("\n" + name2 + " is not found in the Contact List.");
        }


        //test remove method
        Contact removeContact2 = nl.remove(); //removes the last referenced contact (Mike) from ContactList
        System.out.println("\nRemoved Contact: " + removeContact2.getName());

        System.out.println("\nCurrent Contacts: ");
        nl.printToConsole();  //print out all contacts in list
        System.out.println("\nThe length of the Contact List is: " + nl.list.size());


        //re-add a contact
        System.out.println("\nAdded Contact: " + ashley.getName());
        nl.add(ashley);

        System.out.println("\nCurrent Contacts: ");
        nl.printToConsole();  //print out all contacts in list
        System.out.println("\nThe length of the Contact List is: " + nl.list.size());


        //test getCurrent() method
        System.out.println("\nThe Current contact is: " + nl.getCurrent()); //Sarah

        //test get() method
        System.out.println("\nThe First Contact is: " + nl.get(1)); //Allen
        System.out.println("\nThe 6th Contact is: " + nl.get(6)); //Sarah

        //test next() method
        System.out.println("\nThe next Contact is: " + nl.next()); //Ashley
        System.out.println("\nThe next Contact is: " + nl.next()); //Allen
        System.out.println("\nThe next Contact is: " + nl.next()); //Ashley

        //test previous() method
        System.out.println("\nThe previous Contact is: " + nl.previous()); //Allen
        System.out.println("\nThe previous Contact is: " + nl.previous()); //Ashley
        System.out.println("\nThe previous Contact is: " + nl.previous()); //Sarah


        //clear ArrayList
        System.out.println("\nClearing Contacts:");
        nl.list.clear();

        System.out.println("\nCurrent Contacts: ");
        nl.printToConsole();  //print out all contacts in list
        System.out.println("\nThe length of the Contact List is: " + nl.list.size());


        //test addInOrder method
        System.out.println("\nAdding Contacts In Order:");

        //add contacts to Contact List
        nl.addInOrder(mike);
        nl.addInOrder(allen);
        nl.addInOrder(sarah);
        nl.addInOrder(bill);
        nl.addInOrder(ashley);

        System.out.println("\nCurrent Contacts: ");
        nl.printToConsole();  //print out all contacts in list
        System.out.println("\nThe length of the Contact List is: " + nl.list.size());


        //adds the rest of the contacts in order
        System.out.println("\nAdding the rest of the contacts in order:");
        nl.addInOrder(greg);
        nl.addInOrder(catherine);

        System.out.println("\nCurrent Contacts: ");
        nl.printToConsole();  //print out all contacts in list
        System.out.println("\nThe length of the Contact List is: " + nl.list.size());
    }
}
