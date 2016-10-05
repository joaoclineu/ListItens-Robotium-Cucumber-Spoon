package com.example.i7.listitens.obj;


public class ItemLista extends AbstractBean {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String categoria;
	private int qtde;
	private double precoUnit;
	private double precoTotal;

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(final String categoria) {
		this.categoria = categoria;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(final int qtde) {
		this.qtde = qtde;
	}

	public double getPrecoUnit() {
		return precoUnit;
	}

	public void setPrecoUnit(double precoUnit) {
		this.precoUnit = precoUnit;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}
}
