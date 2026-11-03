package com.clebs.interfaces;

public interface Borrowable {

    void borrowItem();

    void returnItem();

    boolean isAvailable();
}