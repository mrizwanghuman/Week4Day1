package com.example.admin.week4day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.week4day1.fragements.BlankFragment;
import com.example.admin.week4day1.modal.Contact;

import java.util.List;

public class Contacts extends AppCompatActivity {

    private static final String TAG = "Contacts";
    private EditText etfirstName;
    private EditText etlastName;
    private EditText etmobileNumber;
    private EditText ethomeNumber;
    private TextView showContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        getETValue();
    }
    public void getETValue(){

        etfirstName = findViewById(R.id.first_name);
        etlastName = findViewById(R.id.last_name);
        etmobileNumber = findViewById(R.id.mobile_number);
        ethomeNumber = findViewById(R.id.home_phone);
//        showContact = findViewById(R.id.showContact);
    }

    public void saveContacts(View view) {

DataBaseHelper dataBaseHelper= new DataBaseHelper(this);
        String firstName = etfirstName.getText().toString();
        String lastName = etlastName.getText().toString();
        String mobileNumber = etmobileNumber.getText().toString();
        String homeNumber = ethomeNumber.getText().toString();
        Contact contact = new Contact(firstName, lastName, mobileNumber, homeNumber);
        long row =dataBaseHelper.SaveContacts(contact);
        if(row>0){
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
            etfirstName.setText("");
            etlastName.setText("");
            etmobileNumber.setText("");
            ethomeNumber.setText("");           ;
        }else {
            Toast.makeText(this, "Not save", Toast.LENGTH_SHORT).show();
        }

    }

    public void showContact(View view) {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        List<Contact> contactList = dataBaseHelper.getContacts();
        DataBaseHelper db = new DataBaseHelper(this);
//      showContact.setText(db.getContacts().toString());
//        BlankFragment blankFragment = new BlankFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.flForContactList,blankFragment,"List").commit();
        //Log.d(TAG, "showContact: "+blankFragment);
        RecyclerView recyclerView = findViewById(R.id.rcContactView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ContactAdapter contactAdapter = new ContactAdapter(contactList);

recyclerView.setAdapter(contactAdapter);



    }
}
