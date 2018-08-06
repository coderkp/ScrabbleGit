import java.io.*;
import java.util.*;
public class Main {
    public static ArrayList<String> allCombs = new ArrayList<>();
    /*
    start & end ---> Staring and Ending indexes in arr[]
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed */
    static void combinationUtil(char arr[], char data[], int start,
                                int end, int index, int r) {
        // Current combination is ready to be printed, print it
        String temp= "";
        if (index == r) {
            for (int j = 0; j < r; j++)
                temp = temp + data[j];
            //System.out.println("");
            allCombs.add(temp);
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }
    }
    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void storeCombination(char arr[], int n, int r) {
        char data[] = new char[r];
        // Store all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n - 1, 0, r);
    }
    public static void listAllPossible(String rack){
        //ArrayList<String> allvalidwords = new ArrayList<>();
        char tempArray[] = rack.toCharArray();
        Arrays.sort(tempArray);
        //String sortedRack = new String(tempArray);
        for(int i=7; i>2; i--)
            storeCombination(tempArray,7,i);
    }
    public static ArrayList<String> listAllWords(String rack, SowpodsUtil s)
    {
        listAllPossible(rack);
        ArrayList<String> words = new ArrayList<>();
        for(String temp: allCombs)
        {
            if(!s.findAnagramEquivalents(temp).isEmpty())
            {
                words.addAll(s.findAnagramEquivalents(temp));
            }
        }
        return words;
    }
    public static void main(String[] args) {

        SowpodsUtil s = new SowpodsUtil();
        s.intSowpodsUtil();
        //System.out.println(s.anagramMap.get("ACT"));
        //listAllWords("XYEUYIA");
        //System.out.println(allCombs);
        for(String st : s.findAnagramEquivalents("TAC"))
            System.out.println(st);
        System.out.println(listAllWords("ABCDEFG", s));
    }
}
