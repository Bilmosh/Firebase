package com.bill.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edit;

    //firebase database object
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //.getInstance                        getReference
        //main access point of the database   references specific part of the DB i.e. rootnode

        //Initialize firebase components
        ref = FirebaseDatabase.getInstance().getReference("data");
        ref.setValue("message");
        btn = (Button) findViewById(R.id.button3);
        edit = (EditText) findViewById(R.id.editText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String names = edit.getText().toString();

                DatabaseReference ref2=ref.push();
                User u=new User(names, 22);

                //clear edit box
                edit.setText("");


                ref2.setValue(u, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if (databaseError!=null){
                            Toast.makeText(MainActivity.this, "Not Successfull", Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(MainActivity.this, "Data Posted Successfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
}
