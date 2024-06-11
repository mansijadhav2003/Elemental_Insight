
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField concentrationField;

    private Label welcomeUsername, reports, periodicTableInfo, titleLabel, concentrationLabel, resultLabel,
            pHValueLabel, steps,
            theory1, theory2, theory3, theory4, theory5, aboutUsLaabel, teamMemLabel, teamMemberNameLabel,
            comminSoonLAbel;
    private AnchorPane root;
    public AnchorPane profileAnchorePane, profileSideAnchorePane, graphAnchorePane, pagesAnchorPane;
    private Button Dashboard, anyalasisButton, ourteamButton, abouC2WButton, loginOutButton, periodicTableButton,
            phCalculator,
            equationbalanceButton, simulatorButton, theroryButton, quizButtom, backButton, calculateButton, playButton1,
            playButton2, playButton3, playButton4, playButton5, repeatQuiz, c2wLink;
    private ImageView c2wLogo, profileLogo, elementalTextLogo, profileSideAnchorePaneLogo, phCalculationLogo,
            backButtonLogo, phScaleImage, phcalculationbackgroundimage, button1logo, aboutc2wimage, c2wBackGround,
            ourInfoImage,
            sirImage, c2wInsta, homepagebackground;
    private HBox inputHBox, resultHBox;

    private VBox vbox, mainVBox, layout;
    private Line lineUpper, lineLower;
    Media media;
    MediaPlayer mediaPlayer;
    MediaView mediaView;

    String username;
    int currectQuiz = 0;
    int wrongQuize = 0;

    int currentQuestionIndex = 0;
    private int score = 0;

    Stage prStage = new Stage();

    @Override
    public void start(Stage primaryStage) {

        prStage = primaryStage;

        primaryStage.setTitle("Chemistry Project Home Page ");

        root = new AnchorPane();
        root.setPrefHeight(800.0);
        root.setPrefWidth(1280);
        root.setStyle(" -fx-background-color: #FFFF;");

        profileAnchorePane = new AnchorPane();
        profileAnchorePane.setPrefHeight(800.0);
        profileAnchorePane.setPrefWidth(300.0);
        // profileAnchorePane.setStyle("-fx-background-color: #4EE2EC;");
        AnchorPane.setBottomAnchor(profileAnchorePane, 0.0);
        AnchorPane.setLeftAnchor(profileAnchorePane, 0.0);
        AnchorPane.setTopAnchor(profileAnchorePane, 0.0);

        Color purpleAmethyst = Color.rgb(108, 45, 199);
        Stop[] stops = new Stop[] {
                new Stop(0.0, Color.LIGHTSKYBLUE),
                new Stop(1.0, purpleAmethyst)
        };

        LinearGradient gradient = new LinearGradient(0, 0, 1, 1, true, null, stops);

        BackgroundFill backgroundFill = new BackgroundFill(gradient, null, null);

        Background background = new Background(backgroundFill);

        profileAnchorePane.setBackground(background);

        profileSideAnchorePane = new AnchorPane();
        profileSideAnchorePane.setPrefHeight(990.0);
        profileSideAnchorePane.setStyle("-fx-background-color: #F5F5F5;");
        AnchorPane.setLeftAnchor(profileSideAnchorePane, 300.0);
        AnchorPane.setRightAnchor(profileSideAnchorePane, 0.0);
        AnchorPane.setTopAnchor(profileSideAnchorePane, 0.0);

        profileSideAnchorePaneLogo = new ImageView("ChemistriyImages/backGraound0.jpg");
        AnchorPane.setRightAnchor(profileSideAnchorePaneLogo, 0.0);
        AnchorPane.setTopAnchor(profileSideAnchorePaneLogo, 0.0);
        AnchorPane.setLeftAnchor(profileSideAnchorePaneLogo, 0.0);
        AnchorPane.setBottomAnchor(profileSideAnchorePaneLogo, 0.0);

        homepagebackground = new ImageView("ChemistriyImages/homepagebackground-removebg-preview.png");
        AnchorPane.setRightAnchor(homepagebackground, 0.0);
        AnchorPane.setTopAnchor(homepagebackground, 0.0);
        AnchorPane.setLeftAnchor(homepagebackground, 0.0);
        AnchorPane.setBottomAnchor(homepagebackground, 0.0);
        homepagebackground.setFitWidth(1640);
        homepagebackground.setFitHeight(990);

        graphAnchorePane = new AnchorPane();
        graphAnchorePane.setPrefHeight(600.0);
        graphAnchorePane.setPrefWidth(500.0);
        AnchorPane.setRightAnchor(graphAnchorePane, 50.0);
        AnchorPane.setTopAnchor(graphAnchorePane, 250.0);
        graphAnchorePane.setStyle("-fx-background-color: WHITE;-fx-background-radius: 30;");

        Color shadowColor = Color.rgb(58, 59, 60);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(shadowColor);
        dropShadow.setRadius(50);

        graphAnchorePane.setEffect(dropShadow);

        c2wLogo = new ImageView("ChemistriyImages/c2wLogo.png");
        c2wLogo.setFitWidth(325);
        c2wLogo.setFitHeight(82);
        AnchorPane.setRightAnchor(c2wLogo, -15.0);
        AnchorPane.setTopAnchor(c2wLogo, 15.0);

        phCalculationLogo = new ImageView("ChemistriyImages/phCalculationLogo.png");
        phCalculationLogo.setFitWidth(840);
        phCalculationLogo.setFitHeight(390);
        AnchorPane.setRightAnchor(phCalculationLogo, 600.0);
        AnchorPane.setTopAnchor(phCalculationLogo, 500.0);

        lineUpper = new Line(0, 210, 300, 210);
        lineUpper.setStroke(Color.WHITE);
        lineUpper.setStrokeWidth(3.0);

        lineLower = new Line(0, 925, 300, 925);
        lineLower.setStroke(Color.WHITE);
        lineLower.setStrokeWidth(3.0);

        elementalTextLogo = new ImageView("ChemistriyImages/elementalLogo2.png");
        elementalTextLogo.setFitWidth(500);
        elementalTextLogo.setFitHeight(90);
        AnchorPane.setLeftAnchor(elementalTextLogo, 85.0);
        AnchorPane.setTopAnchor(elementalTextLogo, 90.0);

        welcomeUsername = new Label("username");

        welcomeUsername.setPrefHeight(40.0);
        // welcomeUsername.setPrefWidth(20.0);
        welcomeUsername.setFont(Font.font("Calibri bold", 18.0));
        welcomeUsername.setStyle("-fx-font-weight:bold;");
        welcomeUsername.setTextFill(Color.BLACK);

        Dashboard = new Button("DASHBOARD");
        Dashboard.setPrefHeight(50.0);
        Dashboard.setPrefWidth(255.0);
        Dashboard.setFont(Font.font("Calibri bold", 18.0));
        Dashboard.setStyle("-fx-font-weight:bold;");
        // Dashboard.setStyle("-fx-background-radius: 15px; #9E7BFF;-fx-padding: 10px
        // 20px;");
        AnchorPane.setRightAnchor(Dashboard, -15.0);
        AnchorPane.setTopAnchor(Dashboard, 250.0);
        Dashboard.setCursor(Cursor.HAND);

        Color purpleAmethyst2 = Color.rgb(210, 90, 240);
        Color purpleAmethyst3 = Color.rgb(240, 178, 208);

        Stop[] stops2 = new Stop[] {
                new Stop(0, purpleAmethyst2),
                new Stop(1, purpleAmethyst3)
        };

        LinearGradient gradient2 = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops2);

        BackgroundFill backgroundFill2 = new BackgroundFill(gradient2, new CornerRadii(18), null);

        Background background2 = new Background(backgroundFill2);

        Dashboard.setBackground(background2);

        Dashboard.setOnAction(event -> {

            profileSideAnchorePane.getChildren().clear();
            graphAnchorePane.getChildren().clear();
            reports.setText("Report");
            dashboardInterface();

        });

        anyalasisButton = new Button("ANALYSIS");
        anyalasisButton.setPrefHeight(50.0);
        anyalasisButton.setPrefWidth(255.0);
        anyalasisButton.setFont(Font.font("Calibri bold", 18.0));
        anyalasisButton.setStyle("-fx-font-weight:bold;");
        AnchorPane.setRightAnchor(anyalasisButton, -15.0);
        AnchorPane.setTopAnchor(anyalasisButton, 335.0);
        anyalasisButton.setBackground(background2);
        anyalasisButton.setCursor(Cursor.HAND);

        anyalasisButton.setOnAction(event -> {

            profileSideAnchorePane.getChildren().clear();
            profileSideAnchorePane.getChildren().addAll(comminSoonLAbel);

        });

        ourteamButton = new Button("OURTEAM");
        ourteamButton.setPrefHeight(50.0);
        ourteamButton.setPrefWidth(255.0);
        ourteamButton.setFont(Font.font("Calibri bold", 18.0));
        ourteamButton.setStyle("-fx-font-weight:bold;");
        AnchorPane.setRightAnchor(ourteamButton, -15.0);
        AnchorPane.setTopAnchor(ourteamButton, 420.0);
        ourteamButton.setBackground(background2);
        ourteamButton.setCursor(Cursor.HAND);

        ourteamButton.setOnAction(event -> {

            profileSideAnchorePane.getChildren().clear();
            profileSideAnchorePane.getChildren().addAll(ourInfoImage, aboutUsLaabel, teamMemLabel, teamMemberNameLabel,
                    backButton);

            // ourInfo();

        });

        abouC2WButton = new Button("ABOUT CORE2WEB");
        abouC2WButton.setPrefHeight(50.0);
        abouC2WButton.setPrefWidth(255.0);
        abouC2WButton.setFont(Font.font("Calibri bold", 18.0));
        abouC2WButton.setStyle("-fx-font-weight:bold;");
        AnchorPane.setRightAnchor(abouC2WButton, -15.0);
        AnchorPane.setTopAnchor(abouC2WButton, 505.0);
        abouC2WButton.setBackground(background2);
        abouC2WButton.setCursor(Cursor.HAND);

        abouC2WButton.setOnAction(event -> {

            profileSideAnchorePane.getChildren().clear();
            profileSideAnchorePane.getChildren().addAll(c2wBackGround, aboutc2wimage, sirImage, backButton, c2wLink);

        });

        aboutUsLaabel = new Label(
                "Introducing our innovative chemistry application, a multifaceted\ntool designed to empower students and chemistry enthusiasts alike.\nThis comprehensive app encompasses a range of essential features,\nmaking it an indispensable resource. \nThis versatile application provides a one-stop solution for chemistry\n-related tasks, from calculations and referencematerials to learning\n and interactive simulations. ");
        aboutUsLaabel.setPrefHeight(320.0);
        aboutUsLaabel.setPrefWidth(600.0);
        // aboutUsLaabel.setTextFill(Color.web("#f2e5e5"));
        aboutUsLaabel.setFont(Font.font("Calibri Bold", 18.0));
        aboutUsLaabel.setStyle("-fx-background-radius: 30px; -fx-padding: 10px 20px; -fx-background-color: #FFFF; ");
        aboutUsLaabel.setTextFill(Color.BLACK);
        AnchorPane.setLeftAnchor(aboutUsLaabel, 80.0);
        AnchorPane.setTopAnchor(aboutUsLaabel, 200.0);

        teamMemLabel = new Label("OUR TEAM MEMBERS ");
        teamMemLabel.setPrefHeight(40.0);
        teamMemLabel.setPrefWidth(480.0);
        // aboutUsLaabel.setTextFill(Color.web("#f2e5e5"));
        teamMemLabel.setFont(Font.font("Calibri Bold", 22.0));
        teamMemLabel.setStyle(
                "-fx-background-radius: 30px; -fx-padding: 10px 20px; -fx-background-color: #FFFF;-fx-font-weight:bold; ");
        teamMemLabel.setTextFill(Color.BLACK);
        AnchorPane.setLeftAnchor(teamMemLabel, 80.0);
        AnchorPane.setTopAnchor(teamMemLabel, 470.0);

        teamMemberNameLabel = new Label(" Prasad Zadokar \n Kunal Sardar \n Ashwini Garad \n Mansi Jadhav");
        teamMemberNameLabel.setPrefHeight(200.0);
        teamMemberNameLabel.setPrefWidth(480.0);
        // teamMemberNameLabel.setTextFill(Color.web("#f2e5e5"));
        teamMemberNameLabel.setFont(Font.font("Calibri Bold", 22.0));
        teamMemberNameLabel.setStyle(
                "-fx-background-radius: 30px; -fx-padding: 10px 20px; -fx-background-color: #FFFF;-fx-font-weight:bold; ");
        teamMemberNameLabel.setTextFill(Color.BLACK);
        AnchorPane.setLeftAnchor(teamMemberNameLabel, 80.0);
        AnchorPane.setTopAnchor(teamMemberNameLabel, 510.0);

        c2wBackGround = new ImageView("ChemistriyImages/c2wBackGround.jpg");
        c2wBackGround.setFitWidth(1640);
        c2wBackGround.setFitHeight(990);
        AnchorPane.setLeftAnchor(c2wBackGround, 0.0);
        AnchorPane.setTopAnchor(c2wBackGround, 0.0);

        aboutc2wimage = new ImageView("ChemistriyImages/aboutcore2web.jpg");
        aboutc2wimage.setFitWidth(700);
        aboutc2wimage.setFitHeight(470);
        AnchorPane.setLeftAnchor(aboutc2wimage, 160.0);
        AnchorPane.setTopAnchor(aboutc2wimage, 200.0);
        aboutc2wimage.setEffect(dropShadow);

        Color shadowColor2 = Color.rgb(80, 235, 236);
        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setColor(shadowColor2);
        dropShadow2.setRadius(150);

        ourInfoImage = new ImageView("ChemistriyImages/ourInfo.jpg");
        ourInfoImage.setFitWidth(1640);
        ourInfoImage.setFitHeight(990);
        AnchorPane.setLeftAnchor(ourInfoImage, 0.0);
        AnchorPane.setTopAnchor(ourInfoImage, 0.0);

        sirImage = new ImageView("ChemistriyImages/sirImages.png");
        sirImage.setFitWidth(400);
        sirImage.setFitHeight(470);
        AnchorPane.setRightAnchor(sirImage, 120.0);
        AnchorPane.setTopAnchor(sirImage, 200.0);
        sirImage.setEffect(dropShadow2);

        c2wInsta = new ImageView("ChemistriyImages/c2wLogo.png");
        c2wInsta.setFitWidth(200);
        c2wInsta.setFitHeight(50);

        c2wLink = new Button("", c2wInsta);
        c2wLink.setPrefHeight(70.0);
        c2wLink.setPrefWidth(170.0);
        AnchorPane.setLeftAnchor(c2wLink, 390.0);
        AnchorPane.setTopAnchor(c2wLink, 700.0);
        c2wLink.setCursor(Cursor.HAND);

        c2wLink.setFont(Font.font("Calibri bold", 16.0));
        c2wLink.setStyle(
                "-fx-background-radius: 30px;-fx-text-fill: BLACK;-fx-padding: 10px 5px;-fx-font-weight:bold;");

        c2wLink.setOnAction(event -> {

            try {
                java.awt.Desktop.getDesktop().browse(new java.net.URI("https://www.core2web.in/"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        loginOutButton = new Button("LOGOUT");
        loginOutButton.setPrefHeight(50.0);
        loginOutButton.setPrefWidth(255.0);
        loginOutButton.setFont(Font.font("Calibri bold", 18.0));
        loginOutButton.setStyle("-fx-font-weight:bold;");
        AnchorPane.setRightAnchor(loginOutButton, -15.0);
        AnchorPane.setTopAnchor(loginOutButton, 590.0);
        loginOutButton.setBackground(background2);
        loginOutButton.setCursor(Cursor.HAND);

        loginOutButton.setOnAction(event -> {

            root.getChildren().clear();
            profileAnchorePane.getChildren().clear();
            profileSideAnchorePane.getChildren().clear();
            graphAnchorePane.getChildren().clear();
            try {

                login();

            } catch (IOException e) {

            }

        });

        periodicTableButton = new Button("PRIODIC\n TABLE");
        periodicTableButton.setPrefHeight(235.0);
        periodicTableButton.setPrefWidth(190.0);
        periodicTableButton.setFont(Font.font("Calibri bold", 20.0));
        periodicTableButton.setStyle("-fx-font-weight:bold;");
        // periodicTableButton.setStyle("-fx-background-radius: 30px;");
        AnchorPane.setLeftAnchor(periodicTableButton, 100.0);
        AnchorPane.setTopAnchor(periodicTableButton, 255.0);
        periodicTableButton.setCursor(Cursor.HAND);

        Color color3 = Color.rgb(244, 51, 255);
        Color color4 = Color.rgb(252, 223, 255);

        Stop[] stops3 = new Stop[] {
                new Stop(0, color3),
                new Stop(1, color4)
        };

        LinearGradient gradient3 = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops3);
        BackgroundFill backgroundFill3 = new BackgroundFill(gradient3, new CornerRadii(25), null);
        Background background3 = new Background(backgroundFill3);
        periodicTableButton.setBackground(background3);

        pagesAnchorPane = new AnchorPane();

        periodicTableButton.setOnAction(event -> {

            profileSideAnchorePane.getChildren().clear();
            graphAnchorePane.getChildren().clear();
            graphAnchorePane.getChildren().add(periodicTableInfo);

            try {

                root = FXMLLoader.load(getClass().getResource("sample.fxml"));

            } catch (IOException e) {

                e.printStackTrace();
            }
            primaryStage.setTitle("Periodic Table ");
            primaryStage.setScene(new Scene(root, 1920, 990));
            primaryStage.setResizable(false);
            primaryStage.show();
            root.getChildren().addAll(backButton, graphAnchorePane, c2wLogo);

        });

        phCalculator = new Button("         PH\nCALCUTATOR");
        phCalculator.setPrefHeight(235.0);
        phCalculator.setPrefWidth(190.0);
        phCalculator.setFont(Font.font("Calibri bold", 20.0));
        phCalculator.setStyle("-fx-font-weight:bold;");
        // phCalculator.setStyle("-fx-background-radius: 30px;");
        AnchorPane.setLeftAnchor(phCalculator, 380.0);
        AnchorPane.setTopAnchor(phCalculator, 255.0);
        phCalculator.setCursor(Cursor.HAND);

        Color color5 = Color.rgb(41, 22, 242);
        Color color6 = Color.rgb(189, 237, 255);

        Stop[] stops4 = new Stop[] {
                new Stop(0, color5),
                new Stop(1, color6)
        };

        LinearGradient gradient4 = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops4);
        BackgroundFill backgroundFill4 = new BackgroundFill(gradient4, new CornerRadii(25), null);
        Background background4 = new Background(backgroundFill4);
        phCalculator.setBackground(background4);

        steps = new Label(
                "Step 1: Identify the solution and its concentration.\n\nStep 2: Find the number of H+ or OH- ions from the\n             dissociation of the given solution.\n\nStep 3: Calculate pH or pOH from the concentration\n             of H+ or OH-\n\n             PH = -log[H+]\n             POH = -log[OH-]");
        // steps.setPrefHeight(30.0);
        // steps.setPrefWidth(100.0);
        steps.setStyle("-fx-font-weight:bold;");
        steps.setTextFill(Color.web("BLACK"));
        steps.setFont(Font.font("Calibri Bold", 18.0));
        AnchorPane.setRightAnchor(steps, 30.0);
        AnchorPane.setLeftAnchor(steps, 30.0);
        AnchorPane.setTopAnchor(steps, 50.0);

        phScaleImage = new ImageView("ChemistriyImages/phScaleImag.png");
        phScaleImage.setFitWidth(370);
        phScaleImage.setFitHeight(220);
        AnchorPane.setRightAnchor(phScaleImage, 60.0);
        AnchorPane.setTopAnchor(phScaleImage, 350.0);

        phcalculationbackgroundimage = new ImageView("ChemistriyImages/phcalculationbackgroundimage (1).png");
        phcalculationbackgroundimage.setFitWidth(1620);
        phcalculationbackgroundimage.setFitHeight(990);
        AnchorPane.setRightAnchor(phcalculationbackgroundimage, 0.0);
        AnchorPane.setTopAnchor(phcalculationbackgroundimage, 0.0);

        phCalculator.setOnAction(event -> {

            primaryStage.setTitle("PH Calculation ");
            profileSideAnchorePane.getChildren().clear();
            graphAnchorePane.getChildren().clear();

            steps.setText(
                    "Step 1: Identify the solution and its concentration.\n\nStep 2: Find the number of H+ or OH- ions from the\n             dissociation of the given solution.\n\nStep 3: Calculate pH or pOH from the concentration\n             of H+ or OH-\n\n             PH = -log[H+]\n             POH = -log[OH-]");
            reports.setText("Steps To Calculate PH");

            graphAnchorePane.getChildren().addAll(steps, phScaleImage);
            profileSideAnchorePane.getChildren().addAll(phcalculationbackgroundimage, mainVBox, phCalculationLogo,
                    backButton, graphAnchorePane, reports);

        });

        equationbalanceButton = new Button(" BALANCE \nEQUATION");
        equationbalanceButton.setPrefHeight(235.0);
        equationbalanceButton.setPrefWidth(190.0);
        equationbalanceButton.setFont(Font.font("Calibri bold", 20.0));
        equationbalanceButton.setStyle("-fx-font-weight:bold;");
        // equationbalanceButton.setStyle("-fx-background-radius: 30px;");
        AnchorPane.setLeftAnchor(equationbalanceButton, 660.0);
        AnchorPane.setTopAnchor(equationbalanceButton, 255.0);
        equationbalanceButton.setCursor(Cursor.HAND);

        Color color7 = Color.rgb(111, 45, 168);
        Color color8 = Color.rgb(204, 204, 255);

        Stop[] stops5 = new Stop[] {
                new Stop(0, color7),
                new Stop(1, color8)
        };

        LinearGradient gradient5 = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops5);
        BackgroundFill backgroundFill5 = new BackgroundFill(gradient5, new CornerRadii(25), null);
        Background background5 = new Background(backgroundFill5);
        equationbalanceButton.setBackground(background5);

        equationbalanceButton.setOnAction(event -> {

            profileSideAnchorePane.getChildren().clear();
            graphAnchorePane.getChildren().clear();
            profileSideAnchorePane.getChildren().addAll(comminSoonLAbel, backButton);

        });

        simulatorButton = new Button("    KINETIC\nSIMULATOR");
        simulatorButton.setPrefHeight(235.0);
        simulatorButton.setPrefWidth(190.0);
        simulatorButton.setFont(Font.font("Calibri bold", 20.0));
        simulatorButton.setStyle("-fx-font-weight:bold;");
        // simulatorButton.setStyle("-fx-background-radius: 30px;");
        AnchorPane.setLeftAnchor(simulatorButton, 100.0);
        AnchorPane.setTopAnchor(simulatorButton, 535.0);
        simulatorButton.setCursor(Cursor.HAND);

        Color color9 = Color.rgb(244, 164, 96);
        Color color10 = Color.rgb(243, 229, 171);

        Stop[] stops6 = new Stop[] {
                new Stop(0, color9),
                new Stop(1, color10)
        };

        LinearGradient gradient6 = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops6);
        BackgroundFill backgroundFill6 = new BackgroundFill(gradient6, new CornerRadii(25), null);
        Background background6 = new Background(backgroundFill6);
        simulatorButton.setBackground(background6);

        simulatorButton.setOnAction(event -> {

            profileSideAnchorePane.getChildren().clear();
            graphAnchorePane.getChildren().clear();
            // profileSideAnchorePane.getChildren().add(comminSoonLAbel);
            getSimulatorInterface();

        });

        theroryButton = new Button(" THEORY");
        theroryButton.setPrefHeight(235.0);
        theroryButton.setPrefWidth(190.0);
        theroryButton.setFont(Font.font("Calibri bold", 20.0));
        theroryButton.setStyle("-fx-font-weight:bold;");
        // quizButtom.setStyle("-fx-background-radius: 30px;");
        AnchorPane.setLeftAnchor(theroryButton, 380.0);
        AnchorPane.setTopAnchor(theroryButton, 535.0);
        theroryButton.setCursor(Cursor.HAND);

        Color color11 = Color.rgb(72, 60, 50);
        Color color12 = Color.rgb(255, 230, 232);

        Stop[] stops7 = new Stop[] {
                new Stop(0, color11),
                new Stop(1, color12)
        };

        LinearGradient gradient7 = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops7);
        BackgroundFill backgroundFill7 = new BackgroundFill(gradient7, new CornerRadii(25), null);
        Background background7 = new Background(backgroundFill7);
        theroryButton.setBackground(background7);
        theroryButton.setCursor(Cursor.HAND);

        theroryButton.setOnAction(event -> {

            profileSideAnchorePane.getChildren().clear();
            graphAnchorePane.getChildren().clear();

            TheoryInterface();

        });

        quizButtom = new Button("QUIZ");
        quizButtom.setPrefHeight(235.0);
        quizButtom.setPrefWidth(190.0);
        quizButtom.setFont(Font.font("Calibri bold", 20.0));
        quizButtom.setStyle("-fx-font-weight:bold;");
        // quizButtom.setStyle("-fx-background-radius: 30px;");
        AnchorPane.setLeftAnchor(quizButtom, 660.0);
        AnchorPane.setTopAnchor(quizButtom, 535.0);
        quizButtom.setCursor(Cursor.HAND);

        Color color13 = Color.rgb(0, 128, 0);
        Color color14 = Color.rgb(219, 249, 219);

        Stop[] stops8 = new Stop[] {
                new Stop(0, color13),
                new Stop(1, color14)
        };

        LinearGradient gradient8 = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops8);
        BackgroundFill backgroundFill8 = new BackgroundFill(gradient8, new CornerRadii(25), null);
        Background background8 = new Background(backgroundFill8);
        quizButtom.setBackground(background8);
        quizButtom.setOnAction(event -> {

            profileSideAnchorePane.getChildren().clear();
            graphAnchorePane.getChildren().clear();

            quizInterface();
            profileSideAnchorePane.getChildren().addAll(layout, backButton);

        });

        periodicTableInfo = new Label(
                "The periodic table is a tabular arrangement of \nchemical elements, organized based on their \natomic number, electron configuration, and \nrecurring chemical properties. It provides a \nsystematic way to understand and categorize\nthe elements, which are the building blocks of\n matter");
        // periodicTableInfo.setPrefHeight(30.0);
        // periodicTableInfo.setPrefWidth(400.0);
        periodicTableInfo.setStyle("-fx-font-weight:bold;");
        periodicTableInfo.setTextFill(Color.web("black"));
        periodicTableInfo.setFont(Font.font("Calibri Bold", 18.0));
        AnchorPane.setLeftAnchor(periodicTableInfo, 50.0);
        AnchorPane.setTopAnchor(periodicTableInfo, 80.0);
        AnchorPane.setRightAnchor(periodicTableInfo, 50.0);
        AnchorPane.setBottomAnchor(periodicTableInfo, 80.0);

        reports = new Label("Report");
        reports.setPrefHeight(30.0);
        reports.setPrefWidth(400.0);
        reports.setStyle("-fx-font-weight:bold;");
        reports.setTextFill(Color.web("#1E90FF"));
        reports.setFont(Font.font("Calibri Bold", 25.0));
        AnchorPane.setLeftAnchor(reports, 1070.0);
        AnchorPane.setTopAnchor(reports, 185.0);

        comminSoonLAbel = new Label("          Comming Soon ...");
        comminSoonLAbel.setPrefHeight(150.0);
        comminSoonLAbel.setPrefWidth(400.0);
        comminSoonLAbel.setStyle("-fx-font-weight:bold;");
        comminSoonLAbel.setTextFill(Color.web("BLACK"));
        comminSoonLAbel.setFont(Font.font("Calibri", 28.0));
        AnchorPane.setRightAnchor(comminSoonLAbel, 600.0);
        AnchorPane.setTopAnchor(comminSoonLAbel, 400.0);

        backButtonLogo = new ImageView("ChemistriyImages/backButtonLogo.png");
        backButtonLogo.setFitWidth(40);
        backButtonLogo.setFitHeight(40);

        backButton = new Button("  BACK ", backButtonLogo);
        backButton.setPrefHeight(40.0);
        backButton.setPrefWidth(.0);
        backButton.setFont(Font.font("Calibri bold", 24.0));
        backButton.setStyle(
                "-fx-background-radius: 30px;-fx-text-fill: white;-fx-background-color: #9E7BFF;-fx-padding: 10px 5px;-fx-font-weight:bold;");

        String pressedButtonStyle = "-fx-background-color: #6C2DC7;-fx-background-radius: 30px;-fx-text-fill: white;-fx-background-color: #7B68EE;-fx-padding: 10px 20px;";

        backButton.setOnMousePressed(event -> backButton.setStyle(pressedButtonStyle));
        backButton.setOnMouseReleased(event -> backButton.setStyle(
                "-fx-background-radius: 30px;-fx-text-fill: white;-fx-background-color: #9E7BFF;-fx-padding: 10px 20px;"));

        AnchorPane.setLeftAnchor(backButton, 170.0);
        AnchorPane.setRightAnchor(backButton, 1580.0);
        AnchorPane.setTopAnchor(backButton, 850.0);
        backButton.setCursor(Cursor.HAND);

        backButton.setOnAction(event -> {

            primaryStage.setTitle("Chemistry Project Home Page ");
            root.getChildren().clear();
            profileAnchorePane.getChildren().clear();
            profileSideAnchorePane.getChildren().clear();
            graphAnchorePane.getChildren().clear();
            reports.setText("Report");
            homePageMethod();
            dashboardInterface();

        });

        // ************************************************************** */

        mainVBox = new VBox(20);
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setPadding(new Insets(10, 10, 10, 10));
        mainVBox.setStyle("-fx-background-image: url('ph3.jpg'); " + "-fx-background-size: cover;");

        AnchorPane.setRightAnchor(mainVBox, 790.0);
        AnchorPane.setTopAnchor(mainVBox, 250.0);

        titleLabel = new Label("pH Calculator");
        titleLabel.setStyle(
                "-fx-text-fill:indigo;-fx-background-color:ghostwhite; -fx-font-weight: bold; -fx-font-size:30");

        concentrationLabel = new Label("Concentration (M):");
        concentrationLabel.setStyle("-fx-text-fill: maroon; -fx-font-weight: bold; -fx-font-size:26");

        concentrationField = new TextField();
        concentrationField.setStyle("-fx-text-fill: BLACK; -fx-font-weight: bold; -fx-font-size:16");
        resultLabel = new Label("pH Result:");
        resultLabel.setStyle("-fx-text-fill: seagreen; -fx-font-weight: bold; -fx-font-size:24");

        pHValueLabel = new Label();
        pHValueLabel.setStyle(" -fx-font-weight: bold; -fx-font-size:20");

        calculateButton = new Button("Calculate pH");
        calculateButton.setStyle(" -fx-font-weight: bold;");
        calculateButton.setFont(Font.font("Calibri bold", 20.0));
        calculateButton.setStyle(
                "-fx-background-radius: 30px;-fx-text-fill: white;-fx-background-color: #9E7BFF;-fx-padding: 10px 20px;");
        String pressedButtonStyle1 = "-fx-background-color: #6C2DC7;-fx-background-radius: 30px;-fx-text-fill: white;-fx-background-color: #7B68EE;-fx-padding: 10px 20px;";

        calculateButton.setOnMousePressed(event -> calculateButton.setStyle(pressedButtonStyle1));
        calculateButton.setOnMouseReleased(event -> calculateButton.setStyle(
                "-fx-background-radius: 30px;-fx-text-fill: white;-fx-background-color: #9E7BFF;-fx-padding: 10px 20px;"));
        calculateButton.setCursor(Cursor.HAND);

        inputHBox = new HBox(10);

        inputHBox.setAlignment(Pos.CENTER);
        inputHBox.getChildren().addAll(concentrationLabel, concentrationField);

        resultHBox = new HBox(10);
        resultHBox.setAlignment(Pos.CENTER);
        resultHBox.getChildren().addAll(resultLabel, pHValueLabel);

        mainVBox.getChildren().addAll(titleLabel, inputHBox, resultHBox, calculateButton);

        calculateButton.setOnAction(event -> {
            try {
                double concentration = Double.parseDouble(concentrationField.getText());
                double pH = -Math.log10(concentration);
                pHValueLabel.setText(String.format("%.2f", pH));
            } catch (NumberFormatException e) {
                pHValueLabel.setText("Invalid input");
            }
        });

        /************************************************************** */

        try {

            login();

        } catch (IOException e) {

        }
        /************************************************
         * * Therory ********************************************************
         */

        videoLink1 = "https://www.youtube.com/watch?v=CIKEp6q-yng&t=40s";
        videoLink2 = "https://www.youtube.com/watch?v=Mxow_MvhZX0";
        videoLink3 = "https://www.youtube.com/watch?v=fLFXDdnJN5U&t=11s";
        videoLink4 = "https://www.youtube.com/watch?v=ybbHBMp6Vxs";
        videoLink5 = "https://www.youtube.com/watch?v=NkIHYfqLiJE";

        button1logo = new ImageView("ChemistriyImages/dalton.png");
        button1logo.setFitWidth(70);
        button1logo.setFitHeight(70);

        playButton1 = new Button(" DALTON'S ATOMIC THEORY\n VIDEO EXPLANATION", button1logo);
        playButton1.setPrefHeight(70.0);
        playButton1.setPrefWidth(350);
        AnchorPane.setLeftAnchor(playButton1, 50.0);
        AnchorPane.setTopAnchor(playButton1, 380.0);
        playButton1.setCursor(Cursor.HAND);

        playButton1.setFont(Font.font("Calibri bold", 16.0));
        playButton1.setStyle(
                "-fx-background-radius: 30px;-fx-text-fill: BLACK;-fx-padding: 10px 5px;-fx-font-weight:bold;");

        String pressedButtonStyle2 = "-fx-background-color: #6C2DC7;-fx-background-radius: 30px;-fx-text-fill: Black;-fx-background-color: #7B68EE;-fx-padding: 10px 20px;";

        backButton.setOnMousePressed(event -> playButton1.setStyle(pressedButtonStyle2));
        backButton.setOnMouseReleased(event -> playButton1.setStyle(
                "-fx-background-radius: 30px;-fx-text-fill: white;-fx-background-color: #9E7BFF;-fx-padding: 10px 20px;"));

        playButton1.setOnAction(event -> {

            try {
                java.awt.Desktop.getDesktop().browse(new java.net.URI(videoLink1));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        ImageView button2logo = new ImageView("ChemistriyImages/bohr.png");
        button2logo.setFitWidth(70);
        button2logo.setFitHeight(70);
        playButton2 = new Button(" BOHR'S ATOMIC THEORY\n  VIDEO EXPLANATION", button2logo);
        playButton2.setPrefHeight(70.0);
        playButton2.setPrefWidth(350.0);
        playButton2.setFont(Font.font("Calibri bold", 18.0));
        playButton2.setStyle("-fx-font-weight:bold;");
        playButton2.setStyle("-fx-background-radius: 20px; -fx-background-colur:BLACK; -fx-padding: 10px 20px;");
        AnchorPane.setLeftAnchor(playButton2, 600.0);
        AnchorPane.setTopAnchor(playButton2, 380.0);
        playButton2.setCursor(Cursor.HAND);

        playButton2.setFont(Font.font("Calibri bold", 16.0));
        playButton2.setStyle(
                "-fx-background-radius: 30px;-fx-text-fill: BLACK;-fx-padding: 10px 5px;-fx-font-weight:bold;");

        backButton.setOnMousePressed(event -> playButton2.setStyle(pressedButtonStyle2));
        backButton.setOnMouseReleased(event -> playButton2.setStyle(
                "-fx-background-radius: 30px;-fx-text-fill: white;-fx-background-color: #9E7BFF;-fx-padding: 10px 20px;"));

        playButton2.setOnAction(event -> {

            try {
                java.awt.Desktop.getDesktop().browse(new java.net.URI(videoLink2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        ImageView button3logo = new ImageView("ChemistriyImages/rutherford.png");
        button3logo.setFitWidth(70);
        button3logo.setFitHeight(70);
        playButton3 = new Button(" Rutherford Experiment\n  VIDEO EXPLANATION", button3logo);
        playButton3.setPrefHeight(70.0);
        playButton3.setPrefWidth(350.0);
        playButton3.setFont(Font.font("Calibri bold", 18.0));
        playButton3.setStyle("-fx-font-weight:bold;");
        playButton3.setStyle("-fx-background-radius: 20px; -fx-background-colur:BLACK; -fx-padding: 10px 20px;");
        AnchorPane.setLeftAnchor(playButton3, 1150.0);
        AnchorPane.setTopAnchor(playButton3, 380.0);
        playButton3.setCursor(Cursor.HAND);

        playButton3.setFont(Font.font("Calibri bold", 16.0));
        playButton3.setStyle(
                "-fx-background-radius: 30px;-fx-text-fill: BLACK;-fx-padding: 10px 5px;-fx-font-weight:bold;");

        backButton.setOnMousePressed(event -> playButton3.setStyle(pressedButtonStyle2));
        backButton.setOnMouseReleased(
                event -> playButton3.setStyle("-fx-background-radius: 30px;-fx-padding: 10px 20px;"));

        playButton3.setOnAction(event -> {

            try {
                java.awt.Desktop.getDesktop().browse(new java.net.URI(videoLink3));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        ImageView button4logo = new ImageView("ChemistriyImages/thomson.png");
        button4logo.setFitWidth(70);
        button4logo.setFitHeight(70);

        playButton4 = new Button(" Thomson's Model of Atom\n  VIDEO EXPLANATION", button4logo);
        playButton4.setPrefHeight(70.0);
        playButton4.setPrefWidth(350.0);
        playButton4.setFont(Font.font("Calibri bold", 18.0));
        playButton4.setStyle("-fx-font-weight:bold;");
        playButton4.setStyle("-fx-background-radius: 20px; -fx-background-colur:BLACK; -fx-padding: 10px 20px;");
        AnchorPane.setLeftAnchor(playButton4, 600.0);
        AnchorPane.setBottomAnchor(playButton4, 50.0);
        playButton4.setCursor(Cursor.HAND);

        playButton4.setFont(Font.font("Calibri bold", 16.0));
        playButton4.setStyle(
                "-fx-background-radius: 30px;-fx-text-fill: BLACK;-fx-padding: 10px 5px;-fx-font-weight:bold;");

        backButton.setOnMousePressed(event -> playButton4.setStyle(pressedButtonStyle2));
        backButton.setOnMouseReleased(event -> playButton4
                .setStyle("-fx-background-radius: 30px;-fx-background-color: #9E7BFF;-fx-padding: 10px 20px;"));

        playButton4.setOnAction(event -> {

            try {
                java.awt.Desktop.getDesktop().browse(new java.net.URI(videoLink4));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        ImageView button5logo = new ImageView("ChemistriyImages/Atom.png");
        button5logo.setFitWidth(70);
        button5logo.setFitHeight(70);

        playButton5 = new Button(" Atoms And Molecules\n VIDEO EXPLANATION", button5logo);
        playButton5.setPrefHeight(70.0);
        playButton5.setPrefWidth(350.0);
        playButton5.setFont(Font.font("Calibri bold", 18.0));
        playButton5.setStyle("-fx-font-weight:bold;");
        playButton5.setStyle("-fx-background-radius: 20px; -fx-background-colur:BLACK; -fx-padding: 10px 20px;");
        AnchorPane.setLeftAnchor(playButton5, 1160.0);
        AnchorPane.setBottomAnchor(playButton5, 50.0);
        playButton5.setCursor(Cursor.HAND);

        playButton5.setFont(Font.font("Calibri bold", 16.0));
        playButton5.setStyle(
                "-fx-background-radius: 30px;-fx-text-fill: BLACK;-fx-padding: 10px 5px;-fx-font-weight:bold;");

        backButton.setOnMousePressed(event -> playButton5.setStyle(pressedButtonStyle2));
        backButton.setOnMouseReleased(event -> playButton5
                .setStyle("-fx-background-radius: 30px;-fx-padding: 10px 20px;-fx-font-weight:bold;"));

        playButton5.setOnAction(event -> {

            try {
                java.awt.Desktop.getDesktop().browse(new java.net.URI(videoLink5));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        theory1 = new Label("Daltons Atomic Theory\n\n" + //
                "Scientist Name: John Dalton\n" + //
                "Discovery Year: Early 19th \ncentury (circa 1803)\n\n" + //
                "Description:\n" + //
                "1) Atoms of different elements have\n    different masses and properties ");
        theory1.setPrefHeight(320.0);
        theory1.setPrefWidth(350.0);
        // theory1.setTextFill(Color.web("#f2e5e5"));
        theory1.setFont(Font.font("Calibri Bold", 18.0));
        theory1.setStyle("-fx-background-radius: 30px; -fx-padding: 10px 20px; -fx-background-color: #FFFF; ");
        theory1.setTextFill(Color.BLACK);
        AnchorPane.setLeftAnchor(theory1, 50.0);
        AnchorPane.setTopAnchor(theory1, 50.0);

        theory2 = new Label("Bohrs Atomic Theory\n\n" + //
                "Scientist Name: Niels Bohr\n" + //
                "Discovery Year: 1913\n\n" + //
                "Description:\n" + //
                "1) Electrons can only exist in these \n   specific energy levels, not in between\n   them.\n" //
        );
        theory2.setPrefHeight(320.0);

        theory2.setPrefWidth(350.0);
        // theory2.setTextFill(Color.web("#f2e5e5"));
        theory2.setFont(Font.font("Calibri Bold", 18.0));
        theory2.setStyle("-fx-background-radius: 30px; -fx-padding: 10px 20px; -fx-background-color: #FFFF; ");
        theory2.setTextFill(Color.BLACK);
        AnchorPane.setLeftAnchor(theory2, 600.0);
        AnchorPane.setTopAnchor(theory2, 50.0);

        theory3 = new Label("Rutherford Experiment \n\n" + //
                "Scientist Name: Ernest Rutherford\n" + //
                "Discovery Year: 1909\n\n" + //
                "Description:\n" + //
                "1) It says positively charged\n    nucleus at the center, while\n    electrons orbit the nucleus. \n" + //
                " ");
        theory3.setPrefHeight(320.0);
        theory3.setPrefWidth(350.0);
        // theory3.setTextFill(Color.web("#f2e5e5"));
        theory3.setFont(Font.font("Calibri Bold", 18.0));
        theory3.setStyle("-fx-background-radius: 30px; -fx-padding: 10px 20px; -fx-background-color: #FFFF; ");
        theory3.setTextFill(Color.BLACK);
        AnchorPane.setLeftAnchor(theory3, 1150.0);
        AnchorPane.setTopAnchor(theory3, 50.0);

        theory4 = new Label(
                " Thomson's Model of Atom \n\nScientis: J.J. Thomson Discovery\nYear: Late 19th century (around 1897)\n\nDescription of Model:\n1) Electrons are distributed throughout\n    the atom in a relatively uniform\n    manner. ");
        theory4.setPrefHeight(320.0);
        theory4.setPrefWidth(350.0);
        // theory4.setTextFill(Color.web("#f2e5e5"));
        theory4.setFont(Font.font("Calibri Bold", 18.0));
        theory4.setStyle("-fx-background-radius: 30px; -fx-padding: 10px 20px; -fx-background-color: #FFFF; ");
        theory4.setTextFill(Color.BLACK);
        AnchorPane.setLeftAnchor(theory4, 600.0);
        AnchorPane.setBottomAnchor(theory4, 150.0);

        theory5 = new Label("Atoms and Molecules\n\n" + //
                "Description:\n" + //
                " He also suggested that different \n elements have different types of\n atoms, and compounds are formed\n by the combination of atoms in\n fixed ratios.\n"
                + //
                " ");
        theory5.setPrefHeight(320.0);
        theory5.setPrefWidth(350.0);
        // theory5.setTextFill(Color.web("#f2e5e5"));
        theory5.setFont(Font.font("Calibri Bold", 18.0));
        theory5.setStyle("-fx-background-radius: 30px; -fx-padding: 10px 20px; -fx-background-color: #FFFF; ");
        theory5.setTextFill(Color.BLACK);
        AnchorPane.setLeftAnchor(theory5, 1160.0);
        AnchorPane.setBottomAnchor(theory5, 150.0);

        /*********************************************************
         * QUIZ
         *************************************************************/

        repeatQuiz = new Button("PRATICE AGAIN ");
        repeatQuiz.setPrefHeight(50.0);
        repeatQuiz.setPrefWidth(300.0);
        repeatQuiz.setFont(Font.font("Calibri bold", 18.0));
        repeatQuiz.setStyle(
                "-fx-background-radius: 20px;-fx-text-fill: white;-fx-background-color: #9E7BFF;-fx-font-weight:bold;");

        String pressedButtonStyle3 = "-fx-background-color: #6C2DC7;-fx-background-radius: 20px;-fx-text-fill: blue;-fx-background-color: #7B68EE;-";

        repeatQuiz.setOnMousePressed(event -> repeatQuiz.setStyle(pressedButtonStyle3));
        repeatQuiz.setOnMouseReleased(event -> repeatQuiz
                .setStyle("-fx-background-radius: 20px;-fx-text-fill: white;-fx-background-color: #9E7BFF;"));

        AnchorPane.setLeftAnchor(repeatQuiz, 675.0);
        // AnchorPane.setRightAnchor(repeatQuiz, 1580.0);
        AnchorPane.setTopAnchor(repeatQuiz, 700.0);
        repeatQuiz.setCursor(Cursor.HAND);

        repeatQuiz.setOnAction(event -> {

            profileSideAnchorePane.getChildren().clear();
            graphAnchorePane.getChildren().clear();

            quizInterface();
            profileSideAnchorePane.getChildren().addAll(layout, backButton);

        });

        /******************************************************************************************************************** */

        // root.getChildren().addAll();

        Scene scene = new Scene(root, 1920, 990);
        primaryStage.setResizable(false);
        // Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void login() throws IOException {

        ImageView backGround = new ImageView("ChemistriyImages/loginpage5.jpg");
        backGround.setFitHeight(990);
        backGround.setFitWidth(1920);
        AnchorPane.setRightAnchor(backGround, 0.0);
        AnchorPane.setTopAnchor(backGround, 0.0);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter your username");
        usernameField.setStyle("-fx-font-size: 20px;");
        usernameField.setPrefWidth(350);
        usernameField.setPrefHeight(40);
        usernameField.setLayoutX(1070);
        usernameField.setLayoutY(405);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordField.setStyle("-fx-font-size: 20px;");
        passwordField.setPrefWidth(350);
        passwordField.setPrefHeight(40);
        passwordField.setLayoutX(1070);
        passwordField.setLayoutY(510);

        final Button login = new Button("Login");
        login.setPrefHeight(55.0);
        login.setPrefWidth(.0);
        login.setFont(Font.font("Calibri bold", 24.0));
        login.setStyle(
                "-fx-background-radius: 30px;-fx-text-fill: white;-fx-background-color: #9E7BFF;-fx-padding: 10px 20px;");

        String pressedButtonStyle = "-fx-background-color: #6C2DC7;-fx-background-radius: 30px;-fx-text-fill: white;-fx-background-color: #7B68EE;-fx-padding: 10px 20px;";

        login.setOnMousePressed(event -> login.setStyle(pressedButtonStyle));
        login.setOnMouseReleased(event -> login.setStyle(
                "-fx-background-radius: 30px;-fx-text-fill: white;-fx-background-color: #9E7BFF;-fx-padding: 10px 20px;"));

        AnchorPane.setLeftAnchor(login, 1100.0);
        AnchorPane.setRightAnchor(login, 560.0);
        AnchorPane.setTopAnchor(login, 597.0);
        login.setCursor(Cursor.HAND);

        Label loginError = new Label(" ");
        loginError.setPrefHeight(75.0);
        loginError.setPrefWidth(1210.0);

        loginError.setTextFill(Color.web("#f2e5e5"));
        loginError.setFont(Font.font("Calibri Bold", 18.0));
        loginError.setTextFill(Color.RED);
        AnchorPane.setLeftAnchor(loginError, 1100.0);
        AnchorPane.setRightAnchor(loginError, 45.0);
        AnchorPane.setTopAnchor(loginError, 670.0);

        root.getChildren().addAll(backGround, usernameField, passwordField, login, loginError);

        login.setOnAction(event -> {

            username = usernameField.getText();
            String password = passwordField.getText();

            Properties properties = new Properties();

            try (InputStream input = new FileInputStream(
                    "LoginInfo.properties")) {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String storedPassword = properties.getProperty(username);

            if (storedPassword != null && storedPassword.equals(password)) {

                Properties properties2 = new Properties();

                try (InputStream input = new FileInputStream(
                        "currectQuizuizeInfo.properties")) {
                    properties2.load(input);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                currectQuiz = Integer.parseInt(properties2.getProperty(username));
                wrongQuize = 100 - currectQuiz;
                // System.out.println(currectQuiz);
                getPiGraph(wrongQuize, currectQuiz);
                String userLogo = "ProfilePhotos/" + username + ".png";
                try {
                    profileLogo = new ImageView(userLogo);
                } catch (Exception e) {

                    profileLogo = new ImageView("ProfilePhotos/profileLogo2.png");

                }

                profileLogo.setFitWidth(120);
                profileLogo.setFitHeight(120);
                AnchorPane.setRightAnchor(profileLogo, 95.0);
                AnchorPane.setTopAnchor(profileLogo, 30.0);

                double n = (300 - username.length() * 8.5) / 2;
                AnchorPane.setLeftAnchor(welcomeUsername, n);
                AnchorPane.setTopAnchor(welcomeUsername, 150.0);

                root.getChildren().clear();
                homePageMethod();
                dashboardInterface();
                reports.setText("Report");

            } else {
                loginError.setText("Username or password is wrong");
            }

            /***************************************************************** 9 */

        });

    }

    private void homePageMethod() {

        welcomeUsername.setText(username);
        profileAnchorePane.getChildren().addAll(profileLogo, welcomeUsername, Dashboard, anyalasisButton, ourteamButton,
                abouC2WButton, loginOutButton, lineUpper, lineLower);
        root.getChildren().addAll(profileAnchorePane, profileSideAnchorePane, c2wLogo);

    }

    private void dashboardInterface() {

        graphAnchorePane.getChildren().addAll(vbox);
        profileSideAnchorePane.getChildren().addAll(profileSideAnchorePaneLogo,
                /* homepagebackground, */ graphAnchorePane, elementalTextLogo, periodicTableButton, phCalculator,
                equationbalanceButton, simulatorButton, theroryButton, quizButtom, reports);

    }

    private void getPiGraph(int w, int c) {

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Wrong", w),
                new PieChart.Data("Currect", c));

        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Quiz Analysis");
        pieChart.setStyle("-fx-font-weight:bold;");
        pieChart.setPrefSize(800, 800);

        vbox = new VBox(pieChart);
        AnchorPane.setRightAnchor(vbox, 20.0);
        AnchorPane.setTopAnchor(vbox, 50.0);
        vbox.setPrefSize(450, 450);
    }

    String videoLink1, videoLink2, videoLink3, videoLink4, videoLink5;

    // Define the YouTube video links

    void TheoryInterface() {

        profileSideAnchorePane.getChildren().addAll(playButton1, playButton2, playButton3, playButton4, playButton5,
                theory1, theory2, theory3, theory4, theory5, backButton);

    }

    private Question[] questions = {

            new Question("Q1.Which of the following is the essential element for batteries used in electric cars?",
                    "Magnesium", "Lithium", "Sodium", "Bromine", "Lithium"),
            new Question("Q2.What is the ratio of change in configuration to the original configuration called as?",
                    "Rebound", "Strain", "Stress", "Elasticity", "Strain"),
            new Question("Q3.Which of the following is not a mixture?", "Air", "Ocean water", "Table Salt", "Soil",
                    "Table Salt"),
            new Question("Q4.What is the atomic number of carbon?", "2", "6", "12", "14", "6"),
            new Question("Q5.Which of the following is a noble gas?", "Nitrogen", "Oxygen", "Argon", "Carbon dioxide",
                    "Argon"),

    };

    private Label questionLabel;
    private RadioButton[] answerRadioButtons;
    private Button submitButton;
    private Label quizResultLabel;

    void quizInterface() {

        currentQuestionIndex = 0;
        questionLabel = new Label();
        questionLabel.setStyle("-fx-text-fill: maroon; -fx-font-weight: bold; -fx-font-size:22");

        answerRadioButtons = new RadioButton[4];
        ToggleGroup answerGroup = new ToggleGroup();
        for (int i = 0; i < 4; i++) {
            answerRadioButtons[i] = new RadioButton();
            answerRadioButtons[i].setToggleGroup(answerGroup);
            answerRadioButtons[i].setStyle("-fx-text-fill: black;-fx-font-weight:bold;-fx-font-size:20;"); // Set text
                                                                                                           // color
            answerRadioButtons[i].setCursor(Cursor.HAND);

        }

        submitButton = new Button("Submit");
        submitButton.setPrefHeight(45.0);
        submitButton.setPrefWidth(120.0);
        submitButton.setFont(Font.font("Calibri bold", 21.0));
        quizResultLabel = new Label();
        quizResultLabel.setStyle(" -fx-font-weight: bold; -fx-font-size:24");

        submitButton.setStyle(
                "-fx-background-radius: 30px;-fx-background-color: #9E7BFF; -fx-text-fill: white;-fx-padding: 10px 20px"); // Button
                                                                                                                           // styling

        submitButton.setOnMousePressed(event -> submitButton.setStyle(
                "-fx-background-color: #6C2DC7;-fx-background-radius: 30px;-fx-text-fill: white;-fx-background-color: #7B68EE;-fx-padding: 10px 20px;"));
        submitButton.setOnMouseReleased(event -> submitButton.setStyle(
                "-fx-background-radius: 30px;-fx-text-fill: white;-fx-background-color: #9E7BFF;-fx-padding: 10px 20px;"));

        submitButton.setOnAction(event -> {
            if (answerGroup.getSelectedToggle() != null) {
                RadioButton selectedRadioButton = (RadioButton) answerGroup.getSelectedToggle();
                String selectedAnswer = selectedRadioButton.getText();
                checkAnswer(selectedAnswer);
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    loadQuestion(currentQuestionIndex);
                } else {
                    showResult();
                }
            }
        });

        VBox optionsBox = new VBox(15);
        optionsBox.setAlignment(Pos.CENTER);
        optionsBox.setPadding(new Insets(5));
        optionsBox.setStyle(
                "-fx-background-color: #7ad7f0; -fx-border-color: black; -fx-border-width: 1px; -fx-border-radius: 1px;");

        GridPane optionsGrid = new GridPane();
        optionsGrid.setAlignment(Pos.CENTER);
        optionsGrid.setHgap(10);
        optionsGrid.setVgap(10);

        for (int i = 0; i < 4; i++) {
            answerRadioButtons[i].setStyle("-fx-text-fill: black;-fx-font-weight:bold");
            optionsGrid.add(answerRadioButtons[i], 0, i);

        }

        layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        AnchorPane.setRightAnchor(layout, 0.0);
        AnchorPane.setLeftAnchor(layout, 0.0);
        AnchorPane.setTopAnchor(layout, 0.0);
        AnchorPane.setBottomAnchor(layout, 0.0);
        // layout.setStyle("-fx-background-color: #99CCFF;-fx-border-color: black;
        // -fx-border-width: 1px;");
        // layout.setStyle("fx-background-image:url('Chem.jpg');" +
        // "-fx-background-size:cover;");
        layout.setStyle("-fx-background-image: url('ChemistriyImages/Chem2.jpg'); " + "-fx-background-size: cover;");

        layout.getChildren().addAll(questionLabel, optionsGrid, submitButton, quizResultLabel);
        loadQuestion(currentQuestionIndex);

    }

    private void loadQuestion(int index) {
        Question question = questions[index];
        questionLabel.setText(question.getQuestion());
        for (int i = 0; i < 4; i++) {
            answerRadioButtons[i].setText(question.getOptions()[i]);
            answerRadioButtons[i].setSelected(false);
        }
        quizResultLabel.setText("");
    }

    private void checkAnswer(String selectedAnswer) {
        Question question = questions[currentQuestionIndex];
        if (selectedAnswer.equals(question.getCorrectAnswer())) {
            score++;
        }
    }

    private void showResult() {
        quizResultLabel.setText("Quiz Completed! Your Score: " + score + " out of " + questions.length);
        doCelebration();
        submitButton.setDisable(true);
        quizCalculation();

    }

    void doCelebration() {

        media = new Media(getClass().getResource("celebration3.mp4").toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(1600); // Width
        mediaView.setFitHeight(990);
        AnchorPane.setTopAnchor(mediaView, -3.0);
        // AnchorPane.setBottomAnchor(mediaView, 0.0);

        AnchorPane.setLeftAnchor(mediaView, 10.0);

        profileSideAnchorePane.getChildren().remove(backButton);
        profileSideAnchorePane.getChildren().add(mediaView);
        mediaPlayer.play();

        AnchorPane.setBottomAnchor(quizResultLabel, 320.0);
        AnchorPane.setLeftAnchor(quizResultLabel, 600.0);
        profileSideAnchorePane.getChildren().addAll(backButton, repeatQuiz, quizResultLabel);
    }

    void quizCalculation() {

        graphAnchorePane.getChildren().clear();
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream(
                "currectQuizuizeInfo.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        currectQuiz = Integer.parseInt(properties.getProperty(username));
        currectQuiz = currectQuiz + score;
        getPiGraph(wrongQuize, currectQuiz);
        score = 0;

        try {

            String currectQuizString = "" + currectQuiz;

            properties.setProperty(username, currectQuizString);

            FileOutputStream output = new FileOutputStream("currectQuizuizeInfo.properties");
            properties.store(output, "Updated properties");
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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

        reactionRateConstantA = 0.1;
        reactionRateConstantB = 0.1;
        initialConcentrationA = 1.0;
        initialConcentrationB = 1.0;
        initialConcentrationC = 0.0;
        initialConcentrationD = 0.0;
        double time = 0.0;

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

        AnchorPane temAnchorPane = new AnchorPane();
        temAnchorPane.setPrefWidth(1940);
        temAnchorPane.setPrefHeight(990);

        VBox root = createVBox(10, Pos.CENTER);
        root.setPrefHeight(500.0);
        root.setPrefWidth(1000.0);

        AnchorPane.setLeftAnchor(root, 300.0);
        AnchorPane.setTopAnchor(root, 200.0);

        // Set a background image
        Image backgroundImage = new Image("ChemistriyImages/Chem2.jpg");
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitHeight(990);
        backgroundView.setFitWidth(1900);
        backgroundView.setStyle("-fx-background-size: cover;");

        root.getChildren().addAll(
                timeLabel, concentrationLabelA, concentrationLabelB, concentrationLabelC, concentrationLabelD,
                reactionRateSliderA, reactionRateSliderB, simulateButton);

        profileSideAnchorePane.getChildren().addAll(backgroundView, root, backButton);

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

    public static void main(String args[]) {
        launch(args);
    }

}
