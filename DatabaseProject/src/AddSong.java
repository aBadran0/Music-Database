

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.toedter.calendar.JDateChooser;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;


public class AddSong extends javax.swing.JFrame {
    /**
     * Creates new form AddEmployee
     */
    myDBCon dbCon;
    ResultSet rs;
    ResultSet rs1;
    ResultSet rs2;
    ResultSet rs3;
    
    public AddSong() {
        initComponents();     
        // center form in screen 
        this.setLocationRelativeTo(null);
   
        // set all error labels to invisible
        lblDateError.setVisible(false);
        lblLengthError.setVisible(false);
        lblSongError.setVisible(false);
        // populate the user type combo box
        try {            
            dbCon = new myDBCon();
            rs1 = dbCon.executeStatement("SELECT Name FROM Artist");
            // populate mgr combo box        
            while (rs1.next()) {
                cmbArtistName.addItem(rs1.getString("name"));
            }
            rs1.close();
        } catch (SQLException e) {
            System.out.println(e);
        }  
        try {            
            dbCon = new myDBCon();
            rs2 = dbCon.executeStatement("SELECT Name FROM Genres");
            while (rs2.next()) {
            	cmbGenre.addItem(rs2.getString("Name"));
            }
            rs2.close();
        } catch (SQLException e) {
            System.out.println(e);
        } 
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        heading = new javax.swing.JLabel();
        RDate = new javax.swing.JLabel();
        Length = new javax.swing.JLabel();
        Artist = new javax.swing.JLabel();
        SName = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnAddSong = new javax.swing.JButton();
        lblDateError = new javax.swing.JLabel();
        lblLengthError = new javax.swing.JLabel();
        lblSongError = new javax.swing.JLabel();
        txtLength = new JTextField();
        
        JDateChooser dateChooser = new JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Login User");
        setResizable(false);

        heading.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        heading.setText("Add New Song");

        RDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        RDate.setText("Release Date (dd-mm-yyyy)");

        Length.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Length.setText("Length (in seconds)");

        Artist.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Artist.setText("Artist Name");

        SName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SName.setText("Song Name");

        txtDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        
        cmbArtistName = new javax.swing.JComboBox<String>();

        cmbArtistName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        
        AutoCompletion.enable(cmbArtistName);
 

        btnAddSong.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 24)); // NOI18N
        btnAddSong.setText("Add Song");
        btnAddSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewEmpActionPerformed(evt);
            }
        });

        lblDateError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblDateError.setForeground(new java.awt.Color(255, 0, 0));
        lblDateError.setText("error label");

        lblLengthError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblLengthError.setForeground(new java.awt.Color(255, 0, 0));
        lblLengthError.setText("error label");

        lblSongError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblSongError.setForeground(new java.awt.Color(255, 0, 0));
        lblSongError.setText("error label");

        txtLength.setFont(new java.awt.Font("Tahoma", 1, 18));
        
        Genre = new JLabel();
        Genre.setText("Genre");
        Genre.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        cmbGenre = new JComboBox<String>();
        cmbGenre.setFont(new Font("Tahoma", Font.PLAIN, 18));
        AutoCompletion.enable(cmbGenre);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(103)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(RDate)
        				.addComponent(SName)
        				.addComponent(Length)
        				.addComponent(Artist, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
        				.addComponent(Genre, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
        						.addComponent(txtDate, 200, 345, Short.MAX_VALUE)
        						.addComponent(txtLength, 200, 345, Short.MAX_VALUE)
        						.addComponent(cmbArtistName, 0, 345, Short.MAX_VALUE))
        					.addGap(15)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(lblLengthError, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        						.addComponent(lblSongError, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(lblDateError, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        				.addComponent(cmbGenre, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
        			.addGap(96))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(234)
        			.addComponent(heading)
        			.addContainerGap(492, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(385)
        			.addComponent(btnAddSong)
        			.addContainerGap(467, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(heading)
        			.addGap(24)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblSongError)
        				.addComponent(SName))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblDateError)
        				.addComponent(RDate))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblLengthError)
        				.addComponent(Length))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(Artist)
        				.addComponent(cmbArtistName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(Genre, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cmbGenre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addGap(30)
        			.addComponent(btnAddSong)
        			.addGap(40))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>                        

    void clearErrorLabels() {
        // erase error label text and set visibility to false 
        lblDateError.setText("");
        lblDateError.setVisible(false);
        lblLengthError.setText("");
        lblLengthError.setVisible(false);
     
        lblSongError.setText("");
        lblSongError.setVisible(false);   
    }
    boolean isValidPassword() {
        // check validity of the password value entered by the user based on your design 
      return true;//placeholder
    }
    boolean isValidData() {
        // check validity of all values entered //
       boolean result = true;
       
        if (txtName.getText().isEmpty()) {          
           lblSongError.setText("Please enter the name of the Song.");       
            lblSongError.setVisible(true);
            return false;
        }
        //date text fields
//        if (txtDate.getText().trim().isEmpty()) {          
//            lblDateError.setText("Please enter the release date of the Song.");       
//            lblDateError.setVisible(true);
//             return false;
//         }
       
        if (txtLength.getText().trim().isEmpty()) {          
            lblLengthError.setText("Please enter the length of the song in seconds.");       
            lblLengthError.setVisible(true);
             return false;
         } 
        
        try { Double.parseDouble(txtLength.getText().trim());   }
        catch (NumberFormatException e) {
        	lblLengthError.setText("Please enter a numerical value here.");       
            lblLengthError.setVisible(true);
        	return false;  
        }    
        return result;    
    }

    void clearInputBoxes() {
        // clear all text boxes and set the user type combo to the default value //
        txtName.setText("");
        txtDate.setText("");
        txtLength.setText("");
       cmbGenre.setSelectedIndex(0);
        cmbArtistName.setSelectedIndex(0);
    }

    private void btnAddNewEmpActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        try {                  
            // verify input data//   
            
            String SNamechk = txtName.getText();
            if (SNamechk.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Song name cannot be empty.");
                return;
            }

            // Check for duplicate song name
            String dupecheck = "SELECT SName FROM songs WHERE SName = ?";
            PreparedStatement pstDupeCheck = dbCon.prepareStatement(dupecheck);
            pstDupeCheck.setString(1, SNamechk);
            ResultSet rs = pstDupeCheck.executeQuery();
            
            if (!rs.isBeforeFirst() && isValidData()) {
                //get current song id
                int lastSong = 0;       
                String sql1 = "SELECT SongID FROM songs ORDER BY SongID DESC FETCH FIRST ROW ONLY";
                rs = dbCon.executeStatement(sql1);
                if (rs.next()) {
                    lastSong = rs.getInt("SongID") + 1;
                }

                //get ArtistID of selected artist name from combo box
                int AID = getArtistId(cmbArtistName.getSelectedItem().toString());
          
                //get GenreID
                int GID = getGenreId(cmbGenre.getSelectedItem().toString());
                
                // Convert length into double
                double length = Double.parseDouble(txtLength.getText().trim());
                
                // Convert release date into Date
                java.sql.Date releaseDate = convertToDate(txtDate.getText().trim());
            	
                //insert into songs table
                String prepSQL = "INSERT INTO songs (SongID, SName, ReleaseDate, Length, ArtistID, GenreID) VALUES ("
                        + lastSong + ", '" + SNamechk + "', TO_DATE('" + releaseDate.toString() + "', 'YYYY-MM-DD'), " 
                        + length + ", " + AID + ", " + GID + ")";
                
                int result = dbCon.executePrepared(prepSQL);         
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "New song added successfully.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    clearInputBoxes();
                }           
            } else {
                JOptionPane.showMessageDialog(null, "Please fix validation errors or song already exists.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | ParseException e) {
            JOptionPane.showMessageDialog(null, "Database error adding new song. Please contact the administrator if this continues");
            e.printStackTrace();
        } 
    }  
    
    
    
    private int getArtistId(String artistName) throws SQLException {
        String sql = "SELECT ArtistID FROM Artist WHERE Name = ?";
        PreparedStatement pst = dbCon.prepareStatement(sql);
        pst.setString(1, artistName);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return rs.getInt("ArtistID");
        }
        return -1; // or throw an exception if the artist must exist
    }


    private int getGenreId(String genreName) throws SQLException {
        String sql = "SELECT GenreID FROM Genres WHERE Name = ?";
        PreparedStatement pst = dbCon.prepareStatement(sql);
        pst.setString(1, genreName);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return rs.getInt("GenreID");
        }
        return -1; // or throw an exception if the genre must exist
    }
    
    private java.sql.Date convertToDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy");
        java.util.Date parsedDate = format.parse(dateString);
        return new java.sql.Date(parsedDate.getTime());
    }

                                             

                                    


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAddSong;
    private javax.swing.JComboBox<String> cmbArtistName;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel RDate;
    private javax.swing.JLabel Length;
    private javax.swing.JLabel Artist;
    private javax.swing.JLabel SName;
    private javax.swing.JLabel lblSongError;
    private javax.swing.JLabel lblLengthError;
    private javax.swing.JLabel lblDateError;
    private javax.swing.JTextField txtName;
    private JTextField txtLength;
    private javax.swing.JTextField txtDate;
    private JLabel Genre;
    private JComboBox<String> cmbGenre;

}

	

