
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The main application class that extends JavaFX Application and implements the quiz application.
 */

public class ChemistryQuiz extends Application {

    private int currentQuestionIndex = 0;
    private int score = 0;

    private Question[] questions = {
            
            new Question("Q1.Which of the following is the essential element for batteries used in electric cars?", "Magnesium", "Lithium", "Sodium", "Bromine", "Lithium"),
            new Question("Q2.What is the ratio of change in configuration to the original configuration called as?", "Rebound", "Strain", "Stress", "Elasticity", "Strain"),
            new Question("Q3.Which of the following is not a mixture?", "Air", "Ocean water", "Table Salt", "Soil", "Table Salt"),
            new Question("Q4.What is the atomic number of carbon?", "2", "6", "12", "14", "6"),
            new Question("Q5.Which of the following is a noble gas?", "Nitrogen", "Oxygen", "Argon", "Carbon dioxide", "Argon"),
            new Question("Q6.Which of the following has the highest pH value?", "Lime juice", "Wine", "Water", "Caustic soda", "Caustic soda"),
            new Question("Q7.What are the most common elements in the human body?", "Phosphorus, nitrogen, calcium", "Sulfur, sodium, magnesium", "Copper, zinc, selenium", "Oxygen, carbon and hydrogen", "Oxygen, carbon and hydrogen"),                
            new Question("Q8.Which of these is not made from potassium compounds?", "glass", "bread", "soap", "gun powder", "bread"),
            new Question("Q9.Which of these is used as a food preservative?", "Beryllium", "Bromine", "Sulfur Dioxide", "Natura gas", "Sulfur Dioxide"),
            new Question("Q10.Which is the principal alkaloid found in tobacco?", "Morphine", "Ephedrine", "Nicotine", "Strychnine", "Nicotine"),
    };

    private Label questionLabel;
    private RadioButton[] answerRadioButtons;
    private Button submitButton;
    private Label quizResultLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Quiz Application");

        questionLabel = new Label();
        answerRadioButtons = new RadioButton[4];
        ToggleGroup answerGroup = new ToggleGroup();
        for (int i = 0; i < 4; i++) {
            answerRadioButtons[i] = new RadioButton();
            answerRadioButtons[i].setToggleGroup(answerGroup);
            answerRadioButtons[i].setStyle("-fx-text-fill: black;"); // Set text color

        }

        submitButton = new Button("Submit");
        quizResultLabel = new Label();
        submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"); // Button styling

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

        VBox optionsBox = new VBox(10); 
        optionsBox.setAlignment(Pos.CENTER);
        optionsBox.setPadding(new Insets(5));
        optionsBox.setStyle("-fx-background-color: #7ad7f0; -fx-border-color: black; -fx-border-width: 1px; -fx-border-radius: 3px;");
        
  
        GridPane optionsGrid = new GridPane();
        optionsGrid.setAlignment(Pos.CENTER);
        optionsGrid.setHgap(10);
        optionsGrid.setVgap(10);

        for (int i = 0; i < 4; i++) {
            answerRadioButtons[i].setStyle("-fx-text-fill: black;");
            optionsGrid.add(answerRadioButtons[i], 0, i);

        }
       
       
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        //layout.setStyle("-fx-background-color: #99CCFF;-fx-border-color: black; -fx-border-width: 1px;"); 
        //layout.setStyle("fx-background-image:url('Chem.jpg');" + "-fx-background-size:cover;");
        layout.setStyle("-fx-background-image: url('Chem.jpg'); " +"-fx-background-size: cover;");

 
        layout.getChildren().addAll(questionLabel, optionsGrid, submitButton, quizResultLabel);


        Scene scene = new Scene(layout, 800, 500);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm()); // Load external CSS

        primaryStage.setScene(scene);
        //resize the size
       // primaryStage.setResizable(false);
        loadQuestion(currentQuestionIndex);
        primaryStage.show();
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
        submitButton.setDisable(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/**
 * Represents a question in the quiz with the question statement, options, and correct answer.
 */

class Question {
    private String question;
    private String[] options;
    private String correctAnswer;

    
    public Question(String question, String option1, String option2, String option3, String option4, String correctAnswer) {
        this.question = question;
        this.options = new String[]{option1, option2, option3, option4};
        this.correctAnswer = correctAnswer;
    }
 

    public String getQuestion() {
        return question;
    }

 
    public String[] getOptions() {
        return options;
    }

  
    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
