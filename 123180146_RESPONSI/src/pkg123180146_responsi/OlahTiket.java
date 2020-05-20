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
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.TableModel;

public class OlahTiket extends JFrame {
    JTable tTable;
    String[][] data = new String[400][4];
    String[] baris = {"Nama", "Jenis Kelamin", "Tujuan", "Kereta"};
    JLabel lTittle, lnama, ljk, ltujuan, lnkereta; 
    String nama, jk, tujuan, nkereta, vnama, vjk, vtujuan, vnkereta;
    int index;
    JTextField fnama;
    javax.swing.JComboBox<String> fjk, ftujuan, fnkereta, ftitel;
    JScrollPane scrollPane;
    JButton bTambah, bEdit, bHapus, bBack;
    ResultSet resultSet;
    Statement statement;

 
    public OlahTiket()
    {			 
	Font fglobal  = new Font("Times New Roman", 0, 15);
        Font ftitel 	= new Font("Times New Roman", 0, 20);
	setTitle("Data Tiket");
	lTittle = new JLabel("OLAH DATA TIKET");  
	lTittle.setFont(ftitel);
        lTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

	lnama= new JLabel("Nama");
	lnama.setFont(fglobal); 
	fnama = new JTextField();
	fnama.setFont(fglobal); 
	ljk = new JLabel("Jenis Kelamin");
	ljk.setFont(fglobal);                        
        fjk = new javax.swing.JComboBox<>();
        fjk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pria", "Wanita"}));
	fjk.setFont(fglobal);  
	lnkereta = new JLabel("Tujuan");
	lnkereta.setFont(fglobal);   
        fnkereta = new javax.swing.JComboBox<>();
        fnkereta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prameks", "Pratameks", "Surya Kencana", "Ketandan"}));
	fnkereta.setFont(fglobal); 
        ltujuan = new JLabel("Tujuan");
	ltujuan.setFont(fglobal);                                
        ftujuan = new javax.swing.JComboBox<>();
        ftujuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tugu Jogja", "Maguwo", "Lempuyangan"}));
	ftujuan.setFont(fglobal); 
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
	add(lnama);
	add(fnama);         
	add(ljk);
        add(fjk);  
	add(ltujuan);
        add(ftujuan);   
	add(lnkereta);
        add(fnkereta); 
	add(bTambah);
	add(bEdit);
	add(bHapus);
	add(bBack); 
        add(scrollPane);
                                
        lTittle.setBounds(50,30,500,50); 
	lnama.setBounds(40, 110, 120, 30);
	fnama.setBounds(155, 110, 270, 30); 
	ljk.setBounds(40, 150, 120, 30);
	fjk.setBounds(155, 150, 270, 30); 
	ltujuan.setBounds(40, 190, 120, 30);
	ftujuan.setBounds(155, 190, 270, 30); 
	lnkereta.setBounds(40, 230, 120, 30);
	fnkereta.setBounds(155, 230, 270, 30); 
	bTambah.setBounds(475, 110, 110, 30);
	bEdit.setBounds(475, 150, 110, 30);
	bHapus.setBounds(475, 190, 110, 30);
	bBack.setBounds(475, 230, 110,30);
        
        scrollPane.setBounds(40, 300, 475, 150);

	setSize(650, 550);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

        Koneksi koneksi = new Koneksi();
        try {
            statement = koneksi.getConnection().createStatement();
            String sql = "SELECT * FROM tiket";
            resultSet = statement.executeQuery(sql);

            int row = 0;
            while (resultSet.next()){
                data[row][0] = resultSet.getString("nama");
                data[row][1] = resultSet.getString("jk");
                data[row][2] = resultSet.getString("tujuan");
                data[row][3] = resultSet.getString("nkereta");
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
                    nama = fnama.getText();
                    jk = fjk.getSelectedItem().toString();
                    tujuan = ftujuan.getSelectedItem().toString();
                    nkereta = fnkereta.getSelectedItem().toString();
                    Koneksi koneksi = new Koneksi();
                    try {
                        statement = koneksi.getConnection().createStatement();
                        statement.executeUpdate("INSERT INTO tiket VALUES( '" + nama + "','" + jk + "','" + tujuan + "','" + nkereta + "')");
                        JOptionPane.showMessageDialog(rootPane, "Data Berhasil Disimpan");
                        statement.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        java.util.logging.Logger.getLogger(OlahTiket.class.getName()).log(Level.SEVERE, null, ex);
                    }
		} catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data Salah");
		}catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane, "SALAH!!");
		}
                setVisible(false);
                new OlahTiket();
            }
	}); 
        
        bEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		try {
                    nama = fnama.getText();
                    jk = fjk.getSelectedItem().toString();
                    tujuan = ftujuan.getSelectedItem().toString();
                    nkereta = fnkereta.getSelectedItem().toString();
                    Koneksi koneksi = new Koneksi();
                    try {
                        statement = koneksi.getConnection().createStatement();
                        statement.executeUpdate("UPDATE tiket SET jk='" + jk + "',tujuan='" + tujuan + "',nkereta='" + nkereta + "' WHERE nama='" + nama + "'");
                        JOptionPane.showMessageDialog(null, "Data berhasil di Update!", "Hasil", JOptionPane.INFORMATION_MESSAGE);							
                        statement.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        java.util.logging.Logger.getLogger(OlahTiket.class.getName()).log(Level.SEVERE, null, ex);
                    }
		} catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data Salah");
		}catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane, "SALAH!!");
		}
                setVisible(false);
                new OlahTiket();
            }
	});
        
         bHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		try {
                    nama = fnama.getText();
                    Koneksi koneksi = new Koneksi();
                    try {
                        statement = koneksi.getConnection().createStatement();
                        statement.executeUpdate("DELETE FROM tiket WHERE nama ='" + nama + "'");
                        JOptionPane.showMessageDialog((Component)null, "Data berhasil di Hapus!", "Hasil", 1);
                        statement.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        java.util.logging.Logger.getLogger(OlahTiket.class.getName()).log(Level.SEVERE, null, ex);
                    }
		} catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data Salah");
		}catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane, "SALAH!!");
		}
                setVisible(false);
                new OlahTiket();
            }
	}); 
        
        
    }
    /*jangan dihapus yaaa*/
    private void tTableMouseClicked(java.awt.event.MouseEvent evt) {  
        index = tTable.getSelectedRow();
        TableModel model = tTable.getModel();
        vnama = (String) model.getValueAt(index, 0);
        vjk = (String) model.getValueAt(index, 1);
        vtujuan = (String) model.getValueAt(index, 2);
        vnkereta = (String) model.getValueAt(index, 3);
        fnama.setText(vnama);
        fnama.setEditable(false);
        fnama.setForeground(new Color(153,153,153));
        fnama.setText(vnama);
        fjk.setSelectedItem(vjk);
        ftujuan.setSelectedItem(vtujuan);
        fnkereta.setSelectedItem(vnkereta);
        
    }
}

