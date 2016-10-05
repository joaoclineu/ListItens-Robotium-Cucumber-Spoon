package com.example.i7.listitens.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.i7.listitens.R;
import com.example.i7.listitens.obj.ItemLista;

public class ItemListaAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	private List<ItemLista> itens;
	
	public ItemListaAdapter(Context context, List<ItemLista> itens) {
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		this.itens = itens;
	}

	@Override
	public int getCount() {
		return itens.size();
	}

	@Override
	public ItemLista getItem(int position) {return itens.get(position);
	}

	@Override
	public long getItemId(int position) {
		return itens.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup root) {
		View view = convertView;

		if (view == null){
			view = inflater.inflate(R.layout.list_item, null);
		}

		ItemLista item = itens.get(position);

		TextView itemNome = (TextView) view.findViewById(R.id.text_view_nome_item_list);
		itemNome.setText(item.getNome());

		TextView itemQtde = (TextView) view.findViewById(R.id.text_view_quantidade);
		itemQtde.setText("Qtd.: " + item.getQtde());
		
		TextView itemTotalPreco = (TextView) view.findViewById(R.id.text_view_total_pagar);
		itemTotalPreco.setText("Total: " + item.getPrecoTotal());

		return view;
	}
	
	public void refreshList(List<ItemLista> itens) {
		this.itens = itens;
		notifyDataSetChanged();
	}

	
}
