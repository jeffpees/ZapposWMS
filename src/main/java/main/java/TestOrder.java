package main.java;

/**
 * Created with IntelliJ IDEA.
 * User: annaleis
 * Date: 7/20/14
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestOrder {

    private int testorderNumber;
    private String testtype;
    private int testsize;
    private int testboxNumber;

    public TestOrder() {
        super();
    }

    public TestOrder(int testorderNumber, String testtype, int testsize, int testboxNumber) {
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

    public void setTestorderNumber(int testorderNumber) {
        this.testorderNumber = testorderNumber;
    }

    public void setTesttype(String testtype) {
        this.testtype = testtype;
    }

    public void setTestsize(int testsize) {
        this.testsize = testsize;
    }

    public void setTestboxNumber(int testboxNumber) {
        this.testboxNumber = testboxNumber;
    }

}


