import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import java.util.ArrayList;
import javax.swing.*;


public class CaffeineTracker extends Application
{
    public static void main(String[] args)
    {    launch(args);    }

    // declare stage object
    private Stage stage;

    // Text field objects for name of user and cups of coffee consumed
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

        // ---------- Create the bottom pane ----------
        Button btnCompute = new Button("Compute");
        btnCompute.setPrefWidth(80);
        btnCompute.setOnAction(e -> btnCompute_Click() );

        Button btnClear = new Button("Clear");
        btnClear.setPrefWidth(80);
        btnClear.setOnAction(e -> btnClear_Click() );

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

    public void btnCompute_Click()
    {	// Create a message string with the customer information
        String msg = "Results for " + tFieldName.getText() + ":";

        // Determine duration of caffeine intake
        int timeframe;
        if (rdoSixHours.isSelected())
            timeframe = 6;
        else if (rdoFourHours.isSelected())
            timeframe = 4;
        else
            timeframe = 2;

        double curCaffeineMg = 0;
        for (int ct1 = 0; ct1 < timeframe; ct1++){
            curCaffeineMg = (curCaffeineMg + tFieldCups.getText());
        }

        // Display the message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Details");
        alert.setHeaderText(msg);
        //alert.setContentText(msg);
        alert.show();
    }

    private String calcCaffeine(CheckBox chk, String msg){
        // PRE: String containing amount of caffeine taken in milligrams
        // POST: String containing amount of caffeine after an hour

        // Helper method for calculating amount of caffeine in milligrams
        if (chk.isSelected())
        {	if (!msg.equals(""))
            msg += ", ";
            msg += chk.getText();
        }
        return msg;
    }

    private void btnClear_Click()
    {
        stage.close();
    }

}
