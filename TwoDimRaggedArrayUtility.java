import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility {

	public static double getAverage(double[][] data) {
		int counter = 0;
		double sum = 0;
		
		for (int i = 0; i < data.length; i++)
			for (int k = 0; k < data[i].length; k++) {
				counter++;
				sum += data[i][k];
			}
		return sum / counter;
	}

	public static double getColumnTotal(double[][] data, int col) {
		double sum = 0.0;

		for (int i = 0; i < data.length; i++) {
			if ( col < data[i].length) {
				sum += data[i][col];
			}
		}	
		return sum;
	}

	public static double getHighestInArray(double[][] data) {
		double highest = data[0][0];
		
		for (int i = 0; i < data.length; i++)
			for (int k = 0; k < data[i].length; k++) 
				if (data[i][k] > highest)
					highest = data[i][k];
		
		return highest;
	}

	public static double getHighestInColumn(double[][] data, int col) {
		double highestColumn = Double.MIN_VALUE;
		
		for (int i = 0; i < data.length; i++)
			if (col < data[i].length) {
				if (data[i][col] > highestColumn) 
					highestColumn = data[i][col];
			}
		return highestColumn;
	}

	public static int getHighestInColumnIndex(double[][] data, int col) {
		int highestColumnIndex = 0;
		double highest = data[0][col];
		
		for (int i = 0; i < data.length; i++)
			if (col < data[i].length)
				if (data[i][col] > highest) {
					highest = data[i][col];
					highestColumnIndex = i;
				}
			
		return highestColumnIndex;
	}

	public static double getHighestInRow(double[][] data, int row) {
		double highestRow = data[row][0];
		
		for (int i = 0; i < data[row].length; i++) 
			if (data[row][i] > highestRow) 
				highestRow = data[row][i];
		
		return highestRow;
	}

	public static int getHighestInRowIndex(double[][] data, int row) {
		double highest = data[row][0];
		int highestRowIndex = 0;
		
		for (int i = 0; i < data[row].length; i++) 
			if (data[row][i] > highest)  {
				highest = data[row][i];
				highestRowIndex = i;
			}
		
		return highestRowIndex;
	}

	public static double getLowestInArray(double[][] data) {
		double lowest = data[0][0];
		
		for (int i = 0; i < data.length; i++)
			for (int k = 0; k < data[i].length; k++)
				if (data[i][k] < lowest)
					lowest = data[i][k];
		
		return lowest;
	}
	

public static double getLowestInColumn(double[][] data, int col) {
	double lowestColumn = Double.MAX_VALUE;
	for (int i = 0; i < data.length; i++)
		if (col < data[i].length) {
			if (data[i][col] < lowestColumn) 
				lowestColumn = data[i][col];
		}
	return lowestColumn;
}

public static int getLowestInColumnIndex(double[][] data, int col) {
	int lowestColumnIndex = 0;
	double lowest = data[0][col];
	for (int i = 0; i < data.length; i++)
		if (col < data[i].length)
			if (data[i][col] < lowest) {
				lowest = data[i][col];
				lowestColumnIndex = i;
			}
	return lowestColumnIndex;
}

public static double getLowestInRow(double[][] data, int row) {
	double lowestRow = data[row][0];
	for (int i = 0; i < data[row].length; i++) 
		if (data[row][i] < lowestRow) 
			lowestRow = data[row][i];
	return lowestRow;
}

public static int getLowestInRowIndex(double[][] data, int row) {
	double lowest = data[row][0];
	int lowestRowIndex = 0;
	for (int i = 0; i < data[row].length; i++) 
		if (data[row][i] < lowest)  {
			lowest = data[row][i];
			lowestRowIndex = i;
		}
	return lowestRowIndex;
}

public static double getRowTotal(double[][] data, int row) {
	double sum = 0.0;
	
	for (int i = 0; i < data[row].length; i++) {
		sum += data[row][i];
	}	
	return sum;
}

public static double getTotal(double[][] data) {
	double sum = 0.0;
	
	for (int i = 0; i < data.length; i++)
		for (int k = 0; k < data[i].length; k++) {
			sum += data[i][k];
		}	
	return sum;
}

public static double[][] readFile(java.io.File file) {
	double[][] data = new double[0][];
	String nextLine;
	int numRows = 0;
	Scanner dataReader;
	
	try {
	    dataReader = new Scanner(file);
	    while (dataReader.hasNextLine()) {
	        numRows++;
	        dataReader.nextLine();
	    }
	    dataReader.close();
	    dataReader = new Scanner(file);
	    data = new double[numRows][];
	    for (int i = 0; i < numRows; i++) {
	        String[] nextNumbers;
	        nextLine = dataReader.nextLine();
	        nextNumbers = nextLine.split(" ");
	        data[i] = new double[nextNumbers.length];
	        for (int k = 0; k < nextNumbers.length; k++) {
	            data[i][k] = Double.parseDouble(nextNumbers[k]);
	        }
	    }
	} catch (FileNotFoundException fileNotFoundException) {
	    fileNotFoundException.printStackTrace();
	}
	return data;
	}
	
	public static void writeToFile(double[][] data, java.io.File outputFile) {
		try {			
			FileWriter fileWriter = new FileWriter(outputFile);			
			for (int i = 0; i < data.length; i++) {
				for(int k = 0; k < data[i].length; k++) {
					fileWriter.write(data[i][k] + " ");
				}				
				fileWriter.write('\n');
			}
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}