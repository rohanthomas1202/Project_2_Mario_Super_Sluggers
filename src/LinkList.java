import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/*******************************
 ** Name    - Rohan Sam Thomas **
 ** UTDID   - RST170000        **
 ** Class   - CS2336           **
 ** Date    - 10/17/2019       **
 ** JDK     - 11               **
 ** IDE     - IntelliJ Idea    **
 ********************************/
// generic linked list
public class LinkList<E extends Comparable<E>> {

    // reference to head node
    private Node head;
    // keeping track of total number of nodes
    private int listCount;
    // using formatter to format BA and OB
    private NumberFormat formatter = new DecimalFormat("#0.000");


    // LinkedList constructor
    LinkList() {
        // creates a new empty list, so link head node to the first element
        // new node with no data
        head = new Node(null);
        listCount = 0;
    }

    // accessors and mutators
    public void setHead(Node<E> n) {
        head = n;
    }
    private Node getHead() {
        return head;
    }
    public void setListCount(int count) {
        listCount = count;
    }
    public int getListCounter() {
        return listCount;
    }

    // add function to add a new node at the end
    void add(Node data) {
        // initialize Node if its first element
        if (head == null) {
            head = (data);
        }
        Node current = head;
        // checking null pt error
        if (current != null) {

            // starting at the head node, crawl to the end of the list and then add element after last node
            while (current.getNext() != null) {
                current = current.getNext();
            }

            // the last node's "next" reference set to our new node
            current.setNext(data);
        }
        listCount++;
    }

