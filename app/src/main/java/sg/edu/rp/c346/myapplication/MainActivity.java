package sg.edu.rp.c346.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Spinner;
import android.widget.Button;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.view.View;
import java.util.Arrays;
import android.widget.AdapterView;



public class MainActivity extends AppCompatActivity {

    Spinner spn1 , spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);


        //initialize the ArrayList
        alNumbers = new ArrayList<>();
        //Create an ArrayAdapter using the default Spinner layout and the ArrayList
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);
        //Bind the ArrayAdapter to the spinner
        spn2.setAdapter(aaNumbers);
        //Add values in array
        alNumbers.add("2");
        alNumbers.add("4");
        alNumbers.add("6");


        btnUpdate.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

            int pos = spn1.getSelectedItemPosition();
            alNumbers.clear();

            if(pos==0){
                String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                alNumbers.addAll(Arrays.asList(strNumbers));

            }else{
                String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                alNumbers.addAll(Arrays.asList(strNumbers));

            }
            aaNumbers.notifyDataSetChanged();
        }
    });


        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void OnItemSelected(AdapterView<?> parent, View view,int position,long id) {
            alNumbers.clear();

            if (position==0){
                String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                alNumbers.addAll(Arrays.asList(strNumbers));

            }else{
                String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                alNumbers.addAll(Arrays.asList(strNumbers));

            }
            aaNumbers.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
    }}




