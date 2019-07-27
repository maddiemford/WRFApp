import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

public class Task {

	private static DataFormatter dataFormatter;
	private Row row;
	private String task;
	private String client;
	private String plaintiff;
	private String caseNo;
	private boolean isDone;
	private String date;
	private int rowNum;
	
	public Task(Row r) {
		dataFormatter = new DataFormatter();
		row = r;
		if (r != null) {
			task = dataFormatter.formatCellValue(r.getCell(8));
			client = dataFormatter.formatCellValue(r.getCell(2)) + ", " + dataFormatter.formatCellValue(r.getCell(3));
			plaintiff = dataFormatter.formatCellValue(r.getCell(5));
			caseNo = dataFormatter.formatCellValue(r.getCell(6));
			if (dataFormatter.formatCellValue(r.getCell(11)).equals("y")) {
				isDone = true;
			} else isDone = false;
			date = dataFormatter.formatCellValue(r.getCell(10));
			rowNum = row.getRowNum() + 1;
		}
	}
	
	public String getTask() {
		return task;
	}
	
	public String getClient() {
		return client;
	}
	
	public String getPlaintiff() {
		return plaintiff;
	}
	
	public String getCaseNo() {
		return caseNo;
	}
	
	public boolean isDone() {
		return isDone;
	}
	
	public int getRowNum() {
		return rowNum;
	}
	
	public void setDone(boolean done) {
		isDone = done;
	}
	
	public String toString() {
		return "";
	}
}
