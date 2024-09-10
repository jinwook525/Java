package chap7;

//Item 클래스
class Item2 {//
	private String name;
	private double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	private int stockQuantity;

	public Item2(String name, double price, int stockQuantity) {
		this.name=name;
		this.price= price;
		this.stockQuantity= stockQuantity;
	}
	public void show() {
		System.out.print("name= "+name+" price= "+price);
	}
}

//Electronics 클래스 (Item 클래스를 상속)
class Electronics extends Item2 {
	private int warranty; // 제품 보증 기간

	public Electronics(String name, double price, int stockQuantity, int warranty) {
		super(name, price, stockQuantity);
		this.warranty = warranty;
	}
	@Override
	public void show() {
		super.show();
		System.out.print(", 보증기간= "+warranty);
	}
}

//Clothing 클래스 (Item 클래스를 상속)
class Clothing extends Item2 {
	private String size;
	private String color;
	public Clothing(String name, double price, int stockQuantity, String size, String color) {
		super(name, price, stockQuantity);
		this.size = size;
		this.color = color;
	}
	@Override
	public void show() {
		super.show();
		System.out.print("size= "+ size+", color="+color);
	}

}
//Customer 추상 클래스 정의
abstract class Customer2 {
	private String cname;
	private String city;
	private int age;

	public Customer2(String cname, String city, int age) {
		this.age=age;
		this.city=city;
		this.cname=cname;
	}
	public void show() {
		System.out.println("name= "+cname+",city= "+city+",age= "+age);
	}	
	abstract double applyDiscount(double totalAmount);

}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer extends Customer2 {
	static final double REGULARDISCOUNT_RATE = 0.03;
	public RegularCustomer(String cname, String city, int age) {
		super(cname,city,age);
	}
	@Override
	double applyDiscount(double totalAmount) {
		// TODO Auto-generated method stub
		return totalAmount * REGULARDISCOUNT_RATE;
	}
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer2 {
	static final double PREMIUMDISCOUNT_RATE = 0.1;
	public PremiumCustomer(String cname, String city, int age) {
		super(cname,city,age);
	}
	@Override
	double applyDiscount(double totalAmount) {
		// TODO Auto-generated method stub
		return totalAmount * PREMIUMDISCOUNT_RATE;
	}

}


//Order 클래스
class Order2 {
	private Customer2 customer;
	private Item2[] items;
	private int[] quantities;
	private int itemCount;
	/*
	 * Order2(),addItem()
	 * calculateTotal(),calculateDiscountedTotal(), printOrderSummary()
	 */
	Order2(Customer2 customer, int maxItems) {
		this.customer= customer;
		items= new Item2[maxItems];
		quantities= new int [maxItems];
		
	}
	public Customer2 getCustomer() {
		return customer;
	}
	public void setCustomer(Customer2 customer) {
		this.customer = customer;
	}
	public Item2[] getItems() {
		return items;
	}
	public void setItems(Item2[] items) {
		this.items = items;
	}
	public int[] getQuantities() {
		return quantities;
	}
	public void setQuantities(int[] quantities) {
		this.quantities = quantities;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	
	public void addItem(Item2 orderItem, int orderQuantity) {
		items[itemCount]=orderItem;
		quantities[itemCount]=orderQuantity;
		itemCount++;
	}
	public double calculateTotal() {
    	double sum=0.0; 
    	for(int i=0; i<itemCount; i++) {
    		sum +=(items[i].getPrice()*quantities[i]);   		   		
    	}return sum-discountCalculateTotal() ;
	}
	public double discountCalculateTotal() {//총 할인된 금액
    	double sum=0.0; 
    	for(int i=0; i<itemCount; i++) {
    		double priceTemp = items[i].getPrice();
    		double discountValue = customer.applyDiscount(priceTemp);
    		sum += discountValue * quantities[i];   		   		
    	}
    	return sum ;
	}
	public void printOrderSummary() {//주문 내역: 고객 이름 + 주문 내역(제품이름, 단가, 수량)
		customer.show();
		for(int i=0; i<itemCount;i++) {
			items[i].show();
			System.out.println(" quantitiy="+quantities[i]);
		}
		System.out.println("Total = "+calculateTotal());
		System.out.println("dicsount="+discountCalculateTotal());
	} 
}

public class 실습과제2 {
	public static void main(String[] args) {
		// 의류 및 전자제품 생성
		Electronics laptop = new Electronics("노트북", 1200.00, 10, 24);
		Electronics phone = new Electronics("휴대폰", 800.00, 30, 12);
		Clothing tshirt = new Clothing("티셔츠", 20.00, 50, "M", "Blue");
		Clothing jacket = new Clothing("자켓", 80.00, 20, "L", "Black");

		// 고객 생성
		PremiumCustomer premiumCustomer = new PremiumCustomer("홍길동", "부산", 30);
		RegularCustomer regularCustomer = new RegularCustomer("계백", "양산", 25);

		// 주문 생성
		Order2 order1 = new Order2(premiumCustomer, 4);
		order1.addItem(laptop, 1);
		order1.addItem(tshirt, 2);

		Order2 order2 = new Order2(regularCustomer, 4);
		order2.addItem(phone, 1);
		order2.addItem(jacket, 1);

		// 주문 요약 출력
		System.out.println("Premium Customer Order:");
		order1.printOrderSummary();

		System.out.println("Regular Customer Order:");
		order2.printOrderSummary();
	}
}
