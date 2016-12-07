import java.util.*;

public class Barcode implements Comparable<Barcode>{
// instance variables
    private String _zip;
    private int _checkDigit;
   
// constructors
//precondtion: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
    public Barcode(String zip) {
	_zip = zip;
	_checkDigit = 0;
        for (int i = 0; i < zip.length(); i ++){
	    _checkDigit += (zip.charAt(i) - '0');
	}
    }

// postcondition: Creates a copy of a bar code.
    public Barcode clone(Barcode x){
	return new Barcode(_zip);
    }


// postcondition: computes and returns the check sum for _zip
    private int checkSum(){
	return _checkDigit;
    }

//postcondition: format zip + check digit + barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	String code = "";
	for (int cu = 0; cu < _zip.length(); cu++){
	    switch(_zip.charAt(i) - '0'){
	    case : 1  code += ":::||";
	    case : 2  code += "::|:|";
	    case : 3  code += "::||:";
case : 4  :|::|
case : 5  :|:|:
case : 6  :||::
case : 7  |:::|
case : 8  |::|:
case : 9  |:|::
case : 0  ||:::
    }


// postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){

    }
}
