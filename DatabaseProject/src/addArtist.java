



import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class addArtist extends javax.swing.JFrame {
    /**
     * Creates new form AddEmployee
     */
    myDBCon dbCon;
    ResultSet rs;
   
    public addArtist() {
        dbCon = new myDBCon();
        initComponents();     
        // center form in screen 
        this.setLocationRelativeTo(null);
   
        // set all error labels to invisible
        lblAgeError.setVisible(false);
        lblNameError.setVisible(false);
        // populate the user type combo box
       cmbUserType.addItem("M");      
       cmbUserType.addItem("F");              
    }
    
    

    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Login User");
        setResizable(false);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{63, 60, 70, 0, 0, 143, 0, 0};
        gridBagLayout.rowHeights = new int[]{44, 28, 28, 30, 30, 43, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        
                jLabel1 = new javax.swing.JLabel();
                
                        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
                        jLabel1.setText("Add Artist");
                        GridBagConstraints gbc_jLabel1 = new GridBagConstraints();
                        gbc_jLabel1.anchor = GridBagConstraints.NORTH;
                        gbc_jLabel1.insets = new Insets(0, 0, 5, 5);
                        gbc_jLabel1.gridwidth = 2;
                        gbc_jLabel1.gridx = 3;
                        gbc_jLabel1.gridy = 0;
                        getContentPane().add(jLabel1, gbc_jLabel1);
        lblName = new javax.swing.JLabel();
        
                lblName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
                lblName.setText("Name:");
                GridBagConstraints gbc_lblName = new GridBagConstraints();
                gbc_lblName.anchor = GridBagConstraints.WEST;
                gbc_lblName.insets = new Insets(0, 0, 5, 5);
                gbc_lblName.gridx = 1;
                gbc_lblName.gridy = 1;
                getContentPane().add(lblName, gbc_lblName);
                txtName = new javax.swing.JTextField();
                
                        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                        GridBagConstraints gbc_txtName = new GridBagConstraints();
                        gbc_txtName.anchor = GridBagConstraints.NORTH;
                        gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
                        gbc_txtName.insets = new Insets(0, 0, 5, 5);
                        gbc_txtName.gridwidth = 2;
                        gbc_txtName.gridx = 2;
                        gbc_txtName.gridy = 1;
                        getContentPane().add(txtName, gbc_txtName);
                lblNameError = new javax.swing.JLabel();
                
                        lblNameError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
                        lblNameError.setForeground(new java.awt.Color(255, 0, 0));
                        lblNameError.setText("error label");
                        GridBagConstraints gbc_lblNameError = new GridBagConstraints();
                        gbc_lblNameError.fill = GridBagConstraints.HORIZONTAL;
                        gbc_lblNameError.insets = new Insets(0, 0, 5, 5);
                        gbc_lblNameError.gridx = 5;
                        gbc_lblNameError.gridy = 1;
                        getContentPane().add(lblNameError, gbc_lblNameError);
                lblAge = new javax.swing.JLabel();
                
                        lblAge.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
                        lblAge.setText("Age:");
                        GridBagConstraints gbc_lblAge = new GridBagConstraints();
                        gbc_lblAge.anchor = GridBagConstraints.EAST;
                        gbc_lblAge.insets = new Insets(0, 0, 5, 5);
                        gbc_lblAge.gridx = 1;
                        gbc_lblAge.gridy = 2;
                        getContentPane().add(lblAge, gbc_lblAge);
                txtAge = new javax.swing.JTextField();
                
                        txtAge.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                        GridBagConstraints gbc_txtAge = new GridBagConstraints();
                        gbc_txtAge.anchor = GridBagConstraints.NORTH;
                        gbc_txtAge.fill = GridBagConstraints.HORIZONTAL;
                        gbc_txtAge.insets = new Insets(0, 0, 5, 5);
                        gbc_txtAge.gridwidth = 2;
                        gbc_txtAge.gridx = 2;
                        gbc_txtAge.gridy = 2;
                        getContentPane().add(txtAge, gbc_txtAge);
                cmbUserType = new javax.swing.JComboBox<>();
                
                        cmbUserType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                        cmbUserType.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cmbUserTypeActionPerformed(evt);
                            }
                        });
                        lblAgeError = new javax.swing.JLabel();
                        
                                lblAgeError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
                                lblAgeError.setForeground(new java.awt.Color(255, 0, 0));
                                lblAgeError.setText("error label");
                                GridBagConstraints gbc_lblAgeError = new GridBagConstraints();
                                gbc_lblAgeError.fill = GridBagConstraints.HORIZONTAL;
                                gbc_lblAgeError.insets = new Insets(0, 0, 5, 5);
                                gbc_lblAgeError.gridx = 5;
                                gbc_lblAgeError.gridy = 2;
                                getContentPane().add(lblAgeError, gbc_lblAgeError);
                        lblSex = new javax.swing.JLabel();
                        
                                lblSex.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
                                lblSex.setText("Sex:");
                                GridBagConstraints gbc_lblSex = new GridBagConstraints();
                                gbc_lblSex.anchor = GridBagConstraints.NORTHEAST;
                                gbc_lblSex.insets = new Insets(0, 0, 5, 5);
                                gbc_lblSex.gridx = 1;
                                gbc_lblSex.gridy = 3;
                                getContentPane().add(lblSex, gbc_lblSex);
                        GridBagConstraints gbc_cmbUserType = new GridBagConstraints();
                        gbc_cmbUserType.anchor = GridBagConstraints.NORTH;
                        gbc_cmbUserType.fill = GridBagConstraints.HORIZONTAL;
                        gbc_cmbUserType.insets = new Insets(0, 0, 5, 5);
                        gbc_cmbUserType.gridx = 2;
                        gbc_cmbUserType.gridy = 3;
                        getContentPane().add(cmbUserType, gbc_cmbUserType);
                btnAddNewEmp = new javax.swing.JButton();
                
                        btnAddNewEmp.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
                        btnAddNewEmp.setText("Add Artist");
                        btnAddNewEmp.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAddNewEmpActionPerformed(evt);
                            }
                        });
                        GridBagConstraints gbc_btnAddNewEmp = new GridBagConstraints();
                        gbc_btnAddNewEmp.anchor = GridBagConstraints.NORTHWEST;
                        gbc_btnAddNewEmp.insets = new Insets(0, 0, 0, 5);
                        gbc_btnAddNewEmp.gridx = 3;
                        gbc_btnAddNewEmp.gridy = 5;
                        getContentPane().add(btnAddNewEmp, gbc_btnAddNewEmp);

        pack();
    }
    
    void clearErrorLabels() {
        // erase error label text and set visibility to false 
        lblAgeError.setText("");
        lblAgeError.setVisible(false);
        lblNameError.setText("");
        lblNameError.setVisible(false);   
    }
  
    boolean isValidData() {
        // check validity of all values entered //
       boolean result = true;
        if (txtName.getText().isEmpty() || (txtName.getText().length() > 50)) {
            if (txtName.getText().isEmpty()) {
                lblNameError.setText("Invalid. Artist Name be empty.");
            } else if (txtName.getText().length() > 50) {
                lblNameError.setText("Invalid. Artist name must be shorter than 50 characters.");
            }
            lblNameError.setVisible(true);
            result = false;
        	}
          if (txtAge.getText().trim().isEmpty()) {
                lblAgeError.setText("Invalid. Cannot be empty.");          
                lblAgeError.setVisible(true);
                result = false;
          		} 
          try { Double.parseDouble(txtAge.getText().trim());   }
          catch (NumberFormatException e) {
          	lblAgeError.setText("Please enter a numerical value here.");       
          	lblAgeError.setVisible(true);
          	return false;  
          }
        return result;    
    }

    void clearInputBoxes() {
        // clear all text boxes and set the user type combo to the default value //
        txtName.setText("");
        txtAge.setText("");
        cmbUserType.setSelectedIndex(0);
    }

    private void btnAddNewEmpActionPerformed(java.awt.event.ActionEvent evt) {                                             
 
     try{                  
        // verify input data//  
    	 
        boolean isduplicate = false;
        String namechk = txtName.getText();
        String dupecheck = "SELECT name FROM artist WHERE name = '" + namechk +"'";
        
        rs = dbCon.executeStatement(dupecheck);
        // isBeforeFirst() returns false if there are no data in the resultset
        isduplicate = rs.isBeforeFirst();   
        
        if (isduplicate == false && isValidData() )
        {
        	
               double age = Double.parseDouble(txtAge.getText().trim());  
            //getting artist ID
               
            int lastArtist;      	
           	String sql1 ="SELECT artistID FROM artist ORDER BY artistID DESC fetch first 1 row only  ";
               rs = dbCon.executeStatement(sql1);
               if (rs.next()) {
                    lastArtist = rs.getInt("artistID");
               } 
               else
             lastArtist = 0 ;           
             lastArtist = lastArtist +1;
               
            //insertion into sql table
            String prepSQL = "INSERT INTO artist (ArtistID, Name, Age, sex) VALUES ("                  
                    + lastArtist+","
                    +" '" + txtName.getText() + "',"
                    + age +", '"
                    +cmbUserType.getSelectedItem()+ "')"
                    ;         
            int result = dbCon.executePrepared(prepSQL);         
            if (result > 0) {

                javax.swing.JLabel label = new javax.swing.JLabel("New Artist added successfully.");
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
            javax.swing.JLabel label = new javax.swing.JLabel("Artist already exists.");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.INFORMATION_MESSAGE);
           
        }
     }
     catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding new artist. Please contact the administrator.");
        } 
    }                                            

                                         

    private void cmbUserTypeActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAddNewEmp;
    private javax.swing.JComboBox<String> cmbUserType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblAgeError;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtAge;
    // End of variables declaration                   
  
}
