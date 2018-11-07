package main.java;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

public class DBAnzeigeTabelleGUI {

    private JTable jTable;
    private JFrame jFrame;
    DBSelectMySQLLehrer db = new DBSelectMySQLLehrer();

    public DBAnzeigeTabelleGUI() {

        jFrame = new JFrame();
        jFrame.setSize(300, 400);

        try {
            jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                TableModel jTable1Model = new DefaultTableModel(db.holeDaten(),
                        new String[] { "ID", "Vorname", "Nachname" });
                jTable = new JTable();
                jFrame.getContentPane().add(jTable, BorderLayout.CENTER);
                jTable.setModel(jTable1Model);


        } catch(Exception e){

        }

        jFrame.add(jTable);
        jFrame.setVisible(true);
    }
    public static void main(String[] args){
        new DBAnzeigeTabelleGUI();
    }
}
