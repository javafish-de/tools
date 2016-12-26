package de.javafish.apiaddition;

public class PooledThread extends ExecutorThread {

    @Override
    protected Runnable getTask() throws InterruptedException {
        return getTasks().take();
    }
    
}
