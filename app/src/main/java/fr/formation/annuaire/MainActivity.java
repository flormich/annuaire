package fr.formation.annuaire;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText etSearch, etName, etTel;
    TextView etId;
    Button btSearch, btNew, btDelete, btInsert;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etId = findViewById(R.id.etId);
        etSearch = findViewById(R.id.etSearch);
        etName = findViewById(R.id.etName);
        etTel = findViewById(R.id.etTel);

        DbInit dbInit = new DbInit(this);
        db = dbInit.getWritableDatabase();
    }

    public void search(View view) {
        String colonnes[] = {"id", "name", "tel"};
        String nom = etSearch.getText().toString();
        nom = nom.toUpperCase();                                //Convertir en majuscules
        nom = nom.replace("'", "''");        //Remplacer chaque ' par un double ''
        String critere = "UPPER(name) = '" + nom + "'";

        Cursor cursor = db.query("contacts", colonnes, critere,null,null,null,null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            etId.setText(cursor.getString(0));
            etName.setText(cursor.getString(1));
            etTel.setText(cursor.getString(2));
        }else{
            Toast.makeText(this, "Contact Inexistant", Toast.LENGTH_SHORT).show();
        }
    }

    public void delete(View view) {

    }

    public void save(View view) {
        ContentValues values = new ContentValues();
        values.put("name", etName.getText().toString());
        values.put("tel", etTel.getText().toString());

        db.insert("contacts", "", values);
    }
}


