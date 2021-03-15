package com.example.changecolor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    private Spinner sLang;
    private Spinner sColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);


        initViews();

    }

    @Override
    public void onClick(View v) {
        if ( sColor.getSelectedItem().toString().equals("Black")) {
            Utils.changeToTheme(this, Utils.THEME_BLACK);
        } else if (sColor.getSelectedItem().toString().equals("Blue")) {

            Utils.changeToTheme(this, Utils.THEME_BLUE);
        } else if (sColor.getSelectedItem().toString().equals("Green")) {

            Utils.changeToTheme(this, Utils.THEME_GREEN);
        }
        String englishItem = "eng";
        String russianItem = "ru";
        if (sLang.getSelectedItem().toString().equals(englishItem)) {
            changeLocale(englishItem);
        } else if (sLang.getSelectedItem().toString().equals(russianItem)) {
            changeLocale(russianItem);
        }
    }

    private void initViews(){
        sLang = findViewById(R.id.spinner);
        sColor = findViewById(R.id.spinner_color);

        initSpinnerLeng();
        initSpinnerColor();
    }
    private void initSpinnerLeng(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lang, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sLang.setAdapter(adapter);
    }
    private void initSpinnerColor(){
        ArrayAdapter<CharSequence> adapterColor = ArrayAdapter.createFromResource(this, R.array.colorName, android.R.layout.simple_spinner_item);
        adapterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sColor.setAdapter(adapterColor);
    }
    @SuppressWarnings("deprecation")
    private void changeLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getBaseContext().getResources()
                .updateConfiguration(configuration,
                        getBaseContext()
                                .getResources()
                                .getDisplayMetrics());
        setTitle(R.string.app_name);

        TextView txt = findViewById(R.id.text_view);
        txt.setText(R.string.txt);
    }

}

