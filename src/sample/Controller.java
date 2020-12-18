package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Random;


public class Controller {
    int answer;
    Random random = new Random();
    int attemptForUser;


    @FXML
    public void initialize() {
        answer = random.nextInt(99) + 1;
        attemptForUser = Integer.parseInt(attempt.getText());
    }

    @FXML
    private Label attempt;

    @FXML
    private Label result;

    @FXML
    private TextField answerField;

    @FXML
    void doAnswerButton() {
        String message = answerField.getText();
        attemptForUser--;
        if (!message.isBlank()) {
            if (attemptForUser > -1) {
                try {

                    int number = Integer.parseInt(message);
                    if (number < 1 || number > 100) {
                        var allert = new Alert(Alert.AlertType.ERROR, "Введите число от 1 до 100!");
                        allert.setTitle("Неправильный тип ввода.");
                        allert.show();
                    } else if (number == answer) {
                        result.setText("Вы угадали!");
                    } else if (number < answer) {
                        result.setText("Берите выше.");
                        attempt.setText(String.valueOf(attemptForUser));
                    } else {
                        result.setText("Берите ниже.");
                        attempt.setText(String.valueOf(attemptForUser));
                    }

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    var allert = new Alert(Alert.AlertType.ERROR, "Введите число!");
                    allert.setTitle("Неправильный тип ввода.");
                    allert.show();
                }
            } else {
                result.setText("Вы проиграли!");
            }
        }
    }
}

