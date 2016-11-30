public class CirculatingBook extends LibraryBook{
    private String currentHolder, dueDate;
    public CirculatingBook(){
	super();
	currentHolder = null;
	dueDate = null;
    }
    public CirculatingBook(String t, String a, String I, String cN){
	super(t,a,I,cN);
	currentHolder = null;
	dueDate = null;
    }
    public String getCurrentHolder(){
	String cH = currentHolder;
	return cH;
    }
    public void setCurrentHolder(String newCurrentHolder){
	currentHolder = newCurrentHolder;
    }
    public String getDueDate(){
	String dd = dueDate;
	return dd;
    }
    public void setDueDate(String newDueDate){
	dueDate = newDueDate;
    }
    public void checkout(String patron, String due){
        currentHolder = patron;
	dueDate = due;
    }
    public void returned(){
	currentHolder = null;
	dueDate = null;
    }
    public String circulationStatus(){
	if (currentHolder == null){
	    return "Good news, Pinkie Pie, the book's available on shelf!";
	}
	return "Currently held by: " + currentHolder + "\n Due back on: " +dueDate;
    }
    public String toString(){
	if (currentHolder == null){
	    return super.toString();
	}
	return super.toString() + ", " + currentHolder + ", " + dueDate;
    }
    // public static void main(String[]args){
    // 	CirculatingBook jay = new CirculatingBook();
    // 	jay.setTitle("IE");
    // 	jay.setAuthor("PinK");
    // 	jay.setISBN("P.");
    // 	jay.setCallNumber("I.");
    // 	System.out.println(jay.toString());
    // 	jay.checkout("Pinki", "Pi");
    // 	System.out.println(jay.toString());
    //     CirculatingBook gee = new CirculatingBook("T", "R", "RD", "F");
    // 	gee.checkout("Apple", "Jack");
    // 	System.out.println(jay.compareTo(gee));
    // 	System.out.println(jay.circulationStatus());
    // 	jay.checkout("me","today");
    // 	System.out.println(jay.circulationStatus());
    // 	jay.returned();
    // 	System.out.println(jay.circulationStatus());
    // }
}
