package chap8;
//2단계 - 문제 4: 동적바인딩

import java.awt.ItemSelectable;

//Item 추상 클래스

abstract class Item {

	private String name; // 제품명
	private double price; // 제품 가격
	private int stockQuantity; // 재고량
	public Item(String name, double price, int stockQuantity) {
		super();
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
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
	public void show() {
		System.out.print("name= "+name+" price= "+price+"stockQuantity="+stockQuantity);
	}
}
//Electronics 클래스: Item 클래스 상속

class Electronics extends Item {
	int madeYear;
	public Electronics(String name, double price, int stockQuantity, int madeYear) {
		super(name, price, stockQuantity);
		this.madeYear = madeYear;
	}
	public void show() {
		super.show();
		System.out.println("제조년도= "+madeYear);
	}
}
//Clothing 클래스: Item 클래스 상속
class Clothing extends Item {
	int size;
	public Clothing(String name, double price, int stockQuantity, int size) {
		super(name, price, stockQuantity);
		this.size = size;
	}
	public void show() {
		super.show();
		System.out.println("치수:"+size);
	}
}
//Discountable 인터페이스 정의

interface Discountable {
	double getDiscountedPrice(double price);
}
//SeasonalDiscount 클래스: Discountable 인터페이스 구현

class SeasonalDiscount implements Discountable {

	private double discountRate;
	public SeasonalDiscount(double  discountRate) {
		this.discountRate = discountRate;
		// TODO Auto-generated constructor stub
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	@Override
	public double getDiscountedPrice(double price) {
		return price *discountRate;
	}

}

//Order 클래스

class Order extends SeasonalDiscount{

	private final int N = 20;
	private Customer customer; // 고객명
	private Item[] items; // 주문 제품들
	private int[] quantities; // 주문 제품 수량들
	private String[] orderDates; // 주문일자들
	private static int count = 0;

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Item[] getItems() {
		return items;
	}
	public void setItems(Item[] items) {
		this.items = items;
	}
	public int[] getQuantities() {
		return quantities;
	}
	public void setQuantities(int[] quantities) {
		this.quantities = quantities;
	}
	public String[] getOrderDates() {
		return orderDates;
	}
	public void setOrderDates(String[] orderDates) {
		this.orderDates = orderDates;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Order.count = count;
	}
	public int getN() {
		return N;
	}
	public Order(Customer customer) {

		super(0.05);
		this.customer = customer;
		this.items = new Item[N];
		this.quantities = new int[N];
		this.orderDates = new String[N];
		count=0;

	}
	public void addItem(Item item, int quantity, String date) {
		items[count]=item;
		quantities[count]=quantity;
		orderDates[count]=date;
		count++;

	}
	public double calculateTotal() {
		double total=0.0; 
		for(int i=0; i<count; i++) {
			total +=(items[i].getPrice()*quantities[i]);   		   		
		}
		return total ;
		/*
		 * 할인없이 수량 단가로 비용 계산
		 */
	}
	public void printOrderSummary() {
		System.out.println("고객:"+customer.getName());
		for(int i=0; i<count;i++) {
			items[i].show();
			System.out.println(" quantitiy="+quantities[i]);
		}
		System.out.println("Total = "+calculateTotal());
	}

	//할인된 내역을 출력하는 메소드
	public double calculateTotalDiscount() {
		double total = calculateTotal();
		// 고객 할인율 적용
		double customerDiscountAmount = total * customer.getDiscountRate();
		// 계절 할인율 적용
		double seasonalDiscountAmount = getDiscountedPrice(total);
		return customerDiscountAmount + seasonalDiscountAmount;
	}
	public double finalTotal() {
		return calculateTotal() - calculateTotalDiscount();

	}
	public void printDiscountDetails() {
		for(int j=0; j<count; j++) {
			System.out.println(items[j].getName()+":"+"원래가격 W"+items[j].getPrice()+
					"시즌할인금액 W"+getDiscountedPrice(items[j].getPrice())+
					"고객할인금액 W"+items[j].getPrice()*customer.getDiscountRate()+
					"할인 후 가격 W"+(items[j].getPrice()-getDiscountedPrice(items[j].getPrice())
							-items[j].getPrice()*customer.getDiscountRate()));
		}
		System.out.println("할인 되어 지불해야하는 금액"+ finalTotal());
		/*

		 * 정가 - 시즌 할인 적용 - 고객 할인 적용 => 할인된 가격 * 수량 > 총 지불 금액

		 */

	}

}
//Customer 추상 클래스 정의

abstract class Customer {

	private String name;
	abstract double applyDiscount(double totalAmount);

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Customer(String name) {
		this.name = name;
	}
	abstract double getDiscountRate();
}
//RegularCustomer 클래스: Customer 클래스를 상속받음

class RegularCustomer extends Customer {

	static final double REGULARDISCOUNT_RATE = 0.03;

	public RegularCustomer(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	@Override
	double applyDiscount(double totalAmount) {
		return totalAmount*REGULARDISCOUNT_RATE;
	}
	@Override
	double getDiscountRate() {
		return REGULARDISCOUNT_RATE;

	}
	//PremiumCustomer 클래스: Customer 클래스를 상속받음
}
class PremiumCustomer extends Customer {

	static final double PREMIUMDISCOUNT_RATE = 0.1;
	public PremiumCustomer(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}
	@Override

	double applyDiscount(double totalAmount) {
		return totalAmount*PREMIUMDISCOUNT_RATE;
	}
	@Override
	double getDiscountRate() {
		return PREMIUMDISCOUNT_RATE;
	}
}

public class 실습과제4  {
	static void showItemsStock(Item []items) {

		//모든 아이템의 이름과 재고량, 가격 출력
		for(int i=0 ; i <items.length; i++ ) {
			items[i].show();
		}
	}
	public static void main(String[] args) {

		//Item 타입의 배열 생성

		Item[] items = new Item[4];
		//배열에 전자제품과 의류패션 객체 추가

		items[0] = new Electronics("노트북", 1500, 100, 23);
		items[1] = new Clothing("티셔츠", 50, 100, 95);
		items[2] = new Electronics("휴대폰", 800, 100, 24);
		items[3] = new Clothing("청바지", 80, 100, 90);

		//모든 아이템의 이름과 재고량, 가격 출력

		showItemsStock(items);

		//고객 생성

		Customer regularCustomer = new RegularCustomer("홍길동");
		Customer premiumCustomer = new PremiumCustomer("강감찬");

		//주문 생성 및 계산 (RegularCustomer)

		Order regularOrder = new Order(regularCustomer);
		regularOrder.addItem(items[0], 1, "240901");
		regularOrder.addItem(items[1], 2, "240902");



		regularOrder.printOrderSummary();
		regularOrder.printDiscountDetails(); // 할인된 내역 출력

		//주문 생성 및 계산 (PremiumCustomer)

		Order premiumOrder = new Order(premiumCustomer);
		premiumOrder.addItem(items[1], 1, "240901");
		premiumOrder.addItem(items[3], 2, "240903");

		premiumOrder.printOrderSummary();
		premiumOrder.printDiscountDetails(); // 할인된 내역 출

		//모든 아이템의 이름과 재고량, 가격 출력

		showItemsStock(items);

	}

}
