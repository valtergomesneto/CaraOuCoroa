package caraoucoroa.cursoandroid.com.caraoucoroa;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DetalheActivity extends AppCompatActivity {

    private ImageView botaoVoltar;
    private  ImageView moedaImagem;
    private Button botaoSair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        botaoVoltar = findViewById(R.id.botaoVoltarId);
        moedaImagem = findViewById(R.id.moedaId);
        botaoSair = findViewById(R.id.botaoSairId);


        Bundle extra = getIntent().getExtras();

        if (extra != null){

            String opcaoEscolhida = extra.getString("opcao");
            if (opcaoEscolhida.equals("cara") ) {
                //imagem cara
                moedaImagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_cara ));

            }else{
                //imagem coroa
                moedaImagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_coroa ));

            }

        }

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Outro metódo de instancia o StartActivity

                startActivity(new Intent(DetalheActivity.this, MainActivity.class));

                //Intent intent = new Intent(DetalheActivity.this, MainActivity.class);
            }
        });

        botaoSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  it = new Intent(DetalheActivity.this, MainActivity.class);
                it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                it.putExtra("SAIR", true);
                startActivity(it);
            }
        });


    }
}
