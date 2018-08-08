package MyPractice;

import util.Xls_Reader;

public class PlayWithExcel {

	public static void main(String[] args) {


			//Xls_Reader reader = new Xls_Reader("C:\\Users\\Madhu X1_Tab\\Downloads\\Compressed\\"
			//		+ "JuneSeleniumSessions-master\\src\\main\\java\\testdata\\TestData.xlsx");
		// for Work Computer
		Xls_Reader reader = new Xls_Reader("L:\\git\\WorkBeforePOM\\JuneSeleniumSession_Naveen\\src\\main\\"
				+ "java\\testdata\\FreeCrmTestData.xlsx");	
		
			String sheetName = "login";
			
			int myRows = reader.getRowCount(sheetName);
			
			System.out.println("The number of rows: " + myRows);
			
			
		
	}

}
