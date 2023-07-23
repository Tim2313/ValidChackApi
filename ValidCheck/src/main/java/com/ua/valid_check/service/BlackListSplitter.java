package com.ua.valid_check.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BlackListSplitter {


    public static void Splitter() throws FileNotFoundException {
        FileInputStream file = new FileInputStream("/home/timatam/coding/ValidChackApi/ValidCheck/src/main/resources/blacklistIp.txt");
        List<String> list = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(list);
    }

}
