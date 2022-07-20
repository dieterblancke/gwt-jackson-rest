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
}
