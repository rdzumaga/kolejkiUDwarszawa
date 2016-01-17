package com.dzumaga.rafal.kolejkiudwarszawa_v2;

/**
 * Created by Rafal on 2016-01-13.
 */

public class queueDetails{

    public  queueDetails(String _name, String _code)
    {
        this.name = _name;
        this.code = _code;
    }

    String status;
    int avgTime;
    int lp;
    int groupId;
    int openedDesks;
    String name;
    String code;
    int waitingCount;
    int currentlyServed;

}
