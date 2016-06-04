package org.onetwo.common.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.onetwo.common.excel.utils.ExcelUtils;
import org.springframework.util.Assert;

@SuppressWarnings({"rawtypes", "unchecked"})
public class DefaultRowMapperWorkbookReader extends DefaultPOIExcelReader implements WorkbookReader {

//	private File file;
//	private HSSFWorkbook workbook;
//	private WorkbookReader workbookReader;
	private ExcelDataExtractor<List<?>> dataExtractor; 
	
	
	public DefaultRowMapperWorkbookReader(SSFRowMapper<?> rowMapper) {
		super();
//		this.rowMapper = rowMapper;
		this.dataExtractor = new ListExcelDataExtractorImpl(rowMapper);
//		this.workbookReader = new DefaultWorkbookReader();
	}

	public <T> List<T> readFirstSheet(String path){
		Workbook workbook = createWorkbook(path);
		Map<String, List<?>> map = readData(workbook, 0, 1);
		return (List<T>)map.values().iterator().next();
	}
	
	public <T> List<T> readFirstSheet(File file){
		Workbook workbook = createWorkbook(file);
		Map<String, List<?>> map = readData(workbook, 0, 1);
		return (List<T>)map.values().iterator().next();
	}
	
	public <T> List<T> readFirstSheet(InputStream in){
		Workbook workbook = createWorkbook(in);
		Map<String, List<?>> map = readData(workbook, 0, 1);
		return (List<T>)map.values().iterator().next();
	}
	
	/*@Override
	public <T> List<T> readFirstSheet(InputStream in, boolean excel2007) {
		Workbook workbook = createWorkbook(in, excel2007);
		Map<String, List<?>> map = readData(workbook, 0, 1);
		return (List<T>)map.values().iterator().next();
	}*/

	public Map<String, List<?>> readData(String path){
		Workbook workbook = createWorkbook(path);
		return readData(workbook);
	}
	
	public Map<String, List<?>> readData(InputStream in){
		Assert.notNull(in);
		Workbook workbook = createWorkbook(in);
		return readData(workbook);
	}
	
	/*@Override
	public Map<String, List<?>> readData(InputStream in, boolean excel2007) {
		Assert.notNull(in);
		Workbook workbook = createWorkbook(in, excel2007);
		return readData(workbook);
	}*/

	public Map<String, List<?>> readData(File file){
		Assert.notNull(file);
		try {
			if(!file.exists()){
				throw new FileNotFoundException("文件不存在：" + file.getPath());
			}
			
			Workbook workbook = createWorkbook(file);
			
			return readData(workbook);
		} catch (Exception e) {
			throw ExcelUtils.wrapAsUnCheckedException("read excel file error.", e);
		}
	}


	public Map<String, List<?>> readData(String path, int startSheet, int readCount){
		Workbook workbook = createWorkbook(path);
		return this.readData(workbook, startSheet, readCount);
	}

	public Map<String, List<?>> readData(InputStream in, int startSheet, int readCount){
		Assert.notNull(in);
		Workbook workbook = createWorkbook(in);
		return this.readData(workbook, startSheet, readCount);
	}

	public Map<String, List<?>> readData(File file, int startSheet, int readCount){
		Assert.notNull(file);
		try {
			if(!file.exists()){
				throw new FileNotFoundException("文件不存在：" + file.getPath());
			}
			
			Workbook workbook = createWorkbook(file);
			
			return readData(workbook, startSheet, readCount);
		} catch (Exception e) {
			throw ExcelUtils.wrapAsUnCheckedException("read excel file error.", e);
		}
	}

	public Map<String, List<?>> readData(Workbook workbook){
		return readData(workbook, this.dataExtractor, -1, -1);
	}

	/*protected Map<String, List<?>> readData22(Workbook workbook, int startSheet, int endSheet){
		Assert.notNull(workbook);
		try {
			int sheetCount = workbook.getNumberOfSheets();
			Sheet sheet = null;
			Map<String, List<?>> datas = new LinkedHashMap<String, List<?>>();
			for(int i=0; i<sheetCount; i++){
				if((startSheet==-1 && endSheet==-1) || (i>=startSheet && i<endSheet)){
					sheet = workbook.getSheetAt(i);
					String name = sheet.getSheetName();
					if(sheet.getPhysicalNumberOfRows()<1)
						continue;
					if(StringUtils.isBlank(name))
						name = "" + i;
					List<?> dataList = readSheet(sheet, i);
					datas.put(name, dataList);
				}
			}
			return datas;
		} catch (Exception e) {
			throw new ServiceException("read excel file error.", e);
		}
	}*/
	
	public Map<String, List<?>> readData(Workbook workbook, int startSheet, int readCount){
		return this.readData(workbook, this.dataExtractor, startSheet, readCount);
	}
	

}
