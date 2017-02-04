import java.util.Scanner;
import java.lang.*;

class A7{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter a base ten number between 0 and 255, inclusive.");
		int[] arr1=convertToBinary(scan.nextInt());
		System.out.println("Enter a base ten number between 0 and 255, inclusive.");
		int[] arr2=convertToBinary(scan.nextInt());

		System.out.println("\nFirst binary number:");
		printBin(arr1);

		System.out.println("\nSecond binary number:");
		printBin(arr2);

		System.out.println("\nAdded:");
		printBin(addBin(arr1,arr2));

		System.out.println(" ");
		return;
	}
	static int[] convertToBinary(int b){
		int[] results = new int [8];
		int p;
		for(int i=7;i>=0;i--){
			p=(int)Math.pow(2,i);
			if(p<=b){
				b-=p;
				results[7-i]=1;
			}
			else{
				results[7-i]=0;
			}
		}
		return results;
	}
	static int[] addBin(int a[],int b[]){

		int add=0;
		int[] results=new int[8];
		int x;

		for(int count=7;count>=0;count--){
			x=a[count]+b[count]+add;
			switch(x){
				case 0:
				results[count]=0;
				add=0;
				break;
				case 1:
				results[count]=1;
				add=0;
				break;
				case 2:
				results[count]=0;
				add=1;
				break;
				case 3:
				results[count]=1;
				add=1;
				break;
			}
		}

		return results;
	}

	static void printBin(int b[]){
		for(int i:b)System.out.print(i+" ");
		return;
	}
}