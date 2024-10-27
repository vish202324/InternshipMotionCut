package Project_1;
import java.util.Scanner;
public class Quiz {
    private final Question[] questions;
    private int score;
    private final int totalQuestions;

    public Quiz(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.questions = new Question[totalQuestions];
        this.score = 0; // Initialize the score from 0
    }

    public void addQuestion(Question question, int index) {
        if (index >= 0 && index < totalQuestions) {
            questions[index] = question;
        } else {
            System.out.println("Invalid index for adding question.");
        }
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            if (question != null) {
                System.out.println(question.getQuestionText());
                String[] options = question.getOptions();
                for (int i = 0; i < options.length; i++) {
                    System.out.println((i + 1) + ": " + options[i]);
                }

                int userAnswer = getUserAnswer(scanner);
                if (question.isCorrect(userAnswer)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong! The correct answer is " + (question.getCorrectAnswer() + 1));
                }
            }
        }
        scanner.close();
        displayScore();
    }

    private int getUserAnswer(Scanner scanner) {
        int userAnswer;
        while (true) {
            try {
                System.out.print("Enter your answer (1-4): ");
                userAnswer = Integer.parseInt(scanner.nextLine()) - 1;
                if (userAnswer >= 0 && userAnswer < 4) {
                    break;
                } else {
                    System.out.println("Please enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return userAnswer;
    }

    private void displayScore() {
        System.out.println("\nYour score is: " + score + "/" + totalQuestions);
    }
}
