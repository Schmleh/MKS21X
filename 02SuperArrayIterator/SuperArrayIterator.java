import java.util.*;

public class SuperArrayIterator implements Iterator<String>{
    public String[] sarry;
    public int current;
    public SuperArrayIterator(String[] jarry, int jurrent){
	sarry = jarry;
	current = jurrent;
    }
    public boolean hasNext(){
	return current < sarry.length - 1;
    }
    public String next(){
	if (hasNext()){
	    current += 1;
	    return sarry[current];
	}else{
	    throw new NoSuchElementException();
	}
    }
    public void remove(){
	throw new UnsupportedOperationException();
    }
}
