/********************************
 ** Name    - Rohan Sam Thomas **
 ** UTDID   - RST170000        **
 ** Class   - CS2336           **
 ** Date    - 10/17/2019       **
 ** JDK     - 11               **
 ** IDE     - IntelliJ Idea    **
 ********************************/
// required directories
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        int count = 0;
        // input file
        Scanner fileName = new Scanner(System.in);              // to get file name from user
        // String inputFile;                                    // variable to hold file name
        File outFile = new File("leaders.txt");  // declaring output file
        // output file
        PrintWriter pw = new PrintWriter(outFile);
        // declaring input and output files
        File inFile = new File(fileName.nextLine());           // getting input file from user
        // linked list to store all player objects
        LinkList<Player> list_players = new LinkList<Player>();

        // opening input and output files
        Scanner in = null;                       // opening user entered file
        try {
            in = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }        // creates an output file if file not found

        // if the file exists
        if (inFile.canRead()) {
            assert in != null;
            while (in.hasNext()) {
                count++;

                // getInput();
                StringBuilder name = new StringBuilder(in.next());
                String record;
                if (in.hasNext()){
                    record = in.next();
                }else{
                    record = "A";
                }

                while(name.length() <= 10){
                    name.append(" ");
                }

                if (list_players.find_name(name.toString()) == null) {
                    // call the Linked List and store each player into it
                    Player p = new Player();
                    p.setName(name.toString());
                    p.sethits(count(record, 'H'));
                    p.setout(count(record, 'O'));
                    p.setstrikeouts(count(record, 'K'));
                    p.setwalks(count(record, 'W'));
                    p.setHBP(count(record, 'P'));
                    p.setsacrifice(count(record, 'S'));

                    // adding the player into the linked list
                    Node<Player> node = new Node<Player>(p);
                    list_players.add(node);

                } else {
                    // if there is an entry with the same entry name, merge them
                    int hits = count(record, 'H');           // H;
                    int walks = count(record, 'W');          // W;
                    int strikeouts = count(record, 'K');     // K;
                    int hit_by_pitch = count(record, 'P');   // P;
                    int out = count(record, 'O');            // O;
                    int sacrifice = count(record, 'S');
                    list_players.update_payload(list_players.find_name(name.toString()), hits, walks, strikeouts, hit_by_pitch, out, sacrifice);
                }

            }
            // closing input file
            in.close();
        }


        // sort names
        //System.out.println("SORT NAMES");
        list_players.insertion_sort("name");
        list_players.printList(pw);
        pw.println();

        pw.println("LEAGUE LEADERS");

        // sort BA
        //System.out.println("SORT BA");
        list_players.insertion_sort("BA");
        list_players.recursive_print("BA", pw);
        pw.println();
        list_players.insertion_sort("name");


        // sort OB
        //System.out.println("SORT OB");
        list_players.insertion_sort("OB");
        list_players.recursive_print("OB", pw);
        pw.println();
        list_players.insertion_sort("name");


        // sort Hits
        //System.out.println("SORT HITS");
        list_players.insertion_sort("h");
        list_players.recursive_print("h", pw);
        pw.println();
        list_players.insertion_sort("name");


        // sort walks
        //System.out.println("SORT WALKS");
        list_players.insertion_sort("w");
        list_players.recursive_print("w", pw);
        pw.println();
        list_players.insertion_sort("name");


        // sort strikeout
        //System.out.println("SORT STRIKEOUTS");

        list_players.insertion_sort("name");
        list_players.insertion_sort("s");
        list_players.recursive_print("s", pw);
        pw.println();
        list_players.insertion_sort("name");


        // sort HBP
        list_players.insertion_sort("name");
        list_players.insertion_sort("P");
        list_players.recursive_print("HBP", pw);
        list_players.insertion_sort("name");
        pw.println();

        // close output file
        pw.close();

        System.out.println("count: " + count);
    }


    // count number of each record
    private static int count(String record, char ch) {
        int count = 0;

        for (int i = 0; i < record.length(); i++) {
            if (record.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

}