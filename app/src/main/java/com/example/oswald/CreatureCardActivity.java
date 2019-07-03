package com.example.oswald;

import android.content.Intent;
import android.os.Bundle;
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

            TextView tv_save = (TextView) findViewById(R.id.text_save);
            String str_save = String.valueOf(monster.save);
            tv_save.setText(str_save);

            TextView tv_fd = (TextView) findViewById(R.id.text_fd);
            String str_fd = String.valueOf(monster.FD);
            tv_fd.setText(str_fd);

            TextView tv_lvl = (TextView) findViewById(R.id.text_lvl);
            String str_lvl = String.valueOf(monster.LVL);
            tv_lvl.setText(str_lvl);
            // -------------------------------------------------------
            // SKILLS VALUES
            TextView tv_combat = (TextView) findViewById(R.id.text_combatvalue);
            String str_combat = String.valueOf(monster.getCombatScore());
            tv_combat.setText(str_combat);

            TextView tv_mystical = (TextView) findViewById(R.id.text_mysticalvalue);
            String str_mystical = String.valueOf(monster.getMysticalScore());
            tv_mystical.setText(str_mystical);

            TextView tv_subterfuge = (TextView) findViewById(R.id.text_subterfugevalue);
            String str_subterfuge = String.valueOf(monster.getSubterfugeScore());
            tv_subterfuge.setText(str_subterfuge);

            TextView tv_trickery = (TextView) findViewById(R.id.text_trickeryalue);
            String str_trickery = String.valueOf(monster.getTrickeryScore());
            tv_trickery.setText(str_trickery);

            // -------------------------------------------------------

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
