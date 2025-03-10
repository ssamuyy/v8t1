package main.v8t1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText euroInput;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        euroInput = findViewById(R.id.EuroInput);
        resultText = findViewById(R.id.TextView);

    }

    public void transformToUSD(View view) {
        double dollars = Double.parseDouble(euroInput.getText().toString()) * 1.05;
        String amountUSD = String.format("$%.2f", dollars);

        resultText.setText(amountUSD);
    }

    public void transformToGBP(View view) {
        double pounds = Double.parseDouble(euroInput.getText().toString()) * 0.83;
        String amountGBP = String.format("£%.2f", pounds);

        resultText.setText(amountGBP);
    }
}