package api.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;


import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import com.opencsv.exceptions.CsvException;

public class DataProviders {

	@DataProvider(name = "Data")
	public static Iterator<String[]> data() throws IOException, CsvException {
		List<String[]> list=null;
		
			list = new CSVReaderBuilder(new BufferedReader(new FileReader(System.getProperty("user.dir")+"/testData/Userdata.csv"))).withSkipLines(1).withFieldAsNull(CSVReaderNullFieldIndicator.BOTH).build().readAll();
			
		return list.iterator();

	}
	
	@DataProvider(name = "UserNames")
	public static Iterator<String[]> UserNames() throws IOException, CsvException {
		List<String[]> list=null;
		
			list = new CSVReaderBuilder(new BufferedReader(new FileReader(System.getProperty("user.dir")+"/testData/userName.csv"))).withSkipLines(1).withFieldAsNull(CSVReaderNullFieldIndicator.BOTH).build().readAll();
			
		return list.iterator();

	}

	@DataProvider (name="Data1")
	public String[] [] getAllData() throws IOException{


		String path=System.getProperty("user.dir")+"/testData/Userdata.xlsx"; 
		XLUtility xl=new XLUtility(path);


		int rownum=xl.getRowCount("Sheet1");

		int colcount=xl.getCellCount("Sheet1", 1);

		String apidata[][]=new String[rownum] [colcount];


		for(int i=1;i<=rownum;i++){

			for(int j=0;j<colcount;j++){

				apidata[i-1][j]= xl.getCellData ("Sheet1", i, j);
			}


		}

		return apidata;

	}


	@DataProvider (name="UserNames1")

	public String[] getUserNames() throws IOException{

		String path=System.getProperty("user.dir")+"/testData/Userdata.xlsx";

		XLUtility xl=new XLUtility(path);

		int rownum=xl.getRowCount("Sheet1");

		String apidata[]=new String[rownum];

		for(int i=1;i<=rownum;i++) {

			apidata[i-1]= xl.getCellData("Sheet1", i, 1);

		}

		return apidata;



	}

}



