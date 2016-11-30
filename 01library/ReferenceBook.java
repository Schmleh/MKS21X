public class ReferenceBook extends LibraryBook{
    private String collection;
    public ReferenceBook(){
	super();
	collection = "";
    }
    public ReferenceBook(String t, String a, String I, String cN, String c){
	super(t,a,I,cN);
	collection = c;
    }
    public void checkout(String patron, String due){
	System.out.println("You can't check out a reference book, Pinkie Pie!");
    }
    public void returned(){
	System.out.println("You can't be returning a reference book, Pinkie Pie. How did you even get that in the first place?");
    }
    public String circulationStatus(){
        return "This book doesn't circulate, Pinkie Pie.";
    }
    public String getCollection(){
	String c = collection;
	return c;
    }
    public void setCollection(String newCollection){
	collection = newCollection;
    }
    public String toString(){
	return super.toString() + ", " + collection;
    }
    // public static void main(String[]args){
    // 	ReferenceBook jay = new ReferenceBook();
    // 	jay.setTitle("IE");
    // 	jay.setAuthor("PinK");
    // 	jay.setISBN("P.");
    // 	jay.setCallNumber("I.");
    // 	jay.setCollection("E.");
    // 	System.out.println(jay.toString());
    // 	ReferenceBook gee = new ReferenceBook("T", "R", "RD", "F", "Aj");
    // 	System.out.println(jay.compareTo(gee));
    // 	jay.checkout("me","today");
    // 	jay.returned();
    // 	jay.circulationStatus();
    // }
}
