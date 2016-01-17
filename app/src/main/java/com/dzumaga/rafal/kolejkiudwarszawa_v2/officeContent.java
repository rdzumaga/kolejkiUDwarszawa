package com.dzumaga.rafal.kolejkiudwarszawa_v2;

import java.util.LinkedHashMap;


/**
 * Created by Rafal on 2016-01-13.
 */
public class officeContent {

    public static LinkedHashMap<String,String> officeList = new LinkedHashMap<>();

    static {
    officeList.put("USC Andersa","https://api.um.warszawa.pl/api/action/wsstore_get?id=5d2e698a-9c31-456b-8452-7ce33e7deb94");
    officeList.put("USC Falęcka","https://api.um.warszawa.pl/api/action/wsstore_get?id=ef5df1a7-882e-4cc5-815b-78768e985724");
    };
}

