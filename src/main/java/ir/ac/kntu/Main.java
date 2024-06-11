package src.main.java.ir.ac.kntu;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exceptions {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello world!");
        String input = "4.42 * ((524 + 46) / 2) - -789 / 11";
        //search how to print error message
        String input2 = "35 / 11";
        Lexer lexer = new Lexer();
        ArrayList<Token> t = lexer.lexicalAnalyzer(input);
        for (Token token : t) {
            System.out.println(token.getValue());
        }


    }

    public String initializer(String input) {
        return null;
    }


}