package br.com.lapps.hackathonunimed.view;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.Select;

import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;
import br.com.lapps.hackathonunimed.R;
import br.com.lapps.hackathonunimed.controller.LoginController;
import br.com.lapps.hackathonunimed.model.Aplicacao;
import br.com.lapps.hackathonunimed.model.pojo.Beneficiario;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private LoginController controller;
    private ProgressDialog dialog;
    @BindView(R.id.txtNumCartao)
    EditText txtNumCartao;
    @BindView(R.id.btnAcessar)
    Button btnAcessar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        Beneficiario beneficiario = new Select().from(Beneficiario.class).querySingle();
        if(beneficiario != null){
            Aplicacao app = (Aplicacao) getApplication();
            app.setBeneficiario(beneficiario);
            Intent intent = new Intent(this, PainelActivity.class);
            startActivity(intent);
            finish();
        }else {
            controller = new LoginController(this);
            // add mask to field
            MaskEditTextChangedListener mascaraCartao = new MaskEditTextChangedListener("# ### ############ #", txtNumCartao);
            txtNumCartao.addTextChangedListener(mascaraCartao);
        }

    }


    private boolean isCartaoValido() {

        return this.txtNumCartao.getText().length() == (17 + 3);
    }


    @OnClick(R.id.btnAcessar)
    public void btnAcessarClick() {
        if(!isCartaoValido()){
            Toast.makeText(this, "Atenção: O numero de cartão informado é inválido!", Toast.LENGTH_LONG).show();
        }else{
            controller.logar();
        }
    }

    public void exibeAlertDialog(String titulo, String mensagem){
        AlertDialog.Builder alert = new AlertDialog.Builder(this).setTitle(titulo)
                .setMessage(mensagem)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert);

        alert.show();
    }

    public String getNumCartao(){
        return this.txtNumCartao.getText().toString().replaceAll("\\s+","");
    }

    public void openDialog(DialogInterface.OnClickListener acao) {
        dialog = new ProgressDialog(this);
        dialog.setTitle("Aguarde.");
        dialog.setMessage("Logando...");
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancelar", acao);
        dialog.setCancelable(true);
        dialog.show();
    }

    public void closeDialog() {
        if(dialog != null){
            dialog.dismiss();
        }
    }

}

