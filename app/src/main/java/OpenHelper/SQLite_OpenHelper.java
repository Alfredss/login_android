package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.sql.SQLException;

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

    //METODO QUE PERMITE VALIDAR SI EL USUARIO EXISTE
    public Cursor consultarUsuPas(String usuario, String password)throws SQLException{
        Cursor cursor = null;
        cursor = this.getReadableDatabase().query("usuarios", new String[]{"_ID", "Usuario", "Email", "Password"},
                "Usuario like '"+ usuario +"' and Password like '"+ password +"'",null,null,null,null);
        
        return cursor;
    }
}
