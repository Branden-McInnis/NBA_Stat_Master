//All raw NBA Data taken from basketball-reference.com

import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraper {

    public static void main(String[] args) {
        // Define the URL of the webpage containing the player stats
        String url = "https://www.basketball-reference.com/leagues/NBA_2020_totals.html";

        try {
            // Send a GET request to the URL and retrieve the HTML content
            Document doc = Jsoup.connect(url).get();

            // Find the table that contains the player stats
            Element table = doc.selectFirst("table#totals_stats");

            // Open a FileWriter to write the stats to a .txt file
            FileWriter writer = new FileWriter("player-stats.txt");

            // Find the table body and iterate over the rows
            Elements rows = table.select("tbody > tr");
            for (Element row : rows) {
                // Skip the header rows with class="thead"
                if (row.hasClass("thead")) {
                    continue;
                }

                // Extract individual data fields from the row
                Element playerNameTd = row.selectFirst("td[data-stat='player']");
                String playerName = playerNameTd.text();
                String position = row.selectFirst("td[data-stat='pos']").text();
                String points = row.selectFirst("td[data-stat='pts']").text();
                String assists = row.selectFirst("td[data-stat='ast']").text();
                String rebounds = row.selectFirst("td[data-stat='trb']").text();
                String steals = row.selectFirst("td[data-stat='stl']").text();
                String gamesPlayed = row.selectFirst("td[data-stat='g']").text();



                // Extract team information (example code)
                Elements teamNameElements = row.select("td[data-stat='team_id'] > a");
                String teamName = teamNameElements.isEmpty() ? "none" : teamNameElements.get(0).text();

                // Write the player stats to the .txt file
                writer.write(" " + playerName);
                writer.write("<>" + position);
                writer.write("<>" + teamName);
                writer.write("<>" + points);
                writer.write("<>" + assists);
                writer.write("<>" + rebounds);
                writer.write("<>" + steals);
                writer.write("<>" + gamesPlayed +  "<>\n");
            }

            // Close the FileWriter
            writer.close();

            System.out.println("Player stats have been successfully scraped and saved to player-stats.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
