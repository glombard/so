package rxtest;

import java.io.Closeable;
import java.io.IOException;

public class MyResource implements Closeable {

    private final int num;

    public MyResource(int num) {
        this.num = num;
    }

    public void close() throws IOException {
        System.out.println("Closing " + toString());
    }

    @Override
    public String toString() {
        return "Resource #" + num;
    }
}
