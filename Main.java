import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String argv[]) {
        System.out.println("TAN: " + scrambleWord("TAN"));
        System.out.println("ABRACADABRA: " + scrambleWord("ABRACADABRA"));
        System.out.println("WHOA: " + scrambleWord("WHOA"));
        System.out.println("AARDVARK: " + scrambleWord("AARDVARK"));
        System.out.println("EGGS: " + scrambleWord("EGGS"));
        System.out.println("A: " + scrambleWord("A"));
        System.out.println(": " + scrambleWord(""));

        List<String> tlist = new ArrayList<String>();
        tlist.add("TAN");
        tlist.add("ABRACADABRA");
        tlist.add("WHOA");
        tlist.add("APPLE");
        tlist.add("EGGS");

        for (String str : tlist) {
            System.out.println(str);
        }
        scrambleOrRemove(tlist);
        System.out.println("");
        for (String str : tlist) {
            System.out.println(str);
        }
    }

    public static String scrambleWord(String word) {
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'A'
                    && i != (word.length() - 1)
                    && word.charAt(i + 1) != 'A') {
                buf.append(word.charAt(i + 1));
                buf.append('A');
                i++;
            } else {
                buf.append(word.charAt(i));
            }
        }

        return buf.toString();
    } 

    public static void scrambleOrRemove(List<String> wordList) {
        boolean remove[] = new boolean[wordList.size()];

        for (int i = 0; i < wordList.size(); i++) {
            String str = wordList.get(i);
            String nstr = scrambleWord(wordList.get(i));

            if (nstr.compareTo(str) == 0) {
                remove[i] = true;
            } else {
                remove[i] = false;
                wordList.set(i, nstr);
            }
        }

        int removed = 0;
        for (int i = 0; i < remove.length; i++) {
            // Done after time was called.
            if (remove[i]) {
                wordList.remove(i - removed);
                removed++;
            }
        }
    }
}
