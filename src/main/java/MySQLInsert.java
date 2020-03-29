package main.java;
import java.sql.*;

public class MySQLInsert {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt;
        ResultSet rs;
        String url = "jdbc:mysql://localhost/klassenbuecher";
        String user = "root";
        String password = "";
        try {
            //Verbindung zur Datenbank aufbauen. (Vorher noch den Treiber installieren für die Datenbank die man braucht.)
            con = DriverManager.getConnection(url, user, password);

            //Statement erzeugt über die Methode createStatement. Diese kann mann dann benutzen zum ausführen von SQL abfragen
            stmt = con.createStatement();

            //Insert
            //Mit executeUpdate kann man etwas eintragen in die Tabelle
            stmt.executeUpdate("INSERT into lehrer(lehrerVorname, lehrerNachname) VALUES('Heinz', 'Müller')");
            stmt.executeUpdate("INSERT into lehrer(lehrerVorname, lehrerNachname) VALUES('Karl', 'Gustav')");
            System.out.println("Insert ok");

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