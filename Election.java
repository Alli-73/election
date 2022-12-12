import java.util.*;
import java.lang.String;
public class Election {
    /**
     * <h1> Election </h1>
     * <h3> This program simulates a U.S. presidential election in a small city of 20</h3>
     * @author  Alli Wang
     * @version 1.0
     * @since   2022-12-11
     */
    public static int i = 0;
    public static int donaldvote = 0;
    public static int bidenvote = 0;
    public String first;
    public String last;
    public static String input;
    private static String[] thirdpartyarray = new String[20];
    
     /**
     * <p>
     * This is the main method where one could cast a vote until the population limit is reached
     * It instantiates an Election object and calls the countVote method
     * When the loop is reached, it calls the static results class
     * @param  String[] args
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("This program simulates a U.S. presidential election.");
        for(int voterID = 1; voterID <= 5; voterID++) {
            System.out.println("Voter Number: "+voterID);
            System.out.println("Please cast your vote for Joe Biden, Donald Trump, or other(please list first and last name): ");
            String input = sc.nextLine();
            Election alli = new Election(input);
            alli.countVote();
        }
        results();
    }
    /**
     * <p>
     * This is the constructor class
     * @param input
     * input is parsed into a string array
     * the two elements of the string array are turned to lowercase
     */
    public Election(String input){
        this.input = input;
        String[] stringarray = input.split(" ");
        first = stringarray[0].toLowerCase();
        last = stringarray[1].toLowerCase();
    }
    
    /**
     * <p>
     * This is the results class.
     * This class is called after all "votes are cast"
     * This utilizes the static donaldvote and bidenvote variables to determine which candidate has the most votes and calls the countThird method to print out all write in ballots
     */
    public static void results(){
        /**
         * int g is made and equals i, or the number of cast in ballots
         * print out countThird until there are no more castin
         */
        int g = i;
        System.out.println("RESULTS ");
        while (g>0){
            System.out.println(countThird(g));
            g--;
        }
        System.out.println("Donald Trump: "+donaldvote+" Joe Biden: "+bidenvote);
        /**
         * if bidenvote is more than donaldvote, biden wins, else trump wins
         * otherwise it is a tie. utilize math.random to determine who wins
         */
        if(bidenvote > donaldvote){
            System.out.println("Biden wins!");
        } else if(bidenvote < donaldvote){
            System.out.println("Trump wins!");
        } else {
            System.out.println("Oops. It's a tie. Looks like we need an electoral college..");
            double electoralcollege = Math.random() - 0.5;
            if(electoralcollege > 0){
                System.out.println("Biden wins!");
            } else if(electoralcollege <= 0){
                System.out.println("Trump wins!");
            }
        }
    }
    /**
     * <p>
     * This is the countVote class.
     * This class validates all votes after the constructor is created
     * If the first object equals donald/joe and the last equals trump/biden, the instance variables are updated
     * otherwise, the input is put into a thirdpartyarray 
     */
    public void countVote(){
        if(first.equals("donald") && last.equals("trump")){ 
            donaldvote += 1;
        } else if(first.equals("joe") && last.equals("biden")){
            bidenvote += 1;
        } else {
            i++;
            thirdpartyarray[i] = input;
        }
    }
    
    /**
     * <p>
     * This is the countThird class
     * @param g (number of third party ballots)
     * @return String of the array element at index g
     */
    
    public static String countThird(int g){
        return "Write in ballot: "+thirdpartyarray[g];
    }
}
