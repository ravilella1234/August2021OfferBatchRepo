package excelDataDrivens;

public class DataDemo 
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e1 = new ExcelAPI("C:\\Users\\ravi\\Desktop\\testdata1.xlsx");
		
		System.out.println(e1.getRowCount("login"));
		
		System.out.println(e1.columnCount("login"));
		
		System.out.println(e1.getCellData("login", 0, 1));
		
		System.out.println(e1.getCellData("login", "Password", 1));
		
		e1.setCellData("login", 4, 4, "failed");

	}

}
