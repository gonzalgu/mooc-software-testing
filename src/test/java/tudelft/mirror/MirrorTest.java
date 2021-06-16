package tudelft.mirror;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MirrorTest {
    @Test
    public void emptyString()
    {
        String result = new Mirror().mirrorEnds("");
        Assertions.assertEquals("", result);
    }

    @Test
    public void singleLetterString()
    {
        String result = new Mirror().mirrorEnds("a");
        Assertions.assertEquals("a", result);
    }

    @Test
    public void aaMapsToa()
    {
        String result = new Mirror().mirrorEnds("aa");
        Assertions.assertEquals("a", result);
    }

    @Test
    public void aaaMapsToaaa()
    {
        String result = new Mirror().mirrorEnds("aaa");
        Assertions.assertEquals("aaa", result);
    }

    @Test
    public void abaMapsToaba(){
        String result = new Mirror().mirrorEnds("aba");
        Assertions.assertEquals("aba", result);
    }

    /*
    mirrorEnds("abXYZba") ==> "ab"
mirrorEnds("abca") ==> "a"
mirrorEnds("aba") ==> "aba"
     */
    @Test
    public void abXYZbaMapsToab()
    {
        String result = new Mirror().mirrorEnds("abXYZba");
        Assertions.assertEquals("ab", result);
    }

    @Test
    public void abcaMapsToa()
    {
        String result = new Mirror().mirrorEnds("abca");
        Assertions.assertEquals("a", result);
    }

    @Test
    public void evenInputLength()
    {
        String result = new Mirror().mirrorEnds("abca");
        Assertions.assertEquals("a", result);
    }

    @Test
    public void unevenInputLength()
    {
        String result = new Mirror().mirrorEnds("axbcdxa");
        Assertions.assertEquals("ax", result);
    }
}
