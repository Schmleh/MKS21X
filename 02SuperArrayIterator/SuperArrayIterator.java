import java.util.*;

public class SuperArrayIterator implements Iterator<String>{
    public SuperArray sarry;
    public int current;
    public SuperArrayIterator(SuperArray jarry, int jurrent){
	sarry = jarry;
	current = jurrent;
    }
    public boolean hasNext(){
	return current < sarry.size() - 1;
    }
    public String next(){
	if (hasNext()){
	    current += 1;
	    return sarry.get(current);
	}else{
	    throw new NoSuchElementException();
	}
    }
    public void remove(){
	throw new UnsupportedOperationException();
    }
}
