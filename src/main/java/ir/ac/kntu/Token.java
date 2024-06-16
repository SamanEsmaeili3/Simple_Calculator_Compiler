package src.main.java.ir.ac.kntu;

public class Token {
    private int column;
    private Type type;
    private String value;

    public Token(int column, Type type, String value){
        this.column = column;
        this.type = type;
        this.value = value;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getType() {
        return type.toString();
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString(){
        return "Token{" +

                "column = " + column +
                ", type = " + type +
                ", name = " + value +
                " }";
    }
}
