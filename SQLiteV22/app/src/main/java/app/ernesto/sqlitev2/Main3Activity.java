package app.ernesto.sqlitev2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.ernesto.sqlitev2.SQL.UsuarioDAO;
import app.ernesto.sqlitev2.model.Usuario;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    private EditText nombre,apellido,correo, clave;
    private Button btnGuardar, btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
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

        nombre = (EditText) findViewById(R.id.txtNombre);
        apellido = (EditText) findViewById(R.id.txtApellido);
        correo = (EditText) findViewById(R.id.txtCorreo);
        clave = (EditText) findViewById(R.id.txtPasswd);

        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnCancelar.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, Main2Activity.class);
        if(v.getId() == R.id.btnCancelar){
            startActivity(i);
        }else if(v.getId() == R.id.btnGuardar){
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre.getText().toString());
            usuario.setApellido(apellido.getText().toString());
            usuario.setCorreo(correo.getText().toString());
            usuario.setClave(clave.getText().toString());

            UsuarioDAO dao = new UsuarioDAO(this);
            if(dao.addUsuario(usuario) > 0){
                Toast.makeText(this, "Se Creo un nuevo Registro", Toast.LENGTH_LONG).show();
                startActivity(i);
            }else{
                Toast.makeText(this, "No se pudo guardar", Toast.LENGTH_LONG).show();

            }
        }
    }
}
