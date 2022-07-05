/**
 * 
 */
package com.gtm.interview;

/**
 * @author kumarga
 *
 */
public class BinaryDecimalConverter {
	
	public String convertDecimalToBinary(long decimal){
		
		if(decimal<2){
			return "Plz enter no greater than or equal 2 !!";
		}else{
			StringBuilder binary=new StringBuilder();
			while(decimal>0){
				long temp=decimal%2;
				binary=binary.append(String.valueOf(temp));
				decimal=decimal/2;
			}
			return binary.reverse().toString();
		}
	}
	
	public String convertBinaryToDecimal(long binary){
		double sum=0;
		int power=0;
		while(binary>0){
			long temp=binary%10;
			sum=sum+(temp*Math.pow(2, power));
			power++;
			binary=binary/10;
		}
		return String.valueOf(new Double(sum).longValue());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryDecimalConverter converter=new BinaryDecimalConverter();
		long decimal=7;
		String binary=converter.convertDecimalToBinary(decimal);
		System.out.println("Decimal value of "+decimal+", binary is :"+binary);
        System.out.println("Binary No of "+binary+", decimal is :"+converter.convertBinaryToDecimal(Long.parseLong(binary)));
	}

}
