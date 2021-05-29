package util;

public class Counter
{

    private int cnt;

    public Counter(int init) {
        cnt = init;
    }

    public Counter() {
        this(0);
    }

    public synchronized int inc() {
        return ++cnt;
    }

    public synchronized int getCount() {
        return cnt;
    }
}
