package org.onetwo.ext.poi;

import java.util.Map;

@SuppressWarnings("unchecked")
public interface RowExecutor {

	public void process(Map context, RowModel field, Object value);

}
