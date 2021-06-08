package com.kodlamaIO.hmrs.core.utilities.results;

// <T> ile DataResult'a döndericeği veri tipinin ne olduğunu söylüyoruz.
//Birden fazla veritipi ile çalışacağızımı icin jenerik bir tip kullanıyoruz t de bunu temsil ediyor sanırım
public class DataResult<T> extends Result{

	private T data;
	
	public DataResult(T data, boolean succes, String message) {
		super(succes, message);
		this.data = data;
	}


	public DataResult(T data,boolean success) {
		super(success);
		this.data = data;
	}

	public T getData() {
		return this.data;
	}

	
}
