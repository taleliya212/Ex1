
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */

public class Ex1Test {

    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));

        String s16 = "FFbG";   // 255b10
        int v3 = Ex1.number2Int(s16);
        assertEquals(255, v3);    // compaire to the real value
        String s2n2 = Ex1.int2Number(v3, 2);  //to base 2
        int v4 = Ex1.number2Int(s2n2);     //back to base 10
        assertEquals(v3, v4);    //compaire the pair
        assertTrue(Ex1.equals(s16, s2n2));   //255=255

        String s8 =  "377b8";
        int v5 = Ex1.number2Int(s8);  // 255b10
        assertEquals(255, v5);  // compaire to the real value
        String s3 = Ex1.int2Number(v5, 3);    //to base 3
        int v6 = Ex1.number2Int(s3);    //back to base 10
        assertEquals(v5, v6);   //compaire the pair
        assertTrue(Ex1.equals(s8, s3));   //255=255

        String s12 = "12AbB";    // 153b10
        int v7 = Ex1.number2Int(s12);
        assertEquals(153,v7);   // compaire to the real value
        String s10n2 = Ex1.int2Number(v7, 10); //to base 10
        int v8 = Ex1.number2Int(s10n2);  //back to base 10
        assertEquals(v7,v8); //compaire the pair
        assertTrue(Ex1.equals(s12,s10n2));  //153=153

    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA","FFbG","CbD"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);  // number in good format
        }
        String[] not_good = {"b2", "2b2", "1G3bG", "0bbA", "abB", "!@b2", "A", "1bb2","9b9","GbG"," BbG"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);  //number in wrong format
        }
    }
    @Test
    void int2NumberTest() {  //int number representation in difrrent base, then compair to the int num
        int n1 = 11, b1 = 2;
        String s1 = Ex1.int2Number(n1, b1);
        assertEquals("1011b2", s1);

        int n2 = 255, b2 = 16;
        String s2 = Ex1.int2Number(n2, b2);
        assertEquals("FFbG", s2);

        int n3 = 10, b3 = 10;
        String s3 = Ex1.int2Number(n3, b3);
        assertEquals("10bA", s3);

        int n4 = 4095, b4 = 16;
        String s4 = Ex1.int2Number(n4, b4);
        assertEquals("FFFbG", s4);

        int n5 = 15, b5 = 1;
        String s5 = Ex1.int2Number(n5, b5);
        assertEquals("", s5);

        int n6 = -10, b6 = 10;
        String s6 = Ex1.int2Number(n6, b6);
        assertEquals("", s6);

        int n7 = 5, b7 = 10;
        String s7 = Ex1.int2Number(n7, b7);
        assertEquals("5bA", s7);

        int n8 = 10, b8 = 'A';
        String s8 = Ex1.int2Number(n8, b8);
        assertEquals("", s8);

    }
    @Test
    void number2IntTest() {
        String s1 = "1011b2";
        int v1 = Ex1.number2Int(s1);
        assertEquals(11, v1);   //11b10

        String s2 = "FFbG";
        int v2 = Ex1.number2Int(s2);
        assertEquals(255, v2);  // 256b10

        String s3 = "10bA";
        int v3 = Ex1.number2Int(s3);
        assertEquals(10, v3);   //10b10

        String s4 = "356";
        int v4 = Ex1.number2Int(s4);
        assertEquals(356, v4);  //356b10

        String s5 = "0bA";
        int v5 = Ex1.number2Int(s5);
        assertEquals(0, v5); //0b10

        String s6 = "C";
        int v6 = Ex1.number2Int(s6);
        assertEquals(-1, v6); // not isnumber
    }
    @Test
    void maxIndexTest() {

        String[] arr1 = {"1011b2", "FFbG", "123bA", "A4bC"};
        int max1 = Ex1.maxIndex(arr1);
        assertEquals(255, max1); // the right max compaire

        String[] arr2 = {"10b2", "15bA", "A4bC"};
        int max2 = Ex1.maxIndex(arr2);
        assertEquals(124, max2); // the right max compaire

        String[] arr3 = {"10b2", null, "A4bC", "FFbG"};
        int max3 = Ex1.maxIndex(arr3);
        assertEquals(255, max3); // the right max compaire

        String[] arr4 = {null, "invalid", null};
        int max4 = Ex1.maxIndex(arr4);
        assertEquals(-1, max4); //not is number



    }

}
