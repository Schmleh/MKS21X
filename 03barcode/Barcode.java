import java.util.*;

public class Barcode implements Comparable<Barcode>{
    
    private String _zip;
    private int _checkDigits;

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
	_checkDigits = _checkDigits % 10;
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
		if (n < 30){
		    checkSum += numify(number);
		}
		number = "";
	    }
	}
	if ((zip.charAt(5) - '0') != (checkSum % 10)){
	    System.out.println(zip.charAt(5) - '0');
	    System.out.println(checkSum % 10);
	    System.out.println("Invalid barcode: Sum of digits don't match.");
	    throw new IllegalArgumentException();
	}else{
	    String newzip = "" + zip.charAt(0) + zip.charAt(1) + zip.charAt(2) + zip.charAt(3) + zip.charAt(4);
	    return newzip;
	}
    }
    
    public static int numify(String barcode){
	ArrayList<String> keycode = new ArrayList<String>();
	keycode.add("||:::");
	keycode.add(":::||");
	keycode.add("::|:|");
	keycode.add("::||:");
	keycode.add(":|::|");
	keycode.add(":|:|:");
	keycode.add(":||::");
	keycode.add("|:::|");
	keycode.add("|::|:");
	keycode.add("|:|::");
	return keycode.indexOf(barcode);
    }

    public String toString(){
	return _zip + _checkDigits + " " + toCode(_zip);
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
	    case 0 : code += "||:::";
		break;
	    case 1 : code += ":::||";
		break;
	    case 2 : code += "::|:|";
		break;
	    case 3 : code += "::||:";
		break;
	    case 4 : code += ":|::|";
		break;
	    case 5 : code += ":|:|:";
		break;
	    case 6 : code += ":||::";
		break;
	    case 7 : code += "|:::|";
		break;
	    case 8 : code += "|::|:";
		break;
	    case 9 : code += "|:|::";
		break;
	    }
	}
	code += "|";
	return code;
    }
    
    public int compareTo(Barcode other){
	return toString().compareTo(other.toString());
    }

    public static void main(String[] args){
	System.out.println(Barcode.toZip("|::||::|::|:|:|::||::|:::|:|:|:|"));
	Barcode one = new Barcode("34567");
	Barcode two = new Barcode("78910");
	System.out.println(one.toString());
	System.out.println(two.toString());
	System.out.println(one.checkSum());
	System.out.println(one.compareTo(two));
    }
}
