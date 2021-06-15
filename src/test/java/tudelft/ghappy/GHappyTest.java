package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {
    //if there are no g's in the string, the string is happy
    @Test
    public void emptyString() {
        boolean result = new GHappy().gHappy("");
        Assertions.assertTrue(result);
    }

    //
    @Test
    public void stringWithNoGsIsHappy() {
        boolean result = new GHappy().gHappy("abcdef");
        Assertions.assertTrue(result);
    }

    @Test
    public void singleGIsNotHappy() {
        boolean result = new GHappy().gHappy("g");
        Assertions.assertFalse(result);
    }

    @Test
    public void twoGsIsHappy()
    {
        boolean result = new GHappy().gHappy("gg");
        Assertions.assertTrue(result);
    }

    @Test
    public void threeGsIsHappy()
    {
        boolean result = new GHappy().gHappy("ggg");
        Assertions.assertTrue(result);
    }

    @Test
    public void twoNonConsecutiveGsIsNotHappy()
    {
        boolean result = new GHappy().gHappy("xxgxxgxx");
        Assertions.assertFalse(result);
    }

    @Test
    public void singleGIsNotLastCharacterInString()
    {
        boolean result = new GHappy().gHappy("gx");
    }

    //examples
    /*
    gHappy("xxggxx") ==> true
gHappy("xxgxx") ==> false
gHappy("xxggyygxx") ==> false
     */
    @ParameterizedTest(name="string={0}, expected={1}")
    @CsvSource({"xxggxx,true", "xxgxx,false", "xxggyygxx,false"})
    public void tests(String str, boolean expected)
    {
        boolean result = new GHappy().gHappy(str);
        Assertions.assertEquals(expected, result);
    }

}
