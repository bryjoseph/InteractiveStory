package broj.inc.interactivestoryapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // member variables

    private EditText nameField; // this is the text field from the starting page
    private Button startButton; // this is the button also on the starting page

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // sets the layout to the activity that we created
        setContentView(R.layout.activity_main);

        // instantiate the member variable
        nameField = findViewById(R.id.nameEditText);
        startButton = findViewById(R.id.startButton);

        // set the listener for the newly created button
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getText().toString();
                // need to explicitly type MainActivity because the org "this" was a reference to an anonymous class
                // Toast is a way to test that the text value actually arrives from the button click (ONLY MEANT FOR TESTING)
                // Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();

                startStory(name);
            }
        });
    }

    private void startStory(String name) {
        Intent intent =  new Intent(this, StoryActivity.class);
        // Resources are available at the context level
        Resources resources = getResources();
        // Once a resource instance is available values can be pulled off of the obj
        String key = resources.getString(R.string.key_name);
        // instead of hardcoding the key name (org. "name") now we can reference the variable pulled from the resource obj
        intent.putExtra(key, name);
        // express the intention
        startActivity(intent);
    }
}
