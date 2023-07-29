package com.ua.valid_check;


import com.ua.valid_check.service.RecieveBlockedIpService;
import com.ua.valid_check.service.ValidationCheckService;

import java.nio.file.Path;
import java.util.Scanner;
import java.util.Set;


public class Main {

    public static final String BLOCKED_IPS_FILEPATH = "/home/timatam/coding/ValidChackApi/ValidCheck/src/main/resources/input.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("EnterIPaddressor 'quit' toexit");
        String inputIp = sc.next();

        while (!inputIp.equals("quit")) {

            boolean isIpValid = ValidationCheckService.isIpValid(inputIp);

            if (!isIpValid) {
                System.out.println("Invalid IP address");
            } else {
                Set<String> blockedIps = RecieveBlockedIpService.getBlockedIps();
                boolean isIpBlocked = blockedIps.contains(inputIp);
                if (isIpBlocked) {
                    System.out.println("Accessdisallowed");
                } else {
                    System.out.println("Accessallowed");
                }
            }
            inputIp = sc.next();

        }
    }

}

