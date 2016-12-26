package de.javafish.apiaddition;

import java.util.concurrent.*;

public class CachedThread extends ExecutorThread {

    @Override
    protected Runnable getTask() throws InterruptedException {
        return getTasks().poll(1, TimeUnit.MINUTES);
    }
    
}
