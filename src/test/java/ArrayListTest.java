import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    List<Integer> elements = new ArrayList<>();

    @BeforeEach
    void setUp() {
        for (int i = 1; i <= 10000; i++) {
            elements.add(i);
        }
    }

    @Test
    void testAdd() {
        assertEquals(1, elements.get(0));
        assertEquals(10000, elements.get(9999));
    }

    @Test
    void testAddMiddle() {
        elements.add(2, 10);
        assertEquals(10, elements.get(2));
    }

    @Test
    void set() {
        elements.set(100, 1);
        assertEquals(1, elements.get(100));
    }

    @Test
    void get() {
        assertEquals(6, elements.get(5));
    }

    @Test
    void testGetFirst() {
        assertEquals(1, elements.getFirst());
    }

    @Test
    void testGetLast() {
        assertEquals(10000, elements.getLast());
    }

    @Test
    void testRemove() {
        assertEquals(11, elements.remove(10));
    }

    @Test
    void testContains() {
        assertEquals(true, elements.contains(9));
    }

    @Test
    void testIsEmpty() {
        assertEquals(false, elements.isEmpty());
    }

    @Test
    void testSize() {
        assertEquals(10000, elements.size());
    }

    @Test
    void testClear() {
        elements.clear();
        assertEquals(null, elements.get(5));

    }
}