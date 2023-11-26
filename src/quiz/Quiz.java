package quiz;

import java.util.InputMismatchException;

public class Quiz {
    String [] geographiesQuestions = {
            "1. Which countries does Slovakia border with? (multiple answers)",
            "2. What colors are on the flag of Germany? (multiple answers)",
            "3. What is the capital city of Australia? (single answer)"
    };

    String [] geographiesPossibilities = {
            "\ta: Czechia\n\tb: Poland\n\tc: Ukraine\n\td: Hungary\n\te: Austria\n",
            "\ta: Yellow\n\tb: Red\n\tc: White\n\td: Blue\n\te: Black\n",
            "\ta: Sydney\n\tb: Melbourne\n\tc: Canberra\n\td: Adelaide\n\te: Perth\n"
    };

    String [] geographiesRightAnswers = {
            "abcde",
            "abe",
            "c"
    };

    String [] geographiesAnswers = new String[geographiesQuestions.length];

    public int order = 0;
    Input input = new Input();
    public boolean startQuiz = false;

    public Quiz() {

    }

    public boolean startQuiz(String statement) {
        if(statement.equals("y")) {
            startQuiz = true;
        } else {
            startQuiz = false;
        }
        return startQuiz;
    }

    public void greetThePlayer() {
        System.out.println("Welcome to our quiz!");
        System.out.println("Choose one of these quizzes: (1 - Geography 2 - Mathematics 3 - Informatics) and good luck!");
        try {
            input.keyInput.nextInt();
        } catch (InputMismatchException e) {
            e.getMessage();
        }
        startQuiz("y");
    }

    public void printQuestion () {
        System.out.println(this.geographiesQuestions[order]);
    }

    public void printPossibilities () {
            System.out.println(this.geographiesPossibilities[order]);
    }

    public void saveAnswer(String answer) {
        geographiesAnswers[order] = answer;
    }

    public int quizResult(String[] answers) {
        int count = 0;
        for(int i = 0; i < answers.length; i++) {
            if(answers[i].equals(geographiesRightAnswers[i])) {
                count++;
            }
        }
        return count;
    }

    public void printResult() {
        System.out.println("Your result is " + quizResult(geographiesAnswers) + "/" + geographiesRightAnswers.length);
    }
}
