package cha13_1;

class Bag<T extends Solid> {
	private T thing; 

	public Bag(T thing) {
		this.thing = thing;

	}


	public T getThing() {
		return thing;
	}


	public void setThing(T thing) {
		this.thing = thing;
	}

	void showType() {
		System.out.println("T의 타입은 "+ thing.getClass().getName());
	}
}

class Solid()
class Liquid()

class Book extends Solid{}
class PencilCase extends Solid{}
class Notebook extends Solid{}

class Water extends Liquid{}
class Coffee extends Liquid{}




public class BagTEest {
	public static void main(String[] args) {
		Bag<Book> bag= new Bag<> (new Book());
		Bag<PencilCase> bag2= new Bag<>(new PencilCase());
		Bag<Notebook> bag3= new Bag<> (new Notebook());

		bag.setThing(new Book());
		bag.setThing(new PencilCase());
		bag.setThing(new Notebook());
		bag.showType();
		bag2.showType();
		bag3.showType();
	}
}
