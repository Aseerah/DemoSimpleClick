package sg.edu.rp.c346.id20009530.demosimpleclick;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView textViewDisplay;
    Button displayButton;
    EditText editTextInput;
    ToggleButton toggleButton;
    RadioGroup rgGender;
    RadioButton radioButtonMale;
    RadioButton radioButtonFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewDisplay = findViewById(R.id.textViewDisplay);
        displayButton = findViewById(R.id.displayButton);
        editTextInput = findViewById(R.id.editTextInput);
        toggleButton = findViewById(R.id.ToggleButtonEnabled);
        rgGender = findViewById(R.id.rgGender);

        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);


        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextInput.getText().toString();
                String stringResponse = editTextInput.getText().toString();
                textViewDisplay.setText(stringResponse);

                if (stringResponse.isEmpty()) {
                    textViewDisplay.setText("Nothing has been entered");
                    Toast.makeText(MainActivity.this, "Please enter something", Toast.LENGTH_SHORT).show();
                } else {
                    int checkedRB = rgGender.getCheckedRadioButtonId();
                    if(checkedRB == R.id.radioButtonFemale){
                        textViewDisplay.setText("She said " + stringResponse);
                    }else{
                        textViewDisplay.setText("He said " + stringResponse);

                    }
                }

            }
        });

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton.isChecked()== true){
                    editTextInput.setEnabled(true);
                    editTextInput.setBackgroundColor(Color.GREEN);
                }else{
                    editTextInput.setBackgroundColor(Color.RED);
                }

            }
        });
    }
}