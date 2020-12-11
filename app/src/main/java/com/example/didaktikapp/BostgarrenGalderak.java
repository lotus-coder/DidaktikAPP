package com.example.didaktikapp;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class BostgarrenGalderak extends AppCompatActivity
{
    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private RadioGroup radioGroup4;
    private RadioGroup radioGroup5;
    private Button butItxi;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bostgarren_galderak);

        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radioGroup3 = (RadioGroup) findViewById(R.id.radioGroup3);
        radioGroup4 = (RadioGroup) findViewById(R.id.radioGroup4);
        radioGroup5 = (RadioGroup) findViewById(R.id.radioGroup5);
        butItxi = (Button) findViewById(R.id.butItxi);
        butItxi.setVisibility(View.INVISIBLE);
    }

    public void butBalidatuListener(View view)
    {
        int rg1ID = radioGroup1.getCheckedRadioButtonId();
        int rg2ID = radioGroup2.getCheckedRadioButtonId();
        int rg3ID = radioGroup3.getCheckedRadioButtonId();
        int rg4ID = radioGroup4.getCheckedRadioButtonId();
        int rg5ID = radioGroup5.getCheckedRadioButtonId();

        if( rg1ID != -1 &&
            rg2ID != -1 &&
            rg3ID != -1 &&
            rg3ID != -1 &&
            rg3ID != -1 )
        {
            RadioButton rbGaldera1Erantzuna = (RadioButton) findViewById(rg1ID);
            RadioButton rbGaldera2Erantzuna = (RadioButton) findViewById(rg2ID);
            RadioButton rbGaldera3Erantzuna = (RadioButton) findViewById(rg3ID);
            RadioButton rbGaldera4Erantzuna = (RadioButton) findViewById(rg4ID);
            RadioButton rbGaldera5Erantzuna = (RadioButton) findViewById(rg5ID);

            int indexRG1 = radioGroup1.indexOfChild(rbGaldera1Erantzuna);
            int indexRG2 = radioGroup2.indexOfChild(rbGaldera2Erantzuna);
            int indexRG3 = radioGroup3.indexOfChild(rbGaldera3Erantzuna);
            int indexRG4 = radioGroup4.indexOfChild(rbGaldera4Erantzuna);
            int indexRG5 = radioGroup5.indexOfChild(rbGaldera5Erantzuna);

            boolean estanBien = true;
            System.out.println("HOLA");
            if(indexRG1 == 1)
            {
                rbGaldera1Erantzuna.setTextColor(Color.GREEN);
                for (int child = 0; child < radioGroup1.getChildCount(); child++)
                {
                    if(child != indexRG1)
                        radioGroup1.getChildAt(child).setEnabled(false);
                }
            }
            else
            {
                rbGaldera1Erantzuna.setTextColor(Color.RED);
                rbGaldera1Erantzuna.setEnabled(false);
                estanBien = false;
            }

            if(indexRG2 == 0)
            {
                rbGaldera2Erantzuna.setTextColor(Color.GREEN);
                for (int child = 0; child < radioGroup2.getChildCount(); child++)
                {
                    if(child != indexRG2)
                        radioGroup2.getChildAt(child).setEnabled(false);
                }
            }
            else
            {
                rbGaldera2Erantzuna.setTextColor(Color.RED);
                rbGaldera2Erantzuna.setEnabled(false);
                estanBien = false;
            }

            if(indexRG3 == 2)
            {
                rbGaldera3Erantzuna.setTextColor(Color.GREEN);
                for (int child = 0; child < radioGroup3.getChildCount(); child++)
                {
                    if(child != indexRG3)
                        radioGroup3.getChildAt(child).setEnabled(false);
                }
            }
            else
            {
                rbGaldera3Erantzuna.setTextColor(Color.RED);
                rbGaldera3Erantzuna.setEnabled(false);
                estanBien = false;
            }

            if(indexRG4 == 0)
            {
                rbGaldera4Erantzuna.setTextColor(Color.GREEN);
                for (int child = 0; child < radioGroup4.getChildCount(); child++)
                {
                    if(child != indexRG4)
                        radioGroup4.getChildAt(child).setEnabled(false);
                }
            }
            else
            {
                rbGaldera4Erantzuna.setTextColor(Color.RED);
                rbGaldera4Erantzuna.setEnabled(false);
                estanBien = false;
            }

            if(indexRG5 == 2)
            {
                rbGaldera5Erantzuna.setTextColor(Color.GREEN);
                for (int child = 0; child < radioGroup5.getChildCount(); child++)
                {
                    if(child != indexRG5)
                        radioGroup5.getChildAt(child).setEnabled(false);
                }
            }
            else
            {
                rbGaldera5Erantzuna.setTextColor(Color.RED);
                rbGaldera5Erantzuna.setEnabled(false);
                estanBien = false;
            }

            if(estanBien == true)
            {
                //IMPLEMENTAR UN DIALOG QUE AVISE AL USUARIO DE QUE
                //NO HA COMETIDO ERRORES
                butItxi.setVisibility(View.VISIBLE);
            }
            else
            {
                //IMPLEMENTAR UN DIALOG QUE AVISE AL USUARIO DE QUE
                //HA COMETIDO ERRORES
            }
        }
        else
        {
            //IMPLEMENTAR UN DIALOG QUE AVISE AL USUARIO DE QUE NO
            //HA RESPONDIDO A TODAS LAS PREGUNTAS
        }
    }

    public void butItxiListener(View view)
    {
        finish();
    }
}