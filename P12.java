
/*

Author Azim Mustufa Baldiwala 
Java Verison 1.8
Wampp Veriosn 3.2.6
JDBC driver version 5.6

*/


import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class P12 extends Frame implements ActionListener{

    Button insert;
    Button update;
    Button delete;

    TextField roll;
    TextField name;
    TextField branch;
    TextField cdiv;

    Label roll_;
    Label name_;
    Label branch_;
    Label class_div_;

    P12(){

        // Setting up the frame 
        super();        // calling constructor of frame class
        setVisible(true);   
        setSize(500,500);
        setLayout(null);
        setTitle("Student Registration");


        // Setting up labels and the text fields 
        roll_ = new Label("Enter Student id: ");
        roll_.setBounds(100, 100, 120, 30); // Giving positions of the label    
        add(roll_); // Adding element into the frame

        roll = new TextField();
        roll.setBounds(240, 100, 100, 30);
        add(roll); 
        

        name_ = new Label("Enter Student Name: ");
        name_.setBounds(100, 150, 120, 30);
        add(name_);

        name = new TextField();
        name.setBounds(240, 150, 100, 30);  
        add(name);

        branch_ = new Label("Enter Student Branch: ");
        branch_.setBounds(100, 200, 120, 30);
        add(branch_);

        branch = new TextField();
        branch.setBounds(240, 200, 100, 30);
        add(branch);

        class_div_ = new Label("Enter class details: ");
        class_div_.setBounds(100, 250, 120, 30);
        add(class_div_);

        cdiv = new TextField();
        cdiv.setBounds(240, 250, 100, 30);
        add(cdiv);

        insert = new Button("Insert");
        insert.setBounds(100, 300, 100, 30);
        add(insert);

        update = new Button("Update");
        update.setBounds(200, 300, 100, 30);
        add(update);

        delete = new Button("Delete");
        delete.setBounds(300, 300, 100, 30);
        add(delete);


        // Registering the buttons 

        insert.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
    }

    public void clearInputs(){

        roll.setText("");
        name.setText("");
        branch.setText("");
        cdiv.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        // Getting data from the Gui 

        String rolld = (String)roll.getText();
        String named = (String)name.getText();
        String branchd = (String)branch.getText();
        String cdivd = (String)cdiv.getText();

        // Database code
        Connection conn = null;
        Statement stmt = null;  

        try{
            Class.forName( "com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/studentdetails", "root", "");
            stmt = conn.createStatement();
            
        }
        catch(Exception se){
            se.printStackTrace();
        }

        // Working on the actions of the button.. (button event)

        if(ae.getSource() == insert){

            // Firing the query into the database 
            try {
                stmt.executeUpdate("insert into students values('"+ rolld + "', '"+ named +"', '"+ branchd+"', '"+ cdivd+"' ) ");
            } catch (Exception e) {
                e.printStackTrace();
            }

            clearInputs();
        }

        
        if(ae.getSource() == update){

             // Firing the query into the database 
             try {

                // Query pending
                //stmt.executeUpdate("insert into students values('"+ rolld + "', '"+ named +"', '"+ branchd+"', '"+ cdivd+"' ) ");
            } catch (Exception e) {
                e.printStackTrace();
            }

            clearInputs();
        }

        if(ae.getSource() == delete){
            
            // Firing the query into the database 
            try {
                stmt.executeUpdate("delete from students where roll='"+ rolld +"'");
            } catch (Exception e) {
                e.printStackTrace();
            }

            clearInputs();

        }


        try{
            if(conn!=null){
                conn.close();
            }
        }catch(Exception e){ 

            e.printStackTrace();
        }

        try{
            if(stmt!=null){
                stmt.close();
            }
        }catch(Exception s){ 

            s.printStackTrace();
        }


    }

    public static void main(String args[]){

        new P12();
    }
}