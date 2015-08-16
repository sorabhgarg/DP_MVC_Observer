package com.borrowedhour.a.mvc;

import com.borrowedhour.a.mvc.controller.Controller;
import com.borrowedhour.a.mvc.model.Model;
import com.borrowedhour.a.mvc.view.LoginListener;
import com.borrowedhour.a.mvc.view.View;

import javax.swing.*;

/**
 * Created by borrowedhour on 8/15/15.
 */
public class Application {


    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                runApp();
            }
        });
    }

    public static void runApp(){
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);

        view.setLoginListener(controller);

    }
}
