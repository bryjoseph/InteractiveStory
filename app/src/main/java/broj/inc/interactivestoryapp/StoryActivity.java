package broj.inc.interactivestoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class StoryActivity extends AppCompatActivity {

    private static final String TAG = StoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // from the first Activity the name value is being passed via an Intent object
        // must get the intent object first because the string value is attached
        Intent intent = getIntent();
        // from the intent we need to GET the "Extra" value that we passed
        // use the key value from the Extra

        // instead of using the hardcoded key name, changed to the Resource id
        /* ORG String name = intent.getStringExtra("name");*/
        String name = intent.getStringExtra(getString(R.string.key_name));
        // checking for empty & null
        if(name == null || name.isEmpty())
        {
            name = "Friend";
        }
        Log.d(TAG, name);
    }
}
