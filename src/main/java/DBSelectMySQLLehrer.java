package main.java;

import java.sql.*;
import java.util.*;

public class DBSelectMySQLLehrer {

    public String[][] holeDaten(){
        int columnindex = 0;
        int rowcounter = 0;

        Connection con = null;
        Statement stmt;
        ResultSet rs;
        String url = "jdbc:mysql://localhost/klassenbuecher";
        String user = "root";
        String password = "";

        String[][] returnds = null;
        //String Parameter ArrayList
        ArrayList<String> row = new ArrayList<>();

        try {
            //Verbindung zur Datenbank aufbauen. (Vorher noch den Treiber installieren für die Datenbank die man braucht.)
            con = DriverManager.getConnection(url, user, password);

            //Statement erzeugt über die Methode createStatement. Diese kann mann dann benutzen zum ausführen von SQL abfragen
            stmt = con.createStatement();

            //Gibt das Ergebnis der SQL Abfrage aus. Über das Statementobjekt führen wir ne Methode aus.
            rs = stmt.executeQuery("select * from lehrer");

            //Hiermit können wir mit der next() alle Datensätze ausgeben, diese interiert über alle Datensätze.
            while(rs.next()){
                try {
                    columnindex = 0;
                    //mit der schleife kann ich ne tabelle mit x spalten ausgeben
                    //for(int i = 1;; i++){
                        row.add(rs.getString(1));
                        row.add(rs.getString(2));
                        row.add(rs.getString(3));
                        //columnindex++;
                    //}
                } catch(Exception e){
                    System.out.println(e);
                }
            }
            //Objekte schließen
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        //Größe geteilt durch anzahl der Zeilen und anzahl der Spalten
        returnds = new String[row.size() / columnindex][columnindex];
        for (int i = 0; i < returnds.length; i++) {
            for (int j = 0; j < returnds[i].length; j++) {
                returnds[i][j] = row.get(rowcounter++);
            }
        }
        return returnds;
    }
}
