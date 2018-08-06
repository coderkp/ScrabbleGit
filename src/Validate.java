import java.util.ArrayList;
import java.util.Arrays;

public class Validate {
    final int CASE_1 = 1;
    final int CASE_2 = 2;
    final int CASE_3 = 3;

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
        for(int i=rack.length(); i>=2; i--)
            storeCombination(tempArray,rack.length(),i);
    }
    public static ArrayList<String> listAllWords(String rack)
    {
        listAllPossible(rack);
        ArrayList<String> words = new ArrayList<>();
        for(String temp: allCombs)
        {
            if(!SowpodsUtil.findAnagramEquivalents(temp).isEmpty())
            {
                words.addAll(SowpodsUtil.findAnagramEquivalents(temp));
            }
        }
        return words;
    }
    private String findMaxString(ArrayList<String> possiblePairs)
    {
        int max = 0, tmp;
        String maxStr = null;
        for(String str: possiblePairs)
        {
            tmp = ScrabbleUtil.getWordScore(str);
            if(max < tmp)
            {
                max = tmp;
                maxStr = str;
            }
        }
        return maxStr;
    }

    public String validate(int caseN, String letters)
    {
        String maxStr = null;
        ArrayList<String> possiblePairs;

        if(caseN == CASE_1)
        {
            possiblePairs = listAllWords(letters);
            if(possiblePairs != null)
                maxStr = findMaxString(possiblePairs);
        }
        else if(caseN == CASE_2)
        {
            for(char c = 'A'; c <= 'Z'; c++)
            {
                letters = letters.concat(Character.toString(c));
                possiblePairs = listAllWords(letters);
                if(possiblePairs != null)
                    maxStr = findMaxString(possiblePairs);
                letters=letters.substring(0,letters.length()-1);
            }
        }
        return maxStr;
    }
    // CASE 3
    public String validate(int caseN, String letters, char fixedChar[], int[] index) // CASE_3
    {
        ArrayList<String> possibleValidPairs = new ArrayList<>();

        if(fixedChar.length==1){
            if(index.length==1)
                possibleValidPairs=findValidStrings(letters,fixedChar[0],index[0]);
            else
                possibleValidPairs=findValidStringsOr(letters,fixedChar[0],index[0],index[1]);
        }
        else if(index.length==3){
            possibleValidPairs.addAll(findValidStringsAnd(letters,fixedChar[0],fixedChar[1],index[0],index[2]+index[0]));
            possibleValidPairs.addAll(findValidStringsAnd(letters,fixedChar[0],fixedChar[1],index[1],index[2]+index[1]));
        }
        else
            possibleValidPairs.addAll(findValidStringsAnd(letters,fixedChar[0],fixedChar[1],index[0],index[1]+index[0]));
        return findMaxString(possibleValidPairs);

    }

    public ArrayList<String> findValidStringsOr( String letters, char fixedChar, int index1,int index2) // CASE_3
    {

        ArrayList<String> possibleValidPairs = new ArrayList<>();

        possibleValidPairs.addAll(findValidStrings( letters,  fixedChar,  index1));
        possibleValidPairs.addAll(findValidStrings( letters,  fixedChar,  index2));
        return possibleValidPairs;

    }
    public ArrayList<String> findValidStringsAnd( String letters, char fixedChar1,char fixedChar2, int index1,int index2) // CASE_3
    {

        ArrayList<String> possibleValidPairs1 = findValidStrings( letters,  fixedChar1,  index1);
        ArrayList<String> possibleValidPairs2 = findValidStrings( letters,  fixedChar2,  index2);
        ArrayList<String> possibleValidPairs = new ArrayList<>();
        for (String t : possibleValidPairs1) {
            if(possibleValidPairs2.contains(t)) {
                possibleValidPairs.add(t);
            }
        }
        return possibleValidPairs;

    }

    public ArrayList<String> findValidStrings(String letters, char fixedChar, int index) // CASE_3
    {
        String maxStr;
        ArrayList<String> possiblePairs;
        ArrayList<String> possibleValidPairs = new ArrayList<>();

        possiblePairs = listAllWords(letters.concat(Character.toString(fixedChar)));
        if(possiblePairs == null)
            return null;

        // remove unwanted strings
        for(String str: possiblePairs)
            if(index<str.length() && str.charAt(index) == fixedChar)
                possibleValidPairs.add(str);
        System.out.println("LIST OF ALL VALID WORDS WITH FIXED CHARACTERS");
        for(String str: possibleValidPairs)
            System.out.print(str+" ");
        System.out.println();

        return possibleValidPairs;

    }
}
