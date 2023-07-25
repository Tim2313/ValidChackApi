package com.ua.valid_check.service;

import java.util.ArrayList;
import java.util.List;

public class ValidationCheckService {

    public static boolean isIpValid(String ip) {

        // Must have 4 octets
        String[] splitIp = ip.split("\\.");
        if (splitIp.length != 4) {
            String messagePattern = "Input ip '%s' should consists of 4 octets!";
            String message = String.format(messagePattern, ip);
            System.out.println(message);
            return false;
        }

        // Only digits are allowed
        List<Integer> ipDigits = new ArrayList<>();
        for (String rawDigit : splitIp) {
            try {
                int digit = Integer.parseInt(rawDigit);
                ipDigits.add(digit);
            } catch (NumberFormatException ex) {
                String messagePattern = "Input '%s' is not a digit!";
                String message = String.format(messagePattern, rawDigit);
                System.out.println(message);
                return false;
            }
        }

        // A digit must be in range [0 - 255]
        for (int digit : ipDigits) {
            if (digit < 0 || digit > 255) {
                String messagePattern = "The digit '%d' is not in range [0 - 255]!";
                String message = String.format(messagePattern, digit);
                System.out.println(message);
                return false;
            }
        }

        return true;
    }
}
