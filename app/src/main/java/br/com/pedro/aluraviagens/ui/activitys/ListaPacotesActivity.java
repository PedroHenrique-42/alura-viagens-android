package br.com.pedro.aluraviagens.ui.activitys;

import static br.com.pedro.aluraviagens.ui.activitys.PacoteActivityConstantes.CHAVE_PACOTE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.pedro.aluraviagens.dao.PacoteDAO;
import br.com.pedro.aluraviagens.R;
import br.com.pedro.aluraviagens.models.Pacote;
import br.com.pedro.aluraviagens.ui.adapters.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.app_bar_title);
        setContentView(R.layout.activity_lista_pacotes);
        setAdapterOnListView();
    }

    private void setAdapterOnListView() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_lisview);
        List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));

        listaDePacotes.setOnItemClickListener((adapterView, view, position, l) -> {
            Pacote pacoteClicado = pacotes.get(position);
            vaiParaResumoPacote(pacoteClicado);
        });
    }

    private void vaiParaResumoPacote(Pacote pacoteClicado) {
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacoteClicado);
        startActivity(intent);
    }
}