package com.ua.valid_check.service;

import java.util.Scanner;
import java.util.Set;

public class ProgrammResponceService {

    public static void validationApi() {

        Scanner sc = new Scanner(System.in);

        System.out.println("EnterIPaddressor 'quit' toexit");
        String inputIp = sc.next();

        while (!inputIp.equals("quit")) {
            boolean isIpValid = ValidationCheckService.isIpValid(inputIp);

            if (!isIpValid) {
                System.out.println("Invalid IP address");
                return;
            }

            Set<String> blockedIps = RecieveBlockedIpService.getBlockedIps();
            boolean isIpBlocked = blockedIps.contains(inputIp);
            if (isIpBlocked) {
                System.out.println("Accessdisallowed");
                return;
            }

            System.out.println("Accessallowed");
        }
    }
}
