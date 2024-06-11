package src.main.java.ir.ac.kntu;

public enum Type {
    /*S_POSITIVE_SIGN, S_NEGATIVE_SIGN,*/ S_PLUS("+"), S_MINUS("-"),
    S_POSITIVE_INT("id"), S_NEGATIVE_INT("id"), S_POSITIVE_DOUBLE("id"),
    S_NEGATIVE_DOUBLE("id"), S_MULTIPLE("*"), S_DIVIDE("/"),
    S_OPEN_P("("), S_CLOSED_P(")"), S_EOF("$");

    private String message;
    private Type(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
