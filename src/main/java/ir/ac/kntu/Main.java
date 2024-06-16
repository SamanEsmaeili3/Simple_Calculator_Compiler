package src.main.java.ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Simple Calculator Compiler");
        System.out.println("Please note that the input must be like this example: "
        +"4.42 * ((524 + 46) / 2) - -789 / 11");
        System.out.println("SPACES ARE IMPORTANT!");
        System.out.println("Please enter the expression: ");
        String input = sc.nextLine();
        initializer(input);

//        //search how to print error message
//        //String input2 = "35 / 7";
//        Lexer lexer = new Lexer();
//        ArrayList<Token> t = lexer.lexicalAnalyzer(input);
////        for (Token token : t) {
////            System.out.println(token.getValue());
////        }
//        Parser parser = new Parser(t);
//        if(parser.parserAnalyzer()){
//            System.out.println("parsed successfully");
//        }else{
//            System.out.println("parsing failed");
//        }
//        System.out.println("Final Value Is: " + parser.calculatedValue());

    }

    public static void initializer(String input) throws Exception {
        Lexer lexer = new Lexer();
        Parser parser = new Parser();

        try {
            ArrayList<Token> t = lexer.lexicalAnalyzer(input);
            parser.setTokens(t);
        } catch (Exception e) {
            throw new Exception("Invalid Input (Lexer error)");
        }
        try {
            parser.parserAnalyzer();

        } catch (Exception e){
            throw new Exception("Invalid Input (Parser error)");
        }
        System.out.println("Lexer completed");
        System.out.println("Parser completed");
        System.out.println("Final Value Is: " + parser.calculatedValue());
    }


}