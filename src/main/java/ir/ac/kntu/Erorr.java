package src.main.java.ir.ac.kntu;

public enum Erorr {
    NUMBER_DETECTION_FAILD("Please enter numbers correctly!");
    private String message;

    private Erorr(String messsage) {
        this.message = messsage;
    }

    public String toString(){
        return message;
    }
}
