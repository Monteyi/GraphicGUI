package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    JFrame frame;
    JButton squares[][] = new JButton[8][8];
    private Color colorGreen = Color.green;
    private int row = 7;
    private int col = 1;
    private ImageIcon knight = new ImageIcon("Knight.png");



    public Main() {
        frame = new JFrame("Play Chess!");
        frame.setSize(800, 800);
        frame.setLayout(new GridLayout(8, 8));

        // Menu bar
        JMenuBar menu = new JMenuBar();
        JMenu menu1 = new JMenu("New game");
        menu.add(menu1);
        JMenu menu2 = new JMenu("Resign");
        menu.add(menu2);
        frame.setJMenuBar(menu);

        ButtonHandler buttonHandler = new ButtonHandler();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new JButton();

                if ((i + j) % 2 != 0) {
                    squares[i][j].setBackground(colorGreen);
                }
                frame.add(squares[i][j]);
                squares[i][j].addActionListener(buttonHandler);

            }
        }

        for (int i = 0; i < 8; i++) {
            squares[1][i].add(new JButton(new ImageIcon(getClass().getResource("BPawn.PNG"))));
            squares[6][i].add(new JButton(new ImageIcon(getClass().getResource("WPawn.png"))));
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.validate();
        frame.setLocationRelativeTo(null);

    }
    private boolean isValidMove(int i, int j) {
        int rowDelta = Math.abs(i - row);
        int colDelta = Math.abs(j - col);

        if ((rowDelta == 1) || (colDelta == 2)) {
            return true;
        }
        if ((colDelta == 1) || (rowDelta == 2)) {
            return true;
        }
        return false;
    }

    private void Click(int i, int j) {
        if (isValidMove(i, j) == false) {
            return;
        }
        squares[row][col].setIcon(null);
        squares[i][j].setIcon(knight);
        row = i;
        col = j;
    }
    private class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (source == squares[i][j]) {
                        Click(i, j);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}