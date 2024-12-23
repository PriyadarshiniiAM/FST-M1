package activities;

@FunctionalInterface
interface Addable {
    int add(int a, int b);
	
}
		public class Activity12 {
		    public static void main(String[] args) {
		    	
		        // Lambda expression with return keyword.
		        Addable addObj = (int a, int b) -> {
		            return (a + b);
		        };
		        System.out.println(addObj.add(20, 10));
		    }
		}

