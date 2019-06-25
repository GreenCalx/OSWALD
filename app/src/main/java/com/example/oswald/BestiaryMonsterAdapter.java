package com.example.oswald;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;

public class BestiaryMonsterAdapter extends ArrayAdapter<Monster> {

    private final Context __context;
    private LinkedList<Monster> __monsters;

    public BestiaryMonsterAdapter(Context context, int resource, LinkedList<Monster> iMonsters) {
        super(context, resource, iMonsters);
        __context = context;
        __monsters = iMonsters;
    }

    @Override
    public View getView(int iPosition, View iConvertView, ViewGroup iParent)
    {
        if(iConvertView == null) {
            LayoutInflater inflater = (LayoutInflater) __context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            iConvertView = inflater.inflate(R.layout.simple_item, iParent, false);
        } else {
            iConvertView = (LinearLayout) iConvertView;
        }
        TextView viewTitle = (TextView) iConvertView.findViewById(R.id.title);
        viewTitle.setText(__monsters.get(iPosition).toString() );
        viewTitle.setTag( __monsters.get(iPosition).toString() );

        return iConvertView;
    }
}
