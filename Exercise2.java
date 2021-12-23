import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Exercise2 {
	public static void main(String[] args) throws FileNotFoundException {
		try {
		String menu;
		do {
		GetSetInput set = new GetSetInput();
		GetSetInput get = new GetSetInput();

		set.setFilePath();

		// get dimensions
		set.setRowInput();
		set.setColInput();

		// table data
		TableData table = new TableData();
		table.resetTable();
		table.keyValue();
		table.writeToFile();
		table.printTable();

		// get menu input
		set.setMenu();
		Menu choose = new Menu();
		menu = get.getMenu();

		switch (menu){
			case "1":
				choose.menuSearch();
				break;

			case "2":
				choose.menuEdit();
				break;

			case "3":
				table.printTable();
				break;

			case "4":
				choose.menuAddRow();
				break;

			case "5":
				choose.menuSortRow();
				break;

			case "6":
				break;

			case "7":
				choose.menuExit();
				break;
			default:
				choose.menuDefault();
		}
		}
		while (menu.equals("6"));
		} catch (Exception e) {
			System.out.println("Invalid input.");
			e.printStackTrace();
		}
	}
}