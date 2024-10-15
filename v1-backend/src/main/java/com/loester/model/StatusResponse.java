package com.loester.model;

import java.util.Map;

public class StatusResponse {
    private String status;
    private String version;
    private Map<String, String> dependencies;

    public StatusResponse(String status, String version, Map<String, String> dependencies) {
        this.status = status;
        this.version = version;
        this.dependencies = dependencies;
    }

    public String getStatus() {
        return status;
    }

    public String getVersion() {
        return version;
    }

    public Map<String, String> getDependencies() {
        return dependencies;
    }
}
