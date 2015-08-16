package com.borrowedhour.a.mvc.controller;

import com.borrowedhour.a.mvc.model.Model;
import com.borrowedhour.a.mvc.view.LoginFormEvent;
import com.borrowedhour.a.mvc.view.LoginListener;
import com.borrowedhour.a.mvc.view.View;

/**
 * Created by borrowedhour on 8/15/15.
 */
public class Controller implements LoginListener{

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void loginPerformed(LoginFormEvent event) {
        System.out.println("Login event recieved by Controller: " + event.getName()+"; "+event.getPassword());
    }
}
