package mundo.hola.com.example.alfre.loginandroid;

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

import OpenHelper.SQLite_OpenHelper;

public class Registro extends AppCompatActivity implements View.OnClickListener{
    EditText edtUsuario;
    EditText edtEmail;
    EditText edtPassword;
    EditText edtRPassword;

    Button btnRegistrarUsuario;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "BD1", null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
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

        edtUsuario = (EditText) findViewById(R.id.edtRUsuario);
        edtEmail = (EditText) findViewById(R.id.edtREmail);
        edtPassword = (EditText) findViewById(R.id.edtRPassword);
        edtRPassword = (EditText) findViewById(R.id.edtRPasswordR);
        btnRegistrarUsuario = (Button) findViewById(R.id.btnRegistrarUsuario);
        btnRegistrarUsuario.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        helper.getWritableDatabase();

        helper.insertReg(String.valueOf(edtUsuario.getText()),
                String.valueOf(edtEmail.getText()),
                String.valueOf(edtPassword.getText()),
                String.valueOf(edtRPassword.getText()));

        helper.close();
        Toast.makeText(Registro.this, "Usuario almacenado con Exito", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
