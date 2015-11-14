package app.ernesto.sqlitev2.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import app.ernesto.sqlitev2.model.Usuario;

/**
 * Created by Neto on 10/11/2015.
 */
public class UsuarioDAO {
    public static final String TABLENAME = "usuario";
    public static final String ID = "_id";
    public static final String NOMBRE = "nombre";
    public static final String APELLIDO = "apellido";
    public static final String CORREO = "correo";
    public static final String CLAVE = "clave";

    public static final String TABLESQL = "CREATE TABLE "+ TABLENAME+"( " +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NOMBRE + " TEXT, " +
            APELLIDO + " TEXT, " +
            CORREO + " TEXT, " +
            CLAVE + " TEXT );";

    private SQLiteDatabase db;
    private SQLiteMannager helper;

    public UsuarioDAO(Context context) {
        helper = new SQLiteMannager(context);
        this.db = helper.getWritableDatabase();
    }

    public long addUsuario(Usuario usuario){
        long out = -1;
        ContentValues values = new ContentValues();
        values.put("nombre", usuario.getNombre());
        values.put("apellido", usuario.getApellido());
        values.put("correo", usuario.getCorreo());
        values.put("clave", usuario.getClave());

        out = db.insert(TABLENAME, null, values);

        return out;
    }


    public long updateUsuario(Usuario usuario){
        long out = -1;
        ContentValues values = new ContentValues();
        values.put("nombre", usuario.getNombre());
        values.put("apellido", usuario.getApellido());
        values.put("correo", usuario.getCorreo());
        values.put("clave", usuario.getClave());

        out = db.update(TABLENAME, values, ID + "=?", new String[]{String.valueOf(usuario.getId())});
        return out;
    }

    public long deleteUsuario(Usuario usuario){
        return db.delete(TABLENAME,ID+"=?", new String[]{String.valueOf(usuario.getId())});
    }

    public Cursor findAll(){
        String[] columna = new String[]{ID, NOMBRE, APELLIDO, CORREO, CLAVE};
        return db.query(TABLENAME, columna, null, null, null, null, null);
    }

    public Cursor findByNombre(Usuario usuario){
        String[] columna = new String[]{ID, NOMBRE, APELLIDO, CORREO, CLAVE};
        return db.query(TABLENAME, columna, NOMBRE+"=?",new String[]{usuario.getNombre()}, null, null, null);
    }

    public Cursor login(Usuario usuario){
        String[] columna = new String[]{ID, NOMBRE, APELLIDO, CORREO, CLAVE};
        return db.query(TABLENAME, columna, CORREO+"=? AND "+CLAVE+"=?",new String[]{usuario.getCorreo(), usuario.getClave()}, null, null, null);
    }
}
