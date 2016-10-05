package com.example.i7.listitens;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.i7.listitens.banco.BancoDeDados;
import com.example.i7.listitens.obj.ItemLista;

public class ItemDetalheActivity extends Activity implements OnClickListener, TextWatcher {

	private ItemLista itemLista;
	
	private EditText nome;
	private Spinner  categoria;
	private EditText quantidade;
	private EditText precoItem;
	private TextView valorTotal;
	
	private BancoDeDados db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_detail);

		db = new BancoDeDados(this);

		nome 		= (EditText) findViewById(R.id.edit_text_nome_item);
		categoria 	= (Spinner) findViewById(R.id.spinner_categoria_item);
		quantidade	= (EditText) findViewById(R.id.edit_text_quantidade_item);
		precoItem 	= (EditText) findViewById(R.id.edit_text_preco_item);
		valorTotal 	= (TextView) findViewById(R.id.text_view_preco_total);
		
		quantidade.addTextChangedListener(this);
		precoItem.addTextChangedListener(this);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			itemLista = (ItemLista) extras.getSerializable("item_compra");
			if (itemLista != null) {
				String[] categorias = getResources().getStringArray(R.array.categorias);

				int categoriaPosition = 0;
				for (int i = 0; i < categorias.length; i++) {
					if (categorias[i].equals(itemLista.getCategoria())) {
						categoriaPosition = i;
						break;
					}
				}
				
				nome.setText(itemLista.getNome());
				categoria.setSelection(categoriaPosition);
				quantidade.setText(String.valueOf(itemLista.getQtde()));
				precoItem.setText(String.valueOf(itemLista.getPrecoUnit()));
			} 
		}

		Button salvarButton = (Button) findViewById(R.id.button_salvar);
		salvarButton.setOnClickListener(this);

		Button cancelButton = (Button) findViewById(R.id.button_cancelar);
		cancelButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.button_salvar:
				
				if (itemLista == null){
					itemLista = new ItemLista();
				}
				
				itemLista.setNome(nome.getText().toString().toUpperCase());
				itemLista.setCategoria(categoria.getSelectedItem().toString());
				
				if (quantidade.getText().length() > 0){
					itemLista.setQtde(Integer.parseInt(quantidade.getText().toString()));
				}
				
				if (precoItem.getText().length() > 0){
					itemLista.setPrecoUnit(Double.parseDouble(precoItem.getText().toString()));
				}
				
				if (valorTotal.getText().length() > 0){
					itemLista.setPrecoTotal(Double.parseDouble(valorTotal.getText().toString()));
				}

				db.saveItem(itemLista);
				
				finish();
				break;
			case R.id.button_cancelar:
				finish();
				break;
		}
		
	}

	@Override
	public void afterTextChanged(Editable s) {
		if (quantidade.getText().toString().length() > 0 && precoItem.getText().toString().length() > 0 ){
			int quantidade = Integer.parseInt(this.quantidade.getText().toString());
			double valor = Double.parseDouble(precoItem.getText().toString());
			double valorTotal = valor * quantidade;
			
			this.valorTotal.setText(String.valueOf(valorTotal));
			
		}
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,int after) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
	}

}
