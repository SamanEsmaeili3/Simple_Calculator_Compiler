package src.main.java.ir.ac.kntu;

import java.util.ArrayList;
import java.util.Stack;

public class Parser {
    Grammer grammer = new Grammer();
    ArrayList<Rule> grammerlist = grammer.getGrammer();
    private ArrayList<Token> tokens;
    private Stack<String> stack;
    private Double d1;
    private Double d2;
    private int i;
    private Token currentToken;
    private Token nextToken;
    private String lastSate;
    private String result;
    private boolean parsed;

    public Parser(ArrayList<Token> tokens) {
        stack = new Stack<>();
        this.tokens = tokens;
    }
    public boolean parserAnalyzer() throws Exceptions {
        Token eof = new Token(0, Type.S_EOF, "$");
        int state = 0;
        Token nextToken;
        stack.push("0");
        int index = 0;
        i0();

        return parsed;
    }

    private void i0() throws Exceptions {
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);

        if (currentToken.getType() == "(") {
            stack.push("(");
            stack.push("4");
            i++;
            i4();
        } else if (currentToken.getType() == "id") {
            stack.push("id");
            stack.push("5");
            i++;
            i5();
        } else if (stack.peek() == "E") {
            //stack.push("E");
            stack.push("1");
            i1();
        } else if (stack.peek() == "T") {
            //stack.push("T");
            stack.push("2");
            i2();
        } else if (stack.peek() == "F") {
            //stack.push("F");
            stack.push("3");
            i3();
        } else {
            throw new Exceptions("false input!");
        }
    }

    private void i1() throws Exceptions {
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);
        if (stack.peek() == "1") {
            parsed = true;
        } else if (currentToken.getType() == "+") {
            stack.push("+");
            stack.push("6");
            i++;
            i6();
        } else if (stack.peek() == "-") {
            stack.push("-");
            stack.push("7");
            i++;
            i7();
        } else {
            throw new Exceptions("false input!");
        }
    }

    private void i2() throws Exceptions {
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);
        if ((stack.peek() == "2") && (currentToken.getType() == "+" || currentToken.getType() == "-" ||
                currentToken.getType() == ")" || currentToken.getType() == "$")) {
            while (stack.peek() != "T") {
                stack.pop();
            }
            stack.pop();
            stack.push("E");
            stack.push("1");
            i1();
        } else if (currentToken.getType() == "*") {
            stack.push("*");
            stack.push("8");
            i++;
            i8();
        } else if (currentToken.getType() == "/") {
            stack.push("/");
            stack.push("9");
            i++;
            i9();
        } else {
            throw new Exceptions("false input!");
        }
    }

    private void i3() throws Exceptions {
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);

        if ((stack.peek() == "3") && (currentToken.getType() == "+" || currentToken.getType() == "-" ||
                currentToken.getType() == "*" || currentToken.getType() == "/" || currentToken.getType() == ")"
                || currentToken.getType() == "$")) {
            while (stack.peek() != "F") {
                stack.pop();
            }
            stack.pop();
            setLastSate(stack.peek());
            stack.push("T");
            gotLastCaller(lastSate);


        } else {
            throw new Exceptions("false input!");
        }

    }

    private void i4() throws Exceptions {
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);

        if (stack.peek() == "E") {
            stack.push("10");
            i10();
        } else if (stack.peek() == "T") {
            stack.push("2");
            i2();
        } else if (stack.peek() == "F") {
            stack.push("3");
            i3();
        } else if (currentToken.getType() == "(") {
            stack.push("(");
            stack.push("4");
            i++;
            i4();
        } else if (currentToken.getType() == "id") {
            stack.push("id");
            stack.push("5");
            i++;
            i5();
        } else {
            throw new Exceptions("false input!");
        }

    }

    private void i5() throws Exceptions {
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);

        if ((stack.peek() == "5") && (currentToken.getType() == "+" || currentToken.getType() == "-" ||
                currentToken.getType() == "*" || currentToken.getType() == "/" || currentToken.getType() == ")"
                || currentToken.getType() == "$")) {
            while (stack.peek() != "id") {
                stack.pop();
            }
            stack.pop();
            setLastSate(stack.peek());
            stack.push("F");
            gotLastCaller(lastSate);

        } else {
            throw new Exceptions("false input!");
        }
    }

    private void i6() throws Exceptions {
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);

        if (stack.peek() == "T") {
            stack.push("11");
            i11();
        } else if (stack.peek() == "F") {
            stack.push("3");
            i3();
        } else if (currentToken.getType() == "(") {
            stack.push("(");
            stack.push("4");
            i++;
            i4();
        } else if (currentToken.getType() == "id") {
            stack.push("id");
            stack.push("5");
            i++;
            i5();
        } else {
            throw new Exceptions("false input!");
        }
    }

    private void i7() throws Exceptions {
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);

        if (stack.peek() == "T") {
            stack.push("12");
            i12();
        } else if (stack.peek() == "F") {
            stack.push("3");
            i3();
        } else if (currentToken.getType() == "(") {
            stack.push("(");
            stack.push("4");
            i++;
            i4();
        } else if (currentToken.getType() == "id") {
            stack.push("id");
            stack.push("5");
            i++;
            i5();
        } else {
            throw new Exceptions("false input!");
        }
    }

    private void i8() throws Exceptions {
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);

        if (stack.peek() == "F") {
            stack.push("13");
            i13();
        } else if (currentToken.getType() == "id") {
            stack.push("id");
            stack.push("5");
            i++;
            i5();
        } else if (currentToken.getType() == "(") {
            stack.push("(");
            stack.push("4");
            i++;
            i4();
        } else {
            throw new Exceptions("false input!");
        }
    }

    private void i9() throws Exceptions {
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);

        if (stack.peek() == "F") {
            stack.push("14");
            i14();
        } else if (currentToken.getType() == "(") {
            stack.push("(");
            stack.push("4");
            i++;
            i4();
        } else if (currentToken.getType() == "id") {
            stack.push("id");
            stack.push("5");
            i++;
            i5();
        } else {
            throw new Exceptions("false input!");
        }
    }

    private void i10() throws Exceptions {
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);

        if (currentToken.getType() == ")") {
            stack.push(")");
            stack.push("10");
            i++;
            i15();
        } else if (currentToken.getType() == "+") {
            stack.push("+");
            stack.push("10");
            i++;
            i6();
        } else if (currentToken.getType() == "-") {
            stack.push("-");
            stack.push("10");
            i++;
            i7();
        } else {
            throw new Exceptions("false input!");
        }
    }

    private void i11() throws Exceptions {
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);

        if ((stack.peek() == "11") && (currentToken.getType() == "+" || currentToken.getType() == "-" ||
                currentToken.getType() == ")" || currentToken.getType() == "$")) {
            while (stack.peek() != "E") {
                stack.pop();
            }
            stack.pop();
            setLastSate(stack.peek());
            stack.push("E");
            gotLastCaller(lastSate);
        } else if (currentToken.getType() == "*") {
            stack.push("*");
            stack.push("11");
            i++;
            i8();
        } else if (currentToken.getType() == "/") {
            stack.push("/");
            stack.push("11");
            i++;
            i9();
        } else {
            throw new Exceptions("false input!");
        }
    }

    private void i12() throws Exceptions {
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);

        if ((stack.peek() == "12") && (currentToken.getType() == "+" || currentToken.getType() == "-" ||
                currentToken.getType() == ")" || currentToken.getType() == "$")) {
            while (stack.peek() != "E") {
                stack.pop();
            }
            stack.pop();
            setLastSate(stack.peek());
            stack.push("E");
            gotLastCaller(lastSate);
        } else if (currentToken.getType() == "*") {
            stack.push("*");
            stack.push("12");
            i++;
            i8();
        } else if (currentToken.getType() == "/") {
            stack.push("/");
            stack.push("12");
            i++;
            i9();
        } else {
            throw new Exceptions("false input!");
        }
    }

    private void i13() throws Exceptions {
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);

        if ((stack.peek() == "13") && (currentToken.getType() == "+" || currentToken.getType() == "-" ||
                currentToken.getType() == "*" || currentToken.getType() == "/" ||
                currentToken.getType() == ")" || currentToken.getType() == "$")) {
            while (stack.peek() != "T") {
                stack.pop();
            }
            stack.pop();
            setLastSate(stack.peek());
            stack.push("T");
            gotLastCaller(lastSate);
        } else {
            throw new Exceptions("false input!");
        }
    }

    private void i14() throws Exceptions {
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);

        if ((stack.peek() == "14") && (currentToken.getType() == "+" || currentToken.getType() == "-" ||
                currentToken.getType() == "*" || currentToken.getType() == "/" ||
                currentToken.getType() == ")" || currentToken.getType() == "$")) {
            while (stack.peek() != "T") {
                stack.pop();
            }
            stack.pop();
            setLastSate(stack.peek());
            stack.push("T");
            gotLastCaller(lastSate);
        } else {
            throw new Exceptions("false input!");
        }
    }

    private void i15() throws Exceptions {
        currentToken = getCurrentToken(i, tokens);
        nextToken = getNextToken(i, tokens);

        if ((stack.peek() == "15") && (currentToken.getType() == "+" || currentToken.getType() == "-" ||
                currentToken.getType() == "*" || currentToken.getType() == "/" ||
                currentToken.getType() == ")" || currentToken.getType() == "$")) {
            while (stack.peek() != "(") {
                stack.pop();
            }
            stack.pop();
            setLastSate(stack.peek());
            stack.push("F");
            gotLastCaller(lastSate);
        } else {
            throw new Exceptions("false input!");
        }
    }

    private Token getNextToken(int index, ArrayList<Token> tokens) {
        Token eof = new Token(0, Type.S_EOF, "$");
        if (index >= tokens.size() - 1) {
            return eof;
        }
        return tokens.get(index + 1);
    }

    private Token getCurrentToken(int index, ArrayList<Token> tokens) {
        if (index < tokens.size()) {
            currentToken = tokens.get(i);
            return currentToken;
        } else if (index == tokens.size()) {
            currentToken = new Token(0, Type.S_EOF, "$");
            return currentToken;
        }
        return null;
    }

    private void setLastSate(String sate) {
        switch (sate) {
            case "0":
                lastSate = "0";
                break;
            case "1":
                lastSate = "1";
                break;
            case "2":
                lastSate = "2";
                break;
            case "3":
                lastSate = "3";
                break;
            case "4":
                lastSate = "4";
                break;
            case "5":
                lastSate = "5";
                break;
            case "6":
                lastSate = "6";
                break;
            case "7":
                lastSate = "7";
                break;
            case "8":
                lastSate = "8";
                break;
            case "9":
                lastSate = "9";
                break;
            case "10":
                lastSate = "10";
                break;
            case "11":
                lastSate = "11";
                break;
            case "12":
                lastSate = "12";
                break;
            case "13":
                lastSate = "13";
                break;
            case "14":
                lastSate = "14";
                break;
            case "15":
                lastSate = "15";
                break;
        }
    }

    private void gotLastCaller(String input) throws Exceptions {
        switch (input) {
            case "0":
                i0();
                break;
            case "1":
                i1();
                break;
            case "2":
                i2();
                break;
            case "3":
                i3();
                break;
            case "4":
                i4();
                break;
            case "5":
                i5();
                break;
            case "6":
                i6();
                break;
            case "7":
                i7();
                break;
            case "8":
                i8();
                break;
            case "9":
                i9();
                break;
            case "10":
                i10();
                break;
            case "11":
                i11();
                break;
            case "12":
                i12();
                break;
            case "13":
                i13();
                break;
            case "14":
                i14();
                break;
            case "15":
                i15();
                break;
        }
    }
}
