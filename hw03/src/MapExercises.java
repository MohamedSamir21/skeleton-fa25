import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        Map<Character, Integer> map = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, (i - 'a') + 1);
        }
        return map;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        Map<Integer, Integer> numbersToSquares = new HashMap<>();
        for (int num: nums) {
            numbersToSquares.put(num, num * num);
        }
        return numbersToSquares;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> wordsToOccurrences = new HashMap<>();
        for (String word1: words) {
            int count = 0;
            for (String word2: words) {
                if (word1.equals(word2)) {
                    count++;
                }
            }
            wordsToOccurrences.put(word1, count);
        }
        return wordsToOccurrences;
    }
}
