import java.util.Scanner;

class A4
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter a tweet:");
		String tweet = scan.nextLine();
		int tweetlen = tweet.length();
		if(tweetlen - 140 > 0)
		{
			System.out.println("Excess Characters: "+(tweetlen - 140));
		}
		else
		{
			System.out.println("Length Correct");

			int h=0;
			int m=0;
			int l=0;

			for(int i=0;i<tweetlen-1;i++)
			{
				if(i==tweetlen-1)break;
				char ch = tweet.charAt(i);
				switch(ch)
				{
					case '#':
					if(tweet.charAt(i+1)!=' '&&tweet.charAt(i+1)!='\t')h++;
					break;
					case '@':
					if(tweet.charAt(i+1)!=' '&&tweet.charAt(i+1)!='\t')m++;
					break;
					case 'h':
					case 'H':

					if(i>=tweetlen-7)break;
					String sub=tweet.substring(i,i+7);

					String t=sub.toLowerCase();

					if(t.equals("http://"))l++;
					
					break;
					default:
					continue;
				}
			}

			System.out.println("Number of Hashtags:"+h+"\nNumber of Attributions:"+m+"\nNumber of Links:"+l);
		}

	}
}