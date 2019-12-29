package com.sda.sylvester.bikecourier.validator;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class AddDeliveryValidator {

    public static boolean isInputValid(List<String> inputs) {
        for (String input : inputs) {
            if (!StringUtils.isAlphanumeric(input)) {
                return false;
            }
        }
        return true;
    }

}