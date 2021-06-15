package tudelft.countletters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountLettersTest {

    @Test
    public void multipleMatchingWords() {
        int words = new CountLetters().count("cats|dogs");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void lastWordDoesNotMatch() {
        int words = new CountLetters().count("cats|dog");
        Assertions.assertEquals(1, words);
    }

    @Test
    public void firstWordEndsWithR()
    {
        int words = new CountLetters().count("pater|familias");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void doesNotEndsWithRorS()
    {
        int words = new CountLetters().count("alia|");
        Assertions.assertEquals(0, words);
    }

    @Test
    public void singleWordEndsWithR()
    {
        int words = new CountLetters().count("pater");
        Assertions.assertEquals(1, words);
    }


}