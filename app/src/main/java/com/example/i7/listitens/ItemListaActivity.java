package com.example.i7.listitens;

import java.util.List;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.example.i7.listitens.adapter.ItemListaAdapter;
import com.example.i7.listitens.banco.BancoDeDados;
import com.example.i7.listitens.obj.ItemLista;

public class ItemListaActivity extends ListActivity implements OnItemLongClickListener {

	private BancoDeDados db;
	private List<ItemLista> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//inicia conexao com o banco de dados
		db = new BancoDeDados(this);
		
		adapter = db.getAllItens();
		
		setListAdapter(new ItemListaAdapter(this, adapter));
		getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

		getListView().setOnItemLongClickListener(this);
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		adapter = db.getAllItens();
		
		((ItemListaAdapter) getListAdapter()).refreshList(adapter);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		
			case R.id.item_menu_adicionar_novo:
				startActivity(new Intent(this, ItemDetalheActivity.class));
				break;
		}
		
		return super.onOptionsItemSelected(item);
	}
	

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		ItemLista item = ((ItemListaAdapter) getListAdapter()).getItem(position);
		Intent intent = new Intent(this, ItemDetalheActivity.class);
		intent.putExtra("item_compra", item);
		
		startActivity(intent);
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> l, View v, int position, long id) {
		final ItemListaAdapter adapter = (ItemListaAdapter) getListAdapter();
		
		// Pega o item escolhido da Lista
		final ItemLista item = adapter.getItem(position);

		AlertDialog.Builder alert = new AlertDialog.Builder(this);

		alert.setTitle("Remover Item");
		alert.setMessage("Deseja remover este Item ?");

		alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				db.deleteItem(item);
				
				ItemListaActivity.this.adapter = db.getAllItens();
				
				adapter.refreshList(ItemListaActivity.this.adapter);
				
				// Fecha o Dialog
				dialog.dismiss();
			}
		});

		alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				// Fecha o Dialog
				dialog.dismiss();
			}
		});

		alert.show();

		return false;
	}

}
