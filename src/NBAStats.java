/**
 *
 * @author Branden McInnis
 * @date 10/31/22
 *
 */

import java.text.DecimalFormat;
import java.util.*;

public class NBAStats {
    //creates the list
    private LinkedList<PlayerRecord> playerRecords;

    DecimalFormat numberFormat = new DecimalFormat("#.0");

    public NBAStats(LinkedList<PlayerRecord> playerRecordLinkedList) {
        playerRecords = playerRecordLinkedList;
    }


    public String mostPointsScored(){
        double mostPoints = 0.0;
        double gamesPlayed = 0.0;
        int index = 0;
        String playerName = "No player read";
        String teamName = "No team read";
        PlayerRecord record = playerRecords.getAt(index);

        while(index < playerRecords.size() - 1){

            if(record.getPointsScored() > mostPoints){

                mostPoints = record.getPointsScored();
                playerName = record.getPlayerName();
                gamesPlayed = record.getGamesPlayed();
                teamName = record.getTeamName();

            }

            index++;
            record = playerRecords.getAt(index);

        }
        return playerName + " | " + teamName + " | " +  numberFormat.format(mostPoints/gamesPlayed);
    }

    public String mostAssists(){
        System.out.println(playerRecords.size());
        double mostAssists = 0.0;
        double gamesPlayed = 0.0;
        int index = 0;


        String playerName = "No player read";
        String teamName = "No team read";

        PlayerRecord record = playerRecords.getAt(index);

        while(index < playerRecords.size() - 1){

            if(record.getAssists() > mostAssists){

                mostAssists = record.getAssists();
                playerName = record.getPlayerName();
                gamesPlayed = record.getGamesPlayed();
                teamName = record.getTeamName();

            }
                index++;
                record = playerRecords.getAt(index);

        }
        return playerName + " | " + teamName + " | " + numberFormat.format(mostAssists/gamesPlayed);
    }

    public String mostRebounds(){

        double mostRebounds = 0.0;
        double gamesPlayed = 0.0;
        int index = 0;


        String playerName = "No player read";
        String teamName = "No team read";

        PlayerRecord record = playerRecords.getAt(index);

        while(index < playerRecords.size() - 1){

            if(record.getRebounds() > mostRebounds && record.getPlayerName() != playerName){

                mostRebounds = record.getRebounds();
                playerName = record.getPlayerName();
                gamesPlayed = record.getGamesPlayed();
                teamName = record.getTeamName();

            }
                index++;
                record = playerRecords.getAt(index);

        }
        return playerName + " | " + teamName + " | " + numberFormat.format(mostRebounds/gamesPlayed);
    }

    public String mostSteals(){

        double mostSteals = 0.0;
        double gamesPlayed = 0.0;
        int index = 0;


        String playerName = "No player read";
        String teamName = "No team read";

        PlayerRecord record = playerRecords.getAt(index);

        while(index < playerRecords.size() - 1){

            if(record.getSteals() > mostSteals){

                mostSteals = record.getSteals();
                playerName = record.getPlayerName();
                gamesPlayed = record.getGamesPlayed();
                teamName = record.getTeamName();

            }

            index++;
            record = playerRecords.getAt(index);

        }
        return playerName + " | " + teamName + " | " + numberFormat.format(mostSteals/gamesPlayed);
    }

}
