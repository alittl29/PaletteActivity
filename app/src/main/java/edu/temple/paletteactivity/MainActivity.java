package edu.temple.paletteactivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PaletteFragment.ItemClickedInterface {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    PaletteFragment paletteFragment;
    CanvasFragment canvasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paletteFragment = new PaletteFragment();
        canvasFragment = new CanvasFragment();

        FragmentManager fragmentManager =  getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(!(getSupportFragmentManager().findFragmentById(R.id.container_1) instanceof PaletteFragment))
        {
            fragmentTransaction.add(R.id.container_1,paletteFragment);
        }
        if(!(getSupportFragmentManager().findFragmentById(R.id.container_2) instanceof CanvasFragment))
        {
            fragmentTransaction.add(R.id.container_2,canvasFragment);
        }


        fragmentTransaction.commit();


    }

    @Override
    public void itemClicked() {

        int selectedColor =  paletteFragment.getColor();
        String colorName = paletteFragment.getColorName();

        canvasFragment.setColor(selectedColor);
        canvasFragment.setColorText(colorName);


    }
}