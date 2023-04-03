package com.example.clase3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.slider.Slider;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SeekBar sk1 = findViewById(R.id.seekBar);
        SeekBar sk2 = findViewById(R.id.seekBar2);

        TextView textView2 = findViewById(R.id.valorSeekBar2);
        textView2.setText(String.valueOf(0));

        sk1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int valor, boolean b) {
                TextView textView = findViewById(R.id.valorSeekBar1);
                textView.setText(String.valueOf(valor));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sk2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int valor, boolean b) {
                TextView textView = findViewById(R.id.valorSeekBar2);
                int valorFinal = valor - 20;
                textView.setText(String.valueOf(valorFinal));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Slider slider = findViewById(R.id.slider);
        slider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                TextView textView = findViewById(R.id.textViewSlider);
                textView.setText(String.valueOf(value));
            }
        });

        ((Button) findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spinner = findViewById(R.id.spinner);
                String nombre = (String) spinner.getSelectedItem();
                String texto = "nombre: " + nombre;
                Snackbar.make(view,texto,Snackbar.LENGTH_SHORT).show();

            }
        });

        String[] listaTelecos2 = {"Rafael","Yujun","Diego"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,listaTelecos2);
        //con arrays:
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.nombres_telecos));

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);


    }
}