package singlyLinkedListTest;

import org.junit.Test;
import singlyLinkedList.SinglyLinkedListImpl;

import static org.junit.Assert.*;

public class AppendTest {
    @Test
    public void testAppendToEmptyList() {
        SinglyLinkedListImpl<Double> list = new SinglyLinkedListImpl<>();
        assertTrue(list.append(1d));
        assertEquals("[1.0]", list.toString());
        assertEquals(1, list.size());
    }

    @Test
    public void testAppendToNonEmptyList() {
        SinglyLinkedListImpl<Integer> list = new SinglyLinkedListImpl<>();
        list.append(1);
        list.append(2);
        list.append(3);
        assertTrue(list.append(4));
        assertEquals("[1, 2, 3, 4]", list.toString());
        assertEquals(4, list.size());
    }

    @Test
    public void testAppendMultipleElements() {
        SinglyLinkedListImpl<String> list = new SinglyLinkedListImpl<>();
        assertTrue(list.append("apple"));
        assertEquals("[apple]", list.toString());
        assertEquals(1, list.size());

        assertTrue(list.append("banana"));
        assertEquals("[apple, banana]", list.toString());
        assertEquals(2, list.size());

        assertTrue(list.append("orange"));
        assertEquals("[apple, banana, orange]", list.toString());
        assertEquals(3, list.size());
    }

    @Test
    public void testGoodAppend() {
        SinglyLinkedListImpl<Integer> nums = new SinglyLinkedListImpl<>();
        assertTrue(nums.append(1));
        assertTrue(nums.append(-12));
        assertTrue(nums.append(0));
        assertTrue(nums.append(Integer.MAX_VALUE));
        assertTrue(nums.append(Integer.MIN_VALUE));
        assertEquals("[1, -12, 0, 2147483647, -2147483648]", nums.toString());
        assertEquals(5, nums.size());
    }

    @Test
    public void testIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            SinglyLinkedListImpl<String> list = new SinglyLinkedListImpl<>();
            list.append(null);
        });
    }
}
