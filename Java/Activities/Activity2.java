package activities;

public class Activity2 {
	public static void main(String[] args) {
	//Create the object for the class
	Activity2 actObj = new Activity2();
	//Create the integer array
	int[] nums= {10,77,55,10,-20,10};
	
	//set the number to search for
	int searchNum = 10;
	int fixedSum = 30;
	
	//Call the result function and print the result
	System.out.println("Result: "+actObj.result(nums,searchNum,fixedSum));
	}
	public boolean result(int[] nums, int searchNum, int fixedSum) {
	//Temp variable to hold the calculated sum
		int tempSum = 0;
		
	//Loop through the array to calculate sum
	for(int number : nums) {
		//check if the value is the searchNum
		if(number ==searchNum) {
			//Add the Value
			tempSum += searchNum;
		}
		//Check if tempSum is greater than fixedsum
		if(tempSum > fixedSum) {
			//condition fails, break loop
			break;
		}
	}
	return fixedSum == tempSum;
	}
}
