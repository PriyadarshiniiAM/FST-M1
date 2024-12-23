package activities;

abstract class Book {
	// variable to hold the book's title
	String title;

	// abstract method to set the title, set and get method always should be public
	public abstract void setTitle(String title);

	// concrete method to return the title of the book
	public String getTitle() {
		return this.title;
	}
}

class MyBook extends Book {
	// Implement the setTitle function
	public void setTitle(String title) {
		this.title = title;
	}
}

class MyBook2 extends Book {
	// Implement the setTitle function
	public void setTitle(String title) {
		if (title.length() < 3) {
			System.out.println("Title is too small");
		} else {
			this.title = title;
		}
	}
}

public class Activity5 {

	public static void main(String[] args) {
		MyBook bookObj = new MyBook();
		bookObj.setTitle("Wings of Fire");
		System.out.println(bookObj.getTitle());
		MyBook2 bookObj2 = new MyBook2();
		bookObj2.setTitle("W");
		System.out.println(bookObj2.getTitle());

	}

}
