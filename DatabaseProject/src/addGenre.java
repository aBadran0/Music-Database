

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;



public class addGenre extends javax.swing.JFrame {
    /**
     * Creates new form AddEmployee
     */
    myDBCon dbCon;
    ResultSet rs;

    public addGenre() {
        dbCon = new myDBCon();

        initComponents();     
        // center form in screen 
        this.setLocationRelativeTo(null);
        lblNameError.setVisible(false);
    }



    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Login User");
        setResizable(false);

                jLabel1 = new javax.swing.JLabel();

                        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
                        jLabel1.setText("Add Genre");
        lblName = new javax.swing.JLabel();

                lblName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
                lblName.setText("Genre Name:");
                txtName = new javax.swing.JTextField();

                        txtName.setFont(new java.awt.Font("Tahoma", 0, 18));
                lblNameError = new javax.swing.JLabel();

                        lblNameError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
                        lblNameError.setForeground(new java.awt.Color(255, 0, 0));
                        lblNameError.setText("error label");
                        btnAddNewEmp = new javax.swing.JButton();

                                btnAddNewEmp.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
                                btnAddNewEmp.setText("Add Genre");
                                btnAddNewEmp.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        btnAddNewEmpActionPerformed(evt);
                                    }
                                });
                                GroupLayout groupLayout = new GroupLayout(getContentPane());
                                groupLayout.setHorizontalGroup(
                                	groupLayout.createParallelGroup(Alignment.LEADING)
                                		.addGroup(groupLayout.createSequentialGroup()
                                			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                				.addGroup(groupLayout.createSequentialGroup()
                                					.addGap(30)
                                					.addComponent(lblName)
                                					.addGap(18)
                                					.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
                                					.addGap(18)
                                					.addComponent(lblNameError, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                                				.addGroup(groupLayout.createSequentialGroup()
                                					.addGap(194)
                                					.addComponent(btnAddNewEmp))
                                				.addGroup(groupLayout.createSequentialGroup()
                                					.addGap(176)
                                					.addComponent(jLabel1)))
                                			.addContainerGap(45, Short.MAX_VALUE))
                                );
                                groupLayout.setVerticalGroup(
                                	groupLayout.createParallelGroup(Alignment.LEADING)
                                		.addGroup(groupLayout.createSequentialGroup()
                                			.addComponent(jLabel1)
                                			.addGap(5)
                                			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                				.addComponent(lblName)
                                				.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                				.addComponent(lblNameError))
                                			.addGap(18)
                                			.addComponent(btnAddNewEmp)
                                			.addGap(17))
                                );
                                getContentPane().setLayout(groupLayout);

        pack();
    }

    void clearErrorLabels() {
        // erase error label text and set visibility to false 

        lblNameError.setText("");
        lblNameError.setVisible(false);   
    }

    boolean isValidData() {
        // check validity of all values entered //
       boolean result = true;
        if (txtName.getText().isEmpty() || (txtName.getText().length() > 50)) {
            if (txtName.getText().isEmpty()) {
                lblNameError.setText("Invalid. Genre name must not be empty.");
            } else if (txtName.getText().trim().length() > 9) {
                lblNameError.setText("Invalid. Genre name must be shorter than 50 characters.");
            }
            lblNameError.setVisible(true);
            result = false;
        }             
        return result;    
    }

    void clearInputBoxes() {
        // clear all text boxes and set the user type combo to the default value //
        txtName.setText("");

    }

    private void btnAddNewEmpActionPerformed(java.awt.event.ActionEvent evt) {                                             

     try{                  
        // verify input data//  

        boolean isduplicate = false;
        String namechk = txtName.getText();
        String dupecheck = "SELECT name FROM genres where name = '" + namechk +"'";

        rs = dbCon.executeStatement(dupecheck);
        // isBeforeFirst() returns false if there are no data in the resultset
        isduplicate = rs.isBeforeFirst();   

        if (isduplicate == false && isValidData() )
        {

        	 int lastGenre;      	
            	String sql1 ="SELECT genreid FROM genres ORDER BY genreid DESC fetch first 1 row only  ";
                rs = dbCon.executeStatement(sql1);
                if (rs.next()) {
                	lastGenre = rs.getInt("genreid");
                } 
                else
                	lastGenre = 0 ;           
                lastGenre = lastGenre +1;            //getting genre ID


            //insertion into sql table
            String prepSQL = "INSERT INTO Genres (genreID, name) VALUES ("                  
                    + lastGenre+","
                    +" '" + namechk + "')" ;         
            int result = dbCon.executePrepared(prepSQL);         
            if (result > 0) {

                javax.swing.JLabel label = new javax.swing.JLabel("New Genre added successfully.");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                clearInputBoxes();
            }

        }
        // verify that new user does not currently exist 
        // if all validations are successful then enter the new user
        else if (!isValidData()) {
             javax.swing.JLabel label = new javax.swing.JLabel("Please fix validation errors...");
             label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
             JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
         }   
        else {
            javax.swing.JLabel label = new javax.swing.JLabel("Genre already exists.");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.INFORMATION_MESSAGE);

        }
     }
     catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding new genre. Please contact the administrator.");
            e.printStackTrace();
 
     } 
    }                                            


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAddNewEmp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JTextField txtName;
    // End of variables declaration                   

}