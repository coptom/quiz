package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    Scanner keyInput = new Scanner(System.in);

    public Input() {

    }

    public int readQuiz() {
       return keyInput.nextInt();
    }

    public String readLine() {
       return keyInput.next();
    }

}
