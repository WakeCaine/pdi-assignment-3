package com.example.main.timetolerance.Data;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class SavingData extends Application{

    static public List<String> getData(Context context){
        TinyDB tinydb = new TinyDB(context);
        return tinydb.getListString("MyData");
    }

    static public void PushListData(Context context, List<String> list){
        TinyDB tinydb = new TinyDB(context);
        tinydb.putListString("MyData", new ArrayList<String>(list));
    }
}
