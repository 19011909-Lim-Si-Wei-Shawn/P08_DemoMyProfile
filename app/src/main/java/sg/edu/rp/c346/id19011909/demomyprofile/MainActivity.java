package sg.edu.rp.c346.id19011909.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Creating Variable,
    EditText etName;
    EditText etGPA;

    @Override
    protected void onPause() {
        super.onPause();

        //Getting UserInput,
        String strName = etName.getText().toString();
        float FGPA = Float.parseFloat(etGPA.getText().toString());

        //Obtaining SharedPreferences Instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        //Creating SharedPreference Editor,
        SharedPreferences.Editor prefEdit = prefs.edit();

        //Setting Key-Value Pair,
        prefEdit.putString("UserName", strName);
        prefEdit.putFloat("GPA", FGPA);

        //Saving Changes to SharedPreference,
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Retrieve SharedPreferences Instance,
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        //Obtaining Data from SharedPreference,
        String MsgName = prefs.getString("UserName", "No Existing Name");
        float MsgGPA = prefs.getFloat("GPA", 0);

        //Updating UI Element,
        etName.setText(MsgName);
        etGPA.setText(String.valueOf(MsgGPA));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking Variable,
        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);

    }
}