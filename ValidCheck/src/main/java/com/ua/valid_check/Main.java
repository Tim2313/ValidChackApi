package com.ua.valid_check;


import com.ua.valid_check.service.ProgrammResponceService;
import com.ua.valid_check.service.RecieveBlockedIpService;
import com.ua.valid_check.service.ValidationCheckService;

import java.io.*;
import java.nio.file.*;
import java.util.*;


public class Main {

    public static final String BLOCKED_IPS_FILEPATH = "/home/timatam/coding/ValidChackApi/ValidCheck/src/main/resources/input.txt";

    public static void main(String[] args) {

        ProgrammResponceService.validationApi();

    }

}

