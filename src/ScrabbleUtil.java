public class ScrabbleUtil {
    static int[] points = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};

    public static int getWordScore(String s){
        int sum=0;
        for(int i=0;i<s.length();i++)
            sum+=points[(int)s.charAt(i)-(int)'A'];
    return sum;
    }

}
