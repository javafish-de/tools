package de.javafish.helper;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

/**
 * DatePickerDemo.java
 *
 * Created on Nov 21, 2010
 *
 * @author Mark Lasby
 */

public class DatePickerDemo extends JFrame {

    // Get the current date and time
    private Calendar rightNow = Calendar.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd, yyyy");

    private JButton btnSetDate;
    private JLabel lblDate;

    /** Creates new form DatePickerDemo */
    public DatePickerDemo() {
        initComponents();
    }

    /** This method is called from within the constructor to initialize the form. */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        lblDate = new JLabel();
        btnSetDate = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(2, 1));

        lblDate.setText("01/01/2010");
        getContentPane().add(lblDate);

        btnSetDate.setText("Set Date");
        btnSetDate.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent evt) {
                btnSetDateActionPerformed(evt);
            }
        });
        getContentPane().add(btnSetDate);

        pack();
    }

    private void btnSetDateActionPerformed (ActionEvent evt) {
        DatePicker myDialog = new DatePicker(this, true, rightNow);
        rightNow = myDialog.getAnswer();
        lblDate.setText(sdf.format(rightNow.getTime()));
        myDialog.dispose();
    }

    public static void main (String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Turn off bold labels, text, etc.
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                new DatePickerDemo().setVisible(true);
            }
        });
    }
}