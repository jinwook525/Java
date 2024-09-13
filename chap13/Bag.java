package chap13;

class Bag<T extends Solid>{
	private T thing;
	private String owner;

	public Bag(T thing) {
		this.thing=thing;
	}

	public T getThing() {
		return thing;
	}

	public void setThing(T thing) {
		this.thing = thing;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	void showType() {
		System.out.println("T의 타입은 "+ thing.getClass().getName());
	}
	boolean isSameOwner(Bag<T> obj) {
		if(this.owner.equals(obj.getOwner()))
			return true;
					return false;
	}
	
}

