package com.example.oswald;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ToolPickerActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_picker);

        // INITIALIZE TOOLS BUTTONS
        Button button_bestiary = (Button) findViewById(R.id.button_bestiary);
        if ( button_bestiary != null )
        {
            button_bestiary.setOnClickListener
                    (
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(ToolPickerActivity.this, BestiaryActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }

                    );
        }

        Button button_rules = (Button) findViewById(R.id.button_rules);
        if ( button_rules != null )
        {
            button_rules.setOnClickListener
                    (
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(ToolPickerActivity.this, PDFReaderActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }

                    );
        }

        Button button_player = (Button) findViewById(R.id.button_player);
        if ( button_player != null )
        {
            button_player.setOnClickListener
                    (
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(ToolPickerActivity.this, PlayerActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }

                    );
        }

    }//! onCreate()

}

