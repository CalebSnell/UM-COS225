/* This program is designed to track your caffeine intake
and tell you that you're drinking too much */
// Programmed by Caleb Snell

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CaffeineTracker extends Application
{
    public static void main(String[] args)
    {    launch(args);    }

    // Declare decimal format object to set precision to 1
    DecimalFormat decForm = new DecimalFormat(".#");

    // declare stage object
    private Stage stage;

    // Text field objects for name of user and cups of coffee consumed
    ArrayList<TextField> caffeineTotals = new ArrayList<TextField>()    ;
    TextField tFieldName;
    TextField tFieldCups;

    // Radio buttons for choosing tracking time period
    RadioButton rdoTwoHours;
    RadioButton rdoFourHours;
    RadioButton rdoSixHours;

    // Checkbox for choosing Espresso shot
    CheckBox containsEspresso;

    @Override public void start(Stage primaryStage){
        // Create primary window for application
        stage = primaryStage;

        // Set header text and formatting
        Text textHeading = new Text("Input and Track Your Caffeine Levels");
        textHeading.setFont(new Font(20));

        // Print header text on top portion of pane with specified padding
        HBox paneTop = new HBox(textHeading);
        paneTop.setPadding(new Insets(20, 10, 20, 10));

        // Create label for user's "name"
        Label lblName = new Label("Name:");
        lblName.setPrefWidth(100);

        // Display text field alongside "name" label
        tFieldName = new TextField();
        tFieldName.setPrefColumnCount(20);
        tFieldName.setMaxWidth(Double.MAX_VALUE);
        HBox paneName = new HBox(lblName, tFieldName);

        // Create label for amount of cups drank
        Label lblCups = new Label("Cups:");
        lblCups.setPrefWidth(100);

        // Display text field alongside "cups" label
        tFieldCups = new TextField();
        tFieldCups.setPrefColumnCount(20);
        HBox paneCups = new HBox(lblCups, tFieldCups);

        // Create the user pane, which contains text fields for name and cups consumed
        VBox paneCustomer = new VBox(10, paneName, paneCups);

        // Create the cups pain, which contains radio buttons for amount of hours tracked
        Label lblTime = new Label("Hours");
        rdoTwoHours = new RadioButton("2");
        rdoFourHours = new RadioButton("4");
        rdoSixHours = new RadioButton("6");

        // Select the two hour option by default
        rdoTwoHours.setSelected(true);

        // Group radio buttons together so only one can be selected at a time
        ToggleGroup groupTime = new ToggleGroup();
        rdoTwoHours.setToggleGroup(groupTime);
        rdoFourHours.setToggleGroup(groupTime);
        rdoSixHours.setToggleGroup(groupTime);

        // Display pane vertically for intake radio buttons
        VBox paneTime = new VBox(lblTime, rdoTwoHours, rdoFourHours, rdoSixHours);
        paneTime.setSpacing(10);


        // Create label and checkbox objects for espresso shots
        Label lblEspresso = new Label("Espresso Shot");
        containsEspresso= new CheckBox();

        // Create the pane for choosing if your coffee has espresso
        VBox paneEspresso = new VBox(lblEspresso, containsEspresso);

        // Add chosen timeframe and true/false espresso to
        HBox paneChoice = new HBox(50, paneTime, paneEspresso);

        // Create the center pane
        VBox paneCenter = new VBox(20, paneCustomer, paneChoice);
        paneCenter.setPadding(new Insets(0,10, 0, 10));

        // Create bottom pane
        Button btnCompute = new Button("Compute");
        btnCompute.setPrefWidth(80);
        btnCompute.setOnAction(e -> btnCompute_Click() );

        Button btnClear = new Button("Clear");
        btnClear.setPrefWidth(80);
        btnClear.setOnAction(e -> btnClear_Click() );

        // Create output pane
        // Creates array of TextFields that the user cannot change after display
        for(int ct0 = 0; ct0 < 6; ct0++) {
            TextField caffeineTotal = new TextField();
            caffeineTotal.setEditable(false);
            caffeineTotal.setVisible(false);
            caffeineTotals.add(caffeineTotal);
        }

        // Displays array of TextFields
        VBox paneOutput = new VBox(10);
        paneOutput.getChildren().addAll(caffeineTotals);



        HBox paneBottom = new HBox(10, btnCompute, btnClear);
        paneBottom.setPadding(new Insets(20, 10, 20, 10));

        // ---------- Finish the scene ----------
        BorderPane paneMain = new BorderPane();
        paneMain.setTop(paneTop);
        paneMain.setCenter(paneCenter);
        paneMain.setBottom(paneBottom);

        // Create the scene and the stage
        Scene scene = new Scene(paneMain);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Caffeine Tracker");
        primaryStage.show();
    }

    public void btnCompute_Click(){
    //POST: Compute caffeine intake, indicate levels over time

        // Create a message string with the customer information
        String msg = "Results for " + tFieldName.getText() + ":";

        // Determine duration of caffeine intake
        int timeframe;
        if (rdoSixHours.isSelected())
            timeframe = 6;
        else if (rdoFourHours.isSelected())
            timeframe = 4;
        else
            timeframe = 2;

        // Get number of cups per hour as int
        int hrlyCups = Integer.parseInt(tFieldCups.getText());

        // Add 100Mg of caffeine to total if espresso is selected
        double hrlyCaffeineMg = hrlyCups * 130;
        if (containsEspresso.isSelected())
            hrlyCaffeineMg = hrlyCaffeineMg + (100 * hrlyCups);

        /* Calculate total caffeine after each hour,
         multiplying by .87 to simulate metabolism */
        double curCaffeineMg = 0;
        for (int ct1 = 0; ct1 < timeframe; ct1++){
            curCaffeineMg = (curCaffeineMg + hrlyCaffeineMg) * 0.87;
            caffeineTotals.get(ct1).setText(decForm.format(curCaffeineMg));
            caffeineTotals.get(ct1).setVisible(true);
        }

        // Ensure only enough text boxes are shown for the given timeframe
        for (int ct2 = timeframe; ct2 < caffeineTotals.size(); ct2++)
            caffeineTotals.get(ct2).setVisible(false);

        // Display the message indicating caffeine consumption
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert!");
        alert.setHeaderText("Results for " + tFieldName.getText() + ":");
        alert.setContentText(decForm.format(curCaffeineMg) + " milligrams after " + timeframe + " hours is way too much caffeine!");
        alert.show();
    }

    private void btnClear_Click(){
    //POST: Clear data input by user

        // Clear all data provided by the user
        tFieldName.clear();
        tFieldCups.clear();
        rdoTwoHours.setSelected(true);
        containsEspresso.setSelected(false);

        // Clear array created when computing caffeine
        for (int ct3 = 0; ct3 < caffeineTotals.size(); ct3++){
            caffeineTotals.get(ct3).clear();
            caffeineTotals.get(ct3).setVisible(false);
        }

    }

}
