/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bulan_200923;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class BannerApp extends JFrame implements ActionListener {
    private Timer timer;
    private int xPos1 = 800;
    private int xPos2 = -200;
    private int yPos1 = 100;
    private int yPos2 = 200;
    private String text1 = "BULAN FITRIA ADVIANI";
    private String text2 = "TRPL 3B";

    public BannerApp() {
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Times New Roman", Font.BOLD, 36));
        g2d.setColor(Color.BLUE);
        g2d.drawString(text1, xPos1, yPos1);
        g2d.setColor(Color.PINK);
        g2d.drawString(text2, xPos2, yPos2);
    }

    public void actionPerformed(ActionEvent e) {
        if (xPos1 > -200) {
            xPos1 -= 2;
        } else {
            xPos1 = getWidth();
        }

        if (xPos2 < getWidth()) {
            xPos2 += 2;
        } else {
            xPos2 = -200;
        }

        repaint();
    }

    public static void main(String[] args) {
        BannerApp app = new BannerApp();
        app.setSize(800, 400);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}