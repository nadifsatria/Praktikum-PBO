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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class Awal extends JFrame{
    JButton bTiket, bKereta, bExit;
    JLabel lTitle;
    public void Awal()
    { 
        setTitle("Pembelian Tiket");
        lTitle = new JLabel("SELAMAT DATANG!!!");
        lTitle.setFont(new Font("Times New Roman", 0, 20));
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bTiket = new JButton("Tambah Tiket");
        bTiket.setFont(new Font("Times New Roman",0, 16));
        bTiket.setBackground(new Color(204,204,255));
        bKereta = new JButton("Tambah Kereta");
        bKereta.setFont(new Font("Times New Roman",0, 16));
        bKereta.setBackground(new Color(204,204,255));
        bExit = new JButton("Exit ");
        bExit.setFont(new Font("Times New Roman",0, 16));
        bExit.setBackground(new Color(204,204,255));

        getContentPane().setBackground(new Color(112,128,145));

        setLayout(null);
        add(lTitle);
        add(bTiket);
        add(bKereta);
        add(bExit); 
        lTitle.setBounds(1,30,429,30);
        bTiket.setBounds(100, 80, 220, 30);
        bKereta.setBounds(100, 120, 220, 30);
        bExit.setBounds(100, 180, 220, 30); 
        setSize(430, 330);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bTiket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OlahTiket();
            }
        });
        
        bKereta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OlahKereta();
            }
        });
        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
