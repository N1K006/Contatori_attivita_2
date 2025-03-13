package com.example.contatori_attivit;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
{
    // Variabili per tenere traccia dei conteggi
    private int q_lavoro = 0;
    private int q_sport = 0;
    private int q_acqua_bevuta = 0;

    // TextView per visualizzare i conteggi
    private TextView txtQuantitàLavoro;
    private TextView txtQuantitàSport;
    private TextView txtQuantitàAcquaBevuta;

    // TextView per lo storico
    private TextView txtStoricoLavoro;
    private TextView txtStoricoSport;
    private TextView txtStoricoAcquaBevuta;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inizializzazione delle TextView per i conteggi
        txtQuantitàLavoro = findViewById(R.id.txt_quantità_lavoro);
        txtQuantitàSport = findViewById(R.id.txt_quantità_sport);
        txtQuantitàAcquaBevuta = findViewById(R.id.txt_quantità_acqua_bevuta);

        // Inizializzazione delle TextView per lo storico
        txtStoricoLavoro = findViewById(R.id.txt_storico_lavoro);
        txtStoricoSport = findViewById(R.id.txt_storico_sport);
        txtStoricoAcquaBevuta = findViewById(R.id.txt_storico_acqua_bevuta);

        /*// Inizializzazione dei bottoni
        Button bLavoroPiù = findViewById(R.id.b_lavoro_più);
        Button bLavoroMeno = findViewById(R.id.b_lavoro_meno);

        Button bSportPiù = findViewById(R.id.b_sport_più);
        Button bSportMeno = findViewById(R.id.b_sport_meno);

        Button bAcquaBevutaPiù = findViewById(R.id.b_acqua_bevuta_più);
        Button bAcquaBevutaMeno = findViewById(R.id.b_acqua_bevuta_meno);*/

    }

    public void b_lavoro(View v)
    {
        Button b = (Button) v;

        if (b.getText().equals("+"))
            q_lavoro++;
        else
        {
            if (q_lavoro > 0)
                q_lavoro--;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        txtQuantitàLavoro.setText("Quantità: " + q_lavoro);
        txtStoricoLavoro.setText(sdf.format(new Date()));
    }

    public void b_sport(View v)
    {
        Button b = (Button) v;

        if (b.getText().equals("+"))
            q_sport++;
        else
        {
            if (q_sport > 0)
                q_sport--;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        txtQuantitàSport.setText("Quantità: " + q_sport);
        txtStoricoSport.setText(sdf.format(new Date()));
    }

    public void b_acqua_bevuta(View v)
    {
        Button b = (Button) v;

        if (b.getText().equals("+"))
            q_acqua_bevuta++;
        else
        {
            if (q_acqua_bevuta > 0)
                q_acqua_bevuta--;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        txtQuantitàAcquaBevuta.setText("Quantità: " + q_acqua_bevuta);
        txtStoricoAcquaBevuta.setText(sdf.format(new Date()));
    }
}