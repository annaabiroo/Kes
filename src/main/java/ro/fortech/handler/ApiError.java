package ro.fortech.handler;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {

    private int status;
    private String error;
    private LocalDateTime timestamp;
    private String message;
    private List<String> errors;

    public ApiError(int status, String error, LocalDateTime timestamp, String message) {
        super();
        this.status = status;
        this.error = error;
        this.timestamp = timestamp;
        this.message = message;
    }

    public ApiError(int status, List<String> errors, LocalDateTime timestamp, String message) {
        super();
        this.status = status;
        this.errors = errors;
        this.timestamp = timestamp;
        this.message = message;
    }

    public ApiError() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "status=" + status +
                ", error='" + error + '\'' +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", errors=" + errors +
                '}';
    }
}
