import java.util.*;
public class SuperArray implements Iterable<String>{


    private String[] data;
    private int size;


    public SuperArray(){
        data = new String[10];
	size = 0;
    }
    
    public SuperArray(int capacity){
	if (capacity < 0) {throw new IllegalArgumentException();}
	data = new String[capacity];
	size = 0;
    }

    public int size(){
	return size;
    }
    
    public int capacity(){
	return data.length;
    }

    public void setSize(int newSize){
	size = newSize;
    }
    
    public boolean add(String n){
	if (data.length == size) {grow();}
	data[size] = n;
	size ++;
	return true;
    }


    public String get(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
		}
	return data[index];
    }
    

    public void grow(){
	int f = 1;
	if (data.length != 0){
	    f = data.length * 2;}
        String[] newdata = new String[f];
	for (int x = 0; x < data.length; x++){
	    newdata[x] = data[x];
	}
	data = newdata;
    }


    public String toString(){
	String Es = "[ ";
	for (int i = 0; i < size; i ++){
	    Es += data[i];
	    if (i + 1  < size) {
		Es += ", ";
	    }
	}
	Es += "]";
	return Es;
    }


    public String toStringDebug(){
	String Es = "[ ";
	for (int i = 0; i < data.length;i ++){
	    if (i < size){
		Es += data[i];
	    }else {
	        Es += "_";
	    }
	    if (i + 1 < data.length){
		Es += ", ";
	    }
	}
	Es += "]";
	return Es;
    }


    public void clear(){
	size = 0;
    }


    public boolean isEmpty(){
	return size == 0;
    }


    public String set(int index, String element){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
        String Temp = data[index];
	data[index] = element;
	return Temp;
    }

    public void add(int index, String element){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	if (size == data.length){
	    grow();
	}
	for (int u = data.length - 1; u > index; u--){
	    data[u] = data[u - 1];
	}
	data[index] = element;
        size ++;
    }

    public String remove(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
        String ret = data[index];
	for (int well = index; well < data.length - 1; well++){
	    data[well] = data[well + 1];
	}
	data[data.length - 1] = null;
	size --;
	return ret;
    }


    public int indexOf(String i){
	for(int bleh = 0; bleh < size; bleh ++){
	    if (data[bleh].equals( i)){
			return bleh;
		}
	}
	return -1;
    }


    public int lastIndexOf(String i){
	int seven = -1;
        for(int bleh = 0; bleh < size; bleh ++){
	    if (data[bleh].equals( i)){
			seven = bleh;
		}
	}
	return seven;
    }

    public String[] toArray(){
	String[] erm = new String[size];
	for (int uh = 0; uh < size; uh ++){
	    erm[uh] = data[uh];
	}
	return erm;
    }

    public void trimToSize(){
        String[] newdata = new String[size];
	for (int x = 0; x < size; x++){
	    newdata[x] = data[x];
	}
	data = newdata;
    }

    public Iterator<String> iterator(){
	return new SuperArrayIterator(data, 0);
    }

    public static void main(String[] args){
	/*SuperArray luna;
        luna = new SuperArray(4);
	luna.add("d");
	System.out.println(luna.toStringDebug());
	luna.add(0,"a");
	System.out.println(luna.toStringDebug());
	luna.add(0,"g");
	System.out.println(luna.toStringDebug());
	luna.add(2,"b");
	System.out.println(luna.toStringDebug());
	luna.add(3,"c");
	System.out.println(luna.toStringDebug());
	luna.remove(0);
	System.out.println(luna.toStringDebug());
	System.out.println(luna.indexOf("b"));
	System.out.println(luna.lastIndexOf("c"));
	System.out.println(luna.size());
	luna.trimToSize();
	System.out.println(luna.toStringDebug());
	luna.clear();
	luna.trimToSize();
	System.out.println(luna.toStringDebug());*/
    }
    
}
