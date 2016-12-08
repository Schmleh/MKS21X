import java.util.*;

public class Barcode implements Comparable<Barcode>{

    private String _zip;
    private int _checkDigits;

    public Barcode(String zip){
	if (zip.length() != 5){
	    System.out.println("The barcode must be five digits long.");
	    throw new UnsupportedOperationException();
	}
	_zip = zip;
	_checkDigits = 0;
	for (int i = 0; i < zip.length(); i ++){
	    if ((zip.charAt(i) - '0') > 9 || (zip.charAt(i) - '0') < 0){
		System.out.println("The barcode may only contain numbers.");
		throw new UnsupportedOperationException();
	    }
	    _checkDigits += (zip.charAt(i) - '0');
	}
    }

    public Barcode clone(){
	return new Barcode(_zip);
    }

    public int checkSum(){
	return _checkDigits;
    }

    public String toString(){
	String zip = _zip + (_checkDigits % 10);
	String code = "|";
	for (int i = 0; i < zip.length(); i ++){
	    switch(zip.charAt(i) - '0'){
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
	    case 0 : code += "||:::";
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
	Barcode one = new Barcode("11100");
	Barcode two = new Barcode("22222");
	System.out.println(one.toString());
	System.out.println(two.toString());
	System.out.println(one.checkSum());
	System.out.println(two.clone().toString());
	System.out.println(one.compareTo(two));
	System.out.println(one.clone());
    }
}
