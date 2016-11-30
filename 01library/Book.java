public class Book{
    private String title, author, ISBN;
    public Book(){
	title = "";
	author = "";
	ISBN = "";
    }
    public Book(String t, String a, String I){
	title = t;
	author = a;
	ISBN = I;
    }
    public String title(){
	String t = title;
	return t;
    }
    public String author(){
	String a = author;
	return a;
    }
    public String ISBN(){
	String I = ISBN;
	return I;
    }
    public void setTitle(String newTitle){
	title = newTitle;
    }
    public void setAuthor(String newAuthor){
	author = newAuthor;
    }
    public void setISBN(String newISBN){
	ISBN = newISBN;
    }
    public String toString(){
	return author + ", " + title + ", " + ISBN;
    }

    // public static void main(String[]args){
    // 	Book jay = new Book();
    //     jay.setTitle("Pink");
    //     jay.setAuthor("E.");
    // 	jay.setISBN("Pi");
    // 	System.out.println(jay.toString());
    // }
}
