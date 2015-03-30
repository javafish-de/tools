package de.javafish.helper;

/**
 * Der Status eines Benchmark-Objekts.
 * 
 * @author fmk
 */
public enum BenchmarkStatus {

    /**
     * Das Benchmark-Objekt wurde erzeugt, aber noch nicht gestartet.
     */
    WAITING,
    /**
     * Das Benchmark-Objekt wurde gestartet, aber noch nicht gestoppt.
     */
    RUNNING,
    /**
     * Das Benchmark-Objekt wurde gestoppt.
     */
    FINISHED,
    /**
     * Bei der Ausführung des Benchmarks ist ein Fehler aufgetreten.
     */
    EXCEPTION,;
}
