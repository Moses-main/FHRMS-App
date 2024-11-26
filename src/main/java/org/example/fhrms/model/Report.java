package org.example.fhrms.model;

import javafx.beans.property.SimpleStringProperty;

public class Report {
    private String reportId;
    private String reportType;
    private String dateGenerated;

    public Report(String reportId, String reportType, String dateGenerated) {
        this.reportId = reportId;
        this.reportType = reportType;
        this.dateGenerated = dateGenerated;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getDateGenerated() {
        return dateGenerated;
    }

    public void setDateGenerated(String dateGenerated) {
        this.dateGenerated = dateGenerated;
    }
}
