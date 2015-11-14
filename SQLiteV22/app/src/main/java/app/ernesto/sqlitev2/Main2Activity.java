package app.ernesto.sqlitev2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
//Este es un comentario
public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private Button btnNuevo, btnModificar, btnEliminar, btnMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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

        btnNuevo = (Button) findViewById(R.id.btnRegistrar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnNuevo.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        switch (v.getId()){
            case R.id.btnRegistrar:
                i.setClass(this, Main3Activity.class);
                startActivity(i);
                break;
            case R.id.btnMostrar:
                i.setClass(this, Main4Activity.class);
                startActivity(i);
                break;
        }
    }
}
