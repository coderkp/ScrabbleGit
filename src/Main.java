import java.io.*;
import java.util.*;
public class Main {


    public static void main(String[] args) {

        SowpodsUtil.intSowpodsUtil();
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        Validate v= new Validate();
        System.out.println("List of all valid words " + v.listAllWords(word) +"\n\n");

        System.out.println("Optimal Start word " + v.validate(1,word)+"\n\n");
        System.out.println("Optimal Start word with blank " + v.validate(2,word.substring(0,word.length()-1))+"\n\n");
        System.out.println("Optimal intermediated word " + v.validate(3,word,"S".toCharArray(),new int[]{5})+"\n\n");
        System.out.println("Optimal intermediated word " + v.validate(3,word,"SE".toCharArray(),new int[]{5,-1})+"\n\n");

    }
}
