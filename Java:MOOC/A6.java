import java.util.Scanner;

class A6{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int i;

		int input=0;
		int first_size=0;
		int second_size=0;
		int[] first_array=new int[10000];
		int[] second_array=new int[10000];

		System.out.println("Enter the values for the first array, up to 10000 values, enter a negative number to quit");
		while(true){
			input=scan.nextInt();
			if(input<0)break;
			first_array[first_size]=input;
			first_size++;
		}

		input=0;

		System.out.println("\nEnter the values for the second array, up to 10000 values, enter a negative number to quit");
		while(true){
			input=scan.nextInt();
			if(input<0)break;
			second_array[second_size]=input;
			second_size++;
		}

		System.out.println("\n\nFirst Array: ");
		for(i=0;i<first_size;i++){
			System.out.print(first_array[i]+" ");
		}
		System.out.println("\n\nSecond Array: ");
		for(i=0;i<second_size;i++){
			System.out.print(second_array[i]+" ");
		}

		

		for(i=1;i<first_size;i++){
			if(first_array[i]<first_array[i-1]){
				System.out.println("\n\nERROR: Array not in correct order");
				return;
			}
		}
		for(i=1;i<second_size;i++){
			if(second_array[i]<second_array[i-1]){
				System.out.println("\n\nERROR: Array not in correct order");
				return;
			}
		}

		System.out.println("\n\nMerged Array:");

		int total_length=first_size+second_size;
		int[] third_array=new int[total_length];

		int first_count=0;
		int second_count=0;

		int fi=0;
		int si=0;

		for(i=0;i<total_length;i++){
			fi=first_array[first_count];
			si=second_array[second_count];
			System.out.println(fi+" "+si+" "+first_count+" "+second_count);
			if(fi<si){
				third_array[i]=fi;
				first_count++;
			}else if(fi>si){
				third_array[i]=si;
				second_count++;
			}else if(fi==si){
				third_array[i]=fi;
				first_count++;
			}
			
		}
		for(i=0;i<total_length;i++){
			System.out.print(third_array[i]+" ");
		}


	}
}