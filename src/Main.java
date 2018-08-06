public class Main {

    public static void main(String[] args) {

        SowpodsUtil s = new SowpodsUtil();
        s.intSowpodsUtil();
        //System.out.println(s.anagramMap.get("ACT"));

        for(String st : s.findAnagramEquivalents("TAC"))
            System.out.println(st);

    }
}
