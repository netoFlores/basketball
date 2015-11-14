package app.ernesto.sqlitev2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import app.ernesto.sqlitev2.SQL.UsuarioDAO;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        crearTabla();
    }

    public void crearTabla(){
        UsuarioDAO dao = new UsuarioDAO(this);
        ListView lv = (ListView) findViewById(R.id.listView);
        String[] columnas = new String[]{"_id", "nombre", "apellido", "correo", "clave"};
        int[] to = new int[]{R.id.col1, R.id.col2, R.id.col3, R.id.col4};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.listfive, dao.findAll(), columnas, to);
        lv.setAdapter(adapter);
    }
}
