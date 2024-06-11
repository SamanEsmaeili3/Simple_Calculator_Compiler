package src.main.java.ir.ac.kntu;

public class Rule {
    private String lefSide;
    private String rightSide;
    private int number;

    public Rule(String lefSide, String rightSide, int number) {
        this.lefSide = lefSide;
        this.rightSide = rightSide;
        this.number = number;
    }
    public String getLeftSide() {
        return lefSide;
    }
    public String getRightSide() {
        return rightSide;
    }
    public int getNumber() {
        return number;
    }
    public void setLeftSide(String lefSide) {
        this.lefSide = lefSide;
    }
    public void setRightSide(String rightSide) {
        this.rightSide = rightSide;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
