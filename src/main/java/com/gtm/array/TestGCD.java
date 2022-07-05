package com.gtm.array;

import java.util.Scanner;

public class TestGCD {

	static int gcd(int a, int b)
	{
		if (a == 0) 
			return b;

		return gcd(b%a,a);
	}
	static int commDiv(int a,int b)
	{
		int n = gcd(a, b);

		int result = 0;
		for (int i=1; i<=Math.sqrt(n); i++)
		{
			if (n%i==0)
			{
				if (n/i == i)
					result += 1;
				else
					result += 2;
			}
		}
		return result;
	}

	public static void main(String args[] ) throws Exception {


		//Scanner
		Scanner s = new Scanner(System.in);
		System.out.println("enter two values :");
		String name = s.nextLine(); // Reading input from STDIN
		s.close();
		String []str = name.split(" ");
		int a = Integer.parseInt(str[0]);


		int b = Integer.parseInt(str[1]);


		// Write your code here

		System.out.println(commDiv(a, b));

	}
}


class TestClass {
    
    static int sumArr(int []b){
        int sum = 0;
        for(int i = 0; i< b.length; i++){
            sum+=b[i];
        }
        return sum;
        
    }
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        */
        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        String name1 = s.nextLine();                 // Reading input from STDIN
        // Write your code here
        int a = Integer.parseInt(name);
        String []str = name1.split(" ");
        int []b = new int[a];
        for(int i = 0; i< str.length; i++){
            b[i] = Integer.parseInt(str[i]);
        } 
        int sum = sumArr(b);
        int ind = 0;
         for(int j = 0; j < 1000; j++){
             ind = j;
             int su = j*a;
             if(su > sum)
             break;
         }
         System.out.print(ind);
        

    }
}