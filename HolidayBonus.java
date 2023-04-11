
public class HolidayBonus {
	
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonus = new double[data.length];
		
		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < data[i].length; k++) {
				if (data[i][k] > 0) {
					if (data[i][k] == TwoDimRaggedArrayUtility.getHighestInColumn(data, k))
						bonus[i] += high;
					else if (data[i][k] == TwoDimRaggedArrayUtility.getLowestInColumn(data, k))
						bonus[i] += low;
					else
						bonus[i] += other;
					}
			}
			
		}
		return bonus;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonus = new double[data.length];
		double sum = 0;
		
		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < data[i].length; k++)
				if (data[i][k] > 0) {
					if (data[i][k] == TwoDimRaggedArrayUtility.getHighestInColumn(data, k))
						bonus[i] += high;
					else if (data[i][k] == TwoDimRaggedArrayUtility.getLowestInColumn(data, k))
						bonus[i] += low;
					else
						bonus[i] += other;
				}
			
		}
		for (int i = 0; i < bonus.length; i++)
			sum += bonus[i];
		
		return sum;
	}
}