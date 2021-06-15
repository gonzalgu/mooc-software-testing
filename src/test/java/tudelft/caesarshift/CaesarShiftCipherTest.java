package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
A Caesar Cipher is a simply way to encrypt messages. There are two inputs: A message and a shift. The message can be
any string containing lower case letters and spaces, any other characters will return 'invalid' The shift can be any
positive or negative integer. Each letter of the message is then shifted by the specified amount
(if shift is '3' then 'abc' becomes 'def' and 'xyz' becomes 'abc').

See our implementation in the CaesarCipherShift class (package tudelft.caesarcipher). There's a bug in this
implementation. Apply everything you learned and do your best to find the bug!! Write your automated tests
inside CaeserCipherShiftTest class. At the end, push your solution to your GitHub repository.
 */

public class CaesarShiftCipherTest {
    @Test
    public void emptyStringMapsToEmpty()
    {
        String result = new CaesarShiftCipher().CaesarShiftCipher("", 2);
        Assertions.assertEquals("", result);
    }

    @Test
    public void zeroShiftReturnsSameString()
    {
        String input = "abcdef";
        String result = new CaesarShiftCipher().CaesarShiftCipher(input, 0);
        Assertions.assertEquals(input, result);
    }

    @Test
    public void abcWithShift3Becomesdef()
    {
        String result = new CaesarShiftCipher().CaesarShiftCipher("abc", 3);
        Assertions.assertEquals("def", result);
    }

    @Test
    public void defWithShiftMinus3Becomesabc()
    {
        String result = new CaesarShiftCipher().CaesarShiftCipher("def", -3);
        Assertions.assertEquals("abc", result);
    }



}
