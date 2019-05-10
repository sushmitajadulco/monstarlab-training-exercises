package PerfectNumber;

public class PerfectNumbers {
	
	
	public static boolean isPerfectNumber(int num) {
		int divisors [] = getDivisors(num);
		int sum=0;
		for(int i=0; i<divisors.length; i++) {
			sum += divisors[i];
		}
		if( (sum == num) && ((sum+num)/2 == num)) {
			return true;
		}
		return false;
	}
	
	private static int [] getDivisors(int num) {
		int [] divisors = new int[num/2];
		divisors[0] = 1;
		int j=1;
		for(int i=2; i<=num/2; i++, j++) {
			if(num % i == 0) {
				divisors[j] = i;
			}
		}
		return divisors;
	}
}
