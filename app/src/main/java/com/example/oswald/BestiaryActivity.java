package com.example.oswald;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.List;

public class BestiaryActivity extends AppCompatActivity
{
    public Monster[] monsters;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestiary);

        // TEST A MONSTER
        HashMap<Monster.enumSKILLS,Integer> skills = BestiaryUtils.generateSkills(1, 2,2,3);
        HashMap<Monster.enumSTATS,Integer> stats = BestiaryUtils.generateCounters(5,2);
        Monster m = new Monster(1, 1, stats, skills);
        m.name = "Tommy the Mobster";
        m.description = "fagz";
        monsters = new Monster[]{m};

        ArrayAdapter<Monster> arrayAdapter
                = new ArrayAdapter<Monster>(this, android.R.layout.simple_list_item_1 , monsters);

        ListView monster_list = (ListView) findViewById(R.id.monster_list);
        monster_list.setAdapter(arrayAdapter);

        monster_list.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id)
            {
                TextView tv = (TextView) view;
                if( tv != null) {
                    // TODO NPE BELOW
                    String monster_tag = (String) tv.getText();

                    Monster pickedMonster = getMonsterFromMonsterTag(monster_tag);
                    if (pickedMonster != null) {
                        // LOAD Monster Activity
                        Intent intent = new Intent(BestiaryActivity.this, CreatureCardActivity.class);
                        String bundle_monster = getResources().getString(R.string.bundle_monster);
                        intent.putExtra(bundle_monster, pickedMonster);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        } );
        // --------------------
    }//! OnCreate

    private Monster getMonsterFromMonsterTag(String iMonsterTag)
    {
        Monster retVal = null;
        for ( Monster m : monsters ) {
            if (iMonsterTag.equals(m.toString()))
            {retVal = m; break;}
        }
        return retVal;
    }
}
