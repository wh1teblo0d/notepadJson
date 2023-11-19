package org.main;
import java.time.LocalDate;
public class notepadik {
    private String noteName;
     private String currentDate;
    private String text;
    private int numSymbol;


    public notepadik( String noteName,String text,  int numSymbol){
        LocalDate tempDate = LocalDate.now();

        this.noteName = noteName;
        currentDate = tempDate.toString();
        this.text = text;
        this.numSymbol = numSymbol;
    }
    public void print(){
        System.out.println( noteName + "\t" );
        System.out.println(text);
        System.out.println(numSymbol);

    }
    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }




    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumSymbol() {
        return numSymbol;
    }

    public void setNumSymbol(int numSymbol) {
        this.numSymbol = numSymbol;
    }
}
