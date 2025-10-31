package com.pmm.a22;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

    TextView pantalla;

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
        pantalla=findViewById(R.id.pantalla);

    }


    public void operandClick(View view) {
        /**
         * Para los operandos he intentado hacerlo con un switch para mayor comodidad
         * pero no me dejaba poner los id's y lo he tenido que hacer con bucles if
         */

        if (calculado) clearClick(null);

        int operandButtonId= view.getId();
        System.out.println(operandButtonId);
        String operand="";

        if (operandButtonId==R.id.b0){operand="0";}
        else if (operandButtonId==R.id.b1){operand="1";}
        else if (operandButtonId==R.id.b2){operand="2";}
        else if (operandButtonId==R.id.b3){operand="3";}
        else if (operandButtonId==R.id.b4){operand="4";}
        else if (operandButtonId==R.id.b5){operand="5";}
        else if (operandButtonId==R.id.b6){operand="6";}
        else if (operandButtonId==R.id.b7){operand="7";}
        else if (operandButtonId==R.id.b8){operand="8";}
        else if (operandButtonId==R.id.b9){operand="9";}
        else if (operandButtonId==R.id.bSum){operand="+";}
        else if (operandButtonId==R.id.bRes){operand="-";}
        else if (operandButtonId==R.id.bMul){operand="X";}
        else if (operandButtonId==R.id.bDiv){operand="/";}

        // COMPLETAR COMO PARTE DEL EJERCICIO SELECCIONANDO EL OPERANDO

        _calculator.setOperand(operand);

        resultado+= operand;

        // COMPLETAR COMO PARTE DEL EJERCICIO ACTUALIZANDO LA PANTALLA DE LA CALCULADORA

        pantalla.setText(resultado);
    }

    public void operatorClick(View view) {

        int operatorButtonId= view.getId();
        System.out.println(operatorButtonId);
        Calculator.Operators operator= null;

        if (!_calculator.isNewOperation()) {
            if (operatorButtonId==R.id.bSum){
                operator=Calculator.Operators.ADD;
            }
            // COMPLETAR COMO PARTE DEL EJERCICIO EJECUTANDO EL CÁLCULO

            return;
        }



        // COMPLETAR COMO PARTE DEL EJERCICIO SELECCIONANDO EL OPERADOR

        _calculator.setOperator(operator);
        resultado+= operator;

        // COMPLETAR COMO PARTE DEL EJERCICIO ACTUALIZANDO LA PANTALLA DE LA CALCULADORA

        pantalla.setText(resultado);

    }

    public void clearClick(View view) {

        _calculator.clear();
        calculado= false;
        resultado= "";

        // COMPLETAR COMO PARTE DEL EJERCICIO ACTUALIZANDO LA PANTALLA DE LA CALCULADORA

        pantalla.setText(resultado);
    }

}