package com.example.oswald;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreatureCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monster_idcard);

        // GET MONSTER FROM BUNDLE
        String monster_bundle =  getString(R.string.bundle_monster);
        Monster monster = (Monster) getIntent().getExtras().getParcelable(monster_bundle);

        // EDIT ID CARD FIELDS
        if (monster!=null)
        {
            TextView tv_monsterName = (TextView) findViewById(R.id.monster_name);
            tv_monsterName.setText(monster.name);

            TextView tv_hp = (TextView) findViewById(R.id.text_hp);
            String str_hp = String.valueOf(monster.health);
            tv_hp.setText(str_hp);

            TextView tv_en = (TextView) findViewById(R.id.text_en);
            String str_en = String.valueOf(monster.energy);
            tv_en.setText(str_en);


        }

    }//! onCreate

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(CreatureCardActivity.this, BestiaryActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }//! onCreate
}
