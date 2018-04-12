package com.parse.starter.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.parse.starter.R;

public class CadastroActivity extends AppCompatActivity {
    private EditText textoUsuario;
    private EditText textoEmail;
    private EditText textoSenha;
    private Button botaoCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        textoUsuario    = (EditText) findViewById(R.id.text_usuario);
        textoEmail      = (EditText) findViewById(R.id.text_email);
        textoSenha      = (EditText) findViewById(R.id.text_senha);
        botaoCadastrar  = (Button)   findViewById(R.id.bt_cadastrar);
        /*botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrarUsuario();
            }
        });*/

    }

    private void cadastrarUsuario() {
        //Criar objeto usuario
        ParseUser usuario = new ParseUser();
        usuario.setUsername(textoUsuario.getText().toString());
        usuario.setEmail(textoEmail.getText().toString());
        usuario.setPassword(textoSenha.getText().toString());

        //Salvando dados do usuario
        usuario.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e==null){
                    Toast.makeText(CadastroActivity.this,"Cadastrado!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(CadastroActivity.this,"Não Cadastrado! "+e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void abrirLoginUsuario(View view){
        Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
        finish();
        startActivity( intent );
    }

}
