import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class SowpodsUtil {

    public static HashMap<String,ArrayList<String>> anagramMap = new HashMap<>();
    public static void intSowpodsUtil(){

        File file = new File("./src/sowpods.txt");
        System.out.println(file);

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                char[] letters = st.toCharArray();
                Arrays.sort(letters);
                String key = new String(letters);
                ArrayList<String> temp;
                if(!anagramMap.containsKey(key)){
                     temp = new ArrayList<>();
                }
                else
                {
                    temp = anagramMap.get(key);
                }
                temp.add(st);
                anagramMap.put(key,temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<String> findAnagramEquivalents(String s){
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        String key = new String(letters);
        if(anagramMap.containsKey(key))
            return anagramMap.get(key);
        else
            return new ArrayList<>();
    }
}

