package com.example.agri;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class retail extends AppCompatActivity {


    ListView l;
    String tutorials[]
            = { "RAJU - +918317486556 (MANDYA)", "HEMA - +919448228546 (THIRTHALLI)",
            "BASAPPA - +9480184924 (TUMKUR)", "CHIRU - +919538325995 (HUBLI)",
            "JAGADISH - +919638325995 (SIRSI)", "LAKSHMI - +919583895995 (BENGALURU)",
            "KALYAN - +919538467995 (KANAKAPURA)", "VIDYAMMA - +919448325995 (DABASPETE)",
            "SHARDA - +919538323455 (MYSORE)","JAGA- +919638325995 (SIRSI)", "SRILAKSHMI - +919583895995 (BENGALURU)",
            "KALYAN - +919538467995 (KANAKAPURA)", "VIDYSHREE - +919448325995 (DABASPETE)",
            "SHARDAAMMA - +919538323455 (MYSORE)" };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retail);
        l = findViewById(R.id.list);
        l.setBackgroundColor(Color.LTGRAY);

        ArrayAdapter<String> arr;
        arr
                = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                tutorials);
        l.setAdapter(arr);
    }
}
