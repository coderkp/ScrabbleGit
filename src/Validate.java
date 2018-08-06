import java.util.ArrayList;

public class Validate {
    final int CASE_1 = 1;
    final int CASE_2 = 2;
    final int CASE_3 = 3;

    private ArrayList<String> listAllWords(String letters)
    {
        // Kush
        return null;
    }

    public int calculateScore(String str)
    {
        // code
        return 0;
    }

    private String findMaxString(ArrayList<String> possiblePairs)
    {
        int max = 0, tmp;
        String maxStr = null;
        for(String str: possiblePairs)
        {
            tmp = calculateScore(str);
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
            }
        }
        return maxStr;
    }
    // CASE 3
    public String validate(int caseN, String letters, char fixedChar, int index) // CASE_3
    {
        String maxStr;
        ArrayList<String> possiblePairs;

        possiblePairs = listAllWords(letters.concat(Character.toString(fixedChar)));
        if(possiblePairs == null)
            return null;

        // remove unwanted strings
        for(String str: possiblePairs)
            if(str.charAt(index) != fixedChar)
                possiblePairs.remove(str);

        maxStr = findMaxString(possiblePairs);
        return maxStr;
    }
    public static void main(String[] args) {

    }
}
