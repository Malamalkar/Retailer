package com.customerRetailer.model;

public class Response {

    private boolean success;
    private String message;
    private int points;

    public Response(boolean success, String message, int points) {
        this.success = success;
        this.message = message;
        this.points = points;
    }

    // Getters and setters (optional if using Lombok or a framework)
    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", points=" + points +
                '}';
    }
}
