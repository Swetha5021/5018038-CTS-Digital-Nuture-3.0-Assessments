package com.swetha.BookStoreAPI.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {

    private final Counter bookCreationCounter;

    public MetricsService(MeterRegistry meterRegistry) {
        // Define a custom counter for book creation events
        this.bookCreationCounter = meterRegistry.counter("bookstore.books.created");
    }

    public void incrementBookCreationCounter() {
        this.bookCreationCounter.increment();
    }
}