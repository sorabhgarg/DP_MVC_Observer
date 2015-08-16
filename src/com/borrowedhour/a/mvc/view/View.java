package com.borrowedhour.a.mvc.view;

import com.borrowedhour.a.mvc.controller.Controller;
import com.borrowedhour.a.mvc.model.Database;
import com.borrowedhour.a.mvc.model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by borrowedhour on 8/15/15.
 */
public class View extends JFrame implements ActionListener {

    private Model model;
    private JButton okButton;
    private JTextField nameField;
    private JTextField passwordField;
    private JTextField repeatPassField;
    private LoginListener loginListener; //Can have a list instead which would store observers

    public View(Model model) {
        super("MVC Demo");
        this.model = model;

        okButton = new JButton("OK");
        nameField = new JTextField(10);
        passwordField = new JTextField(10);
        repeatPassField = new JTextField(10);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.LAST_LINE_END;
        gc.gridx = 1;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.insets = new Insets(100, 0, 0, 10);
        gc.fill = GridBagConstraints.NONE;

        add(new JLabel("Name: "), gc);

        gc.anchor = GridBagConstraints.LAST_LINE_START;
        gc.gridx = 2;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.insets = new Insets(100, 0, 0, 0);
        gc.fill = GridBagConstraints.NONE;

        add(nameField, gc);

        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 1;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.insets = new Insets(0, 0, 0, 10);
        gc.fill = GridBagConstraints.NONE;

        add(new JLabel("Password: "), gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 2;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.fill = GridBagConstraints.NONE;

        add(passwordField, gc);

//        gc.anchor = GridBagConstraints.LINE_START;
//        gc.gridx = 1;
//        gc.gridy = 3;
//        gc.weightx = 1;
//        gc.weighty = 1;
//        gc.insets = new Insets(0, 0, 0, 10);
//        gc.fill = GridBagConstraints.NONE;
//
//        add(new JLabel("Repeat Password: "), gc);
//
//        gc.anchor = GridBagConstraints.LINE_START;
//        gc.gridx = 2;
//        gc.gridy = 3;
//        gc.weightx = 1;
//        gc.weighty = 1;
//        gc.insets = new Insets(0, 0, 0, 0);
//        gc.fill = GridBagConstraints.NONE;
//
//        add(repeatPassField, gc);


        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 2;
        gc.gridy = 3;
        gc.weightx = 1;
        gc.weighty = 100;
        gc.fill = GridBagConstraints.NONE;

        add(okButton, gc);

        okButton.addActionListener(this);

        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                Database.getDbInstance().connect();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                Database.getDbInstance().disconnect();
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();
        String password = passwordField.getText();
        System.out.println("Name: " + name + " Password: " + password);

        fireLoginEvent(new LoginFormEvent(name, password));

    }

    public void fireLoginEvent(LoginFormEvent event) {

        if (loginListener != null) {
            loginListener.loginPerformed(event);
        }
    }

    public void setLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }
}
