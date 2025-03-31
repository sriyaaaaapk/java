package javasem;
import java.util.Scanner;
public class runprograms {
	
	/*public static void main(String[] args) {
		String[]names= 
		{"Rahul","Neha","Gokul","Preethi","Robert","Peter"};
		for(int i=0;i<names.length;i++) 		System.out.print(names[i]+" ");
		
		System.out.println();
		
		System.out.println("Using for each loop");
		for(String name:names) System.out.print(name+" ");
		
		System.out.println();
		int[]numbers= {3,2,1,5,6};
		for(int number:numbers) System.out.print(number+" ");
		 }*/
	/*public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Add 1 Sub 2 Mul 3 Div 4");
		int choice=sc.nextInt();
		int a=0;
		int b=0;
		if(choice>=1 && choice<=4) {
		System.out.println("Enter First Number :");
		a=sc.nextInt();
		System.out.println("Enter Second Number :");
		b=sc.nextInt();
		}
		
		switch(choice) {
		case 1:
			System.out.println(a+b);
			break;
		case 2:
			System.out.println(a-b);
			break;
		case 3:
			System.out.println(a*b);
			break;
		case 4:
			System.out.println((double)a/b);
			break;
		default:
			System.out.println("Unknown Operator");
		}
		}*/
	//finding factorial
	static long fact(int N) {
		long prod=1;
		for(int i=N;i>0;i--) prod=prod*i;
		return prod;
		}
	//checking prime
	static boolean isPrime(int N) {
		for(int i=2;i<(int)(Math.pow(N,0.5)+1);i++) {
		if(N%i==0) {
		return false;
		}
		}
		return true;
		 }
//find permutations
	static int nPr(int n,int r) {
		int prod=1;
		for(int i=n;i>n-r;i--) {
		prod=prod*i;
		}
		return prod;
		}
	
//combination
	static long nCr(int n,int r) {
	    double prod=1;
		int R=r;
		for(int i=n;i>n-r;i--) {
		prod=prod*(double)i/R;
		R=R-1;
		}
		return Math.round(prod);
		}
	
	public static void main(String[] args) {
		        String S = "abracadabra"; // Original string
		        char[] s = S.toCharArray(); // Convert to char array
		        String str = new String(s); // Convert char array back to string
		        for (int i = 0; i < str.length(); i++) {
		            System.out.println(str.charAt(i)); // Print each character
		        }
		    }



		//System.out.println(isPrime(34));
		/*int i=2;
		while(i<100) {
		if(isPrime(i))System.out.print(i+" ");
		i+=1;*/
	
}


