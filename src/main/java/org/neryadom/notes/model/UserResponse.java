package org.neryadom.notes.model;

import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
public class UserResponse {
    private HttpStatusCode httpStatusCode;
    private String responseMessage;

    public UserResponse(){}

    public UserResponse(HttpStatusCode statusCode) {
        this.httpStatusCode = statusCode;
    }

    public UserResponse(HttpStatusCode statusCode, String responseMessage) {
        this.httpStatusCode = statusCode;
        this.responseMessage = responseMessage;
    }
}
