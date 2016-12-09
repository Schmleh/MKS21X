import java.util.*;

public class Barcode implements Comparable<Barcode>{
    
    private String _zip;
    private int _checkDigits;
    public final String[] keycode = {":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::", "||:::"};
    
    public Barcode(String zip){
	if (zip.length() != 5){
	    System.out.println("The barcode must be five digits long.");
	    throw new IllegalArgumentException();
	}
	_zip = zip;
	_checkDigits = 0;
	for (int i = 0; i < zip.length(); i ++){
	    if ((zip.charAt(i) - '0') > 9 || (zip.charAt(i) - '0') < 0){
		System.out.println("The barcode may only contain numbers.");
		throw new IllegalArgumentException();
	    }
	    _checkDigits += (zip.charAt(i) - '0');
	}
    }
    
    public int checkSum(){
	return _checkDigits;
    }

    public static String toZip(String barcode){
	if (barcode.length() != 32){
	    System.out.println("The barcode must be 32 characters long.");
	    throw new IllegalArgumentException();
	}
	String zip = "";
	String number = "";
	int checkSum = 0;
	for (int n = 1; n < 31;n ++){
	    number += barcode.charAt(n);
	    if (number.length() == 5){
	        zip += numify(number);
		checkSum += numify(number);
		number = "";
	    }
	}
	if ((zip.charAt(6) - '0') != (checkSum % 10)){
	    System.out.println("Invalid barcode: Sum of digits don't match.");
	    throw new IllegalArgumentException();
	}else{
	    String newzip = "" + zip.charAt(1) + zip.charAt(2) + zip.charAt(3) + zip.charAt(4) + zip.charAt(5);
	    return newzip;
	}
    }
    
    public static int numify(String barcode){
	//change the 5 character string of | and : to a number.
	return 0;
    }

    public String toString(){
	return toCode(_zip);
    }
    
    public String toCode(String zip){
	int sum = 0;
	for (int i = 0; i < zip.length(); i ++){
	    if ((zip.charAt(i) - '0') > 9 || (zip.charAt(i) - '0') < 0){
		System.out.println("The barcode may only contain numbers.");
		throw new IllegalArgumentException();
	    }
	    sum += (zip.charAt(i) - '0');
	}
	zip += (sum % 10);
	String code = "|";
	for (int i = 0; i < zip.length(); i ++){
	    switch(zip.charAt(i) - '0'){
	    case 1 : code += ":::||";
	    case 2 : code += "::|:|";
	    case 3 : code += "::||:";
	    case 4 : code += ":|::|";
	    case 5 : code += ":|:|:";
	    case 6 : code += ":||::";
	    case 7 : code += "|:::|";
	    case 8 : code += "|::|:";
	    case 9 : code += "|:|::";
	    case 0 : code += "||:::";
	    }
	}
	code += "|";
	return code;
    }
    
    public int compareTo(Barcode other){
	return toString().compareTo(other.toString());
    }

    public static void main(String[] args){
	/*Barcode one = new Barcode("345aa");
	Barcode two = new Barcode("78910");
	System.out.println(one.toString());
	System.out.println(two.toString());
	System.out.println(one.checkSum());
	System.out.println(two.clone().toString());
	System.out.println(one.compareTo(two));
	System.out.println(one.clone());*/
    }
}
