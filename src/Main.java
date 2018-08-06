public class Main {

    public static void main(String[] args) {

        SowpodsUtil s = new SowpodsUtil();
        SowpodsUtil.intSowpodsUtil();
        System.out.println(ScrabbleUtil.getWordScore("ACT"));

        for(String st : SowpodsUtil.findAnagramEquivalents("TAC"))
            System.out.println(st);

    }
}
