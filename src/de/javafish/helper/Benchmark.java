package de.javafish.helper;

import java.text.*;

/**
 * Ein Benchmark, der die zeitliche Differenz zwischen zwei Zeitpunkten
 * ermittelt.
 * 
 * <p>Der erste Zeitpunkt wird nach der Erzeugung eines
 * Benchmark-Objekts durch den Aufruf der <code>start()</code>-Methode gesetzt,
 * der zweite durch den Aufruf der <code>stop()</code>-Methode.
 * 
 * <p>Eine einfache Implementierung:
 * <p><blockquote><pre>
 *     Benchmark b = new Benchmark("MeinBenchmark").start();
 *     // do something protracted
 *     System.out.println(b.stop());
 * </pre></blockquote>
 * 
 * <p>Eine ausführlichere Implementierung:
 * <p><blockquote><pre>
 *     Benchmark b = new Benchmark();
 *     b.setName("MeineZeitmessung");
 *     // do anything
 *     b.start();
 *     // do something protracted
 *     b.stop();
 *     // do anything
 *     System.out.println(b);
 * </pre></blockquote>
 * 
 * <p>Zur Vermeidung von Nebeneffekten sind zwischen den Aufrufen von
 * <code>start()</code> und <code>stop()</code> keine anderen Methoden-Aufrufe
 * auf dem Objekt zulässig. Ausnahme: <code>{@link Benchmark#getStatus()}</code>
 * 
 * @author fmk
 */
public class Benchmark {

    /**
     * Der Name des Benchmark. Kann via Konstruktor gesetzt werden. Kann via
     * <code>setName()</code> gesetzt werden. Wird ansonsten auf den Standard
     * "Benchmark-n" gesetzt (n - lfd. des Benchmark-Objekts).
     */
    private String name;
    /**
     * Der Zeitstempel für den Start-Zeitpunkt. Wird mittels der Methode
     * <code>start()</code> gesetzt.
     */
    private long stampStart;
    /**
     * Der Zeitstempel für den End-Zeitpunkt. Wird mittels der Methode
     * <code>stop()</code> gesetzt.
     */
    private long stampStop;
    /**
     * Der Status des Benchmark. Jeder Benchmark durchläuft in der Regel die
     * Status in folgender Reihenfolge: 
     * <ol>
     * <li> <em>WAITING</em> (Konstruktion des Objekts)
     * <li> <em>RUNNING</em> (Aufruf von <code>start()</code>)
     * <li> <em>FINISHED</em> (Aufruf von <code>stop()</code>)
     * </ol>     
     * Der Status <em>EXCEPTION</em> wird gesetzt, sobald eine Exception
     * geworfen wird. In diesem Fall wird der Benchmark unbrauchbar.
     */
    private BenchmarkStatus status;
    /**
     * Zählt die erzeugten Benchmark-Objekte mit.
     */
    private static int counter;

    /**
     * Erzeugt einen Benchmark. Der Benchmark erhält einen Namen.
     *
     * @param name Der Name des Benchmark.
     */
    public Benchmark(String name) {
        this.name = name;
        this.status = BenchmarkStatus.WAITING;
        counter++;
    }

    /**
     * Erzeugt einen Benchmark. Es wird ein Standard-Name in der Form
     * "Benchmark-n" vergeben (n - lfd. Nr. des Benchmark-Objekts).
     */
    public Benchmark() {
        this("Benchmark-" + counter);
    }

    /**
     * Die zentrale Methode zur Erzeuguzng einer Exception. Der Status wird auf
     * <em>EXCEPTION</em> und die Zeitstempel werden auf 0 gesetzt. Damit wird
     * dieser Benchmark unbrauchbar. Anschließend wird die Exception geworfen.
     * 
     * @param text Der Text
     */
    private void throwBenchmarkException(String text) {
        this.status = BenchmarkStatus.EXCEPTION;
        this.stampStart = 0L;
        this.stampStop = 0L;
        throw new BenchmarkException(text + ": " + name);
    }
    
    /**
     * Die Zeitmessung beginnt.
     *
     * @return Dieses Benchmark-Objekt. Dadurch wird ein verketteter Aufruf mit
     * <code><b>new</b></code> möglich.
     * @throws BenchmarkException falls der Benchmark bereits gestartet wurde
     * oder schon beendet wurde.
     */
    public Benchmark start() {
        if (this.getStatus() != BenchmarkStatus.WAITING) {
            // start() ist nur aus dem Status WAITING zulässig
            throwBenchmarkException("Benchmark was no longer waiting");
        }
        this.status = BenchmarkStatus.RUNNING;
        this.stampStart = System.nanoTime();
        return this;
    }

    /**
     * Die Zeitmessug wird angehalten.
     *
     * @return Das Benchmark-Objekt als String. So kann die
     * <code>stop()</code>-Methode direkt auf der Konsole ausgegeben werden.
     * @throws BenchmarkException falls die Zeitmessung noch nicht begonnen
     * wurde oder bereits beendet ist.
     */
    public String stop() {
        // Zeitstempel merken, falls die Methode legal aufgerufen wurde
        long n = System.nanoTime();
        
        if (this.getStatus() != BenchmarkStatus.RUNNING) {
            // stop() ist nur aus dem Status RUNNING zulässig
            throwBenchmarkException("Benchmark was not running");
        }
        
        this.status = BenchmarkStatus.FINISHED;
        this.stampStop = n;
        return toString();
    }

