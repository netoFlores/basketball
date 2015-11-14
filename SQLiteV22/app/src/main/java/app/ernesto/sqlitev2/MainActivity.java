package app.ernesto.sqlitev2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

import app.ernesto.sqlitev2.SQL.UsuarioDAO;
import app.ernesto.sqlitev2.model.Usuario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText correo,  passwd;
    private Button btnIngresar;
    UsuarioDAO dao = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao = new UsuarioDAO(this);

        correo = (EditText) findViewById(R.id.txtCorreo);
        passwd = (EditText) findViewById(R.id.txtClave);
        btnIngresar = (Button) findViewById(R.id.button);
        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            Usuario usuario = new Usuario(), usuario2 = null;
            usuario.setCorreo(correo.getText().toString());
            usuario.setClave(passwd.getText().toString());
            Cursor login = dao.login(usuario);
            if(login.moveToFirst()){
                do{
                    usuario2 = new Usuario();
                    usuario2.setId(login.getInt(0));
                    usuario2.setNombre(login.getString(1));
                    usuario2.setApellido(login.getString(2));
                    usuario2.setCorreo(login.getString(3));
                    usuario2.setClave(login.getString(4));

                }while (login.moveToNext());
            }else{
                Toast.makeText(this, "Usuario o contraseña invalido", Toast.LENGTH_LONG).show();
            }

            if(usuario2.getId() > 0){
                Toast.makeText(this, "Bienvenido "+usuario2.getNombre()+" "+usuario2.getApellido(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("mensaje","Hola Mundo");
                intent.putExtra("usuario", usuario2);
                startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
