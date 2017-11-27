package com.example.taruc.lab3_3inputcontrols;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements Spinner.OnItemSelectedListener, DatePickerFragment.OnDateSelectedListener {
    private EditText editTextName, editTextPhone, editTextEmail, editTextPassword, editTextDate;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private ImageView imageViewIconOn;
    private Spinner spinnerSalary;
    private Button buttonDisplay, buttonSelectDate;
    private ToggleButton toggleOnOff;
    DatePickerFragment newFragment;
    public static final String EXTRA_MESSAGE = "Grid Layout And Input Controls";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextDate = (EditText) findViewById(R.id.editTextDate);
        imageViewIconOn = (ImageView)findViewById(R.id.imageViewIconFire);
        spinnerSalary = (Spinner) findViewById(R.id.spinnerSalary);
        spinnerSalary.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.salary, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSalary.setAdapter(adapter);

    }

    public void showMessage(View view){
        Intent intent = new Intent(this, DisplayActivity.class);

        radioSexGroup = (RadioGroup) findViewById(R.id.radioGroup_Sex);
        int selectedId = radioSexGroup.getCheckedRadioButtonId();
        // find the radio button by returned id
        radioSexButton = (RadioButton) findViewById(selectedId);


        String message = "User Name: " + editTextName.getText().toString() +
                "\nUser Phone: " + editTextPhone.getText().toString()+
                "\nUser Email: " + editTextEmail.getText().toString()+
                "\nUser Password: " + editTextPassword.getText().toString() +
                "\nBirth Date: " + editTextDate.getText().toString() +
                "\nUser Sex: " + radioSexButton.getText().toString() +
                "\nUser Salary Group: " + spinnerSelection +
                "\nUser Heart Status: " + imageIconSelection;

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    String imageIconSelection = "";
    public void showPicture(View view){
        boolean on = ((ToggleButton)view).isChecked();

        if(on) {
            imageViewIconOn.setVisibility(View.VISIBLE);
            imageIconSelection = "Fire on my heart is on!";
        }
        else {
            imageViewIconOn.setVisibility(View.INVISIBLE);
            imageIconSelection = "Fire on my heart is off!";
        }
    }

    String spinnerSelection = "";
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerSelection = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void selectDate(View view) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "DatePicker");
    }

    public void populateSetDate(int year, int month, int day) {
        editTextDate.setText(month + "/" + day + "/" + year);
    }

}
