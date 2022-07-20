package com.github.nmorel.gwtjackson.rest.api;

/**
 *
 */
public class RestException extends RuntimeException {

    private static final long serialVersionUID = 0L;

    private final int status;
    private final String statusText;
    private final String response;

    public RestException(int status, String statusText, String response) {
        this.status = status;
        this.statusText = statusText;
        this.response = response;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusText() {
        return statusText;
    }

    public String getResponse() {
        return response;
    }



    public static class GatewayTimeout extends RestException {
        public GatewayTimeout(String statusText, String response) {
            super(504, statusText, response);
        }
    }

    public static class ServiceUnavailable extends RestException {
        public ServiceUnavailable(String statusText, String response) {
            super(503, statusText, response);
        }
    }

    public static class BadGateway extends RestException {
        public BadGateway(String statusText, String response) {
            super(502, statusText, response);
        }
    }

    public static class NotImplemented extends RestException {
        public NotImplemented(String statusText, String response) {
            super(501, statusText, response);
        }
    }

    public static class InternalServerError extends RestException {
        public InternalServerError(String statusText, String response) {
            super(500, statusText, response);
        }
    }

    public static class UnprocessableEntity extends RestException {
        public UnprocessableEntity(String statusText, String response) {
            super(422, statusText, response);
        }
    }

    public static class TooManyRequests extends RestException {
        public TooManyRequests(String statusText, String response) {
            super(429, statusText, response);
        }
    }

    public static class UnsupportedMediaType extends RestException {
        public UnsupportedMediaType(String statusText, String response) {
            super(415, statusText, response);
        }
    }

    public static class Gone extends RestException {
        public Gone(String statusText, String response) {
            super(410, statusText, response);
        }
    }

    public static class Conflict extends RestException {
        public Conflict(String statusText, String response) {
            super(409, statusText, response);
        }
    }

    public static class NotAcceptable extends RestException {
        public NotAcceptable(String statusText, String response) {
            super(406, statusText, response);
        }
    }

    public static class MethodNotAllowed extends RestException {
        public MethodNotAllowed(String statusText, String response) {
            super(405, statusText, response);
        }
    }

    public static class NotFound extends RestException {
        public NotFound(String statusText, String response) {
            super(404, statusText, response);
        }
    }

    public static class Forbidden extends RestException {
        public Forbidden(String statusText, String response) {
            super(403, statusText, response);
        }
    }

    public static class Unauthorized extends RestException {
        public Unauthorized(String statusText, String response) {
            super(401, statusText, response);
        }
    }

    public static class BadRequest extends RestException {
        public BadRequest(String statusText, String response) {
            super(400, statusText, response);
        }
    }
}
