package com.ua.valid_check.service;

import java.util.ArrayList;
import java.util.List;

public class Memory {
    private List<List> blacklistIP = new ArrayList<>();

    public void saveListOfIp(List list) {
        blacklistIP.add(list);
    }

}
