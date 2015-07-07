package io.blinktech.patientprofile;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.SQLException;

public class SearchPatient extends AppCompatActivity {
    TextView name;
    TextView patient_id;
    TextView family_id;
    TextView age;
    TextView blood;
    TextView phone;
    TextView house_id;
    TextView previous;
    Patient result;

    private ImageView profile_picture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patient);

        profile_picture = (ImageView) findViewById(R.id.profile_picture);
        profile_picture.setImageResource(R.drawable.sample_profile);


        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //Log.e("Search String", query);
            name = (TextView) findViewById(R.id.name);
            patient_id = (TextView) findViewById(R.id.patient_id);
            family_id = (TextView) findViewById(R.id.family_id);
            house_id = (TextView) findViewById(R.id.house_id);
            age = (TextView) findViewById(R.id.age);
            blood = (TextView) findViewById(R.id.blood_group);
            phone = (TextView) findViewById(R.id.phone);
            previous = (TextView) findViewById(R.id.previous);

            result = new Patient();
            //label.setText(query);
            PatientDataInterface dataObject = new PatientDataInterface(getApplicationContext());
            //if(dataObject!=null) Log.e("Not","NULL");
            int id = Integer.parseInt(query);
           // Log.e("Not",String.valueOf(id));

            try {
               result = dataObject.getPatient(id);

                name.setText(result.getName());
                patient_id.setText("#"+ String.valueOf(id));
                family_id.setText("#" + String.valueOf(result.getFamilyId()));
                age.setText(String.valueOf(result.getAge()));
                blood.setText(result.getBloodGroup());
                phone.setText(String.valueOf(result.getPhone()));
                house_id.setText("#" + String.valueOf(result.getHouseId()));
                previous.setText(result.getPreviousDate());

             } catch (SQLException e) {
              e.printStackTrace();
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_patient, menu);
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
