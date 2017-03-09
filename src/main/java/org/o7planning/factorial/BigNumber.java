package org.o7planning.factorial;

import java.math.BigInteger;

public class BigNumber {
	private long num;
	private String numStr;
	private BigInteger numBig;
	
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getNumStr() {
		return numStr;
	}
	public void setNumStr(String numStr) {
		this.numStr = numStr;
	}
	public BigInteger getNumBig() {
		return numBig;
	}
	public void setNumBig(BigInteger numBig) {
		this.numBig = numBig;
	}
	
	public BigNumber(long n) {
		BigInteger a = new BigInteger(String.valueOf(n));
		while (n>1) {
			--n;
			a = a.multiply(new BigInteger(String.valueOf(n)));
		}
		
		this.numBig = a;
		this.numStr = String.valueOf(a);
		this.num = n;
	}

}
