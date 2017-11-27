package trial_DRC_Release1_HISS;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class WordDocHandling {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		String fileName = "E:\\Trials.docx";
		new File(fileName).createNewFile();
		FileOutputStream fis1 = new FileOutputStream(fileName);
		
		XWPFDocument doc = new XWPFDocument();
		XWPFParagraph paragraph = doc.createParagraph();
		
		paragraph.createRun().setBold(true);
		
		paragraph.createRun().setText("Test Case");
		XWPFTable table = doc.createTable();
		table.getRow(0).getCell(0).setText("Step Name");
		table.getRow(0).addNewTableCell().setText("Description");
		table.getRow(0).addNewTableCell().setText("Expected");
		table.getRow(0).addNewTableCell().setText("Actual");
		table.getRow(0).addNewTableCell().setText("Result");
		XWPFTableRow row2 = table.createRow();
		row2.getCell(0).setText("Step0");
		row2.getCell(1).setText("Prerequisite");
		row2.getCell(2).setText("User should");
		row2.getCell(3).setText("NA");
		row2.getCell(4).setText("PASS");
		
				
		/*BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "jpg", new File("E:\\DIM-DRC\\SPRINT WORK ITEMS\\SP_1732 [08AUG2017 - 21AUG2017]\\screenshot.jpg"));
			
		java.nio.file.Files.copy(Paths.get("E:\\DIM-DRC\\SPRINT WORK ITEMS\\SP_1732 [08AUG2017 - 21AUG2017]\\screenshot.jpg"), Paths.get("E:\\DIM-DRC\\SPRINT WORK ITEMS\\SP_1732 [08AUG2017 - 21AUG2017]\\screenshot.jpg"));
	    
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		ImageIO.write(cb.getData(DataFlavor.imageFlavor), formatName, output) 
		
		*/
		doc.write(fis1);
		doc.close();
		fis1.close();
		
	}

}
