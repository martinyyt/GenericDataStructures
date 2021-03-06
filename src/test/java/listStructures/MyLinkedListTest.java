package listStructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class MyLinkedListTest {

    /**
     * Tests getLength and addLast methods
     */
    @Test
    public void testsAddAndGetLength() {
        int expectedLength = 1568;
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        Assert.assertEquals(0, list.getLength());
        for (int i = 0; i < expectedLength; i++) {
            list.addLast(i);
            //System.out.println(listStructures.getLength());
        }
        Assert.assertEquals(expectedLength, list.getLength());
        list.addFirst(5);
        Assert.assertEquals(5, (int) list.getFirst());
        Assert.assertEquals(5, (int) list.get(0));
        Assert.assertEquals(expectedLength - 1, (int) list.getLast());
        list.addAt(158, -1);
        Assert.assertEquals(-1, (int) list.get(158));
    }

    @Test(expected = NoSuchElementException.class)
    public void testsGetFirst_Exception() {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.getFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testsGetLast_Exception() {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.getLast();
    }

    @Test(expected = NoSuchElementException.class)
    public void testsPopFirst_Exception() {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.popFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testsPopLast_Exception() {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.popLast();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testsDelete_Exception() {
        MyLinkedList<String> list = new MyLinkedList<String>();
        list.addFirst("one");
        list.delete(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testsGet_Exception() {
        MyLinkedList<String> list = new MyLinkedList<String>();
        list.get(0);
        //System.out.println(list.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testsAddAt_Exception() {
        MyLinkedList<String> list = new MyLinkedList<String>();
        list.addAt(1, "5");
    }

    @Test
    public void testsRunList() {
        int expectedLength = 168;
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        for (int i = 0; i < expectedLength; i++) {
            list.addLast(i);
            //System.out.println("length = " + list.getLength());
            //System.out.println("element = " + list.get(i));
        }
        Assert.assertEquals(167, list.indexOf(167));
        Assert.assertEquals(-1, list.indexOf(168));
        list.delete(0);
        list.delete(0);
        list.delete(0);
        Assert.assertEquals(expectedLength - 3, list.getLength());
        Assert.assertEquals(3, (int) list.get(0));
        Assert.assertEquals(164, list.indexOf(167));
        Assert.assertEquals(true, list.contains(167));
        Assert.assertEquals(-1, list.indexOf(0));
        Assert.assertEquals(false, list.contains(0));
        list.addFirst(-100);
        Assert.assertEquals(-100, (int) list.popFirst());
        list.addLast(-200);
        Assert.assertEquals(-200, (int) list.popLast());
        list.clear();
        Assert.assertEquals(0, list.getLength());
    }

    @Test
    public void testsAddAt() {
        MyLinkedList<String> list = new MyLinkedList<String>();
        list.addLast("s");
        //System.out.println(list.getLength());
        list.addLast("42");
        //System.out.println(list.getLength());
        list.addLast("12");
        //System.out.println(list.getLength());
        list.addLast("9");
        //System.out.println(list.getLength());
        list.addAt(2, "test");
        //System.out.println(list.getLength());
        list.addAt(5, "last");

        Assert.assertEquals("test", list.get(2));
        Assert.assertEquals("9", list.get(4));
        Assert.assertEquals("last", list.getLast());
    }

    @Test
    public void testsSort_Integer() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addLast(12);
        list.addLast(2);
        list.addLast(85);
        list.addLast(-5);
        list.addLast(6);
        list.addLast(185);
        list.addLast(16);
        list.addLast(37);
        list.addLast(48);
        list.addLast(-85);
        list.sort();
        //System.out.println(list.toString());
        Assert.assertEquals(-85, (int) list.getFirst());
        Assert.assertEquals(-5, (int) list.get(1));
        Assert.assertEquals(85, (int) list.get(list.getLength()-2));
        Assert.assertEquals(185, (int) list.getLast());
    }

    @Test
    public void testsSort_String() {
        MyLinkedList<String> list = new MyLinkedList<String>();
        list.addLast("s");
        list.addLast("42");
        list.addLast("12");
        list.addLast("9");
        list.sort();
        //System.out.println(list.toString());
        Assert.assertEquals("12", list.get(0));
        Assert.assertEquals("42", list.get(1));
        Assert.assertEquals("9", list.get(2));
        Assert.assertEquals("s", list.get(3));
    }

    @Test
    public void testsToString() {
        String expected = "12 | 2 | 85 | -5 | 6 | 185 | 16 | 37 | 48 | -85";
        MyLinkedList<Integer> list = new MyLinkedList<>();
        Assert.assertEquals(null, list.toString());
        list.addLast(12);
        Assert.assertEquals("12", list.toString());
        list.addLast(2);
        list.addLast(85);
        list.addLast(-5);
        list.addLast(6);
        list.addLast(185);
        list.addLast(16);
        list.addLast(37);
        list.addLast(48);
        list.addLast(-85);
        //System.out.println(list.toString());
        Assert.assertEquals(expected, list.toString());
    }
}