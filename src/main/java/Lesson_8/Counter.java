package Lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counter extends JFrame {
    private int value;

    public Counter(int initialValue){
        setBounds(300,300, 500, 300);
        setTitle("Simple counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Font font = new Font ("Arial", Font.BOLD,32);

        JLabel counterValueView = new JLabel();
        counterValueView.setFont(font);
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
        add (counterValueView, BorderLayout.CENTER);

        value = initialValue;
        counterValueView.setText(String.valueOf(value));

        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        add(decrementButton, BorderLayout.WEST);

        JButton incrementButton = new JButton(">");
        incrementButton.setFont(font);
        add(incrementButton, BorderLayout.EAST);

        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value--;
                counterValueView.setText(String.valueOf(value));
            }
        });

        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value++;
                counterValueView.setText(String.valueOf(value));
            }
        });

        JButton reset = new JButton("Сброс");
        reset.setFont(font);
        add(reset, BorderLayout.SOUTH);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = 0;
                counterValueView.setText(String.valueOf(value));
            }
        });

        JButton saveButton = new JButton();
        saveButton.setFont(font);
        saveButton.setText("Сохранить значение");
        add(saveButton, BorderLayout.NORTH);
        saveButton.addActionListener(new ActionListener() {
            private boolean oneTouch = false;
            private int savedValue;
            @Override
            public void actionPerformed(ActionEvent e) {
                oneTouch=!oneTouch;
                if (oneTouch){
                    savedValue = value;
                    saveButton.setText("Установить значение: "+ String.valueOf(savedValue));
                } else {
                    value = savedValue;
                    saveButton.setText("Сохранить значение");
                    counterValueView.setText(String.valueOf(value));
                }

            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Counter(0);
    }
}
