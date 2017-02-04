import java.util.Scanner;

class A5{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);

		System.out.println("Enter the first String:");
		String s1=scan.nextLine();

		System.out.println("Enter the replacement String:");
		String s2=scan.nextLine();

		if(s1.indexOf('*')==-1){
			System.out.println("Error: No *");
			return;
		}

		String chr;
		int sc=0;
		int index = s1.indexOf("*");

		String s3,s4,s5;

		if(index==-1){
			System.out.println("Error: no *");
			return;
		}

		for(int i=0;i<s1.length()-1;i++){
			chr=s1.substring(i,i+1);

			if(chr.equals("*")){
				sc++;
				if(sc>=2){
					System.out.println("Error: No *");
					return;
				}
				continue;
			}
			if(chr.equals(" ")||chr.equals("\t")){
				continue;
			}
			if(chr.toUpperCase().equals(chr.toLowerCase())){
				System.out.println("Error: Incorrect characters");
				return;
			}
		}

		if(index==s1.length()-1){
			s4=s1.substring(0,s1.length()-1);
			s5=s4.concat(s2);
		}
		else if (index==0){
			s4=s1.substring(1,s1.length());
			s5=s2.concat(s4);
		}
		else{
			s3=s1.substring(0,index);
			s4=s1.substring(index+1,s1.length());
			s5=s3.concat(s2);
			s5=s5.concat(s4);
		}

		System.out.println(s5); 
		
	}
}