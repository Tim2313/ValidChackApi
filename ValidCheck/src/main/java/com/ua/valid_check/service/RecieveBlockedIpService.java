package com.ua.valid_check.service;

import com.ua.valid_check.Main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class RecieveBlockedIpService {

    public static Set<String> getBlockedIps() {

        Set<String> blockedIps = new HashSet<>();

        try (
                FileInputStream file = new FileInputStream(Main.BLOCKED_IPS_FILEPATH);
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
