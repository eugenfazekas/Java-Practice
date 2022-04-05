import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CubeTest {
	


	public static void main(String[] args) {
		
		Map<Integer,Integer> cube = new HashMap<>();
		
		for(int i = 0 ; i < 24; i++) {
			cube.put(i, 0);
		}

		int cycle = 0;
		
		int[]  test =  {0,4,17,8,22,12,1,5,19,9,20,13,2,6,16,10,23,14,3,7,18,11,21,15};
		//int[]  test2 = {1,5,18,9,23,13,2,6,20,10,21,14,3,7,17,11,24,15,4,8,19,12,22,16};
		
		while(!checkEndAll(cube)) {
			for (int i = 0; i < test.length; i++ ) {
				System.out.println("test2 "+test[2]+ "length: "+test.length);
				int cubeIndexValue  = cube.get(test[i]);
				int indexTemp = cubeIndexValue + 1;
				boolean loopCheck = false;
				
				while(loopCheck == false && indexTemp < 9) {
					System.out.println("cycle++: "+cycle++);
					System.out.println("loppcheck 1 "+ loopCheck);
					System.out.println("cubeIndexValue: "+cubeIndexValue);
					if(indexTemp < 9) {	
						cube.put(test[i], indexTemp);
						loopCheck = true;
						System.out.println("added i: "+test[i]+ " indexTemp: " + indexTemp);
						System.out.println("loppcheck 2 "+ loopCheck);
					}
	
					if(checkUniqueAll(cube) == false && indexTemp >0) {
						cube.put(test[i], cubeIndexValue );	
						loopCheck = false;
						System.out.println("restore i: "+test[i]+" with value: "+ cubeIndexValue);
					}
					indexTemp++;
				}
			}
		}
		
		System.out.println("cycle: "+cycle);
	 int[]  test1 = {1,2,3,4,5,6,7,0};
	 int[]  test2 = {0,0,0,0,0,0,0,0};

	}
	
	 static int[]  getArray1(Map<Integer,Integer> cube) {
		int[] array2 = new int[8];
		
		array2[0] = cube.get(1);
		array2[1] = cube.get(3);
		array2[2] = cube.get(5);
		array2[3] = cube.get(7);
		array2[4] = cube.get(9);
		array2[5] = cube.get(11);
		array2[6] = cube.get(13);	
		array2[7] = cube.get(15);	
		
		System.out.println("getArray1: "+Arrays.toString(array2));	
		
		return array2;
	}
	 
	
	 static int[]  getArray2(Map<Integer,Integer> cube) {
		int[] array1 = new int[8];
		
		array1[0] = cube.get(0);
		array1[1] = cube.get(2);
		array1[2] = cube.get(4);
		array1[3] = cube.get(6);
		array1[4] = cube.get(8);
		array1[5] = cube.get(10);
		array1[6] = cube.get(12);	
		array1[7] = cube.get(14);	
		
		System.out.println("getArray2: "+Arrays.toString(array1));	
		
		return array1;
	}
	

	
	 static int[] getArray3(Map<Integer,Integer> cube) {
		int[] array3 = new int[8];
		
		array3[0] = cube.get(0);
		array3[1] = cube.get(1);
		array3[2] = cube.get(17);
		array3[3] = cube.get(19);
		array3[4] = cube.get(11);
		array3[5] = cube.get(10);
		array3[6] = cube.get(22);	
		array3[7] = cube.get(20);	
		
		System.out.println("getArray3: "+Arrays.toString(array3));	
		
		return array3;
	}
	
	 static int[]  getArray4(Map<Integer,Integer> cube) {
		int[] array4 = new int[8];
		
		array4[0] = cube.get(2);
		array4[1] = cube.get(3);
		array4[2] = cube.get(16);
		array4[3] = cube.get(18);
		array4[4] = cube.get(9);
		array4[5] = cube.get(8);
		array4[6] = cube.get(23);	
		array4[7] = cube.get(21);	
		
		System.out.println("getArray4: "+Arrays.toString(array4));	
		
		return array4;
	}
	
	 static int[]  getArray5(Map<Integer,Integer> cube) {
		int[] array5 = new int[8];
		
		array5[0] = cube.get(4);
		array5[1] = cube.get(5);
		array5[2] = cube.get(16);
		array5[3] = cube.get(17);
		array5[4] = cube.get(15);
		array5[5] = cube.get(14);
		array5[6] = cube.get(20);	
		array5[7] = cube.get(21);	
		
		System.out.println("getArray5: "+Arrays.toString(array5));	
		
		return array5;
	}
	
	 static int[]  getArray6(Map<Integer,Integer> cube) {
		int[] array6 = new int[8];
		
		array6[0] = cube.get(6);
		array6[1] = cube.get(7);
		array6[2] = cube.get(18);
		array6[3] = cube.get(19);
		array6[4] = cube.get(13);
		array6[5] = cube.get(12);
		array6[6] = cube.get(22);	
		array6[7] = cube.get(23);	
		
		System.out.println("getArray6: "+Arrays.toString(array6));	
		
		return array6;
	}
	
	 static boolean uniqueCheck(int[] input) {
		boolean ret = true;
		for(int i = 0 ; i < input.length; i++) {
			for (int j = i + 1 ; j < input.length; j++ ) {
				if(input[i] == input[j] && input[j] != 0)
					return false;
			}
		}
		return ret;
	}
	 
	 static boolean endCheck(int[] input) {
		 int val = 0;
		 	for (int i = 0 ; i < input.length; i++) 
		 		val += input[i]; System.out.println(Arrays.toString(input));	 	
		 	return val == 36 ? true : false;
	 }
	 
	 static boolean checkEndAll(Map<Integer,Integer> cube) {
		 int counter = 0;
		 counter += CubeTest.endCheck(getArray1(cube)) ?  1 : 0;
		 counter += CubeTest.endCheck(getArray2(cube)) ?  1 : 0;
		 counter += CubeTest.endCheck(getArray3(cube)) ?  1 : 0;
		 counter += CubeTest.endCheck(getArray4(cube)) ?  1 : 0;
		 counter += CubeTest.endCheck(getArray5(cube)) ?  1 : 0;		 
		 counter += CubeTest.endCheck(getArray6(cube)) ?  1 : 0;
		 System.out.println("checkEndAll counter; " + counter);
		 System.out.println("checkEndAll counter; " + (counter == 6 ? true : false));
		return counter == 6 ? true : false; 
	 }
	 
	 static boolean checkUniqueAll(Map<Integer,Integer> cube) {
		 int counter = 0;
		 counter += CubeTest.uniqueCheck(getArray1(cube))  ? 1 : 0;
		 counter += CubeTest.uniqueCheck(getArray2(cube))  ? 1 : 0;
		 counter += CubeTest.uniqueCheck(getArray3(cube))  ? 1 : 0;
		 counter += CubeTest.uniqueCheck(getArray4(cube))  ? 1 : 0;
		 counter += CubeTest.uniqueCheck(getArray5(cube))  ? 1 : 0;
		 counter += CubeTest.uniqueCheck(getArray6(cube))  ? 1 : 0;
		 System.out.println("checkUniqueAll counter; " + counter);
		return counter == 6 ? true : false; 
	 }
}
