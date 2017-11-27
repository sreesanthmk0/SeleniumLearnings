package trial_DRC_Release1_HISS;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TC_Report {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		File[] files = new File("E:\\TCoE_VG_Share\\OQ Scripts\\Testing\\").listFiles();
		for(File file : files) {
			FileInputStream fis = new FileInputStream("E:\\TCoE_VG_Share\\OQ Scripts\\Testing\\" + file.getName());
		
			Workbook wb = WorkbookFactory.create(fis);
		
			int counter;
			for(int i=0; i<wb.getNumberOfSheets();i++) {
				counter=0;
				System.out.print(file.getName() + "--" + wb.getSheetAt(i).getSheetName()+"--");
				for(int j=1; j<50; j++) {
					try {
						if(wb.getSheetAt(i).getRow(j).getCell(1).getStringCellValue() == "")
							break;
					}
					catch(Exception e) {}
					counter = counter + 1;
				}
				System.out.println(counter);
				
			}
				
		}
	}
}
