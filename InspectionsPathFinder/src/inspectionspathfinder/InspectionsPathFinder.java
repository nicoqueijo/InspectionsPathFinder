/*
This program was designed to automate the repetitive task of typing out a path.
How to use:
    > Enter loan number into input text field.
    > Click the corresponding client number.
    > Program generates the path and copies it to the clipboard.
Example: https://i.imgur.com/BvaNZWH.png
*/

package inspectionspathfinder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Nicolás Queijo
 */
public class InspectionsPathFinder extends Application implements EventHandler<ActionEvent> {

    // Global variables
    String finalPath;
    String loanNumber;
    String firstFour;
    String jphotos = "J:\\Photos2\\IN\\";
    String caliber = "335";
    String bayview = "442";
    String selene = "473";
    String colonial = "485";
    Label labelLoan;
    TextField input;
    Button button335;
    Button button442;
    Button button473;
    Button button485;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Inspections Path Finder");

        // button 1
        button335 = new Button();
        button335.setText(caliber);
        button335.setTooltip(new Tooltip("Caliber"));
        // button 2
        button442 = new Button();
        button442.setText(bayview);
        button442.setTooltip(new Tooltip("Bayview"));
        // button 3
        button473 = new Button();
        button473.setText(selene);
        button473.setTooltip(new Tooltip("Selene"));
        // button 4
        button485 = new Button();
        button485.setText(colonial);
        button485.setTooltip(new Tooltip("Colonial"));
        // text input field
        input = new TextField();
        input.setTooltip(new Tooltip("source code found at github.com/nicoqueijo"));
        // label field
        labelLoan = new Label();
        labelLoan.setText("Loan Number:  ");

        GridPane buttons = new GridPane();
        buttons.getChildren().add(button335);
        buttons.getChildren().add(button442);
        buttons.getChildren().add(button473);
        buttons.getChildren().add(button485);
        buttons.setHgap(11);
        GridPane.setConstraints(button335, 0, 0);
        GridPane.setConstraints(button442, 1, 0);
        GridPane.setConstraints(button473, 2, 0);
        GridPane.setConstraints(button485, 3, 0);

        GridPane pane = new GridPane();
        Scene scene = new Scene(pane, 370, 87);

        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(12);
        pane.setHgap(2);
        GridPane.setConstraints(labelLoan, 0, 0);
        GridPane.setConstraints(input, 1, 0);
        GridPane.setConstraints(buttons, 1, 1);

        pane.getChildren().add(labelLoan);
        pane.getChildren().add(input);
        pane.getChildren().add(buttons);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        button335.setOnAction(this);
        button442.setOnAction(this);
        button473.setOnAction(this);
        button485.setOnAction(this);

    }

    // Event handler for buttons clicks
    @Override
    public void handle(ActionEvent event) {

        try {
            if (event.getSource() == button335) {
                buttonHandler(caliber);
            }
            if (event.getSource() == button442) {
                buttonHandler(bayview);
            }
            if (event.getSource() == button473) {
                buttonHandler(selene);
            }
            if (event.getSource() == button485) {
                buttonHandler(colonial);
            }
        } catch (Exception e) {
            // this handles error in case user enters string above length of 4
        }

    }
    
    public void buttonHandler(String s) {
        loanNumber = input.getText();
        firstFour = loanNumber.substring(0, 4);
        finalPath = jphotos + s + "\\" + firstFour + "\\" + loanNumber;
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(finalPath);
        clipboard.setContent(content);
    }
}


