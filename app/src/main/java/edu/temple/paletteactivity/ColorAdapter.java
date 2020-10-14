package edu.temple.paletteactivity;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends BaseAdapter {

    Context context;
    ArrayList<Integer> colorsList;


    //constructor
    public ColorAdapter(Context context, ArrayList<Integer> colorsList){
        this.context = context;
        this.colorsList = colorsList;
    }

    @Override
    public int getCount() {
        return colorsList.size();
    }

    @Override
    public Object getItem(int position) {
        return colorsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView;
        Resources res = context.getResources();
        String[] colorNames = res.getStringArray(R.array.colors_array);


        if(convertView == null)
        {
            textView = new TextView(context);
        }
        else
        {
            textView = (TextView)convertView;
        }

        textView = new TextView(context);
        textView.setPadding(5,5,5,5);
        textView.setText(colorNames[position]);
        textView.setBackgroundColor(colorsList.get(position));


        return textView;
    }
}