    // recursive print function to print out the required values
    void recursive_print(String record, PrintWriter pw) {
        Node curr_head = head.getNext();
        // if we are printing batting average
        if (record.equals("BA")) {
            pw.print("BATTING AVERAGE");
            int counter = 0;
            double curr_value = 0;
            double next_value;
            boolean print = false;
            // go through linked list to get and set values,
            while (curr_head != null && counter < 3) {
                curr_value = ((Player) curr_head.getPayload()).calculate_BA();
                if (!print) {

                    //System.out.print("\n" + formatter.format(curr_value) + "\t");
                    pw.print("\n" + formatter.format(curr_value) + "\t");
                    print = true;
                }
                //System.out.print(((Player) curr_head.getPayload()).getName());
                pw.print(((Player) curr_head.getPayload()).getName().trim());
                // counter to keep track of number of names printed
                counter++;
                if (curr_head.getNext() != null) {
                    next_value = ((Player) curr_head.getNext().getPayload()).calculate_BA();
                    // print all values
                    if (curr_value != next_value) {
                        //counter++;
                        print = false;
                    }
                    else{
                        //System.out.print(" ");
                        if(counter == 3){
                            // if the next name has the same value and if the counter is at 3
                            counter--;
                        }
                        pw.print(", ");
                    }
                }
                // go to the next node in linked list
                curr_head = curr_head.getNext();
            }
        }
        if (record.equals("OB")) {
            pw.print("ON-BASE PERCENTAGE");
            int counter = 0;
            double curr_value;
            double next_value;
            boolean print = false;
            // go through the linked list
            while (curr_head != null && counter < 3) {
                curr_value = ((Player) curr_head.getPayload()).calculate_OB();
                if (!print) {

                    //System.out.print("\n" + formatter.format(curr_value) + "\t");
                    pw.print("\n" + formatter.format(curr_value) + "\t");
                    print = true;
                }
                //System.out.print(((Player) curr_head.getPayload()).getName());
                pw.print(((Player) curr_head.getPayload()).getName().trim());
                counter++;
                if (curr_head.getNext() != null) {
                    next_value = ((Player) curr_head.getNext().getPayload()).calculate_OB();
                    // print all values
                    if (curr_value != next_value) {
                        print = false;
                    } else {
                        //System.out.print(" ");
                        if(counter == 3){
                            counter--;
                        }
                        pw.print(", ");
                    }
                }
                curr_head = curr_head.getNext();
            }
        }
        // if printing values for hits
        if (record.equals("h")) {
            pw.print("HITS");
            int counter = 0;
            int curr_value;
            int next_value;
            boolean print = false;
            while (curr_head != null && counter < 3) {
                curr_value = ((Player) curr_head.getPayload()).gethits();
                if (!print) {
                    pw.print("\n" + (curr_value) + "\t");
                    print = true;
                }
                pw.print(((Player) curr_head.getPayload()).getName().trim());
                counter++;
                if (curr_head.getNext() != null) {
                    next_value = ((Player) curr_head.getNext().getPayload()).gethits();
                    // print all values
                    if (curr_value != next_value) {
                        print = false;
                    } else {if(counter == 3){
                        counter--;
                    }
                        pw.print(", ");
                    }
                }
                curr_head = curr_head.getNext();
            }
        }
        if (record.equals("w")) {
            pw.print("WALKS");
            int counter = 0;
            int curr_value;
            int next_value;
            boolean print = false;
            while (curr_head != null && counter < 3) {
                curr_value = ((Player) curr_head.getPayload()).getwalks();
                if (!print) {
                    pw.print("\n" + (curr_value) + "\t");
                    print = true;
                }
                pw.print(((Player) curr_head.getPayload()).getName().trim());
                counter++;
                if (curr_head.getNext() != null) {
                    next_value = ((Player) curr_head.getNext().getPayload()).getwalks();
                    // print all values
                    if (curr_value != next_value) {
                        print = false;
                    } else {if(counter == 3){
                        counter--;
                    }
                        pw.print(", ");
                    }
                }
                curr_head = curr_head.getNext();
            }
        }
        if (record.equals("s")) {
            pw.print("STRIKEOUTS");
            int counter = 0;
            int curr_value;
            int next_value;
            boolean print = false;
            while (curr_head != null && counter < 3) {
                curr_value = ((Player) curr_head.getPayload()).getstrikeouts();
                if (!print) {
                    pw.print("\n" + (curr_value) + "\t");
                    print = true;
                }
                pw.print(((Player) curr_head.getPayload()).getName().trim());
                counter++;
                if (curr_head.getNext() != null) {
                    next_value = ((Player) curr_head.getNext().getPayload()).getstrikeouts();
                    // print all values
                    if (curr_value != next_value) {
                        print = false;
                    } else {if(counter == 3){
                        counter--;
                    }
                        pw.print(", ");
                    }
                }
                curr_head = curr_head.getNext();
            }
        }
        if (record.equals("HBP")) {
            pw.print("HIT BY PITCH");
            int counter = 0;
            int curr_value;
            int next_value;
            boolean print = false;
            while (curr_head != null && counter < 3) {
                curr_value = ((Player) curr_head.getPayload()).getHBP();
                if (!print) {
                    pw.print("\n" + (curr_value) + "\t");
                    print = true;
                }
                pw.print(((Player) curr_head.getPayload()).getName().trim());
                counter++;
                if (curr_head.getNext() != null) {
                    next_value = ((Player) curr_head.getNext().getPayload()).getHBP();
                    // print all values
                    if (curr_value != next_value) {
                        print = false;
                    } else {
                        if(counter == 3){
                            counter--;
                        }
                        pw.print(", ");
                    }
                }
                curr_head = curr_head.getNext();
            }
        }





        pw.println();




    }

    // function to remove a node from the linked list
    // tested but not used
    Node remove(Node<E> n) {
        Node hold = null;

        if (head != null) {
            if (head.equals(n)) {
                hold = head;
                head = head.getNext();
                hold.setNext(null);
            } else {
                Node p = head;
                while (p.getNext() != null && !p.getNext().equals(n))
                    p = p.getNext();

                if (p.getNext() != null) {
                    hold = p.getNext();
                    p.setNext(hold.getNext());
                    hold.setNext(null);
                }
            }
        }
        return hold;
    }

    // overriding to string to print all of the player details
    @Override
    public String toString() {

        return null;
    }

