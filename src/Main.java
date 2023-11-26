import quiz.Input;
import quiz.Quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Quiz quiz = new Quiz();

        quiz.greetThePlayer();

        while(quiz.startQuiz) {
            quiz.printQuestion();
            quiz.printPossibilities();
            quiz.saveAnswer(input.readLine());
            quiz.order++;
            if(quiz.order == 3) {
                quiz.order = 0;
                quiz.printResult();
                System.out.println("Do you wanna to solve another quiz? (y/n)");
                quiz.startQuiz(input.readLine());
            }
        }


    }
}