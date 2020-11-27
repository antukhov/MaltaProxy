package com.malta.proxy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Cache queue single-thread processor.
 * This implementation of sequential cache queue processor: 1 thread
 */
public class CacheQueueSingleThreadWorker implements CacheQueueProcessor {

    private static final CacheQueueSingleThreadWorker INSTANCE;
    private static final Logger LOGGER;
    // indicator if worker currently in progress
    static final AtomicBoolean inProgress;
    static ExecutorService executorService;
    CacheQueue cacheQueue;

    private CacheQueueSingleThreadWorker() {
        cacheQueue = CacheQueue.getInstance();
    }

    public static CacheQueueSingleThreadWorker getInstance() {
        return INSTANCE;
    }

    static {
        INSTANCE = new CacheQueueSingleThreadWorker();
        LOGGER = Logger.getLogger(CacheQueueSingleThreadWorker.class.getName());
        LOGGER.setLevel(Level.INFO);
        executorService = Executors.newSingleThreadExecutor();
        inProgress = new AtomicBoolean(false);
    }

    @Override
    public void process() {
        if (!inProgress.get() && cacheQueue.getCounter().get() > 0) {
            executorService.submit(this::run);
        }
    }

    private void run() {
        inProgress.set(true);
        while (cacheQueue.getCounter().get() > 0) {
            LOGGER.log(Level.INFO, "Processing {0} ", cacheQueue.poll());
        }
        inProgress.set(false);
    }
}
