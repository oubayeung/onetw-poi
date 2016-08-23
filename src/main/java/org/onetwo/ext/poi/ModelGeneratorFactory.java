package org.onetwo.ext.poi;

import java.util.Map;

import org.onetwo.ext.poi.interfaces.TemplateGenerator;

public interface ModelGeneratorFactory {
	public TemplateGenerator create(WorkbookModel workbook, Map<String, Object> context);
}
