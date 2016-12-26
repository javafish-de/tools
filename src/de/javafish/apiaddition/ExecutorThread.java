package de.javafish.apiaddition;

import java.util.concurrent.*;

public abstract class ExecutorThread extends Thread {
    
    private final BlockingQueue<Runnable> task;

    private boolean active;
    private boolean shutdown;

    public ExecutorThread() {
        task = new SynchronousQueue<>();
    }
    
    public boolean addTask(Runnable t) {
        if (shutdown) {
            throw new IllegalStateException("thread already shut down");
        }
        return task.offer(t);
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                Runnable r = getTask();
                if (r != null) {
                    activate();
                    r.run();
                    inactivate();
                } else {
                    break;
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            
            if (Thread.interrupted()) {
                break;
            }
        }
    }
    
    protected abstract Runnable getTask() throws InterruptedException;
    
    public void shutdown() {
        shutdown = true;
        if (!active) {
            interrupt();
        }
    }
    
    public boolean isActive() {
        return active;
    }

    private void activate() {
        this.active = true;
    }
    
    private void inactivate() {
        this.active = false;
    }
    
    public BlockingQueue<Runnable> getTasks() {
        return task;
    }

    public boolean isShutdown() {
        return shutdown;
    }
    
}
