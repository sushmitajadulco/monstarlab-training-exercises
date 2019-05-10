package Array;

public class WorkingWithArrays {
	
	public static void main(String args []) {
		int input[] = {1, 5 , 8, 6, 2};
		int index = getMinDistance(input);
		System.out.println("index: " + index );
	}
	
	public static int getMinDistance(int [] input) {
		int min_distance = 0;
		int index = 0;
		for(int i=0; i<input.length-1 ; i++) {
			int d = input[i] - input[i+1];
			d = Math.abs(d);
			if(d < min_distance || i == 0) {
				min_distance = d;
				index = i;
			}	
		}
		return index;
	}
}
