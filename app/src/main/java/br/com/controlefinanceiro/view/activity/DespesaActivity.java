package br.com.controlefinanceiro.view.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputEditText;

import br.com.controlefinanceiro.R;
import br.com.controlefinanceiro.model.entidade.Despesa;
import br.com.controlefinanceiro.viewmodel.DespesaViewModel;

public class DespesaActivity extends BaseActivity {

    private DespesaViewModel mViewModel;
    private AppCompatButton mBtnSalvar;
    private Despesa mDespesa;
    private TextInputEditText mDescricaoEdit;
    private TextInputEditText mValorEdit;
    private Spinner mResponsavelSpinner;
    private Spinner mMesSpinner;
    private Spinner mContaSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesa);

        mViewModel = ViewModelProviders.of(this).get(DespesaViewModel.class);

        doBindings();

        mBtnSalvar = findViewById(R.id.btnSalvar);
        mDescricaoEdit = findViewById(R.id.descricaoEdit);
        mValorEdit = findViewById(R.id.valorEdit);
        mMesSpinner = findViewById(R.id.mesSpinner);
        mContaSpinner = findViewById(R.id.contaSpinner);
        mResponsavelSpinner = findViewById(R.id.responsavelSpinner);

        super.spinnerMeses(mMesSpinner);
        super.spinnerConta(mContaSpinner);
        super.spinnerResponsavel(mResponsavelSpinner);

        mDespesa = new Despesa();

        mBtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!camposValidos()) {
                    return;
                }
                mViewModel.save(despesa());
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void doBindings() {
        super.onStart();
        super.observeError(mViewModel);
        observeSucess();
    }

    private Boolean camposValidos() {
        if (TextUtils.isEmpty(mDescricaoEdit.getText())) {
            mDescricaoEdit.setError(getString(R.string.campo_obrigatorio));
            return false;
        }
        if (TextUtils.isEmpty(mValorEdit.getText())) {
            mValorEdit.setError(getString(R.string.campo_obrigatorio));
            return false;
        }
        if(mResponsavelSpinner.getSelectedItemPosition() == 0){
            Toast.makeText(this, getString(R.string.spinner_responsavel_erro), Toast.LENGTH_SHORT).show();
            return false;
        }
        if(mContaSpinner.getSelectedItemPosition() == 0){
            Toast.makeText(this, getString(R.string.spinner_conta_erro), Toast.LENGTH_SHORT).show();
            return false;
        }
        if(mMesSpinner.getSelectedItemPosition() == 0){
            Toast.makeText(this, getString(R.string.spinner_mes_erro), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private Despesa despesa() {
        mDespesa.valor = Double.parseDouble(mValorEdit.getText().toString());
        mDespesa.descricao = mDescricaoEdit.getText().toString();
        mDespesa.conta = mContaSpinner.getSelectedItemPosition();
        mDespesa.responsavel = mResponsavelSpinner.getSelectedItemPosition();
        mDespesa.mes = mMesSpinner.getSelectedItemPosition();
        return mDespesa;
    }

    private void observeSucess() {
        mViewModel.sucess.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
