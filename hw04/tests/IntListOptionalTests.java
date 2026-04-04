import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Formatter;

import static org.junit.Assert.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IntListOptionalTests {

    /**
     * If a cycle exists in the IntList, this method
     * returns an integer equal to the item number of the location where the
     * cycle is detected.
     */
    private int detectCycles(IntList A) {
        IntList tortoise = A;
        IntList hare = A;

        if (A == null) {
            return 0;
        }

        int cnt = 0;

        while (true) {
            cnt++;
            if (hare.rest != null) {
                hare = hare.rest.rest;
            } else {
                return 0;
            }

            tortoise = tortoise.rest;

            if (tortoise == null || hare == null) {
                return 0;
            }

            if (hare == tortoise) {
                return cnt;
            }
        }
    }

    /** Outputs the IntList as a String. You are not expected to read
     * or understand this method. */
    private String intListToString(IntList L) {
        if (L == null) {
            return "()";
        }

        Formatter out = new Formatter();
        String sep;
        sep = "(";
        int cycleLocation = detectCycles(L);
        int cnt = 0;

        for (IntList p = L; p != null; p = p.rest) {
            out.format("%s%d", sep, p.first);
            sep = ", ";

            cnt++;
            if ((cnt > cycleLocation) && (cycleLocation > 0)) {
                out.format("... (cycle exists) ...");
                break;
            }
        }
        out.format(")");
        return out.toString();
    }

    @Test
    @Order(0)
    @DisplayName("Test sum correctness")
    public void testSum() {
        IntList L = IntListRequiredTests.of(1, 2, 3, 4);
        int expected = 10;
        int result = L.sum();

        if (result != expected) {
            String errorMessage = String.format(
                    "For input %s, expected sum to return %d but got %d",
                    intListToString(L), expected, result);
            fail(errorMessage);
        }
    }

    @Test
    @Order(1)
    @DisplayName("Test sum correctness with a single element")
    public void testSumSingle() {
        IntList L = IntListRequiredTests.of(42);
        int expected = 42;
        int result = L.sum();

        if (result != expected) {
            String errorMessage = String.format(
                    "For input %s, expected sum to return %d but got %d",
                    intListToString(L), expected, result);
            fail(errorMessage);
        }
    }

    @Test
    @Order(2)
    @DisplayName("Test sum correctness with negative numbers")
    public void testSumNegative() {
        IntList L = IntListRequiredTests.of(-5, 10, -3);
        int expected = 2;
        int result = L.sum();

        if (result != expected) {
            String errorMessage = String.format(
                    "For input %s, expected sum to return %d but got %d",
                    intListToString(L), expected, result);
            fail(errorMessage);
        }
    }

    @Test
    @Order(3)
    @DisplayName("Test sum does not modify the list")
    public void testSumNonDestructive() {
        IntList L = IntListRequiredTests.of(1, 2, 3);
        IntList before = IntListRequiredTests.of(1, 2, 3);
        L.sum();

        if (!IntListRequiredTests.checkEquals(L, before)) {
            String errorMessage = String.format(
                    "For input %s, expected L after call to sum to be %s but got %s",
                    intListToString(before), intListToString(before), intListToString(L));
            fail(errorMessage);
        }
    }

    @Test
    @Order(4)
    @DisplayName("Test addLast correctness")
    public void testAddLast() {
        IntList L = IntListRequiredTests.of(1, 2, 3);
        IntList expected = IntListRequiredTests.of(1, 2, 3, 4);
        L.addLast(4);

        if (!IntListRequiredTests.checkEquals(L, expected)) {
            String errorMessage = String.format(
                    "After addLast(4) on %s, expected list to be %s but got %s",
                    intListToString(IntListRequiredTests.of(1, 2, 3)),
                    intListToString(expected), intListToString(L));
            fail(errorMessage);
        }
    }

    @Test
    @Order(5)
    @DisplayName("Test addLast correctness on a one-element list")
    public void testAddLastOneElement() {
        IntList L = IntListRequiredTests.of(1);
        IntList expected = IntListRequiredTests.of(1, 2);
        L.addLast(2);

        if (!IntListRequiredTests.checkEquals(L, expected)) {
            String errorMessage = String.format(
                    "After addLast(2) on %s, expected list to be %s but got %s",
                    intListToString(IntListRequiredTests.of(1)),
                    intListToString(expected), intListToString(L));
            fail(errorMessage);
        }
    }

    @Test
    @Order(6)
    @DisplayName("Test addFirst correctness")
    public void testAddFirst() {
        IntList L = IntListRequiredTests.of(2, 3, 4);
        IntList expected = IntListRequiredTests.of(1, 2, 3, 4);
        L.addFirst(1);

        if (!IntListRequiredTests.checkEquals(L, expected)) {
            String errorMessage = String.format(
                    "After addFirst(1) on %s, expected list to be %s but got %s",
                    intListToString(IntListRequiredTests.of(2, 3, 4)),
                    intListToString(expected), intListToString(L));
            fail(errorMessage);
        }
    }

    @Test
    @Order(7)
    @DisplayName("Test addFirst correctness on a one-element list")
    public void testAddFirstOneElement() {
        IntList L = IntListRequiredTests.of(1);
        IntList expected = IntListRequiredTests.of(0, 1);
        L.addFirst(0);

        if (!IntListRequiredTests.checkEquals(L, expected)) {
            String errorMessage = String.format(
                    "After addFirst(0) on %s, expected list to be %s but got %s",
                    intListToString(IntListRequiredTests.of(1)),
                    intListToString(expected), intListToString(L));
            fail(errorMessage);
        }
    }

    @Test
    @Order(8)
    @DisplayName("Test sum correctness with zeros")
    public void testSumZeros() {
        IntList L = IntListRequiredTests.of(0, 0, 0);
        int expected = 0;
        int result = L.sum();

        if (result != expected) {
            String errorMessage = String.format(
                    "For input %s, expected sum to return %d but got %d",
                    intListToString(L), expected, result);
            fail(errorMessage);
        }
    }

    @Test
    @Order(9)
    @DisplayName("Test addLast correctness when called multiple times")
    public void testAddLastMultiple() {
        IntList L = IntListRequiredTests.of(1, 2);
        IntList expected = IntListRequiredTests.of(1, 2, 3, 4);
        L.addLast(3);
        L.addLast(4);

        if (!IntListRequiredTests.checkEquals(L, expected)) {
            String errorMessage = String.format(
                    "After addLast(3) and addLast(4) on %s, expected list to be %s but got %s",
                    intListToString(IntListRequiredTests.of(1, 2)),
                    intListToString(expected), intListToString(L));
            fail(errorMessage);
        }
    }

    @Test
    @Order(10)
    @DisplayName("Test addFirst correctness when called multiple times")
    public void testAddFirstMultiple() {
        IntList L = IntListRequiredTests.of(3, 4);
        IntList expected = IntListRequiredTests.of(1, 2, 3, 4);
        L.addFirst(2);
        L.addFirst(1);

        if (!IntListRequiredTests.checkEquals(L, expected)) {
            String errorMessage = String.format(
                    "After addFirst(2) and addFirst(1) on %s, expected list to be %s but got %s",
                    intListToString(IntListRequiredTests.of(3, 4)),
                    intListToString(expected), intListToString(L));
            fail(errorMessage);
        }
    }
}