    /**
     * Die Zeitdifferenz in Nanosekunden.
     *
     * @return Nanosekunden.
     * @throws BenchmarkException falls die Zeitmessung noch nicht mit
     * <code>{@link Benchmark#stop()}</code> abgeschlossen wurde.
     */
    public long getTimeInNanos() {
        if (this.getStatus() != BenchmarkStatus.FINISHED) {
            // ist noch nicht beendet
            throwBenchmarkException("Benchmark was not finished");
        }
        return stampStop - stampStart;
    }

    /**
     * Die Zeitdifferenz in Mikrosekunden.
     *
     * @return Mikrosekunden.
     * @throws BenchmarkException falls die Zeitmessung noch nicht mit
     * <code>{@link Benchmark#stop()}</code> abgeschlossen wurde.
     */
    public double getTimeInMicros() {
        return getTimeInNanos() / 1000.0;
    }

    /**
     * Die Zeitdifferenz in Millisekunden.
     *
     * @return Millisekunden.
     * @throws BenchmarkException falls die Zeitmessung noch nicht mit
     * <code>{@link Benchmark#stop()}</code> abgeschlossen wurde.
     */
    public double getTimeInMillis() {
        return getTimeInMicros() / 1000.0;
    }

    /**
     * Die Zeitdifferenz in Sekunden.
     *
     * @return Sekunden.
     * @throws BenchmarkException falls die Zeitmessung noch nicht mit
     * <code>{@link Benchmark#stop()}</code> abgeschlossen wurde.
     */
    public double getTimeInSeconds() {
        return getTimeInMillis() / 1000;
    }

    /**
     * Der Name des Benchmark.
     *
     * @return Der Name.
     * @throws BenchmarkException falls die Zeitmessung gerade läuft. Zur
     * Vermeidung von Nebeneffekten ist während des Laufs der Zeitmessung nur
     * der Aufruf von <code>{@link Benchmark#stop()}</code> zulässig.
     */
    public String getName() {
        if (this.getStatus() == BenchmarkStatus.RUNNING) {
            // Methodenaufruf nur zulässig, wenn nicht RUNNING
            throwBenchmarkException("Benchmark is running");
        }
        return name;
    }

    /**
     * @param name the name to set
     * @throws BenchmarkException falls die Zeitmessung gerade läuft. Zur
     * Vermeidung von Nebeneffekten ist während des Laufs der Zeitmessung nur
     * der Aufruf von <code>{@link Benchmark#stop()}</code> zulässig.
     */
    public void setName(String name) {
        if (this.getStatus() == BenchmarkStatus.RUNNING) {
            // Methodenaufruf nur zulässig, wenn nicht RUNNING
            throwBenchmarkException("Benchmark is running");
        }
        this.name = name;
    }

    /**
     * Das Benchmark-Objekt als String.
     *
     * @return ein String
     */
    @Override
    public String toString() {
        if (status == BenchmarkStatus.EXCEPTION) {
            return getName() + ": is invalid";
        }
        String unit = "nanos";
        double d = getTimeInNanos();
        if (d > 1000) {
            unit = "micros";
            d = getTimeInMicros();
            if (d > 1000) {
                unit = "millis";
                d = getTimeInMillis();
                if (d > 1000) {
                    unit = "sec";
                    d = getTimeInSeconds();
                }
            }
        }
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setGroupingUsed(true);
        nf.setMaximumFractionDigits(2);
        return getName() + ": " + nf.format(d) + " " + unit;
    }

    /**
     * Der Status des Benchmark.
     * 
     * <p>Jeder Benchmark durchläuft in der Regel die Status in folgender
     * Reihenfolge:
     * 
     * <ol>
     * <li> <em>WAITING</em> (durch die Konstruktion des Objekts)
     * <li> <em>RUNNING</em> (durch den Aufruf von <code>{@link Benchmark#start()}</code>)
     * <li> <em>FINISHED</em> (durch den Aufruf von <code>{@link Benchmark#stop()}</code>)
     * </ol>
     * 
     * <p>Der Status <em>EXCEPTION</em> wird gesetzt, sobald eine Exception
     * geworfen wird. In diesem Fall wird der Benchmark unbrauchbar.
     * 
     * @return the status
     */
    public BenchmarkStatus getStatus() {
        return status;
    }

    /**
     * @return the stampStart
     */
    public long getStart() {
        if (this.getStatus() != BenchmarkStatus.FINISHED) {
            // ist noch nicht beendet
            throwBenchmarkException("Benchmark was not finished");
        }
        return stampStart;
    }

    /**
     * @return the stampStop
     */
    public long getStop() {
        if (this.getStatus() != BenchmarkStatus.FINISHED) {
            // ist noch nicht beendet
            throwBenchmarkException("Benchmark was not finished");
        }
        return stampStop;
    }

}
