package com.example.tictac;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    TextView writeF;
    Button secondB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeF = (TextView) findViewById(R.id.choosedText);
        secondB = (Button) findViewById(R.id.secondView);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        secondB.setOnClickListener(v -> goSecondPage());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu
        getMenuInflater().inflate(R.menu.menu_example, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle clicks
        if (item.getTitle() != null) {
            getClickedItem(item.getTitle().toString());
        }
        return super.onOptionsItemSelected(item);

    }

    private void getClickedItem(String it) {
        if (it != null) {
            writeF.setText(it);
            secondB.setText("Go ".concat(it));
        }
    }

    private void goSecondPage() {
        Intent intent = null;
        String[] content = secondB.getText().toString().split(" ");
        String fruitName = content[content.length - 1];

        switch (fruitName) {
            case "Apple":
                intent = new Intent(this, Apple.class);
                intent.putExtra("fruits_name","Apple");
                break;
            case "Banana":
                intent = new Intent(this, Banna.class);
                intent.putExtra("fruits_name","Banana");
                break;
            case "Guava":
                intent = new Intent(this, Guava.class);
                intent.putExtra("fruits_name","Guava");
                break;
            default:
                Log.d("SelectedFruit", "No activity for: " + fruitName);
        }

        if (intent != null) {
            startActivity(intent);
        }

    }
}
