package quiz;

import java.lang.invoke.WrongMethodTypeException;
import java.util.InputMismatchException;

public class Quiz {
    /**
     * Questions of quizzes
     */
    String [] geographiesQuestions = {
            "1. Which countries does Slovakia border with? (multiple answers)",
            "2. What colors are on the flag of Germany? (multiple answers)",
            "3. What is the capital city of Australia? (single answer)"
    };

    String [] mathematicsQuestions = {
            "1. Which answer corresponds to the result = 4? (multiple answers)",
            "2. Which of the given numbers are prime numbers? (multiple answers)",
            "3. Subtract the number 17 from the number 50 and multiply by the number 3. What result did you get? (single answer)"
    };

    String [] informaticsQuestions = {
            "1. How many bits are in one byte? (single answers)",
            "2. The shortcut key ALT + F4 serves to? (single answers)",
            "3. Which data type does not allow storing a decimal number? (multiple answer)"
    };

    /**
     * Answer possibilities
     */
    String [] geographiesPossibilities = {
            "\ta: Czechia\n\tb: Poland\n\tc: Ukraine\n\td: Hungary\n\te: Austria\n",
            "\ta: Yellow\n\tb: Red\n\tc: White\n\td: Blue\n\te: Black\n",
            "\ta: Sydney\n\tb: Melbourne\n\tc: Canberra\n\td: Adelaide\n\te: Perth\n"
    };

    String [] mathematicsPossibilities = {
            "\ta: 2+2\n\tb: 2*2\n\tc: 2^2;\n\td: 10/2\n\te: 8 % 2\n",
            "\ta: 2\n\tb: 4\n\tc: 5\n\td: 7\n\te: 9\n",
            "\ta: 33\n\tb: 67\n\tc: 99\n\td: 201\n\te: 11\n"
    };

    String [] informaticsPossibilities = {
            "\ta: 8\n\tb: 7\n\tc: 15\n\td: 16\n\te: 1\n",
            "\ta: saving data to the clipboard\n\tb: help display\n\tc: close the active window\n\td: hide the active window\n\te: pasting data to the clipboard\n",
            "\ta: float\n\tb: double\n\tc: int\n\td: char\n\te: boolean\n"
    };

    /**
     * Correct answers
     */
    String [] geographiesCorrectAnswers = {
            "abcde",
            "abe",
            "c"
    };

    String [] mathematicsCorrectAnswers = {
            "abc",
            "acd",
            "c"
    };

    String [] informaticsCorrectAnswers = {
            "a",
            "c",
            "cde"
    };

    /**
     * Arrays for saving the player's answers
     */
    String [] geographiesAnswers = new String[geographiesQuestions.length];
    String [] mathematicsAnswers = new String[mathematicsQuestions.length];
    String [] informaticsAnswers = new String[informaticsQuestions.length];

    public int order = 0;
    int quizNumber = 0;
    Input input = new Input();
    public boolean startQuiz = false;

    public Quiz() {

    }

    public boolean startQuiz(String statement) {
        if(statement.equals("y")) {
            startQuiz = true;
        } else {
            startQuiz = false;
            System.exit(0);
        }
        return startQuiz;
    }

    public void greetThePlayer() {
        System.out.println("Welcome to our quiz!");
        System.out.println("Choose one of these quizzes: (1 - Geography 2 - Mathematics 3 - Informatics) and good luck!");
        try {
            quizNumber = input.readQuiz();
        } catch (Exception e) {
            e.printStackTrace();
        }
        startQuiz("y");
    }

    public void printQuestion () {
        switch (quizNumber) {
            case 1:
                System.out.println(this.geographiesQuestions[order]);
                break;
            case 2:
                System.out.println(this.mathematicsQuestions[order]);
                break;
            case 3:
                System.out.println(this.informaticsQuestions[order]);
                break;
        }
    }

    public void printPossibilities () {
        switch (quizNumber) {
            case 1:
                System.out.println(this.geographiesPossibilities[order]);
                break;
            case 2:
                System.out.println(this.mathematicsPossibilities[order]);
                break;
            case 3:
                System.out.println(this.informaticsPossibilities[order]);
                break;
        }
    }

    public void saveAnswer(String answer) {
        switch (quizNumber) {
            case 1:
                geographiesAnswers[order] = answer;
                break;
            case 2:
                mathematicsAnswers[order] = answer;
                break;
            case 3:
                informaticsAnswers[order] = answer;
                break;
        }
    }

    public int quizResult(String[] answers) {
        int count = 0;
        for(int i = 0; i < answers.length; i++) {
            switch (quizNumber) {
                case 1:
                    if(answers[i].equals(geographiesCorrectAnswers[i])) {
                        count++;
                    }
                    break;
                case 2:
                    if(answers[i].equals(mathematicsCorrectAnswers[i])) {
                        count++;
                    }
                    break;
                case 3:
                    if(answers[i].equals(informaticsCorrectAnswers[i])) {
                        count++;
                    }
                    break;
            }
        }
        return count;
    }

    public void printResult() {
        switch (quizNumber) {
            case 1:
                System.out.println("Your result is " + quizResult(geographiesAnswers) + "/" + geographiesCorrectAnswers.length);
                break;
            case 2:
                System.out.println("Your result is " + quizResult(mathematicsAnswers) + "/" + mathematicsCorrectAnswers.length);
                break;
            case 3:
                System.out.println("Your result is " + quizResult(informaticsAnswers) + "/" + informaticsCorrectAnswers.length);
                break;
        }
    }
}
