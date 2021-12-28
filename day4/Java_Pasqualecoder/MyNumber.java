public class MyNumber {
    private int n;
    private boolean b;

    public MyNumber(int n, boolean b) {
        this.n = n;
        this.b = b;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public boolean getB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return String.valueOf(n);
    }
}
