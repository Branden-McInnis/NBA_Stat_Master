/**
 *
 * @author Branden McInnis
 * @date 10/31/22
 *
 */

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class NBAListDemo {

    public static void main(String[] args) throws IOException {
        //initializing scanner
        Scanner k = new Scanner(System.in);
        System.out.println("Enter the filename to read from: ");
        String filename = k.nextLine();

        LinkedList<PlayerRecord> playerRecordLinkedList = new LinkedList<>();


        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        inputFile.useDelimiter("<>");



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
        PlayerRecord prevPlayerRecord = null;


        while(inputFile.hasNext()){
            playerName = inputFile.next();

            Position = inputFile.next();
            teamName = inputFile.next();
            pointsScored = inputFile.nextDouble();
            Assists = inputFile.nextDouble();
            Rebounds = inputFile.nextDouble();
            steals = inputFile.nextDouble();
            gamesPlayed = inputFile.nextDouble();

            if(prevPlayerRecord != null && prevPlayerRecord.getPlayerName().equals(playerName)) {

                pointsScored += prevPlayerRecord.getPointsScored();
                Assists += prevPlayerRecord.getAssists();
                Rebounds += prevPlayerRecord.getRebounds();
                steals += prevPlayerRecord.getSteals();
                gamesPlayed += prevPlayerRecord.getGamesPlayed();

            }

            record = new PlayerRecord(playerName, Position, teamName, pointsScored, Assists, Rebounds, steals, gamesPlayed);
            playerRecordLinkedList.add(record);

            prevPlayerRecord = record;
            inputFile.nextLine();

        }
        NBAStats stats = new NBAStats(playerRecordLinkedList);

        inputFile.close();
        try {
            File answers =new File("player-stats-output.txt");
            FileWriter myWriter = new FileWriter(answers);
            PrintWriter myPrinter = new PrintWriter(myWriter);
            myPrinter.println("NBA Results Summary");
            myPrinter.println("\nPlayers with the highest amount of points and their team:");
            myPrinter.println(stats.mostPointsScored());
            myPrinter.println("\nPlayer with the highest amount of assists and their team:");
            myPrinter.println(stats.mostAssists());
            myPrinter.println("\nPlayers with the highest amount of rebounds and their team:");
            myPrinter.println(stats.mostRebounds());
            myPrinter.println("\nPlayer with the highest amount of assists and their team:");
            myPrinter.println(stats.mostSteals());
            myPrinter.close();
        }

        catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }




    }

}
