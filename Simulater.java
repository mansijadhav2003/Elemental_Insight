//import javafx.application.Application;
import javafx.geometry.Pos;
//import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.layout.Background;
//import javafx.scene.layout.BackgroundImage;
//import javafx.scene.layout.BackgroundRepeat;
//import javafx.scene.layout.BackgroundPosition;
//import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class Simulater  {

    private double reactionRateConstantA = 0.1;
    private double reactionRateConstantB = 0.1;
    private double initialConcentrationA = 1.0;
    private double initialConcentrationB = 1.0;
    private double initialConcentrationC = 0.0;
    private double initialConcentrationD = 0.0;
    private double time = 0.0;
    private double timeStep = 0.01;

    private Label timeLabel;
    private Label concentrationLabelA;
    private Label concentrationLabelB;
    private Label concentrationLabelC;
    private Label concentrationLabelD;

    public void getSimulatorInterface() {

        timeLabel = createLabel("Time: " + time, 16, Color.MIDNIGHTBLUE);
        concentrationLabelA = createLabel("Initial Concentration A: " + initialConcentrationA, 16, Color.NAVY);
        concentrationLabelB = createLabel("Initial Concentration B: " + initialConcentrationB, 16, Color.NAVY);
        concentrationLabelC = createLabel("Initial Concentration C: " + initialConcentrationC, 16, Color.NAVY);
        concentrationLabelD = createLabel("Initial Concentration D: " + initialConcentrationD, 16, Color.NAVY);

        Slider reactionRateSliderA = createSlider(0.01, 1.0, reactionRateConstantA);
        Slider reactionRateSliderB = createSlider(0.01, 1.0, reactionRateConstantB);

        Button simulateButton = createButton("Simulate", 16, Color.WHITE, Color.RED);
        simulateButton.setOnAction(event -> {
            simulateReaction();
            updateUI();
        });

        VBox root = createVBox(20, Pos.CENTER);


        root.getChildren().addAll(
                timeLabel, concentrationLabelA, concentrationLabelB, concentrationLabelC, concentrationLabelD,
                reactionRateSliderA, reactionRateSliderB, simulateButton);

        // Set a background image
        Image backgroundImage = new Image("file:///C://Users//kunal//Desktop//chemistry_project//Chemistry_Elemental//Chemistry_Elemental//Chemistry Kinetics Simulator//sm//simulation.jpg");
        new ImageView(backgroundImage);
    }

       

    private Label createLabel(String text, int fontSize, Color textColor) {
        Label label = new Label(text);
        label.setFont(Font.font("Arial", fontSize));
        label.setTextFill(textColor);
        return label;
    }

    private Slider createSlider(double min, double max, double value) {
        Slider slider = new Slider(min, max, value);
        slider.setStyle("-fx-background-color: HoneyDew; -fx-control-inner-background: lime;");
        return slider;
    }

    private Button createButton(String text, int fontSize, Color textColor, Color backgroundColor) {
        Button button = new Button(text);
        button.setFont(Font.font("Arial", fontSize));
        button.setTextFill(textColor);
        button.setStyle("-fx-background-color: " + toRGBCode(backgroundColor) + "; -fx-font-weight: bold;");
        return button;
    }

    private VBox createVBox(int spacing, Pos alignment) {
        VBox vbox = new VBox(spacing);
        vbox.setPadding(new javafx.geometry.Insets(10));
        vbox.setAlignment(alignment);
        return vbox;
    }

    private void simulateReaction() {
        double rateA = reactionRateConstantA * initialConcentrationA;
        double rateB = reactionRateConstantB * initialConcentrationB;

        double dA = -rateA;
        double dB = -rateB;
        double dC = rateA;
        double dD = rateB;

        initialConcentrationA += dA * timeStep;
        initialConcentrationB += dB * timeStep;
        initialConcentrationC += dC * timeStep;
        initialConcentrationD += dD * timeStep;

        time += timeStep;
    }

    private void updateUI() {
        timeLabel.setText("Time: " + time);
        concentrationLabelA.setText("Initial Concentration A: " + initialConcentrationA);
        concentrationLabelB.setText("Initial Concentration B: " + initialConcentrationB);
        concentrationLabelC.setText("Initial Concentration C: " + initialConcentrationC);
        concentrationLabelD.setText("Initial Concentration D: " + initialConcentrationD);
    }



    public static String toRGBCode(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
 }
}
