
public class Unio {

	public static void main(String[] args) {
	
int [] tomb1 = {2,3,4,5,1,10,7,8,9,6};

int[] tomb2 = {44,5,13,10,7,12,14,61};

int[] tomb3 = new int [100];

int z = tomb1.length;

for(int i = 0 ; i < tomb1.length ; i++)
	
	tomb3[i] = tomb1[i];

for(int j = 0 ; j < tomb2.length ; j++) {
	
	int i = 0;
	
	while(i < tomb1.length && tomb1[i] != tomb2[j])
		i++;
	 
	if( i >= tomb1.length ) {
		
		tomb3[z++] = tomb2[j];
		
			}
	}
	
for(int v = 0 ; v < tomb3.length; v++)
	
	if(tomb3[v] > 0)
	System.out.print(tomb3[v]+" ");
	}
} // 2 3 4 5 1 10 7 8 9 6 44 13 12 14 61 
