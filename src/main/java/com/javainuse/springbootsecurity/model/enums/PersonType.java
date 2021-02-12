package com.javainuse.springbootsecurity.model.enums;

public enum PersonType {

    SUPPLIER, BROCKER, CLIENT;

    public static boolean isValid(String userType) {

        for (PersonType type : PersonType.values()) {
            if (userType.equals(type.name())) {
                return true;
            }
        }
        return false;
    }
}
