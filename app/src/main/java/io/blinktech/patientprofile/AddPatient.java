package io.blinktech.patientprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

import io.blinktech.patientprofile.PatientDataInterface;

public class AddPatient extends AppCompatActivity {

    private ImageView placeholder;
    private Patient newPatient;
    EditText name;
    EditText family_id;
    EditText age;
    EditText blood;
    EditText phone;
    EditText house_id;
    EditText patient_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        placeholder = (ImageView) findViewById(R.id.placeholder);
        placeholder.setImageResource(R.drawable.placeholder);

        final Button button = (Button) findViewById(R.id.next);
        name = (EditText) findViewById(R.id.name);
        family_id = (EditText) findViewById(R.id.family_id);
        age = (EditText) findViewById(R.id.age);
        blood = (EditText) findViewById(R.id.blood_group);
        phone = (EditText) findViewById(R.id.phone);
        house_id = (EditText) findViewById(R.id.house_id);
        patient_id = (EditText) findViewById(R.id.patient_id);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String element_name = name.getText().toString();
                String element_blood = blood.getText().toString();
                int element_family_id = Integer.parseInt(family_id.getText().toString());
                int element_age = Integer.parseInt(age.getText().toString());
                int element_phone = Integer.parseInt(phone.getText().toString());
                int element_house_id = Integer.parseInt(house_id.getText().toString());
                int element_patient_id = Integer.parseInt(patient_id.getText().toString());


                newPatient = new Patient(3,element_patient_id,element_family_id,element_house_id,element_name,element_age,element_phone,element_blood,"2016-05-10","none","none","yes","yes","yes","no notes");

                PatientDataInterface add = new PatientDataInterface(getApplicationContext());

                try {
                    add.result = add.createPatient(newPatient);
                    Toast.makeText(getApplicationContext(),"This works",Toast.LENGTH_LONG).show();
                   // Log.e("returning result", String.valueOf(add.result));
                    //Log.e("Patient Name",add.getPatient(5));
                    Patient element = add.getPatient(5);


                } catch (SQLException e) {
                    e.printStackTrace();
                }

               // Log.e("returning result", String.valueOf(add.result));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_patient, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
