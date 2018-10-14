package br.com.thecoders.tasktool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import org.joda.time.DateTime;

import br.com.thecoders.tasktool.Classes.PedidoLogin;
import br.com.thecoders.tasktool.Classes.RespostaLogin;
import br.com.thecoders.tasktool.Util.DeserializerData;
import br.com.thecoders.tasktool.Util.SharedPref;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity
{
    private SharedPref sharedPref;

    @BindView(R.id.login_edittext)
    public EditText loginEditText;
    @BindView(R.id.senha_edittext)
    public EditText senhaEditText;
    @BindView(R.id.salvarsenha_switch)
    public Switch salvarSenhaSwitch;
    @BindView(R.id.loading_progressbar)
    public ProgressBar loadingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        loadingProgressBar.setVisibility(View.INVISIBLE);
        sharedPref = new SharedPref(this);
        loginEditText.setText(sharedPref.getLogin());
        salvarSenhaSwitch.setChecked(!sharedPref.getSenha().isEmpty());
        senhaEditText.setText(sharedPref.getSenha());
    }

    public void entrar(View v)
    {
        if (validar())
        {
            final Gson gson = new GsonBuilder().registerTypeAdapter(DateTime.class, new DeserializerData()).create();
            PedidoLogin pedidoLogin = new PedidoLogin(loginEditText.getText().toString(), senhaEditText.getText().toString());
            JsonObject jsonObject = gson.toJsonTree(pedidoLogin, PedidoLogin.class).getAsJsonObject();
            loadingProgressBar.setVisibility(View.VISIBLE);

            Ion.with(this)
                    .load("http://192.168.0.88/TaskTop/api/auth.login/")
                    .setJsonObjectBody(jsonObject)
                    .asJsonObject()
                    .withResponse()
                    .setCallback(new FutureCallback<Response<JsonObject>>()
                    {
                        @Override
                        public void onCompleted(Exception e, Response<JsonObject> result)
                        {
                            if (result.getHeaders().code() == 200)
                            {

                                RespostaLogin login = gson.fromJson(result.getResult(), RespostaLogin.class);
                                sharedPref.setLogin(loginEditText.getText().toString());
                                sharedPref.setSenha(salvarSenhaSwitch.isChecked() ? senhaEditText.getText().toString() : "");
                                sharedPref.setId(login.getUsuario().getId());
                                sharedPref.salvar();

                                loadingProgressBar.setVisibility(View.INVISIBLE);

                                if (login.getUsuario().getTipo().equals("funcionario"))
                                    startActivity(new Intent(Login.this, Agenda.class));
                                else if (login.getUsuario().getTipo().equals("estoque"))
                                    startActivity(new Intent(Login.this, Estoque.class));
                                else if (login.getUsuario().getTipo().equals("supervisor"))
                                    startActivity(new Intent(Login.this, OrdemDeServico.class));
                            }
                            else
                            {
                                Toast.makeText(Login.this, result.getResult().get("error").getAsJsonObject().get("message").getAsString(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
        }
    }

    public boolean validar()
    {
        boolean ok = true;
        if (loginEditText.getText().toString().isEmpty())
        {
            loginEditText.setError("Login deve ser preenchido");
            ok = false;
        }
        else if (senhaEditText.getText().toString().isEmpty())
        {
            senhaEditText.setError("Senha deve ser preenchida");
            ok = false;
        }
        return ok;
    }
}
