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

    public queueDetails()
    {}


    String status;
    String avgTime;
    String lp;
    String groupId;
    String openedDesks;
    String name;
    String code;
    String waitingCount;
    String currentlyServed;

}
