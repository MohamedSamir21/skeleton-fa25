/**
 * @author mohmed samer.
 * This is my implementation of the stack using LinkedList.
 * My invariants:
 * # sentinenl is always the first node in the LinkedList.
 * # sentinel.next is always the first node in the stack, assuming the stack isn't empty.
 * # size is always the number of items in the stack
 * # size equals 0 when the stack is empty.
 */
public class Stack {
    private final IntNode sentinel;
    private int size;

    private static class IntNode {
        private int item;
        private IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    public Stack() {
        sentinel = new IntNode(0, null);
    }

    /**
     * Puts value on top of the stack
     *
     * @param value is the value to be put into the stack
     */
    public void push(int value) {
        size++;
        sentinel.next = new IntNode(value, sentinel.next);
    }

    /**
     * Removes the value at the top of the stack
     * @return the value at the top of the stack
     */
    public int pop() {
        size--;
        int value = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        return value;
    }

    /**
     * @return the number of items on the stack
     */
    public int size() {
        return size;
    }

    /**
     * @return compute the sum of the numbers on the stack
     */
    public int sum() {
        // 1. Recursion: Don't forget to uncomment out the sumHelper(..) method
//        return sumHelper(sentinel.next);

        // 2. Iteration
        IntNode p = sentinel.next;
        int total = 0;
        while (p != null) {
            total += p.item;
            p = p.next;
        }
        return total;
    }

//    private int sumHelper(IntNode node) {
//        if (node == null) {
//            return 0;
//        }
//        return node.item + sumHelper(node.next);
//    }
}
