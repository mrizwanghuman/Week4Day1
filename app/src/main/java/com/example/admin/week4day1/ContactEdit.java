package com.example.admin.week4day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.week4day1.modal.Contact;

public class ContactEdit extends AppCompatActivity {

    private EditText firstname;
    private EditText lastname;
    private EditText mobileno;
    private EditText homeNo;
    private EditText contactId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_edit);

        Intent intent = getIntent();
        String getIntenFN =intent.getStringExtra("firstname");
        String getIntLN = intent.getStringExtra("lastname");
        String getMobileN = intent.getStringExtra("mobile");
        String getHomeN = intent.getStringExtra("home");
        String getID = intent.getStringExtra("id");

        firstname = findViewById(R.id.ed_first_name);
        lastname = findViewById(R.id.ed_last_name);
        mobileno = findViewById(R.id.ed_mobile);
        homeNo = findViewById(R.id.ed_home);
        contactId = findViewById(R.id.ed_id);
        firstname.setText(getIntenFN);
        lastname.setText(getIntLN);
        mobileno.setText(getMobileN);
        homeNo.setText(getHomeN);
        contactId.setText(getID);

    }

    public void updateContact(View view) {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        String id ;
        int idNo;
        Intent intent = new Intent(this, Contacts.class);

        switch (view.getId()) {
            case R.id.btnDelete:
id = contactId.getText().toString();
idNo = Integer.parseInt(id);
                dataBaseHelper.deleteRow(idNo);
            finish();

            startActivity(intent);
            break;
            case R.id.btnEdit:
                id = contactId.getText().toString();
                idNo = Integer.parseInt(id);
                String firstN = firstname.getText().toString();

                String lastN = lastname.getText().toString();
                String mobileN = mobileno.getText().toString();
                String homeN = homeNo.getText().toString();
                Toast.makeText(this, ""+firstN + lastN + mobileN+ homeN, Toast.LENGTH_SHORT).show();
                Contact contact = new Contact(firstN, lastN,mobileN, homeN);

                dataBaseHelper.updateRecord(contact);
                finish();
                startActivity(intent);

        }
    }
}
