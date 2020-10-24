package edu.temple.paletteactivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class PaletteFragment extends Fragment {

    View l;
    GridView gvColors;
    Context context;
    ArrayList<Integer> colorList;
    ItemClickedInterface parentActivity;
    String colorName;
    int selectedColor;

    public PaletteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof ItemClickedInterface)
        {
            parentActivity = (ItemClickedInterface) context;
        }
        else
            {
                throw new RuntimeException("must Implement ItemCLickedInterface");
            }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        l =  inflater.inflate(R.layout.fragment_palette, container, false);

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

        gvColors = l.findViewById(R.id.gvColors);
        gvColors.setNumColumns(3);

        gvColors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                selectedColor = colorList.get(position);
                colorName = ((TextView)view).getText().toString();

                parentActivity.itemClicked();
            }
        });

        context = l.getContext();
        ColorAdapter myAdapter = new ColorAdapter(context,colorList);
        gvColors.setAdapter(myAdapter);

        return l;
    }

    public int getColor()
    {
        return selectedColor;
    }

    public String getColorName()
    {
        return colorName;
    }

    interface ItemClickedInterface
    {
        void itemClicked();
    }

}