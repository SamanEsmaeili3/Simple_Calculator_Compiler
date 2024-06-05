package src.main.java.ir.ac.kntu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lexer {
    private ArrayList<Token> tokens;
    //private Stream<Token> tokenStream;
    char lastChar = '\0';
    int rowNo = 0, colNo = 0;
    public Lexer() {
        tokens = new ArrayList<>();
        //tokenStream = Stream.<Token>builder().build();
    }
    public ArrayList<Token> lexicalAnalyzer(String input) throws Exceptions {
        char[] charInput = input.toCharArray();
        char nextChar;
        Type type = null;
        char[] nextWord = new char[80];
        int state = 0, length = 0;

        for(int i = 0; i < charInput.length; i++){
            if(lastChar != '\0'){
                nextChar = lastChar;
                lastChar = '\0';
            } else{
                nextChar = charInput[i];
            }
            nextWord[length++] = nextChar;
            colNo++;

            switch (state) {
                case 0 -> {
                    if (nextChar == '\n' || nextChar == '\t' || nextChar == ' ') {
                        state = 0;
                        length = 0;
                    }

                    else if (nextChar == '+') state = 1;
                    else if (nextChar == '-') state = 5;
                    else if (nextChar == '*') state = 9;
                    else if (nextChar == '/') state = 10;
                    else if (nextChar == '(') state = 11;
                    else if (nextChar == ')') state = 12;
                    else if (isDigit(nextChar)) state = 13;
                    else throw new Exceptions("Invalid Input!");
                }
                case 1 -> {
                    if (nextChar == ' ') {
                        type = Type.S_PLUS;
                        lastChar = nextChar;
                        nextWord[--length] = '\0';
                        tokens.add(new Token(colNo - length, type, Arrays.toString(nextWord)));
                        state = 0;
                    } else if (isDigit(nextChar)) state = 2;
                    else throw new Exceptions("Invalid Input!");
                }
                case 2 -> {
                    if (isDigit(nextChar)) state = 2;
                    else if (nextChar == '.') state = 3;
                    else if (nextChar == ' ') {
                        type = Type.S_POSITIVE_INT;
                        lastChar = nextChar;
                        nextWord[--length] = '\0';
                        tokens.add(new Token(colNo - length, type, Arrays.toString(nextWord)));
                        state = 0;
                    } else throw new Exceptions("Invalid Input!");
                }
                case 3 -> {
                    if (isDigit(nextChar)) state = 4;
                    else throw new Exceptions("Invalid Input!");
                }
                case 4 -> {
                    if (isDigit(nextChar)) state = 4;
                    else if (nextChar == ' ') {
                        type = Type.S_POSITIVE_DOUBLE;
                        lastChar = nextChar;
                        nextWord[--length] = '\0';
                        tokens.add(new Token(colNo - length, type, Arrays.toString(nextWord)));
                        state = 0;
                    } else throw new Exceptions("Invalid Input!");
                }
                case 5 -> {
                    if (nextChar == ' ') {
                        type = Type.S_MINUS;
                        lastChar = nextChar;
                        nextWord[--length] = '\0';
                        tokens.add(new Token(colNo - length, type, Arrays.toString(nextWord)));
                        state = 0;
                    } else if (isDigit(nextChar)) state = 6;
                    else throw new Exceptions("Invalid Input!");
                }
                case 6 -> {
                    if (isDigit(nextChar)) state = 6;
                    else if (nextChar == '.') state = 7;
                    else if (nextChar == ' ') {
                        type = Type.S_NEGATIVE_INT;
                        lastChar = nextChar;
                        nextWord[--length] = '\0';
                        tokens.add(new Token(colNo - length, type, Arrays.toString(nextWord)));
                        state = 0;
                    } else throw new Exceptions("Invalid Input!");
                }
                case 7 -> {
                    if (isDigit(nextChar)) state = 8;
                    else throw new Exceptions("Invalid Input!");
                }
                case 8 -> {
                    if (isDigit(nextChar)) state = 8;
                    else if (nextChar == ' ') {
                        type = Type.S_NEGATIVE_DOUBLE;
                        lastChar = nextChar;
                        nextWord[--length] = '\0';
                        tokens.add(new Token(colNo - length, type, Arrays.toString(nextWord)));
                        state = 0;
                    } else throw new Exceptions("Invalid Input!");
                }
                case 9 -> {
                    if (nextChar == ' ') {
                        type = Type.S_MULTIPLE;
                        lastChar = nextChar;
                        nextWord[--length] = '\0';
                        tokens.add(new Token(colNo - length, type, Arrays.toString(nextWord)));
                        state = 0;
                    } else throw new Exceptions("Invalid Input!");
                }
                case 10 -> {
                    if (nextChar == ' ') {
                        type = Type.S_DIVIDE;
                        lastChar = nextChar;
                        nextWord[--length] = '\0';
                        tokens.add(new Token(colNo - length, type, Arrays.toString(nextWord)));
                        state = 0;
                    } else throw new Exceptions("Invalid Input!");

                }
                case 11 -> {
                    if (nextChar == ' ' || isDigit(nextChar)) {
                        type = Type.S_OPEN_P;
                        lastChar = nextChar;
                        nextWord[--length] = '\0';
                        tokens.add(new Token(colNo - length, type, Arrays.toString(nextWord)));
                        state = 0;
                    } else throw new Exceptions("Invalid Input!");
                }
                case 12 -> {
                    if (nextChar == ' ' || isDigit(nextChar)) {
                        type = Type.S_CLOSED_P;
                        lastChar = nextChar;
                        nextWord[--length] = '\0';
                        tokens.add(new Token(colNo - length, type, Arrays.toString(nextWord)));
                        state = 0;
                    } else throw new Exceptions("Invalid Input!");
                }
                case 13 -> {
                    if (isDigit(nextChar)) state = 13;
                    else if (nextChar == '.') state = 14;
                    else if (nextChar == ' ') {
                        type = Type.S_POSITIVE_INT;
                        lastChar = nextChar;
                        nextWord[--length] = '\0';
                        tokens.add(new Token(colNo - length, type, Arrays.toString(nextWord)));
                        state = 0;
                    } else throw new Exceptions("Invalid Input!");
                }
                case 14 -> {
                    if (isDigit(nextChar)) state = 15;
                    else throw new Exceptions("Invalid Input!");
                }
                case 15 -> {
                    if (isDigit(nextChar)) state = 15;
                    else if (nextChar == ' ') {
                        type = Type.S_POSITIVE_DOUBLE;
                        lastChar = nextChar;
                        nextWord[--length] = '\0';
                        tokens.add(new Token(colNo - length, type, Arrays.toString(nextWord)));
                        state = 0;
                    } else throw new Exceptions("Invalid Input!");
                }
            }
        }

        return tokens;
    }



    public static boolean isDigit(char nextChar) {
        return nextChar >= '0' && nextChar <= '9';
    }
    public static boolean isSeparator(char nextChar) {
        return nextChar == '\n' || nextChar == '\t' || nextChar == ' ' || nextChar == ';' || nextChar == '\0'||nextChar=='\r';
    }
}
