package org.onetwo.ext.poi;

import org.apache.poi.ss.usermodel.Workbook;
import org.onetwo.ext.poi.data.WorkbookData;
import org.onetwo.ext.poi.interfaces.TemplateGenerator;

public interface PoiExcelGenerator extends TemplateGenerator {
	public PropertyStringParser getPropertyStringParser();
//	public ExcelValueParser getExcelValueParser();
//	public void setExcelValueParser(ExcelValueParser excelValueParser);
	public Workbook getWorkbook();
	public WorkbookData getWorkbookData();

}