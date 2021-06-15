package tudelft.sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoNumbersSumTest {

    @Test
    public void addEmptysReturnsEmpty()
    {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Integer> result = new TwoNumbersSum().addTwoNumbers(l1, l2);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void firstEmptyReturnsSecond()
    {
        ArrayList<Integer> empty = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);

        ArrayList<Integer> result = new TwoNumbersSum().addTwoNumbers(empty, l);
        Assertions.assertEquals(1, result.get(0));
        Assertions.assertEquals(2, result.get(1));
        Assertions.assertEquals(3, result.get(2));
        Assertions.assertEquals(3, result.size());
    }

    @Test
    public void secondEmptyReturnsFirst()
    {
        ArrayList<Integer> empty = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);

        ArrayList<Integer> result = new TwoNumbersSum().addTwoNumbers(l, empty);
        Assertions.assertEquals(1, result.get(0));
        Assertions.assertEquals(2, result.get(1));
        Assertions.assertEquals(3, result.get(2));
        Assertions.assertEquals(3, result.size());
    }

    @Test
    public void firstGTsecondNoComplement()
    {
        ArrayList<Integer> fst = new ArrayList<>();
        fst.add(1);
        fst.add(2);
        fst.add(3);

        ArrayList<Integer> snd = new ArrayList<>();
        snd.add(4);
        snd.add(5);

        ArrayList<Integer> result = new TwoNumbersSum().addTwoNumbers(fst, snd);
        Assertions.assertEquals(3, result.size());

        Assertions.assertEquals(1, result.get(0));
        Assertions.assertEquals(6, result.get(1));
        Assertions.assertEquals(8, result.get(2));
    }

    @Test
    public void secondGTfirstNoComplement()
    {
        ArrayList<Integer> fst = new ArrayList<>();
        fst.add(4);
        fst.add(5);

        ArrayList<Integer> snd = new ArrayList<>();
        snd.add(1);
        snd.add(2);
        snd.add(3);

        ArrayList<Integer> result = new TwoNumbersSum().addTwoNumbers(fst, snd);
        Assertions.assertEquals(3, result.size());

        Assertions.assertEquals(1, result.get(0));
        Assertions.assertEquals(6, result.get(1));
        Assertions.assertEquals(8, result.get(2));
    }

    @Test
    public void sumWithCarry()
    {
        ArrayList<Integer> fst = new ArrayList<>();
        fst.add(9);

        ArrayList<Integer> snd = new ArrayList<>();
        snd.add(9);

        ArrayList<Integer> result = new TwoNumbersSum().addTwoNumbers(fst, snd);
        Assertions.assertEquals(2, result.size());

        Assertions.assertEquals(1, result.get(0));
        Assertions.assertEquals(8, result.get(1));
    }

}
