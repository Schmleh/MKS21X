import java.util.*;

public class Barcode implements Comparable<Barcode>{
    
    private String _zip;
    private int _checkDigits;

    public Barcode(String zip){
	if (zip.length() != 5){
	    try{
		throw new IllegalArgumentException();
	    } catch (IllegalArgumentException e) {
		    System.out.println("The barcode must be five digits long.");
		    System.exit(0);
	    }
	}
	_zip = zip;
	_checkDigits = 0;
	for (int i = 0; i < zip.length(); i ++){
	    if ((zip.charAt(i) - '0') > 9 || (zip.charAt(i) - '0') < 0){
		try{
		    throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
		    System.out.println("The barcode may only contain numbers.");
		    System.exit(0);
		}
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
	    try{
		throw new IllegalArgumentException();
	    } catch (IllegalArgumentException e) {
		System.out.println("The barcode must be 32 characters long.");
		System.exit(0);
	    }
	}
	if (barcode.charAt(0) != '|' || barcode.charAt(31) != '|'){
	    try{
		throw new IllegalArgumentException();
	    } catch (IllegalArgumentException e) {
		System.out.println("Barcode must start and end with '|'.");
		System.exit(0);
	    }
	}
	String zip = "";
	String number = "";
	int checkSum = 0;
	for (int n = 1; n < 31;n ++){
	    if ((barcode.charAt(n) != '|') && (barcode.charAt(n) != ':')) {
		try{
		    throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
		    System.out.println("Barcodes may only cosist of '|' and ':'.");
		    System.exit(0);
		}
	    }
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
	    try{
		throw new IllegalArgumentException();
	    } catch (IllegalArgumentException e) {
		System.out.println("Invalid barcode: Sum of digits don't match.");
		System.exit(0);
	    }
	}
	String newzip = "" + zip.charAt(0) + zip.charAt(1) + zip.charAt(2) + zip.charAt(3) + zip.charAt(4);
	return newzip;
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
	int index = keycode.indexOf(barcode);
	if (index == -1) {
	    try{
		throw new IllegalArgumentException();
	    } catch (IllegalArgumentException e) {
		System.out.println("There's a character in the barcode that doesn't exist.");
		System.exit(0);
	    }
	}
	return index;
    }

    public String toString(){
	return _zip + _checkDigits + " " + toCode(_zip);
    }
    
    public String toCode(String zip){
	if (zip.length() != 5) {
	    try{
		throw new IllegalArgumentException();
	    } catch (IllegalArgumentException e) {
		System.out.println("Zip code must be 5 characters long.");
		System.exit(0);
	    }
	}
	int sum = 0;
	for (int i = 0; i < zip.length(); i ++){
	    if ((zip.charAt(i) - '0') > 9 || (zip.charAt(i) - '0') < 0){
		try{
		    throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
		    System.out.println("The zipcode may only contain numbers.");
		    System.exit(0);
		}
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
	// System.out.println(Barcode.toZip("|::||::|::|:|:|::||::|:::|:|:|:|"));
	// Barcode one = new Barcode("34567");
	// Barcode two = new Barcode("78910");
	// System.out.println(one.toString());
	// System.out.println(two.toString());
	// System.out.println(one.checkSum());
	// System.out.println(one.compareTo(two));
	System.out.println(toZip("::::::::::::::::::::::::::::::::"));
    }
}
