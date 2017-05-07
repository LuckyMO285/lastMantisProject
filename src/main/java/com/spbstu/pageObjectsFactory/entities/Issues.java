package com.spbstu.pageObjectsFactory.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by luck on 16.04.17.
 */

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Issues {

    String category;
    String reproducibility;
    String severity;
    String priority;
    String platform;
    String OS;
    String OSVersion;
    String order;
    String summary;
    String description;
    String stepsToReproduce;
    String additionalInfo;

    public String getCategory() {
        return category;
    }

    public String getReproducibility() {
        return reproducibility;
    }

    public String getSeverity() {
        return severity;
    }

    public String getPriority() {
        return priority;
    }

    public String getPlatform() {
        return platform;
    }

    public String getOS() {
        return OS;
    }

    public String getOSVersion() {
        return OSVersion;
    }

    public String getOrder() {
        return order;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public String getStepsToReproduce() {
        return stepsToReproduce;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

}
