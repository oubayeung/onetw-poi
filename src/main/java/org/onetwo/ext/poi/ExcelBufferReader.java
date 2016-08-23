package org.onetwo.ext.poi;

public interface ExcelBufferReader<T> {

	void initReader();
	T read();
	public int getCurrentRowNumber();
	boolean isEnd();

}