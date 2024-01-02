package entities;

public class Produto implements GerenciamentoProduto{
	private String nome;
	private Integer codigo;
	private Double price;
	private Integer quantidadeEstoque;
	
	public Produto(){
	}

	public Produto(String nome, Integer codigo, Double price, Integer quantidadeEstoque) {
		this.nome = nome;
		this.codigo = codigo;
		this.price = price;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEsoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	@Override
	public void produtosComprados(int qtProdutosComparados) {
		quantidadeEstoque += qtProdutosComparados;
	}
	
	@Override
	public void produtosVendidos(int qtProdutosVendidos) throws CauseException {
		
		if(quantidadeEstoque < qtProdutosVendidos) {
			throw new CauseException("ERROR! Não tem estoque suficiente !!!");
		}
		else {
			quantidadeEstoque -= qtProdutosVendidos;
		}
	}
	
}
