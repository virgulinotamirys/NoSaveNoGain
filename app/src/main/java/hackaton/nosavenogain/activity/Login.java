package hackaton.nosavenogain.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import hackaton.nosavenogain.R;
import hackaton.nosavenogain.util.Utils;

public class Login extends AppCompatActivity
{
    private EditText input_cpf;
    private EditText input_senha;
    private Button btn_entrar;
    private Button btn_cadastrar;
    private Dialog dialog_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        setEvents();
    }

    private void init()
    {
        input_cpf = (EditText) findViewById(R.id.input_cpf);
        input_senha = (EditText) findViewById(R.id.input_senha);

        btn_entrar = (Button) findViewById(R.id.btn_entrar);
        btn_cadastrar = (Button) findViewById(R.id.btn_cadastrar);
    }

    private void setEvents()
    {
        btn_entrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!Utils.validaCampo(input_cpf) && !Utils.validaCampo(input_senha))
                    return;
                startActivity(new Intent(getApplicationContext(), Principal.class));
                finish();
            }
        });

        btn_cadastrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dialog_cadastro = new Dialog(Login.this);
                dialog_cadastro.setContentView(R.layout.dialog_cadastro);
                dialog_cadastro.setTitle("Cadastro");
                dialog_cadastro.getWindow()
                        .setLayout((int) (Utils.getScreenWidth(Login.this) * .9), ViewGroup.LayoutParams.WRAP_CONTENT);
                final Button btn_concluido = (Button) dialog_cadastro.findViewById(R.id.btn_concluido);
                final Button btn_cancel = (Button) dialog_cadastro.findViewById(R.id.btn_cancel);
                btn_concluido.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog_cadastro.dismiss();
                    }
                });
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog_cadastro.dismiss();
                    }
                });
                dialog_cadastro.show();
            }
        });
    }

}
