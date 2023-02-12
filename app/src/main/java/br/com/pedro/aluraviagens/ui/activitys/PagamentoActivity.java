package br.com.pedro.aluraviagens.ui.activitys;

import static br.com.pedro.aluraviagens.ui.activitys.PacoteActivityConstantes.CHAVE_PACOTE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.pedro.aluraviagens.R;
import br.com.pedro.aluraviagens.models.Pacote;
import br.com.pedro.aluraviagens.utils.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TITULO_APPBAR);
        setContentView(R.layout.activity_pagamento);

        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            mostraPreco(pacote);
            configuraBotao(pacote);
        }
    }

    private void configuraBotao(Pacote pacote) {
        Button botaoFinalizaCompra = findViewById(R.id.pagamento_botao_finaliza_compra);
        botaoFinalizaCompra.setOnClickListener(view -> {
            vaiParaResumoCompra(pacote);
        });
    }

    private void vaiParaResumoCompra(Pacote pacote) {
        Intent intent1 = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent1.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent1);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}