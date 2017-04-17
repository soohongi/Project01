package io;

import java.io.Serializable;

public class SerData implements Serializable {

	
	int sum;
	private static final long serialVersionUID = 1234L;
	//String str;
	int kor;
	int eng;
	int mat;
	/**
	 * @param str
	 * @param cnt
	 */
	public SerData(/*String str, */int kor, int eng, int mat) {
		//this.str = str;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
		//cal();
	}
	
	 /*void cal()
	 {
		 this.sum+=kor+eng+mat;
	 }*/
	
	@Override
	public String toString() {
		return /*"SerData [str=" + str + */" kor=" + kor + ", eng=" + eng + ", mat=" + mat + sum+"]";
	}
	
	
	
}
