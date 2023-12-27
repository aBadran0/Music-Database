/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.HeadlessException;


public class LoginForm extends javax.swing.JFrame {

    myDBCon dbCon;
    boolean validLogin = false;
    ResultSet rs;
    ResultSet rs2;


    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        this.setLocationRelativeTo(null); // center the login form in the screen 
        dbCon = new myDBCon();

//        try {
//            // read valid username accounts to compare 
//            rs = dbCon.executeStatement("SELECT username, password, userType FROM Users ");
//
//        } catch (SQLException e) {
//            javax.swing.JLabel label = new javax.swing.JLabel("SQL Error - Retreiving Login User accounts.");
//            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
//            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
//        }

    }

  
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login to JDBC GUI");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Username:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Password:");

        txtUsername.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Register or Login to SongSatchel");

        btnLogin.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        
        JButton btnNewButton = new JButton("Register");
        btnNewButton.setFont(new Font("Forte", Font.PLAIN, 24));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                String userType = "0";
                
                try {
                    // Check if the username already exists
                    if (isValidData() && !isDuplicate(txtUsername.getText().trim())) {
                        // Prepare the SQL statement
                    	String username = txtUsername.getText().trim();
                    	String password = new String(txtPassword.getPassword());
                    	int userType1 = 0; 

                    	String sqlu = "INSERT INTO Users (Username, Password, Usertype) VALUES ('" + username + "', '" + password + "' , '" + userType1 + "')";


                            // Execute the update
                        int result = dbCon.executePrepared(sqlu);         
                        if (result > 0) {
                                // Success
                                JOptionPane.showMessageDialog(null, "New User added successfully.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                                clearInputBoxes();
                            } else {
                                // Insert failed
                                JOptionPane.showMessageDialog(null, "Error adding new User: Insert failed.");
                            }
                        }
                     else {
                        JOptionPane.showMessageDialog(null, "Error adding new User: Invalid data or username already exists.");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error adding new User: " + e1.getMessage());
                }
            }
			private void clearInputBoxes() {
			        txtUsername.setText("");
			        txtPassword.setText("");
			 
				
			}

			private boolean isDuplicate(String trim) throws SQLException {
				boolean isduplicate = false;
		        //setting up the query to get all usernames from loginusers table
		        String stmtSQL = "SELECT Username FROM Users WHERE Username = '" + txtUsername.getText().trim() + "'";
		        rs = dbCon.executeStatement(stmtSQL);
		        // isBeforeFirst() returns false if there are no data in the resultset
		        isduplicate = rs.isBeforeFirst();
		        return isduplicate;
			}

			private boolean isValidData() {
				return true;
			}

			private boolean isValidPassword() {
				// TODO Auto-generated method stub
				return true;
			}

			private void clearErrorLabels() {
				// TODO Auto-generated method stub
				
			}
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(96)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel3)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(layout.createSequentialGroup()
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(jLabel1)
        								.addGap(49))
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(jLabel2)
        								.addGap(54)))
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(txtUsername)
        							.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
        						.addPreferredGap(ComponentPlacement.RELATED))
        					.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        						.addComponent(btnNewButton)
        						.addGap(18)
        						.addComponent(btnLogin)
        						.addPreferredGap(ComponentPlacement.RELATED))))
        			.addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel3)
        			.addGap(27)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:

        try {
        	String sql = "SELECT username, password, userType FROM Users WHERE username = ?";
        	String sql2 = "SELECT userType FROM Users WHERE username = ?";

        	PreparedStatement pstmt = dbCon.prepareStatement(sql);
        	pstmt.setString(1, txtUsername.getText().trim());
        	PreparedStatement pstmt1 = dbCon.prepareStatement(sql2);
        	pstmt1.setString(1, txtUsername.getText().trim());

        	
        	try(ResultSet rs = pstmt.executeQuery())
        			{ 
            	try(ResultSet rs1 = pstmt1.executeQuery()){
            		if (rs1.next() && rs1.getString("userType").equals("0")) {
    		            while (rs.next()) { // loop over the current login user accounts searching for a match 
    		                if (rs.getString("username").equals(txtUsername.getText().trim()) && rs.getString("password").equals(txtPassword.getText().trim())) {
    		                    // Valid Login User found
    		                    validLogin = true;
    		                    // create a new login user object and pass details to Menu form 
    		                    (new Menu(new LoginUser(rs.getString("Username"), rs.getString("Usertype")))).setVisible(true);
    		                    this.dispose(); // remove this login from from memory 
    		                }}}
    		            else {
        		            while (rs.next()) { // loop over the current login user accounts searching for a match 
        		                if (rs.getString("username").equals(txtUsername.getText().trim()) && rs.getString("password").equals(txtPassword.getText().trim())) {
        		                    // Valid Login User found
        		                    validLogin = true;
        		                    // create a new login user object and pass details to Menu form 
        		                    (new MenuAdmin(new LoginUser(rs.getString("Username"), rs.getString("Usertype")))).setVisible(true);
        		                    this.dispose(); // remove this login from from memory 
    		            	
    		            	
    		            }
    			}

        }
            		
            		
            	}
        				

            if (!validLogin) { // this mean Invalid credentials 
                javax.swing.JLabel label = new javax.swing.JLabel("Wrong username/password.");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
                txtUsername.setText("");
                txtPassword.setText("");
            }

        }} catch (SQLException e) { // this is an SQL error
            javax.swing.JLabel label = new javax.swing.JLabel("SQL Error - " + e.getMessage());
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    //GEN-LAST:event_btnLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JLabel lblPasswordError;
}