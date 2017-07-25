package side.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        getAddition mGetadd = new getAddition();
        if(4 == mGetadd.getAddition(2,2)) {
            assertTrue(true);
        }else {
            assertTrue(false);
        }
    }

    @Test
    public void subtraction_isCorrect() throws Exception {
        getSubtraction mGetsub = new getSubtraction();
        if(4 == mGetsub.getSubtraction(6,2)) {
            assertTrue(true);
        }else {
            assertTrue(false);
        }
    }

    @Test
    public void division_isCorrect() throws Exception {
        getDivision mGetDiv = new getDivision();
        if(4 == mGetDiv.getDivision(6,2)) { // This should failed. Expected result is fail as 6/2 = 3 not 4
            assertTrue(true);
        }else {
            assertTrue(false);
        }
    }

    @Test
    public void multiplication_isCorrect() throws Exception {
        getMultiplication mGetMul = new getMultiplication();
        if(12 == mGetMul.getMultiplication(6,2)) {
            assertTrue(true);
        }else {
            assertTrue(false);
        }
    }

    @Test
    public void mod_isCorrect() throws Exception {
        getMod mGetMod = new getMod();
        if(1 == mGetMod.getMod(7,2)) {
            assertTrue(true);
        }else {
            assertTrue(false);
        }
    }

    @Test
    public void neg_isCorrect() throws Exception {
        getNegation mGetNeg = new getNegation();
        String d1 = Double.toString(7);

        if(-7 == mGetNeg.getNegation(d1)) {
            assertTrue(true);
        }else {
            assertTrue(false);
        }
    }
}