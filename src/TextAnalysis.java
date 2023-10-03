public class TextAnalysis {
    private final char[] alphabet = "abcdefghijklmnopqrstuvwxyzæøå$".toCharArray();
    private final int[] charOccurence = new int[30]; //AntallTegn = new Int[30]
    private int numOfChar;
    private String mostOccuredChar;
    private double percOfNonChar;

    public TextAnalysis(String input) {
        String text = input.toLowerCase();
        this.setCharOccurence(text);
        this.setNumOfChar(text);
        this.setPercOfNonChar(text);
        this.setMostOccuredChar();
    }

    private void setCharOccurence(String text) {
        for (int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                charOccurence[c - 'a']++;
            } else {
                int num = switch (c) {
                    case 'æ' -> 26;
                    case 'ø' -> 27;
                    case 'å' -> 28;
                    default -> 29;
                };
                charOccurence[num]++;
            }


            /*
            for (int j = 0; j < alphabet.length - 1; j++) {
                if (text.charAt(i) == alphabet[j]) {
                    charOccurence[j]++;
                } else {
                    charOccurence[29]++;
                }

            }

             */

        }
    }

    private void setNumOfChar(String text) {
        for (int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                this.numOfChar++;
            } else if (c == 'æ' || c == 'ø' || c == 'å') {
                this.numOfChar++;
            }


            /*
            for (int j = 0; j < alphabet.length - 1; j++) {
                if (text.charAt(i) == alphabet[j]) {
                    charOccurence[j]++;
                }

            }

             */
        }
    }

    private void setPercOfNonChar(String text) {
        this.percOfNonChar = (double) (this.charOccurence[29]) / (text.length());
    }

    private void setMostOccuredChar() {
        char[] sortedAlphabet = this.alphabet;
        int[] sortedCharOccurence = this.charOccurence;

        for (int i = 0; i < sortedCharOccurence.length ; i++) {
            for (int j = i + 1; j < sortedCharOccurence.length ; j++) {
                if (sortedCharOccurence[j] > sortedCharOccurence[i]) {
                    int temp = sortedCharOccurence[i];
                    sortedCharOccurence[i] = sortedCharOccurence[j];
                    sortedCharOccurence[j] = temp;

                    char cTemp = sortedAlphabet[i];
                    sortedAlphabet[i] = sortedAlphabet[j];
                    sortedAlphabet[j] = cTemp;
                }
            }
        }
        String returnString = "";
        for (int i = 0; i < sortedCharOccurence.length; i++) {
            if (sortedCharOccurence[i] == sortedCharOccurence[0]) {
                returnString += sortedAlphabet[i] + ", ";
            }
        }
        returnString += "occur " + sortedCharOccurence[0] + " times";

        this.mostOccuredChar = returnString;
    }

    public void getCharOccurence() {
        System.out.println("charOccurence:");
        for (int i = 0; i < 30; i++) {
            if (this.charOccurence[i] > 0) {
                System.out.println(this.alphabet[i] + ": " + this.charOccurence[i]);
            }
        }
        System.out.println();
    }

    public void getNumOfChar() {
        System.out.println("numOfChar:" + this.numOfChar + "\n");
    }

    public void getPercOfNonChar() {
        System.out.printf("percOfNonChar: %,.2f", this.percOfNonChar );
        System.out.println("\n");
    }

    public void getOccurenceOfChar(char input) {
        int num;
        char c = Character.toLowerCase(input);
        if (c >= 'a' && c <= 'z') {
            num = c - 'a';
        } else {
            num = switch (c) {
                case 'æ' -> 26;
                case 'ø' -> 27;
                case 'å' -> 28;
                default -> 29;
            };
        }
        System.out.println("occurenceOfChar " + input + ": " + this.charOccurence[num] + "\n");

    }

    public void getMostOccuredChar() {
        System.out.println(this.mostOccuredChar + "\n");
    }

    public void testClient() {
        this.getCharOccurence();
        this.getNumOfChar();
        this.getPercOfNonChar();
        this.getOccurenceOfChar('h');
        this.getMostOccuredChar();

    }
}
