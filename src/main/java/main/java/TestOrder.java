package main.java;

/**
 * Created with IntelliJ IDEA.
 * User: annaleis
 * Date: 7/20/14
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestOrder {

    private final int testorderNumber;
    private final String testtype;
    private final int testsize;
    private final int testboxNumber;


    public testorder(int testorderNumber, String testtype, int testsize, int testboxNumber) {
        this.testorderNumber = testorderNumber;
        this.testtype = testtype;
        this.testsize = testsize;
        this.testboxNumber = testboxNumber;
    }

    public int getTestorderNumber() {
        return testorderNumber;
    }

    public String getTesttype() {
        return testtype;
    }

    public int getTestsize() {
        return testsize;
    }

    public int getTestboxNumber() {
        return testboxNumber;
    }
}
