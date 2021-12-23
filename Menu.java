import java.io.*;
import java.util.*;
import javax.swing.*;

public class Menu {
	GetSetInput get = new GetSetInput();
	GetSetInput set = new GetSetInput();
	String outputFilePath = get.getFilePath();

	int row = get.getRowInput();
	int col = get.getColInput();
	String menu = get.getMenu();
	String searchString = get.getSearchString();

	Generator generate = new Generator();
	TableData newTable = new TableData();
	LinkedHashMap<String, String> table = newTable.getTable();
	
	public void menuSearch() throws FileNotFoundException {
		set.setSearchString();
		newTable.splitTable();
		newTable.searchArray();
	}

	public void menuEdit() throws FileNotFoundException {
		set.setRowEdit();
		set.setColEdit();
		set.setEditOption();

		Scanner scan = new Scanner(newTable.getFile());
		// find cell to replace
		for (int rowCount = 0; rowCount < row; rowCount++) {
			for (int colCount = 0; colCount < col; colCount++) {
				if (rowCount == get.getRowEdit() && colCount == get.getColEdit()) {
					set.setEditKey(scan.nextLine().substring(0,3)); // get key from index
					break;
				} else scan.nextLine();
	  		}
	  		if (rowCount == get.getRowEdit()) break;			
		}
	
		switch (get.getEditOption()) {
			case "key":
				newTable.splitTable();
				newTable.editKey();
				newTable.writeToTableNewKey();
				break;
			case "value":
				newTable.editValue();
				break;
			default:
				menuDefault();
				menuExit();
				break;
		}
		newTable.writeToFile();
		newTable.printTable();
	}

	public void menuAddRow() throws FileNotFoundException {
		// generate and append additional row to hashmap
		for (int rowCount = 0; rowCount < 1; rowCount++) {
			for (int colCount = 0; colCount < col; colCount++) {
				table.put(generate.threeCharGenerator(), generate.threeCharGenerator());
			}
		}
		// rewrite table to file
		newTable.writeToFile();
		newTable.printTable();
	}

	public void menuSortRow() throws FileNotFoundException {
		// concatenate and sort
		newTable.concatTable();
		newTable.sortTable();
		newTable.writeToTable(); // rewrite sorted data to 

		// reprint table
		newTable.writeToFile();
		newTable.printTable();
	}

	public void menuExit() {
		System.exit(0);
	}

	public void menuDefault(){
		System.out.println("Not a valid option.");
		menu = "reset";
	}
}