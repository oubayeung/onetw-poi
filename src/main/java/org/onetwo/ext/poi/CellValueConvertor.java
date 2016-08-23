package org.onetwo.ext.poi;

import org.apache.poi.ss.usermodel.Cell;

public interface CellValueConvertor {

	public Object convert(Cell cell);
}
