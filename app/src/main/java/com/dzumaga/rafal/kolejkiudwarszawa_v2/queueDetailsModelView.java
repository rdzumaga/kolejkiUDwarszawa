package com.dzumaga.rafal.kolejkiudwarszawa_v2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafal on 2016-01-17.
 */
public class queueDetailsModelView {

    String updateDate;
    String updateTime;

    List<queueDetails> queueDetailsArrayList;

    queueDetailsModelView()
    {
        queueDetailsArrayList = new ArrayList<>();
    }

    static queueDetailsModelView getExample() {
        queueDetailsModelView exVal = new queueDetailsModelView();
        exVal.updateTime = "37";
        exVal.updateDate = "13";

        queueDetails obj = new queueDetails("test1", "test2");
        exVal.queueDetailsArrayList.add(obj);

        return exVal;
    }
}
