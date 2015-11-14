package app.ernesto.sqlitev2.SQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Neto on 10/11/2015.
 */
public class SQLiteMannager extends SQLiteOpenHelper {
    public static final String DBNAME = "usuario.sqlite";
    public static final int DBVERSION = 1;
    public SQLiteMannager(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsuarioDAO.TABLESQL);
        db.execSQL("INSERT INTO usuario VALUES (null, 'admin','admin', 'admin@admin.com', '123456');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
