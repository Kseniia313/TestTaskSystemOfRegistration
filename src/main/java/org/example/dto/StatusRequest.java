package org.example.entity;

public enum StatusApplication {
    DRAFT("DRAFT"),
    SENT("SENT"),
    ACCEPTED("ACCEPTED"),
    REJECTED("REJECTED");
    private final String statusApp;

    StatusApplication(String statusApp) {
        this.statusApp = statusApp;
    }

    public String getStatusApp() {
        return statusApp;
    }

}
