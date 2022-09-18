package nivel2_sigmageek;

import java.math.BigInteger;

public class Combinacao9 {
	int[] combinacao = new int[9];
	BigInteger soma = BigInteger.valueOf(0);
	public int[] getCombinacao() {
		return combinacao;
	}
	public void setCombinacao(int[] combinacao) {
		this.combinacao = combinacao;
	}
	public void somaPosiçoes() {
		int n=0;
		for(int i=0;i<9;i++) {
			BigInteger mult = BigInteger.valueOf(this.combinacao[i]*n);
			this.soma=this.soma.add(mult);
			n=n*10;
		}
	}
	public BigInteger getSoma() {
		return soma;
	}
	public void setSoma(BigInteger soma) {
		this.soma = soma;
	}
	
}
