package edu.temple.paletteactivity;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CanvasFragment extends Fragment {

    View l;
    TextView textView;
    int defaultColor = Color.WHITE;
    String defaultText = "White";


    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        l = inflater.inflate(R.layout.fragment_canvas, container, false);

        return l;
    }

    public void setColor(int selectedColor)
    {
        l.setBackgroundColor(selectedColor);
    }

    public void setColorText(String colorName)
    {
        textView = l.findViewById(R.id.textViewColor);
        textView.setText(colorName);
    }

}