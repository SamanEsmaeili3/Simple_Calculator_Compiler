package src.main.java.ir.ac.kntu;

import java.util.ArrayList;

public class Grammer {
    private ArrayList<Rule> grammer;
    public Grammer() {
        grammer = new ArrayList<>();
        grammer.add(new Rule("E'", "E$", 0));
        grammer.add(new Rule("E", "E+T", 1));
        grammer.add(new Rule("E", "E-T", 2));
        grammer.add(new Rule("E", "T", 3));
        grammer.add(new Rule("T", "T*F", 4));
        grammer.add(new Rule("T", "T/F", 5));
        grammer.add(new Rule("T", "F", 6));
        grammer.add(new Rule("F", "(E)", 7));
        grammer.add(new Rule("F", "id", 8));
    }
    public ArrayList<Rule> getGrammer() {
        return grammer;
    }



}
