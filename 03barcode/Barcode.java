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
	String zip = _zip + _checkDigits;
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
