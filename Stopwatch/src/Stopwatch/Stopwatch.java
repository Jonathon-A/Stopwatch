package Stopwatch;

import java.awt.Color;
import static java.awt.Color.gray;
import static java.awt.Color.white;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.ChronoUnit.MILLIS;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Stopwatch {

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
    public static DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static LocalTime alarmtim;
    public static LocalTime tim = LocalTime.of(0, 0, 0, 0);
    public static LocalTime current = LocalTime.now();
    public static LocalTime test;
    public static LocalTime test2;
    public static JLabel mylabel = new JLabel();
    public static JButton myalarm = new JButton();
    public static boolean first = true;
    public static boolean alarm;
    public static boolean invalid = false;
    public static boolean play;
    public static int mi = 0;
    public static int i = 0;
    public static int j = 0;
    public static int k = 0;

    public static void main(String[] args) throws InterruptedException {
        play = true;
        test2 = LocalTime.of(0, 0, 0, 0);
        test = LocalTime.of(0, 0, 0, 0);
        JFrame x = new JFrame();
        Border roundedBorder = BorderFactory.createLineBorder(Color.BLACK, 5, false);
        Border roundedBorder2 = BorderFactory.createLineBorder(Color.gray, 5, false);
        x.setDefaultCloseOperation(EXIT_ON_CLOSE);
        x.setSize(1600, 1000);
        x.getContentPane().setBackground(gray);
        x.setTitle("Display");
        JButton reset = new JButton("Reset");
        reset.setBounds(205, 800, 1190, 100);
        reset.setBackground(Color.white);
        reset.setBorder(roundedBorder);
        reset.setFont(new Font("Verdana", Font.PLAIN, 30));
        x.add(reset);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play = false;
                mylabel.setText(dtf.format(tim));
                test = LocalTime.of(0, 0, 0, 0);
                test2 = LocalTime.of(0, 0, 0, 0);
                mi = 0;
                alarm = false;
            }
        });
        myalarm.setBounds(320, 100, 960, 100);
        myalarm.setFont(new Font("Verdana", Font.PLAIN, 100));
        myalarm.setBackground(gray);
        myalarm.setForeground(white);
        myalarm.setBorder(roundedBorder2);
        x.add(myalarm);
        JButton B = new JButton("Add 1 Hour");
        B.setBounds(325, 250, 150, 50);
        B.setBackground(Color.white);
        B.setBorder(roundedBorder);
        B.setFont(new Font("Verdana", Font.PLAIN, 18));
        x.add(B);
        B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k++;
            }
        });
        JButton B2 = new JButton("Minus 1 Hour");
        B2.setBounds(485, 250, 150, 50);
        B2.setBackground(Color.white);
        B2.setBorder(roundedBorder);
        B2.setFont(new Font("Verdana", Font.PLAIN, 18));
        x.add(B2);
        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k--;
            }
        });
        JButton B3 = new JButton("Add 1 Minute");
        B3.setBounds(645, 250, 150, 50);
        B3.setBackground(Color.white);
        B3.setBorder(roundedBorder);
        B3.setFont(new Font("Verdana", Font.PLAIN, 18));
        x.add(B3);
        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j++;
            }
        });

        JButton B4 = new JButton("Minus 1 Minute");
        B4.setBounds(805, 250, 150, 50);
        B4.setBackground(Color.white);
        B4.setBorder(roundedBorder);
        B4.setFont(new Font("Verdana", Font.PLAIN, 18));
        x.add(B4);
        B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j--;
            }
        });
        JButton B5 = new JButton("Add 1 Second");
        B5.setBounds(965, 250, 150, 50);
        B5.setBackground(Color.white);
        B5.setBorder(roundedBorder);
        B5.setFont(new Font("Verdana", Font.PLAIN, 18));
        x.add(B5);
        B5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i++;
            }
        });
        JButton B6 = new JButton("Minus 1 Second");
        B6.setBounds(1125, 250, 150, 50);
        B6.setBackground(Color.white);
        B6.setBorder(roundedBorder);
        B6.setFont(new Font("Verdana", Font.PLAIN, 18));
        x.add(B6);
        B6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i--;
            }
        });
        JButton b4 = new JButton("Pause");
        b4.setBounds(805, 740, 590, 50);
        b4.setBackground(Color.white);
        b4.setBorder(roundedBorder);
        b4.setFont(new Font("Verdana", Font.PLAIN, 30));
        x.add(b4);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (play == true) {
                    play = false;
                    test2 = test;
                }
            }
        });
        JButton b6 = new JButton("Play");
        b6.setBounds(205, 740, 590, 50);
        b6.setBackground(Color.white);
        b6.setBorder(roundedBorder);
        b6.setFont(new Font("Verdana", Font.PLAIN, 30));
        x.add(b6);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (play == false) {
                    current = LocalTime.now();
                    play = true;
                }
            }
        });
        mylabel.setHorizontalAlignment(JLabel.CENTER);
        mylabel.setFont(new Font("Verdana", Font.PLAIN, 200));
        mylabel.setForeground(white);
        mylabel.setText(dtf.format(tim));
        x.add(mylabel, SwingConstants.CENTER);
        boolean loop = true;
        while (loop == true) {
            loop(reset, x);
        }
    }

    public static void loop(JButton reset, JFrame x) throws InterruptedException {
        alarmtim = (LocalTime.of(0, 0, 0).plusSeconds(i).plusMinutes(j).plusHours(k));
        if ((alarmtim) == (LocalTime.of(0, 0, 0))) {
            invalid = true;
        } else {
            invalid = false;
        }
        if (play == true) {
            LocalTime now = LocalTime.now();
            long millis = current.until(now, ChronoUnit.MILLIS);
            test = test2.plus(millis, MILLIS);
            mylabel.setText(dtf.format(test));
        }
        if ((dtf2.format(alarmtim).equals(dtf2.format(test))) && ((alarmtim) != (LocalTime.of(0, 0, 0))) && (first == false)) {
            play = false;
            alarm = true;
            while (alarm == true) {
                java.awt.Toolkit.getDefaultToolkit().beep();//should play beep
                //Thread.sleep(100); //this is being weird, if u here windows sound then just comment out line 
            }
        }
        if ("00:00:00".equals(dtf2.format(test)) && (first == true)) {
            first = false;
            x.setVisible(true);
            reset.doClick();
        }
        if (invalid == true) {
            myalarm.setText("Alarm: Offline");
        } else {
            myalarm.setText("Alarm: " + dtf2.format(alarmtim));
        }

    }
}
