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
public class Banner extends JFrame {
    private JLabel bannerLabel;
    private String bannerText = "Your name here!";
    private int currentPosition = 0;
    private Timer timer;

    public Banner() {
        setTitle("Banner App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 100);
        setLocationRelativeTo(null);

        bannerLabel = new JLabel();
        bannerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        bannerLabel.setHorizontalAlignment(JLabel.CENTER);
        updateBannerText();

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPosition++;
                if (currentPosition > bannerText.length()) {
                    currentPosition = -getWidth();
                }
                updateBannerText();
            }
        });

        getContentPane().add(bannerLabel);
    }

    private void updateBannerText() {
        String displayedText = bannerText.substring(Math.max(0, currentPosition), Math.min(bannerText.length(), currentPosition + getWidth()));
        bannerLabel.setText(displayedText);
    }

    public void startBanner() {
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Banner banner = new Banner();
                banner.setVisible(true);
                banner.startBanner();
            }
        });
    }
}