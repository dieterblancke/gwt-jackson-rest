package com.github.nmorel.gwtjackson.rest.api;

import java.util.HashMap;
import java.util.Map;

public class RestExceptionTranslator {

    private static final Map<Integer, RestExceptionSupplier<? extends RestException>> EXCEPTION_MAPPINGS = new HashMap<>();

    private RestExceptionTranslator() {
    }

    public static <T extends RestException> void addStatusException(int statusCode, RestExceptionSupplier<T> restExceptionSupplier) {
        EXCEPTION_MAPPINGS.put(statusCode, restExceptionSupplier);
    }

    public static RestException createStatusException(int statusCode, String statusText, String responseText) {
        if (EXCEPTION_MAPPINGS.containsKey(statusCode)) {
            return EXCEPTION_MAPPINGS.get(statusCode).get(statusCode, statusText, responseText);
        }

        return new RestException(statusCode, statusText, responseText);
    }

    public interface RestExceptionSupplier<T extends RestException> {

        T get(int statusCode, String statusText, String responseText);

    }
}
