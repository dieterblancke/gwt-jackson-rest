package com.github.nmorel.gwtjackson.rest.api;

import com.github.nmorel.gwtjackson.rest.api.RestException.*;

import java.util.HashMap;
import java.util.Map;

public class RestExceptionTranslator {

    private static final Map<Integer, RestExceptionSupplier<? extends RestException>> EXCEPTION_MAPPINGS = new HashMap<>();

    static {
        addStatusException(400, BadRequest::new);
        addStatusException(401, Unauthorized::new);
        addStatusException(403, Forbidden::new);
        addStatusException(404, NotFound::new);
        addStatusException(405, MethodNotAllowed::new);
        addStatusException(406, NotAcceptable::new);
        addStatusException(409, Conflict::new);
        addStatusException(410, Gone::new);
        addStatusException(415, UnsupportedMediaType::new);
        addStatusException(422, UnprocessableEntity::new);
        addStatusException(429, TooManyRequests::new);
        addStatusException(415, UnsupportedMediaType::new);
        addStatusException(500, InternalServerError::new);
        addStatusException(501, NotImplemented::new);
        addStatusException(502, BadGateway::new);
        addStatusException(503, ServiceUnavailable::new);
        addStatusException(504, GatewayTimeout::new);
    }

    private RestExceptionTranslator() {
    }

    public static <T extends RestException> void addStatusException(int statusCode, RestExceptionSupplier<T> restExceptionSupplier) {
        EXCEPTION_MAPPINGS.put(statusCode, restExceptionSupplier);
    }

    public static RestException createStatusException(int statusCode, String statusText, String responseText) {
        if (EXCEPTION_MAPPINGS.containsKey(statusCode)) {
            return EXCEPTION_MAPPINGS.get(statusCode).get(statusText, responseText);
        }

        return new RestException(statusCode, statusText, responseText);
    }

    public interface RestExceptionSupplier<T extends RestException> {

        T get(String statusText, String responseText);

    }
}
