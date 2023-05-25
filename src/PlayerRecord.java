/**
 *
 * @author Branden McInnis
 * @date 10/31/22
 *
 */

import java.util.*;
public class PlayerRecord {

    private String playerName;
    private String Position;
    private String teamName;
    private double pointsScored;
    private double Assists;
    private double rebounds;
    private double steals;
    private double fieldGoalPercentage;
    private double freeThrowPercentage;
    private double gamesPlayed;


    public PlayerRecord(String playerName, String Position, String teamName, double pointsScored, double Assists, double rebounds, double steals, double gamesPlayed){
        this.playerName = playerName;
        this.Position = Position;
        this.teamName = teamName;
        this.pointsScored = pointsScored;
        this.Assists = Assists;
        this. rebounds = rebounds;
        this.steals = steals;
        this.gamesPlayed = gamesPlayed;
    }


    @Override
    public String toString() {
        return "PlayerRecord{" +
                "playerName='" + playerName + '\'' +
                ", Position='" + Position + '\'' +
                ", teamName='" + teamName + '\'' +
                ", gamesPlayed=" + gamesPlayed +
                ", goalsScored=" + pointsScored +
                ", Assists=" + Assists +
                ", penaltiesMinutes=" + rebounds +
                ", shotsOnGoal=" + steals +
                ", gameWinningGoals=" + fieldGoalPercentage +
                '}';
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPosition(){
        return Position;
    }

    public String getTeamName() {
        return teamName;
    }

    public double getGamesPlayed() {
        return gamesPlayed;
    }

    public double getPointsScored() {
        return pointsScored;
    }

    public double getAssists() {
        return Assists;
    }

    public double getRebounds() {
        return rebounds;
    }

    public double getSteals() {
        return steals;
    }

    public double getFieldGoalPercentage() {
        return fieldGoalPercentage;
    }

    public double getFreeGoalPercentage(){
        return freeThrowPercentage;
    }

}
