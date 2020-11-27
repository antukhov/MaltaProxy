package com.malta.proxy;

/**
 * The interface Cache queue processor.
 */
public interface CacheQueueProcessor {

    /**
     * Process method triggered every time new request added to the queue
     */
    void process();

}
