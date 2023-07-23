package com.ua.valid_check;


import java.io.*;
import java.util.*;


public class Main {

    private static final String BLOCKED_IPS_FILEPATH = "/home/timatam/coding/ValidChackApi/ValidCheck/src/main/resources/input.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("EnterIPaddressor 'quit' toexit");
        String inputIp = sc.next();

        while (inputIp.equals("quit")) {
            boolean isIpValid = isIpValid(inputIp);

            if (!isIpValid) {
                System.out.println("Invalid IP address");
                return;
            }

            Set<String> blockedIps = getBlockedIps();
            boolean isIpBlocked = blockedIps.contains(inputIp);
            if (isIpBlocked) {
                System.out.println("Accessdisallowed");
                return;
            }

            System.out.println("Accessallowed");
        }
    }

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

    public static Set<String> getBlockedIps() {

        Set<String> blockedIps = new HashSet<>();

        try (
                FileInputStream file = new FileInputStream(BLOCKED_IPS_FILEPATH);
                InputStreamReader inputStreamReader = new InputStreamReader(file);
                BufferedReader reader = new BufferedReader(inputStreamReader)
        ) {
            String line = reader.readLine();
            while (line != null) {
                blockedIps.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return blockedIps;
    }



}

