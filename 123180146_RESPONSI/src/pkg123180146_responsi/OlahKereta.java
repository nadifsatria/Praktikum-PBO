/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg123180146_responsi;

/**
 *
 * @author Nadifsa
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.sql.ResultSet;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.TableModel;

public class OlahKereta extends JFrame {
    JTable tTable;
    String[][] data = new String[300][4];
    String[] baris = {"ID", "Kereta", "Kelas"};
    JLabel lTittle, lid, lnkereta, lkelas;
    String id, nkereta, kelas, vid, vkelas , vnkereta;
    int index;
    JTextField fid, fnkereta, fkelas; 
    JScrollPane scrollPane;
    JButton bTambah, bEdit, bHapus, bBack;
    ResultSet resultSet;
    Statement statement;

 
    public OlahKereta()
    {			 
	Font fglobal  = new Font("Times New Roman", 0, 15);
        Font ftitel 	= new Font("Times New Roman", 0, 20);
	setTitle("Data Kereta");
	lTittle = new JLabel("OLAH DATA KERETA");  
	lTittle.setFont(ftitel);
        lTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

	lid= new JLabel("ID");
	lid.setFont(fglobal); 
	fid = new JTextField();
	fid.setFont(fglobal); 
	lkelas = new JLabel("Kelas");
	lkelas.setFont(fglobal);   
	fkelas = new JTextField();                     
        fkelas.setFont(fglobal);  
	lnkereta = new JLabel("Kereta");
	lnkereta.setFont(fglobal);  
	fnkereta = new JTextField(); 
        fnkereta.setFont(fglobal); 
        
        bTambah = new JButton("Tambah");
	bTambah.setFont(fglobal);
	bTambah.setBackground(new Color(255,100,100));  
        
	bEdit = new JButton("Ubah");
	bEdit.setFont(fglobal);
	bEdit.setBackground(new Color(100,255,100));
        
	bHapus = new JButton("Hapus");
	bHapus.setFont(fglobal);
	bHapus.setBackground(new Color(100,100,255));
        
	bBack = new JButton("Kembali");
	bBack.setFont(fglobal);
	bBack.setBackground(new Color(233,150,122));
         
        tTable = new JTable(data,baris);
        tTable.setBackground(new Color(192,192,192));
        tTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               tTableMouseClicked(evt);
           }
        });
        scrollPane = new JScrollPane(tTable);
        scrollPane.setBackground(new Color(112,128,145));
 
	getContentPane().setBackground(new Color(112,128,145));
 
	setLayout(null);
	add(lTittle);           
	add(lid);
	add(fid);         
	add(lkelas);
        add(fkelas);   
	add(lnkereta);
        add(fnkereta); 
	add(bTambah);
	add(bEdit);
	add(bHapus);
	add(bBack); 
        add(scrollPane);
                                
        lTittle.setBounds(50,30,500,50); 
	lid.setBounds(40, 110, 120, 30);
	fid.setBounds(120, 110, 270, 30); 
	lkelas.setBounds(40, 150, 120, 30);
	fkelas.setBounds(120, 150, 270, 30); 
	lnkereta.setBounds(40, 190, 120, 30);
	fnkereta.setBounds(120, 190, 270, 30);  
	bTambah.setBounds(40, 230, 110, 30);
	bEdit.setBounds(160, 230, 110, 30);
	bHapus.setBounds(280, 230, 110, 30);
	bBack.setBounds(400, 230, 110,30);
        
        scrollPane.setBounds(40, 300, 475, 150);

	setSize(650, 550);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

        Koneksi koneksi = new Koneksi();
        try {
            statement = koneksi.getConnection().createStatement();
            String sql = "SELECT * FROM kereta";
            resultSet = statement.executeQuery(sql);

            int row = 0;
            while (resultSet.next()){
                data[row][0] = resultSet.getString("id");
                data[row][1] = resultSet.getString("nkereta");
                data[row][2] = resultSet.getString("kelas"); 
                row++;
            }
            statement.close();

        } catch (SQLException sqlError) {
        } catch (ClassNotFoundException classError) {
            JOptionPane.showMessageDialog(rootPane, "Driver tidak ditemukan !!");
        }

	bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Awal();
            }
	});

	bTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		try {
                    id = fid.getText();
                    kelas = fkelas.getText();
                    nkereta = fnkereta.getText();
                    Koneksi koneksi = new Koneksi();
                    try {
                        statement = koneksi.getConnection().createStatement();
                        statement.executeUpdate("INSERT INTO kereta VALUES( '" + id + "','" + nkereta + "','" + kelas + "')");
                        JOptionPane.showMessageDialog(rootPane, "Data Berhasil Disimpan");
                        statement.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        java.util.logging.Logger.getLogger(OlahKereta.class.getName()).log(Level.SEVERE, null, ex);
                    }
		} catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data Salah");
		}catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane, "SALAH!!");
		}
                setVisible(false);
                new OlahKereta();
            }
	}); 
        
        bEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		try {
                    id = fid.getText();
                    kelas = fkelas.getText();
                    nkereta = fnkereta.getText();
                    Koneksi koneksi = new Koneksi();
                    try {
                        statement = koneksi.getConnection().createStatement();
                        statement.executeUpdate("UPDATE kereta SET id='" + id + "',nkereta='" + nkereta + "',kelas='" + kelas + "' WHERE id='" + id + "'");
                        JOptionPane.showMessageDialog(null, "Data berhasil di Update!", "Hasil", JOptionPane.INFORMATION_MESSAGE);							
                        statement.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        java.util.logging.Logger.getLogger(OlahKereta.class.getName()).log(Level.SEVERE, null, ex);
                    }
		} catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data Salah");
		}catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane, "SALAH!!");
		}
                setVisible(false);
                new OlahKereta();
            }
	});
        
         bHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		try {
                    id = fid.getText();
                    Koneksi koneksi = new Koneksi();
                    try {
                        statement = koneksi.getConnection().createStatement();
                        statement.executeUpdate("DELETE FROM kereta WHERE id ='" + id + "'");
                        JOptionPane.showMessageDialog((Component)null, "Data berhasil di Hapus!", "Hasil", 1);
                        statement.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        java.util.logging.Logger.getLogger(OlahKereta.class.getName()).log(Level.SEVERE, null, ex);
                    }
		} catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data Salah");
		}catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane, "SALAH!!");
		}
                setVisible(false);
                new OlahKereta();
            }
	});  
    }
    /*jangan dihapus yaaa*/
    private void tTableMouseClicked(java.awt.event.MouseEvent evt) {  
        index = tTable.getSelectedRow();
        fid.setText(vid);
        fid.setEditable(false);
        fid.setForeground(new Color(153,153,153));
        fid.setText(vid);
        TableModel model = tTable.getModel();
        vid = (String) model.getValueAt(index, 0); 
        vnkereta = (String) model.getValueAt(index, 1);
        vkelas = (String) model.getValueAt(index, 2);
        fnkereta.setText(vnkereta); 
        fkelas.setText(vkelas); 
        
    }
}

