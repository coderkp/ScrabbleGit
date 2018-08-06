public class Main {

    public static void main(String[] args) {

        SowpodsUtil s = new SowpodsUtil();
        s.intSowpodsUtil();
        System.out.println(ScrabbleUtil.getWordScore("ACT"));

        for(String st : s.findAnagramEquivalents("TAC"))
            System.out.println(st);

    }
}
