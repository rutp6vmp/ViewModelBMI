package com.example.viewmodelbmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber , editTextNumber3;
    Button button;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 創建 ViewModel
        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        editTextNumber = findViewById(R.id.editTextNumber);

        editTextNumber3 = findViewById(R.id.editTextNumber3);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        button.setOnClickListener(view -> {
            double height = Double.parseDouble(editTextNumber.getText().toString());
            double weight = Double.parseDouble(editTextNumber3.getText().toString());
            viewModel.setHeight(height);
            viewModel.setWeight(weight);
            viewModel.calculateBmi();
            // 獲取 BMI 和分類
            double bmi = viewModel.getBmi();
            String category = viewModel.getBmiCategory();

            // 在 TextView 中顯示 BMI 和分類
            TextView textView = findViewById(R.id.textView);
            TextView textView2 = findViewById(R.id.textView2);
            textView.setText(String.format("BMI: %.2f ", bmi));
            textView2.setText(String.format("(%s)",category));

        });

        imageView.setOnClickListener(view -> {
            viewModel.reset();
            editTextNumber.setText("");
            editTextNumber3.setText("");
            TextView textView = findViewById(R.id.textView);
            TextView textView2 = findViewById(R.id.textView2);
            textView.setText("");
            textView2.setText("");
        });

    }
}