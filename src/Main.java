import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("ØVING 6 OPPGAVE 2");

        boolean runProgram = true;

        TextAnalysis text = null;

        if (getOptions(1) >= 2) {
            runProgram = false;
        } else {
            text = getTextInput();
        }

        while (runProgram) {
            int chosenOption = getOptions(2);

            switch (chosenOption) {
                case 1:
                    text.getCharOccurence();
                    break;
                case 2:
                    text.getNumOfChar();
                    break;
                case 3:
                    text.getPercOfNonChar();
                    break;
                case 4:
                    System.out.println("Which character?");
                    char c = new Scanner(System.in).nextLine().charAt(0);
                    text.getOccurenceOfChar(c);
                    //Kunne ha gjort alt dette i get-metoden i stedet for å ha parameter smh
                    break;
                case 5:
                    text.getMostOccuredChar();
                    break;
                case 6:
                    text = getTextInput();
                    break;
                default:
                    runProgram = false;
            }
        }

        System.out.println("Exit");

    }
    public static int getOptions(int menuType) {
        switch (menuType) {
            case 1:
                System.out.println("1. Analyse new text");
                System.out.println("2. Exit");
                break;
            case 2:
                System.out.println("1. Get character occurence");
                System.out.println("2. Get number of characters");
                System.out.println("3. Get percentage of non characters");
                System.out.println("4. Get occurence of specific character");
                System.out.println("5. Get most occured character");
                System.out.println("6. Analyse new text");
                System.out.println("7. Exit");

        }
        return new Scanner(System.in).nextInt();

    }

    public static TextAnalysis getTextInput() {
        System.out.println("Write text:");
        String input = new Scanner(System.in).nextLine();
        return new TextAnalysis(input);
    }
}