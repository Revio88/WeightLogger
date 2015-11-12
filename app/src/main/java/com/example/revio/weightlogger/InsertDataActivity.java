package com.example.revio.weightlogger;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InsertDataActivity extends AppCompatActivity {

    private MyDataBase mMyDataBase = null;
    private EditText mEditNome;
    private EditText mEditCognome;
    private EditText mEditEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_insert_data);

        mMyDataBase = new MyDataBase(getApplicationContext());

        recuperaNumeroRecord();

        mEditNome = (EditText) this.findViewById(R.id.mainEditTextName);
        mEditCognome = (EditText) this.findViewById(R.id.mainEditTextSurname);
        mEditEmail = (EditText) this.findViewById(R.id.mainEditTextEmail);

        Button button = (Button) this.findViewById(R.id.mainButtonAggiungi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Query di inserimento
                ContentValues contentValues = new ContentValues();

                contentValues.put("nome", mEditNome.getText().toString());
                contentValues.put("cognome", mEditCognome.getText().toString());
                contentValues.put("email", mEditEmail.getText().toString());

                //Accedo al database in scrittura
                SQLiteDatabase db = mMyDataBase.getWritableDatabase();
                db.insert("rubrica", null, contentValues);    //Inserisco i dati

                //Pulisco i campi
                mEditCognome.setText("");
                mEditEmail.setText("");
                mEditNome.setText("");
                mEditNome.requestFocus();

                Toast.makeText(getApplicationContext(), "Nuovo record aggiunto", Toast.LENGTH_SHORT).show();

                //Aggiorno il numero dei record presenti nel database
                recuperaNumeroRecord();
            }
        });

    }

    public boolean onCreateOptionMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    private void recuperaNumeroRecord() {
        SQLiteDatabase db = mMyDataBase.getReadableDatabase();

        final String sql = "SELECT COUNT(*) FROM rubrica";

        Cursor c = db.rawQuery(sql, null);

        if(c.moveToFirst()) {
            final TextView tView = (TextView) this.findViewById(R.id.mainTextViewNumeroRecord);
            tView.setText(c.getString(0));
        }
    }

}
