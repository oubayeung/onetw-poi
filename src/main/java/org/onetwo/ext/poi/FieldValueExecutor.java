package org.onetwo.ext.poi;

import org.onetwo.ext.poi.data.CellContextData;


public interface FieldValueExecutor {
	
	public boolean apply(CellContextData cellContext, ExecutorModel executorModel);
	
	public Object execute(CellContextData cellContext, ExecutorModel executorModel, Object preResult);

}
