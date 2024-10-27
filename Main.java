package Project_1;
public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz(3);

        // Adding sample questions
        quiz.addQuestion(new Question(
            "What is the capital of France?", 
            new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 2), 0);
        
        quiz.addQuestion(new Question(
            "Which language is used for Android development?", 
            new String[]{"Swift", "Kotlin", "JavaScript", "Python"}, 1), 1);
        
        quiz.addQuestion(new Question(
            "What is 2 + 2?", 
            new String[]{"3", "4", "5", "6"}, 1), 2);

        // Start the quiz
        quiz.startQuiz();
    }
}
