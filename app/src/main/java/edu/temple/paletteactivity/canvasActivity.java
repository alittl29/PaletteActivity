package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class canvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        //set the title for the activity
        setTitle(getString(R.string.canvasActivity));
        //
       View thisActivity = findViewById(R.id.activityCanvas);
       TextView textView = findViewById(R.id.textView);

        //get the bundle sent from the initial activity
        Bundle bundle = getIntent().getExtras();

        //store the data from the bundle
        ArrayList<Integer> colorsList = bundle.getIntegerArrayList("ArrayList");
        String colorName = bundle.getString("colorName");
        int selectedColor = bundle.getInt("selectedColor");

        //set the properties of the page with the stored values
        thisActivity.setBackgroundColor(colorsList.get(selectedColor));
        textView.setText(colorName);
    }
}