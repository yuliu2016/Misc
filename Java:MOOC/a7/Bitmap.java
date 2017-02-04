import java.lang.*;
public class Bitmap
{
	String image[][];

	Bitmap(int a[]){
		this.image=new String[10][10];
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				this.image[i][j]="-";
			}
		}
		boolean ok=true;
		for(int k:a){
			if(k>9||k<0){
				ok=false;
			}
		}
		if(a.length%2!=0){
			ok=false;
		}
		if(ok){
			for(int ii=0;ii<a.length;ii+=2){
				this.image[a[ii]][a[ii+1]]="*";
			}
		}
	}

	public String toString(){
		String result="";
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				result+=this.image[i][j].toString();
			}
			result+="\n";
		}
		return result;
	}
	public void flipHorizontal(){
		String temp;
		for(int i=0;i<10;i++){
			for(int j=0;j<5;j++){
				temp=this.image[i][9-j];
				this.image[i][9-j]=this.image[i][j];
				this.image[i][j]=temp;
			}
		}
	}
	public void flipVertical(){
		String temp;
		for(int i=0;i<5;i++){
			for(int j=0;j<10;j++){
				temp=this.image[9-i][j];
				this.image[9-i][j]=this.image[i][j];
				this.image[i][j]=temp;
			}
		}
	}
	public void reverse(){
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(this.image[i][j]=="-"){
					this.image[i][j]="*";
				}else{
					this.image[i][j]="-";
				}
			}
		}
	}
}