import java.io.*;
import java.util.*;

public class Task {
public static void main(String[] args){
    String text = "";
    System.out.println("Введите текст");
    Scanner sc1 = new Scanner(System.in);
    text = sc1.nextLine();
    char[] chararr = text.toCharArray();
    int counter = 0;
    for(char x: chararr){

        if(Character.isLetter(x)){
            counter++;
            System.out.print(x);
        }
        else{
            if(counter!=0){
                System.out.print(" ");
            }
            counter = 0;
        }
    }
}
}
