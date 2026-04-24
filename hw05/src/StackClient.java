/**
 * @author mohmed samer
 */
public class StackClient {

    /**
     * @param s the stack you want to flip.
     * @return Returns a version of the stack that is flipped.
     */
    public static Stack flipped(Stack s) {
        Stack result = new Stack();
        while (s.size() != 0) {
            result.push(s.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 1000000;

        // 1. Verify the pushing
        System.out.println("-----Benchmark for the push()-----");
        for (int i = 100000; i <= N; i+=100000) {
            Stack s = new Stack();
            long startTime = System.currentTimeMillis();
            for (int j = 1; j <= i; j++) {
                s.push(j);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Pushing the " + (i/1000)+ "k items into the stack took " + (endTime - startTime) + " milliseconds");
        }

        // 2. Verify the popping
        System.out.println("-----Benchmark for the pop()-----");
        for (int i = 100000; i <= N; i += 100000) {
            Stack s = new Stack();
            for (int j = 1; j <= i; j++) {
                s.push(j);
            }
            long startTime = System.currentTimeMillis();
            for (int j = 1; j <= i; j++) { // Avoid to use the s.sum() instead of N, since this is additional cost.
                s.pop();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Popping up the " + (i/1000) + "k items out of the stack took " + (endTime - startTime) + " milliseconds");
        }

        Stack s = new Stack();
        // 3. Verify the sum
        System.out.println("-----Benchmark for the sum()-----");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 100000; j++) {
                s.push(j);
            }
            long startTime = System.currentTimeMillis();
            s.sum();
            long endTime = System.currentTimeMillis();
            System.out.println("Summing up the " + (i * 100) + "k items of the stack took " + (endTime - startTime) + " milliseconds");
        }
    }
}
