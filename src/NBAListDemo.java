/**
 *
 * @author Branden McInnis
 * @date 10/31/22
 *
 */

import java.io.*;
import java.util.Scanner;

public class NBAListDemo {

    public static void main(String[] args) throws IOException {
        //initializing scanner
        Scanner k = new Scanner(System.in);
        System.out.println("Enter the filename to read from: ");
        String filename = k.nextLine();

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        inputFile.useDelimiter("<>");
        NBAStats playerRecords = new NBAStats();
        String playerName;
        String Position;
        String teamName;
        double pointsScored;
        double Assists;
        double Rebounds;
        double steals;
        double fieldGoalPercentage;
        double freeThrowPercentage;
        double gamesPlayed;

        PlayerRecord record = null;

        while(inputFile.hasNext()){

            playerName = inputFile.next();
            Position = inputFile.next();
            teamName = inputFile.next();
            pointsScored = inputFile.nextDouble();
            Assists = inputFile.nextDouble();
            Rebounds = inputFile.nextDouble();
            steals = inputFile.nextDouble();
            gamesPlayed = inputFile.nextDouble();

            inputFile.nextLine();


            record = new PlayerRecord(playerName, Position, teamName, pointsScored, Assists, Rebounds, steals, gamesPlayed);
            playerRecords.add(record);


        }

        inputFile.close();
        try {
            File answers =new File("player-stats-output.txt");
            FileWriter myWriter = new FileWriter(answers);
            PrintWriter myPrinter = new PrintWriter(myWriter);
            myPrinter.println("NBA Results Summary");
            myPrinter.println("Players with highest points and their teams:");
            myPrinter.println(playerRecords.mostPoints());
            myPrinter.println("\nMost aggressive players, their teams and their positions:");
            myPrinter.println(playerRecords.mostPenaltyMinutes());
            myPrinter.println("\nMost valuable players and their teams:");
            myPrinter.println(playerRecords.mostGameWinningGoals());
            myPrinter.println("\nMost promising players and their teams:");
            myPrinter.println(playerRecords.mostShotsOnGoal());
            myPrinter.println("\nTeams that had the most number of penalty minutes:");
            myPrinter.println(playerRecords.teamMostPenalty());
            myPrinter.println("\nTeams that had the most number of game winning goals:");
            myPrinter.println(playerRecords.teamMostGoals());
            myPrinter.close();

        }

        catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }




    }

}
