package de.javafish.helper;

public class BenchTest {
    public static void main(String[] args) {
        new BenchTest().go();
    }
    
    
    private void go() {
        Benchmark b = new Benchmark("NANO");
        try {
            b.start();
            Thread.sleep(100);
            System.out.println(b.stop());
        } catch (InterruptedException ex) {
        }
    }
}
