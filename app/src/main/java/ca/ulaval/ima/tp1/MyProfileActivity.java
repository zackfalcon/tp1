package ca.ulaval.ima.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyProfileActivity extends AppCompatActivity {

    TextView firstNameField, lastNameField, birthDateField, iDULField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile2);

        firstNameField = findViewById(R.id.firstNameField);
        lastNameField = findViewById(R.id.lastNameField);
        birthDateField = findViewById(R.id.birthDateField);
        iDULField = findViewById(R.id.iDULField);

        Intent intent = getIntent();
        Profil profilData = intent.getParcelableExtra("PROFIL_DATA");

        String lastName = profilData.getLastName();
        String firstName = profilData.getFirstName();
        Calendar birthDate = profilData.getBirthDate();
        String iDUL = profilData.getiDUL();

        firstNameField.setText(firstName);
        lastNameField.setText(lastName);
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(birthDate.getTime());
        birthDateField.setText(strDate);
        iDULField.setText(iDUL);
    }
}
