abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    public LibraryBook(){
	super();
	callNumber = "";
    }
    public LibraryBook(String t, String a, String I,String cN){
	super(t,a,I);
	callNumber = cN;
    }
    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();
    public String getCallNumber(){
	String cN = callNumber;
	return cN;
    }
    public void setCallNumber(String newCallNumber){
	callNumber = newCallNumber;
    }
    public String toString(){
	return super.toString() + ", " + callNumber;
    }
    public int compareTo(LibraryBook p){
        if (callNumber.compareTo(p.getCallNumber()) > 0){return 1;}
	else if (callNumber.compareTo(p.getCallNumber()) == 0){return 0;}
        return -1;
    }
}
