package fr.formation.annuaire;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbInit extends SQLiteOpenHelper {

    //Le nom de la base de données est fixé à annuaire
    //le numéro de verison est fixé à 1
    public DbInit(Context ctxt) {
        super(ctxt, "annuaire", null, 1);
    }

    //Cette methode est exécutée une seule fois pour créer la base de données
    @Override
    public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE contacts (" +
                    " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
                    ", name TEXT NOT NULL" +
                    ", tel TEXT" +
                    ")";
            db.execSQL(sql);
    }

    //Cette méthode est exécutée quand la version du fichier ne correspond pas à celle indiquée dans le constructeur
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

