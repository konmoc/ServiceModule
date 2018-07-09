package com.company.service.entity;

import lombok.Data;

import javax.persistence.Entity;

/**
    Different categories for devices
    Might be useful when worker decides what kind of device is he adding
 */

public enum DeviceType {
    PERSONAL_COMPUTER, FRIDGE, SMARTPHONE
}
