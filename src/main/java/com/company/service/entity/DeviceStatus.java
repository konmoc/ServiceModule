package com.company.service.entity;

/**
 Simple statuses for devices:
 UP_AND_RUNNING - when everything's ok
 BROKEN - when the device is broken
 BEING_REPAIRED - when the device is broken and serviceman is assigned
 */
public enum  DeviceStatus {
    BEING_REPAIRED, BROKEN, UP_AND_RUNNING
}
