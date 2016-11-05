package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by alfre on 05/11/2016.
 */
public class SQLite_OpenHelper extends SQLiteOpenHelper{

    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table usuarios(_ID integer primary key autoincrement, Usuario text, Email text, Password text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    /*
    public void abrirBD(){
        this.getWritableDatabase();
    }//ABRE LA BASE DE DATOS

    public void cerrarBD(){
        this.close();
    }//CIERRA LA BASE DE DATOS
    */

    public void insertReg(String usuario, String email, String pass, String rPass){


        if (pass.equals(rPass)) {
            ContentValues valores = new ContentValues();
            valores.put("Usuario", usuario);
            valores.put("Email", email);
            valores.put("Password", pass);
            this.getWritableDatabase().insert("usuarios", null, valores);
        }

    }
}
