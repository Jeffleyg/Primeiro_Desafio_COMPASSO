package entities;

public interface GerenciamentoProduto {
	void produtosComprados(int qtProdutosComprados);
	void produtosVendidos(int qtProutosVenditos) throws CauseException;
}
