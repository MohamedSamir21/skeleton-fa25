import java.util.ArrayList;
import java.util.List;

public class ListExercises {
    /** Returns the total sum in a list of integers */
    public static int sum(List<Integer> L) {
        int result = 0;
        for (int num: L) {
            result += num;
        }
        return result;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> evenNumbers = new ArrayList<>();
        for (int num: L) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            }
        }
        return evenNumbers;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        ArrayList<Integer> commonList = new ArrayList<>();
        for (int num: L1) {
            if (L2.contains(num)) {
                commonList.add(num);
            }
        }
        return commonList;
    }

    public static int countOccurrencesOfWord(List<String> words, String w) {
        return 0;
    }

    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int count = 0;
        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    count++;
                }
            }
        }
        return count;
    }
}
