package com.frosquivel.magicrequiredfields;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.frosquivel.magicalrequiredfields.MagicalRequiredFields;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Spinner spinner;
    RadioButton radio1;
    RadioButton radio2;
    CheckBox checkBox1;
    CheckBox checkBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinnerTest);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        editText = (EditText) findViewById(R.id.editTest);
        radio1 = (RadioButton) findViewById(R.id.radio1);
        radio2 = (RadioButton) findViewById(R.id.radio2);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);

        Button btnRequired = (Button) findViewById(R.id.btnRequired);
        Button btnRequiredAll = (Button) findViewById(R.id.btnRequiredAll);
        Button btnRequiredRadioCheck = (Button) findViewById(R.id.btnRequiredRadioCheck);


        btnRequired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<View> listObj = new ArrayList<View>();
                listObj.add(editText);
                listObj.add(spinner);

                Boolean validateFields =
                        MagicalRequiredFields.validateReq(listObj,"This is an required field");

                if(validateFields){
                    Toast.makeText(getApplicationContext(), "You passed the test", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "You don't passed the test", Toast.LENGTH_SHORT).show();
                }

            }
        });






        btnRequiredAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<View> listObj = new ArrayList<View>();
                listObj.add(editText);
                listObj.add(spinner);

                List<View> listObjRadioGroup = new ArrayList<View>();
                listObjRadioGroup.add(radio1);
                listObjRadioGroup.add(radio2);

                List<View> listObjCheckBoxGroup = new ArrayList<View>();
                listObjRadioGroup.add(checkBox1);
                listObjRadioGroup.add(checkBox2);

                List<List<View>> listOfListViewsGroup = new ArrayList<List<View>>();
                listOfListViewsGroup.add(listObjRadioGroup);
                listOfListViewsGroup.add(listObjCheckBoxGroup);

                Boolean validateFields =
                        MagicalRequiredFields.validateReq(listObj,listOfListViewsGroup,"This is an required field");

                if(validateFields){
                    Toast.makeText(getApplicationContext(), "You passed the test", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "You don't passed the test", Toast.LENGTH_SHORT).show();
                }

            }
        });





        btnRequiredRadioCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<View> listObjRadioGroup = new ArrayList<View>();
                listObjRadioGroup.add(radio1);
                listObjRadioGroup.add(radio2);

                List<View> listObjCheckBoxGroup = new ArrayList<View>();
                listObjRadioGroup.add(checkBox1);
                listObjRadioGroup.add(checkBox2);

                List<List<View>> listOfListViewsGroup = new ArrayList<List<View>>();
                listOfListViewsGroup.add(listObjRadioGroup);
                listOfListViewsGroup.add(listObjCheckBoxGroup);

                Boolean validateFields =
                        MagicalRequiredFields.validateReq(null,listOfListViewsGroup,"This is an required field");

                if(validateFields){
                    Toast.makeText(getApplicationContext(), "You passed the test", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "You don't passed the test", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}