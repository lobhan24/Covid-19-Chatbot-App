package com.example.covid_19_bvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    ImageButton button;
    Button moreinfo,view_symp,view_prec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //no action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        view_symp=(Button)findViewById(R.id.txtViewSymptoms) ;
        moreinfo=(Button)findViewById(R.id.btnKnowMore);
        view_prec=(Button)findViewById(R.id.txtViewPrecautions);
        //for click view of moreinfo
        moreinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.who.int/health-topics/coronavirus#tab=tab_1"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        //for click view of symptomps
        view_symp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.cdc.gov/coronavirus/2019-ncov/symptoms-testing/symptoms.html"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
       //for click view of precautions
        view_prec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.who.int/westernpacific/emergencies/covid-19/information/transmission-protective-measures"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView recyclerView1 = findViewById(R.id.recyclerViewPrecautions);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new HorizontalAdapter(new String[]{"Dry Cough", "Fever", "Head Ache","Sore Throat "}));

        recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView1.setAdapter(new HorizontalAdapter2(new String[]{"Hand Wash", "Stay Home", "Social Distance","Mask "}));

        button = findViewById(R.id.Chatbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openchatbotActivity2();
            }
        });
    }

    public void openchatbotActivity2() {
        Intent intent = new Intent(this, chatbotActivity2.class);
        startActivity(intent);
    }
}