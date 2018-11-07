package main.java;

import java.sql.*;

public class MySQLTabellenAnlegenLoeschen {

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt;
        ResultSet rs;
        String url = "jdbc:mysql://localhost/personen";
        String user = "root";
        String password = "";

        try {
            //Verbindung zur Datenbank aufbauen. (Vorher noch den Treiber installieren für die Datenbank die man braucht.)
            con = DriverManager.getConnection(url, user, password);

            //Statement erzeugt über die Methode createStatement. Diese kann mann dann benutzen zum ausführen von SQL abfragen
            stmt = con.createStatement();

            //Tabelle in DB löschen
            /*stmt.executeUpdate("DROP TABLE IF EXISTS personen;");
            System.out.println("Tabelle gelöscht");*/

            //Tabelle in DB anlegen
            String sql = "CREATE TABLE IF NOT EXISTS mitarbeiter (id int(11) NOT NULL, vorname varchar(20) NOT NULL, nachname varchar(20) NOT NULL, PRIMARY KEY (id))";
            stmt.executeUpdate(sql);
            System.out.println("Tabelle erstellt");

            //Tabelle leeren
            /*String sql2 = "TRUNCATE mitarbeiter";
            stmt.executeUpdate(sql2);
            System.out.println("Tabelle geleert");*/

            //Gibt das Ergebnis der SQL Abfrage aus. Über das Statementobjekt führen wir ne Methode aus.
            //Mit der Methode executeQuery gibt ein ResultSet zurück
            rs = stmt.executeQuery("select * from lehrer");

            //Hiermit können wir mit der next() alle Datensätze ausgeben, diese interiert über alle Datensätze. ResultSet Objekt wir dazu benötigt.
            while(rs.next()){
                try {
                    //mit der schleife kann ich ne tabelle mit x spalten ausgeben
                    for(int i = 1;; i++){
                        System.out.print(rs.getString(i) + "\t");
                    }
                } catch(Exception e){
                    System.out.println("");
                }
            }
            //Objekte schließen
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        //Hier muss die Verbindung geschlossen werdne in dem finally
        finally{
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("Fehler");
                }
            }
        }
    }
}
