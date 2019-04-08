package list;

import org.junit.Assert;
import org.junit.Test;

public class MyListTest {

    /**
     * Tests getLength and add methods
     */
    @org.junit.Test
    public void testsAddAndGetLength() {
        int expectedLength = 1568;
        MyList<Integer> list = new MyList<Integer>();
        for (int i = 0; i <expectedLength ; i++) {
            list.add(i);
            //System.out.println(list.getLength());
        }

        Assert.assertEquals(expectedLength, list.getLength());
    }

    @Test
    public void testsDeleteAt() {
        int expectedLength = 168;
        MyList<Integer> list = new MyList<Integer>();
        for (int i = 0; i <expectedLength ; i++) {
            list.add(i);
            System.out.println("length = "+list.getLength());
            System.out.println("element = "+list.get(i));
        }
        Assert.assertEquals(167, list.find(167));
        Assert.assertEquals(-1, list.find(168));
        list.delete(0);
        list.delete(0);
        list.delete(0);
        Assert.assertEquals(expectedLength-3, list.getLength());
        Assert.assertEquals(3,list.get(0));
        Assert.assertEquals(164, list.find(167));
        Assert.assertEquals(-1, list.find(0));
    }
    @Test
    public void testsSort_Integer() {
        MyList<Integer> list = new MyList<Integer>();
        list.add(12);
        list.add(2);
        list.add(85);
        list.add(-85);
        list.sort();
        Assert.assertEquals(-85, list.get(0));
        Assert.assertEquals(2, list.get(1));
        Assert.assertEquals(12, list.get(2));
        Assert.assertEquals(85, list.get(3));
    }
    @Test
    public void testsSort_String() {
        MyList<String> list = new MyList<String>();
        list.add("s");
        list.add("42");
        list.add("12");
        list.add("9");
        list.sort();
        Assert.assertEquals("12", list.get(0));
        Assert.assertEquals("42", list.get(1));
        Assert.assertEquals("9", list.get(2));
        Assert.assertEquals("s", list.get(3));
    }
    @Test
    public void testsAddAt() {
        MyList<String> list = new MyList<String>();
        list.add("s");
        list.add("42");
        list.add("12");
        list.add("9");
        list.addAt(2,"test");

        Assert.assertEquals("test", list.get(2));
    }
}