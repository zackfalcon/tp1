package ca.ulaval.ima.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    Profil profil;
    String UrlToLoad = "https://www.facebook.com/";
    Button buttonWebSiteWv;
    Button buttonWebSiteExt;
    Button buttonUlaval;
    Button buttonMyProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profil = new Profil("Zakaria", "Laabid",
                new GregorianCalendar(1998,7,28), "ZALAA");

        buttonWebSiteExt =  findViewById(R.id.buttonWebSiteExt);
        buttonWebSiteExt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(UrlToLoad));
                startActivity(browserIntent);
            }
        });

        buttonWebSiteWv =  findViewById(R.id.buttonWebSiteWv);
        buttonWebSiteWv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), WebViewActivity.class);
                intent.putExtra("URL_TO_LOAD", UrlToLoad);
                startActivity(intent);
            }
        });

        buttonUlaval = findViewById(R.id.buttonUlaval);
        buttonUlaval.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), UlavalActivity.class);
                startActivity(intent);
            }
        });



        buttonMyProfile = findViewById(R.id.buttonMyProfile);
        buttonMyProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MyProfileActivity.class);
                intent.putExtra("PROFIL_DATA", profil);
                startActivity(intent);
            }
        });

    }
}