    // function to print all the values in the linked list
    void printList(PrintWriter pw) {
        Node current = getHead();
        while (current != null) {
            if (current.getPayload() instanceof Player) {
                pw.print(current.getPayload().toString());

            }
            current = current.getNext();
        }
    }


    // function to find the node of a given name
    Node find_name(String name) {
        Node found = null;
        Node current = getHead();
        if (current.getPayload() != null) {
            if ((((Player) current.getPayload()).getName()).compareTo(name) == 0) {
                found = current;
            }
        }
        // iterate through the linked list to compare name
        while (current != null) {
            if (current.getPayload() instanceof Player) {

                String Str = (((Player) current.getPayload()).getName());
                if (Str.toLowerCase().compareTo((name).toLowerCase()) == 0) {
                    found = current;
                }
            }
            current = current.getNext();
        }
        return found;
    }

    // function to update an entire player inside a node
    void update_payload(Node node, int h, int w, int k, int hp, int out, int sacrifice) {
        if (node.getPayload() instanceof Player) {
            ((Player) node.getPayload()).hits_plus(h);
            ((Player) node.getPayload()).walks_plus(w);
            ((Player) node.getPayload()).strikeouts_plus(k);
            ((Player) node.getPayload()).HBP_plus(hp);
            ((Player) node.getPayload()).out_plus(out);
            ((Player) node.getPayload()).sacrifice_plus(sacrifice);
        }
    }

    // sort function to sort the linked list according to the given parameters
    void insertion_sort(String record) {
        Node curr_head;
        curr_head = head.getNext();
        // switch case to find the required value to sort the linked list based on
        switch (record) {
            // sort according to name
            case "name":
                while (curr_head != null) {
                    //curr = curr_head;
                    smallest_name(curr_head);

                    curr_head = curr_head.getNext();
                }
                break;
                // sort according to batting avg
            case "BA":
                while (curr_head != null) {
                    //curr = curr_head;
                    highest_BA(curr_head);

                    curr_head = curr_head.getNext();
                }
                break;
                // sort according to on base percent
            case "OB":
                while (curr_head != null) {
                    //curr = curr_head;
                    highest_OB(curr_head);
                    curr_head = curr_head.getNext();
                }
                break;
                // sort according to hits
            case "h":
                while (curr_head != null) {
                    //curr = curr_head;
                    highest_h(curr_head);
                    curr_head = curr_head.getNext();
                }
                break;
                // sort according to walks
            case "w":
                while (curr_head != null) {
                    //curr = curr_head;
                    highest_w(curr_head);
                    curr_head = curr_head.getNext();
                }
                break;
            case "s":
                while (curr_head != null) {
                    //curr = curr_head;
                    lowest_s(curr_head);
                    curr_head = curr_head.getNext();
                }
                break;
                // checking for HBP
            case "P":
                while (curr_head != null) {
                    //curr = curr_head;
                    highest_HBP(curr_head);
                    curr_head = curr_head.getNext();
                }
                break;
        }
    }

    // function to swap two given nodes
    private void swap(Node curr_head, Node curr) {
        Player temp = new Player();
        temp = (Player) curr.getPayload();
        curr.setPayload(curr_head.getPayload());
        curr_head.setPayload(temp);
    }

    // function to find the smallest name in the list
    private void smallest_name(Node curr_head) {
        String min = ((Player) curr_head.getPayload()).getName().trim();
        Node curr = curr_head;
        Node change = null;
        // itterate through the linked list to find the smallest name
        while (curr.getNext() != null) {
            String str = ((Player) curr.getNext().getPayload()).getName().trim();
            if ((str.toLowerCase()).compareTo(min.toLowerCase()) < 0) {
                min = str;
                change = curr.getNext();
            }
            curr = curr.getNext();
        }
        if (change != null)
            swap(curr_head, change);
    }

