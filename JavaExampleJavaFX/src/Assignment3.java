/*
 * Name: Matthew Beaudoin
 * Date: March, 4, 2022
 * 
 * This program is a Javafx application which allows the user to select from
 * settings to change the font, font styling, font position, text color, 
 * text content and background colour of a label. The user can use Mnemonics
 * to change some of these settings and the user can use buttons to reset or
 * exit the program. 
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Assignment3 extends Application{

    //Root and Scene
    private HBox root = new HBox();
    private Scene sc = new Scene(root, 440, 330);

    //Radio Buttons for font size change
    private RadioButton radSmall = new RadioButton("_Small");
    private RadioButton radMed = new RadioButton("_Medium");
    private RadioButton radLarge = new RadioButton("_Large");

    //Radio Buttons for font position change
    private RadioButton radLeft = new RadioButton("Le_ft");
    private RadioButton radCenter = new RadioButton("_Center");
    private RadioButton radRight = new RadioButton("Ri_ght");

    //Label used for displaying text and colours
    private Label lblforeground = new Label("Assignment3");

    //Checkboxes used for Bold and Italic
    private CheckBox chkBold = new CheckBox("Bold");
    private CheckBox chkItalic = new CheckBox("Italic");

    //Comboboxs for colour choice
    private ComboBox<String> cmbForeColour = new ComboBox<String>();
    private ComboBox<String> cmbBackColour = new ComboBox<String>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //Sets Defaults
        lblforeground.setTextFill(Color.BLUE);
        String defaultSet = getClass().getResource("Default.css").toExternalForm();
        sc.getStylesheets().add(defaultSet);
        radMed.setSelected(true);
        radLeft.setSelected(true);
        cmbBackColour.setValue("Gray");
        cmbBackColour.setValue("Gray");
        cmbForeColour.setValue("Blue");

        //Sets padding and spacing on main HBox
        root.setSpacing(15);
        root.setPadding(new Insets(10,10,10,10));

        //Creates first vbox and sets spacing
        VBox v1 = new VBox();
        v1.setSpacing(5);

        //Handles Font Sizing
        HBox fontSizing = new HBox();
        fontSizing.setSpacing(5);
        Label lblsize = new Label("Text Size:");
        ToggleGroup grpfontSize = new ToggleGroup();

        //Sets togglegroup, onaction and mnemonicparsing for all the radio buttons
        radSmall.setToggleGroup(grpfontSize);
        radSmall.setOnAction(new fontChange());
        radSmall.setMnemonicParsing(true);

        radMed.setToggleGroup(grpfontSize);
        radMed.setOnAction(new fontChange());
        radMed.setMnemonicParsing(true);

        radLarge.setToggleGroup(grpfontSize);
        radLarge.setOnAction(new fontChange());
        radLarge.setMnemonicParsing(true);

        //Places all the radio buttons and the label into fontsizing HBox
        fontSizing.getChildren().addAll(lblsize,radSmall,radMed,radLarge);

        //Handles Font Positioning
        Label lblAlign = new Label("Alignment:");
        HBox fontAlignment = new HBox();
        fontAlignment.setSpacing(5);
        ToggleGroup grpAlignment = new ToggleGroup();

        //Sets togglegroup, onaction and mnemonicparsing for all the radio buttons
        radLeft.setToggleGroup(grpAlignment);
        radLeft.setOnAction(new fontAlign());
        radLeft.setMnemonicParsing(true);

        radCenter.setToggleGroup(grpAlignment);
        radCenter.setOnAction(new fontAlign());
        radCenter.setMnemonicParsing(true);

        radRight.setToggleGroup(grpAlignment);
        radRight.setOnAction(new fontAlign());
        radRight.setMnemonicParsing(true);

        //Places all the radio buttons and the label into fontAlignment hbox
        fontAlignment.getChildren().addAll(lblAlign, radLeft, radCenter, radRight);

        //handles the users inputed text
        HBox newWords = new HBox();
        Label lblNewTxt = new Label("Change Text:");
        TextField txtInput = new TextField();

        //Eventhandler that checks if the user hit enter while the txt box is in focus
        txtInput.setOnKeyPressed(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER){
                    //replaces the text in the label and then clears the txt box
                    lblforeground.setText(txtInput.getText());
                    txtInput.setText("");
                }   
            } 
        });

        //Places label and txtbox into newWords HBox
        newWords.getChildren().addAll(lblNewTxt, txtInput);
        

        //handles Display Area
        //Settings for the label displaying all the user settings
        lblforeground.setId("foreground");
        lblforeground.setMinWidth(300);
        lblforeground.setMinHeight(150);

        //Places the label into displayArea HBox
        HBox displayArea = new HBox(lblforeground);

        //handles exit and reset buttons
        HBox buttons = new HBox();
        buttons.setSpacing(5);
        buttons.setAlignment(Pos.CENTER);

        //Creates buttons
        Button btnreset = new Button("_Reset");
        btnreset.setMnemonicParsing(true);
        Button btnexit = new Button("E_xit");
        btnexit.setMnemonicParsing(true);

        //Event handler for the reset button
        btnreset.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                //Clears all font sizing CSS
                String smallFont = getClass().getResource("SmallFont.css").toExternalForm();
                String medFont = getClass().getResource("MedFont.css").toExternalForm();
                String largeFont = getClass().getResource("LargeFont.css").toExternalForm();
                sc.getStylesheets().remove(smallFont);
                sc.getStylesheets().remove(medFont);
                sc.getStylesheets().remove(largeFont);

                //Clears font bold and italic CSS
                String boldFont = getClass().getResource("BoldFont.css").toExternalForm();
                lblforeground.getStylesheets().remove(boldFont);
                String italicFont = getClass().getResource("ItalicFont.css").toExternalForm();
                lblforeground.getStylesheets().remove(italicFont);

                //Clears all background colour CSS
                String white = getClass().getResource("White.css").toExternalForm();
                String beige = getClass().getResource("Biege.css").toExternalForm();
                String gray = getClass().getResource("Gray.css").toExternalForm();
                sc.getStylesheets().remove(white);
                sc.getStylesheets().remove(beige);
                sc.getStylesheets().remove(gray);

                //Resets properties of Label to default
                lblforeground.setAlignment(Pos.CENTER_LEFT);
                lblforeground.setText("Assignment3");
                lblforeground.setTextFill(Color.BLUE);

                //Emptys user input txt box
                txtInput.setText("");

                //Resets what options are selected to match defaults
                radMed.setSelected(true);
                radLeft.setSelected(true);
                chkBold.setSelected(false);
                chkItalic.setSelected(false);
                cmbBackColour.setValue("Gray");
                cmbForeColour.setValue("Blue");
            }
            
        });
        
        //Event handler for exit button
        btnexit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.exit(0); 
            }
        });

        //places buttons in buttons HBox
        buttons.getChildren().addAll(btnreset, btnexit);

        //places all previous HBox into v1 VBox
        v1.getChildren().addAll(fontSizing, fontAlignment, newWords, displayArea, buttons);

        //places v1 into the root HBox
        root.getChildren().add(v1);

        //handles Bold and Italic
        VBox v2 = new VBox();
        v2.setSpacing(5);
        Label lblFontSetting = new Label("Font Options:");

        //Event handler for the bold checkbox
        chkBold.setOnAction(new EventHandler<ActionEvent>() {

            String boldFont = getClass().getResource("BoldFont.css").toExternalForm();

            @Override
            public void handle(ActionEvent event) {

                if(chkBold.isSelected()){
                    lblforeground.getStylesheets().add(boldFont);
                }
                else{
                    lblforeground.getStylesheets().remove(boldFont);
                }
            }
        });

        //Event handler for Italic checkbox
        chkItalic.setOnAction(new EventHandler<ActionEvent>(){

            String italicFont = getClass().getResource("ItalicFont.css").toExternalForm();

            @Override
            public void handle(ActionEvent event) {
                
                if(chkItalic.isSelected()){
                    lblforeground.getStylesheets().add(italicFont);
                }
                else{
                    lblforeground.getStylesheets().remove(italicFont);
                }
            } 
        });

        //places checkboxs and labels into v2 VBox
        v2.getChildren().addAll(lblFontSetting, chkBold, chkItalic);

        //Handles Colour
        Label lblForeColour = new Label("Foreground:");
        cmbForeColour.getItems().addAll("Black", "Blue", "Purple");
        Label lblBackColour = new Label("Background:");
        cmbBackColour.getItems().addAll("White", "Biege", "Gray");

        //Changes lbl opacity so background colour is visible
        lblforeground.setOpacity(100);

        //Event handler for the combo button changing forground colours
        cmbForeColour.setOnAction(new EventHandler<ActionEvent>() {

            //Stores all the potential colour options inside
            Color[] foreColour = {Color.BLACK, Color.BLUE, Color.PURPLE};

            @Override
            public void handle(ActionEvent event) {
                
                //Checks what colour was picked from the combo box and uses its index as the index in forecolour
                lblforeground.setTextFill(foreColour[cmbForeColour.getSelectionModel().getSelectedIndex()]);    
            }
        });

        //Event handler for the combo button changing background colours
        cmbBackColour.setOnAction(new EventHandler<ActionEvent>() {

        //Grabs all the external CSS sheets
        String white = getClass().getResource("White.css").toExternalForm();
        String beige = getClass().getResource("Biege.css").toExternalForm();
        String gray = getClass().getResource("Gray.css").toExternalForm();

        //Stores potential options
        String[] backColour = {white, beige, gray};

            @Override
            public void handle(ActionEvent event) {
                
                //Removes all potential CSS background colour sheets
                sc.getStylesheets().remove(backColour[0]);
                sc.getStylesheets().remove(backColour[1]);
                sc.getStylesheets().remove(backColour[2]);

                //Uses index of combo box choice as index of backColour array to select option for text fill
                sc.getStylesheets().add(backColour[cmbBackColour.getSelectionModel().getSelectedIndex()]);
                
            }
        });
        
        //Places labels and combo boxes into v2 VBox
        v2.getChildren().addAll(lblForeColour, cmbForeColour, lblBackColour, cmbBackColour);

        //Inserts v2 into the root HBox
        root.getChildren().add(v2);
        

        //Runs stage
        primaryStage.setScene(sc);
        primaryStage.setTitle("Assignment 3");
        primaryStage.show();
    }

    //Event Handler for font sizing
    private class fontChange implements EventHandler<ActionEvent>{

        //Grabs the external CSS sheets
        String smallFont = getClass().getResource("SmallFont.css").toExternalForm();
        String medFont = getClass().getResource("MedFont.css").toExternalForm();
        String largeFont = getClass().getResource("LargeFont.css").toExternalForm();

        @Override
        public void handle(ActionEvent event) {

            //Checks what radio button was selected and selects it for Mnemonics
            RadioButton radSender = (RadioButton)event.getSource();
            radSender.setSelected(true);

            //Checks what radio button is selected and changes font size
            if(radSmall.isSelected()){
                sc.getStylesheets().add(smallFont);
            }
            else{
                //Removes CSS if this radio button isn't selected
                sc.getStylesheets().remove(smallFont);
            }

            if(radMed.isSelected()){
                sc.getStylesheets().add(medFont);
            }
            else{
                sc.getStylesheets().remove(medFont);
            }

            if(radLarge.isSelected()){
                sc.getStylesheets().add(largeFont);
            }
            else{
                sc.getStylesheets().remove(largeFont);
            }
        }
    }

    //Event handler for the font alignment
    private class fontAlign implements EventHandler<ActionEvent>{
    
        @Override
        public void handle(ActionEvent event) {
            
            //Checks what radio button was selected and sets it to true so Mnemonics can trigger the code
            RadioButton radSender = (RadioButton)event.getSource();
            radSender.setSelected(true);

            //Checks what radio button selected and alters alignment
            if(radLeft.isSelected()){
                lblforeground.setAlignment(Pos.CENTER_LEFT);
            }
            else if(radCenter.isSelected()){
                lblforeground.setAlignment(Pos.CENTER);
            }
            else{
                lblforeground.setAlignment(Pos.CENTER_RIGHT);
            }
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}
