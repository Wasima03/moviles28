package com.pmm.a22;

import static com.pmm.a22.R.*;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.pmm.a22.calculator.Calculator;

public class MainActivity extends AppCompatActivity {

    private final Calculator _calculator= new Calculator();

    private String resultado= "";
    private boolean calculado= false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }


    public void operandClick(View view) {

        if (calculado) clearClick(null);

        int operandButtonId= view.getId();
        System.out.println(operandButtonId);
        String operand="";


        // COMPLETAR COMO PARTE DEL EJERCICIO SELECCIONANDO EL OPERANDO

        _calculator.setOperand(operand);

        resultado+= operand;

        // COMPLETAR COMO PARTE DEL EJERCICIO ACTUALIZANDO LA PANTALLA DE LA CALCULADORA

    }

    public void operatorClick(View view) {

        int operatorButtonId= view.getId();
        System.out.println(operatorButtonId);
        Calculator.Operators operator= null;

        if (!_calculator.isNewOperation()) {

            // COMPLETAR COMO PARTE DEL EJERCICIO EJECUTANDO EL CÁLCULO

            return;
        }

        // COMPLETAR COMO PARTE DEL EJERCICIO SELECCIONANDO EL OPERADOR

        _calculator.setOperator(operator);
        resultado+= operator;

        // COMPLETAR COMO PARTE DEL EJERCICIO ACTUALIZANDO LA PANTALLA DE LA CALCULADORA

    }

    public void clearClick(View view) {

        _calculator.clear();
        calculado= false;
        resultado= "";

        // COMPLETAR COMO PARTE DEL EJERCICIO ACTUALIZANDO LA PANTALLA DE LA CALCULADORA
    }

}