    // finding the highest Batting Average from the given linklist
    private void highest_BA(Node curr_head) {
        double max = ((Player) curr_head.getPayload()).calculate_BA();
        Node curr = curr_head;
        Node change = null;

        // iterate through the linked list to find the largest BA
        while (curr.getNext() != null) {
            double BA = ((Player) curr.getNext().getPayload()).calculate_BA();
            if (Double.compare(BA, max) > 0) {
                max = BA;
                change = curr.getNext();
            }
            curr = curr.getNext();
        }
        if (change != null)
            swap(curr_head, change);
    }

    // finding the highest On Base Percent from the given linklist
    private void highest_OB(Node curr_head) {
        double max = ((Player) curr_head.getPayload()).calculate_OB();
        Node curr = curr_head;
        Node change = null;

        // itterate through the linked list to find the lagest OB
        while (curr.getNext() != null) {
            double OB = ((Player) curr.getNext().getPayload()).calculate_OB();
            if (Double.compare(OB, max) > 0) {
                max = OB;
                change = curr.getNext();
            }
            curr = curr.getNext();
        }
        // swap if necessary
        if (change != null)
            swap(curr_head, change);
    }


    // finding the highest hits from the list of players from the given linklist
    private void highest_h(Node curr_head) {
        int max = ((Player) curr_head.getPayload()).gethits();
        Node curr = curr_head;
        Node change = null;


        // itterate through the linked list to find the highest hits
        while (curr.getNext() != null) {
            int hit = ((Player) curr.getNext().getPayload()).gethits();
            if (hit > max) {
                max = hit;
                change = curr.getNext();
            }
            curr = curr.getNext();
        }
        if (change != null)
            swap(curr_head, change);
    }

    // finding the highest walks from the given linklist
    private void highest_w(Node curr_head) {
        int max = ((Player) curr_head.getPayload()).getwalks();
        Node curr = curr_head;
        Node change = null;

        // itterate through the linked list to find the highest walks
        while (curr.getNext() != null) {
            int walks = ((Player) curr.getNext().getPayload()).getwalks();
            if (walks > max) {
                max = walks;
                change = curr.getNext();
            }
            curr = curr.getNext();
        }
        if (change != null)
            swap(curr_head, change);
    }

    // finding the highest Batting Average from the given linklist
    private void lowest_s(Node curr_head) {
        int min = ((Player) curr_head.getPayload()).getstrikeouts();
        Node curr = curr_head;
        Node change = null;


        // itterate through the linked list to find the smallest strikeouts
        while (curr.getNext() != null) {
            int sac = ((Player) curr.getNext().getPayload()).getstrikeouts();
            String str_name= ((Player) curr.getNext().getPayload()).getName().trim();
            String head_string = ((Player) curr_head.getNext().getPayload()).getName();
            if (min > sac) {
                min = sac;
                change = curr.getNext();
            }else if(sac == min && (str_name.compareTo(head_string) < 0)){
                //String HBP_name= ((Player) curr.getNext().getPayload()).getName();
                //String head_string = ((Player) curr_head.getNext().getPayload()).getName();
                change = curr.getNext();
            }
            curr = curr.getNext();
        }
        if (change != null)
            swap(curr_head, change);
    }

    // finding the highest Hits By P. from the given linklist
    private void highest_HBP(Node curr_head) {
        int max = ((Player) curr_head.getPayload()).getHBP();
        Node curr = curr_head;
        Node change = null;

        // itterate through the linked list to find the highest hbp
        while (curr.getNext() != null) {
            int HBP = ((Player) curr.getNext().getPayload()).getHBP();
            String HBP_name= ((Player) curr.getNext().getPayload()).getName().trim();
            String head_string = ((Player) curr_head.getPayload()).getName().trim();
            if (HBP > max) {
                max = HBP;
                change = curr.getNext();
            }else if(HBP == max && (HBP_name.compareTo(head_string) < 0)){
                //String HBP_name= ((Player) curr.getNext().getPayload()).getName();
                //String head_string = ((Player) curr_head.getNext().getPayload()).getName();
                change = curr.getNext();
            }
            curr = curr.getNext();
        }
        // swap nodes if necessary
        if (change != null)
            swap(curr_head, change);
    }
}