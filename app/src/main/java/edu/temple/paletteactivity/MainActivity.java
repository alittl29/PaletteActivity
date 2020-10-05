package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gvColors;
    ArrayList<Integer> colorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        colorList = new ArrayList<Integer>();
        colorList.add(Color.BLACK);
        colorList.add(Color.WHITE);
        colorList.add(Color.RED);
        colorList.add(Color.BLUE);
        colorList.add(Color.YELLOW);
        colorList.add(Color.GREEN);
        colorList.add(Color.GRAY);
        colorList.add(Color.rgb(255, 182,193));
        colorList.add(Color.rgb(255,165,0));

        gvColors = findViewById(R.id.gvPaletteActivity);
        gvColors.setNumColumns(3);


        ColorAdapter myAdapter = new ColorAdapter(this, colorList);
        gvColors.setAdapter(myAdapter);


        //set the on click methods for the columns
        gvColors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //create a bundle with all the stuff needed
                //array list for the background color
                //int for the position
                //string for the name
                Bundle bundle = new Bundle();
                bundle.putIntegerArrayList("ArrayList",colorList);
                bundle.putInt("selectedColor", position);
                bundle.putString("colorName",((TextView)view).getText().toString());

                Intent secondActivity = new Intent(MainActivity.this, canvasActivity.class);
                secondActivity.putExtras(bundle);

                //start the activity with the bundle
                startActivity(secondActivity);
            }
        });

    }
}