package vehicle_rental_system;

public class Car extends Vehicle{
	
	private int safetyRating;
	private final static double COST_PER_DAY_LESS = 20.0;
	private final static double COST_PER_DAY_MORE = 15.0;

	public Car(String brand, String model, int value, int safetyRating) {
		super(brand, model, value, COST_PER_DAY_LESS, COST_PER_DAY_MORE);
		this.safetyRating = safetyRating;
	}

	public int getSafetyRating() {
		return safetyRating;
	}

	public void setSafetyRating(int safetyRating) {
		this.safetyRating = safetyRating;
	}
	
	@Override
	public double getRentalCostForSingleDay(int numberOfRentalDays) {
		return numberOfRentalDays >= 7 ? COST_PER_DAY_MORE : COST_PER_DAY_LESS;
	}

	@Override
	public double calculateTotalInsurance(int numberOfRentalDays) {
		
		double  insurancePerDay= getInsuranceCostForSingleDay();
		
		System.out.println("Insurance per day: $" + insurancePerDay + "\n" );
		
		double fullInsurancePrice = insurancePerDay * numberOfRentalDays;
		
		if(safetyRating >= 4) {
			return fullInsurancePrice - fullInsurancePrice * 0.10 ;  
		}
		
		return fullInsurancePrice;
	}

	@Override
	public double getInsuranceCostForSingleDay() {
		//0.01% of the value of car
		return 0.0001 * value; 
	}
	
	
	
	
	
}
