package com.edgars.CarShare.enums;

public enum Gearbox {
    MANUAL("manual"),
    AUTOMATIC("automatic");

    private String gearbox;

    Gearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getGearbox() {
        return gearbox;
    }
}
