package src.main.java.ir.ac.kntu;

import java.util.ArrayList;
import java.util.Stack;

public class Parser {
    Grammer grammer = new Grammer();
    ArrayList<Rule> grammerlist = grammer.getGrammer();
    ArrayList<Token> tokens;
    private String result;
    private boolean parsed;
    Stack<String> stack = new Stack<>();
    Double d1;
    Double d2;
    int i;
    Token currentToken;
    Token nextToken;

    public boolean parserAnalyzer(ArrayList<Token> tokens) throws Exceptions {
        Token eof = new Token(0,Type.S_EOF,"$");
        int state = 0;
        Token nextToken;
        stack.push("0");
        int index = 0;
        i0();
//        for(int i = 0; i<tokens.size(); i++){
//            if(tokens.size() == i-1){
//                nextToken = eof;
//            }else {
//               nextToken = tokens.get(i+1);
//            }
//
//        }

        return false;
    }

    void i0 () throws Exceptions{
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);

        if(stack.peek() == "(" && currentToken.getType() == "("){
            stack.push("(");
            stack.push("4");
            i4();
            i++;
        }
        else if(stack.peek() == "id" && currentToken.getType() == "id"){
            stack.push("id");
            stack.push("5");
            i5();
            i++;
        }
        else if(stack.peek() == "E"){
            stack.push("E");
            stack.push("1");
            i1();
            i++;
        }
        else if(stack.peek() == "T"){
            stack.push("T");
            stack.push("2");
            i2();
        }
        else if(stack.peek() == "F"){
            stack.push("F");
            stack.push("3");
            i3();
        }
        else {
            throw new Exceptions("false input!");
        }
    }

    void i1 () throws Exceptions{
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);

        if(stack.peek() == "+" && currentToken.getType() == "+"){
            stack.push("+");
            stack.push("6");
            i6();
            i++;
        }
        else if(stack.peek() == "-" && currentToken.getType() == "-"){
            stack.push("-");
            stack.push("7");
            i7();
            i++;
        }
        else if(stack.peek() == "E" && currentToken.getType() == "$"){
            parsed = true;
        }
        else{
            throw new Exceptions("false input!");
        }
    }
    void i2 () throws Exceptions{
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);

        if(stack.peek() == "*" && currentToken.getType() == "*"){
            stack.push("*");
            stack.push("2");
            i8();
            i++;
        }
        else if(stack.peek() == "/" && currentToken.getType() == "/"){
            stack.push("/");
            stack.push("2");
            i9();
            i++;
        }
        else if(stack.peek() == "2" && nextToken.getType() == "+"){
            while (stack.peek() != "T"){
                stack.pop();
            }
            stack.pop();
            stack.push("E");
        }
    }
    void i3 () throws Exceptions{

    }
    void i4 () throws Exceptions{

    }
    void i5 () throws Exceptions{

    }
    void i6 () throws Exceptions{

    }
    void i7 () throws Exceptions{

    }
    void i8 () throws Exceptions{

    }
    void i9 () throws Exceptions{

    }
    void i10 () throws Exceptions{

    }
    void i11 () throws Exceptions{

    }
    void i12 () throws Exceptions{

    }
    void i13 () throws Exceptions{

    }
    void i14 () throws Exceptions{

    }
    void i15 () throws Exceptions{

    }

    public Token getNextToken(int index, ArrayList<Token> tokens){
        Token eof = new Token(0,Type.S_EOF,"$");
        if(index == tokens.size() -1){return eof;}
        return tokens.get(index+1);
    }

    public Token getCurrentToken(int index, ArrayList<Token> tokens){
        if(index < tokens.size()){
            currentToken = tokens.get(i);
            return currentToken;
        } else if (index == tokens.size()) {
            currentToken = new Token(0,Type.S_EOF,"$");
            return currentToken;
        }
        return null;
    }
}
