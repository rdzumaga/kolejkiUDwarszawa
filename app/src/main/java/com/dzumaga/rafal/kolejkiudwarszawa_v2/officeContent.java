package com.dzumaga.rafal.kolejkiudwarszawa_v2;

import java.util.ArrayList;
import java.util.LinkedHashMap;


/**
 * Created by Rafal on 2016-01-13.
 */
public class officeContent {

    public static LinkedHashMap<String,String> officeList = new LinkedHashMap<>();
    public static ArrayList<Integer> imageIds = new ArrayList();
    public static ArrayList<String> addressList = new ArrayList<>();

    static {
        officeList.put("USC Śródmieście", "https://api.um.warszawa.pl/api/action/wsstore_get?id=5d2e698a-9c31-456b-8452-7ce33e7deb94");
        officeList.put("USC Mokotów", "https://api.um.warszawa.pl/api/action/wsstore_get?id=ef5df1a7-882e-4cc5-815b-78768e985724");
        officeList.put("UD Białołęka","https://api.um.warszawa.pl/api/action/wsstore_get?id=95fee469-79db-4b4b-9ddc-91d49d1f0f51");
        officeList.put("UD Bielany","https://api.um.warszawa.pl/api/action/wsstore_get?id=9c3d5770-57d8-4365-994c-69c5ac4186ee");
        officeList.put("UD Ochota","https://api.um.warszawa.pl/api/action/wsstore_get?id=624d7e2a-bf45-48d6-ba79-8b512e662d1c");
        officeList.put("UD Wola","https://api.um.warszawa.pl/api/action/wsstore_get?id=7ef70889-4eb9-4301-a970-92287db23052");
        officeList.put("UD Żoliborz", "https://api.um.warszawa.pl/api/action/wsstore_get?id=831ef31a-b2a3-4cbb-aaa5-cb90fe05ad8c");
    }

    static {
        imageIds.add(R.drawable.usc_andersa);
        imageIds.add(R.drawable.usc_falecka);
        imageIds.add(R.drawable.ud_bialoleka);
        imageIds.add(R.drawable.ud_bielany);
        imageIds.add(R.drawable.ud_ochota);
        imageIds.add(R.drawable.ud_wola);
        imageIds.add(R.drawable.ud_zoliborz);
    }

    static {
        addressList.add("Urząd Stanu Cywilnego Warszawa-Śródmieście, Generała Władysława Andersa 5, Warszawa");
        addressList.add("Urząd Stanu Cywilnego Warszawa-Mokotów, Falęcka 10, Warszawa");
        addressList.add("Urząd Dzielnicy Białołęka, Modlińska 197, 03-180 Warszawa");
        addressList.add("Urząd Dzielnicy Bielany m.st. Warszawy, Stefana Żeromskiego 29, Warszawa");
        addressList.add("Urząd Dzielnicy Ochota m. st. Warszawy, Grójecka 17a, Warszawa");
        addressList.add("Urząd Dzielnicy Wola m. st. Warszawy, aleja Solidarności, Warszawa");
        addressList.add("Urząd Dzielnicy Żoliborz m. st. Warszawy, Juliusza Słowackiego 6/8, Warszawa");

    }
}

