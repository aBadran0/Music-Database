import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import java.awt.Color;

public class ViewSongsByGenre extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public ViewSongsByGenre() {
        initComponents();
        try {
            myDBCon dbCon = new myDBCon();
            // Adjusted SQL query to exclude SongID
            ResultSet rs = dbCon.executeStatement("SELECT G.Name AS \"Genre Name\", " +
                    "LISTAGG(S.SName, ', ') WITHIN GROUP (ORDER BY S.SName) AS \"Songs\", " +
                    "COUNT(S.SongID) AS \"Number Of Songs In Genre\" " +
                    "FROM Genres G " +
                    "JOIN Songs S ON G.GenreID = S.GenreID " +
                    "GROUP BY G.Name " +
                    "ORDER BY \"Genre Name\"");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            String[] columnNames = new String[columnCount];
            for (int column = 1; column <= columnCount; column++) {
                columnNames[column - 1] = metaData.getColumnName(column);
            }

            tableModel = new DefaultTableModel(columnNames, 0);
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rowData[i] = rs.getObject(i + 1);
                }
                tableModel.addRow(rowData);
            }

            if (tableModel.getRowCount() == 0) {
                System.out.println("empty query");
            } else {
                System.out.println("query has stuff");
            }

            table.setModel(tableModel);
            rs.close();
        } catch (SQLException e) {
            JLabel label = new JLabel("SQL Error - Unable to execute command.");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            javax.swing.JOptionPane.showMessageDialog(null, label, "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Songs");
        setResizable(true);

        JLabel jLabel1 = new JLabel();
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36));
        jLabel1.setText("View Songs");

        JPanel panel = new JPanel();
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(groupLayout);

        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(new Color(0, 0, 0));
        table.setFillsViewportHeight(true);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        scrollPane.setViewportView(table);

        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
    }

  
}
