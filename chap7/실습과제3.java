package chap7;

//Discountable 인터페이스 정의
interface Discountable {
	double getDiscountedPrice(double price);
}

//SeasonalDiscount 클래스: Discountable 인터페이스 구현
class SeasonalDiscount implements Discountable {
	private double discountRate;
	
	public SeasonalDiscount(double discountRate) {
		this.discountRate = discountRate;
	}
	public double getDiscountRate() {
	       return discountRate;
	}
	    
	@Override
	public double getDiscountedPrice(double price) {
		return price *discountRate; 
	}
}

//Item 추상 클래스
abstract class Item3 {
	private String name;    // 제품명
	private double price;   // 제품 가격
	private int stockQuantity; // 재고량
	public Item3(String name, double price, int stockQuantity) {

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
		System.out.print("name= "+name+" price= "+price);
	}

}

//Electronics 클래스: Item 클래스 상속
class Electronics3 extends Item3 {
	int madeYear;
	public Electronics3(String name, double price, int stockQuantity, int madeYear ) {
		super (name, price,stockQuantity);
		this.madeYear = madeYear;
	}
}

//Clothing 클래스: Item 클래스 상속
class Clothing3 extends Item3 {
	int size;
	public Clothing3(String name, double price, int stockQuantity, int size) {
		super(name, price,stockQuantity);
		this.size= size;
	}
}


//Order 클래스
class Order3 extends SeasonalDiscount{
	private final int N = 20;
	private Customer3 customer; // 고객명
	private Item3[] items;      // 주문 제품들
	private int[] quantities;  // 주문 제품 수량들
	private String[] orderDates; // 주문일자들 
	private int count;

	Order3(Customer3 customer)  {//Order3(Customer3 c, int capacity, double discountRate) 로 수정하여 main()에서 초기 값을 설정
		super(0.05); //시즌 할인 비율
		this.customer=customer;
		items=new Item3[N];
		quantities= new int[N];
		orderDates= new String[N];
		count=0;

	}

	
	public Customer3 getCustomer() {
		return customer;
	}

	public void setCustomer(Customer3 customer) {
		this.customer = customer;
	}

	public Item3[] getItems() {
		return items;
	}

	public void setItems(Item3[] items) {
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


	public void addItem(Item3 item, int quantity, String date) {
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


	}
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
	public void printOrderSummary() {
		System.out.println("고객:"+customer.getName());
		for(int i=0; i<count;i++) {
			items[i].show();
			System.out.println(" quantitiy="+quantities[i]);
		}
		System.out.println("Total = "+calculateTotal());
		System.out.println("dicsount="+calculateTotalDiscount());
		System.out.println("최종 금액=:"+finalTotal());

	}
	// 할인된 내역을 출력하는 메소드
	public void printDiscountDetails() {
		for(int j=0; j<count; j++)
		System.out.println(items[j].getName()+":"+"원래가격 W"+items[j].getPrice()+
				"시즌할인금액 W"+getDiscountedPrice(items[j].getPrice())+
				"고객할인금액 W"+items[j].getPrice()*customer.getDiscountRate()+
				"할인 후 가격 W"+(items[j].getPrice()-getDiscountedPrice(items[j].getPrice())
						-items[j].getPrice()*customer.getDiscountRate()));
	}
}

//Customer 추상 클래스 정의
abstract class Customer3 {
	private String name;
	
		
		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		// 할인율을 계산하는 메서드
	abstract double getDiscountRate();

	abstract double applyDiscount(double totalAmount);
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer3 extends Customer3 {
	static final double REGULARDISCOUNT_RATE = 0.03;
	
	public RegularCustomer3(String name) {
		super.setName(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    double getDiscountRate() {
        return REGULARDISCOUNT_RATE;
    }
	
	@Override
	double applyDiscount(double totalAmount) {
		// TODO Auto-generated method stub
		return totalAmount *REGULARDISCOUNT_RATE ;
	}

}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer3 extends Customer3 {
	static final double PREMIUMDISCOUNT_RATE = 0.1;

	public PremiumCustomer3(String name) {
		super.setName(name);
		// TODO Auto-generated constructor stub
	}
	@Override
    double getDiscountRate() {
        return PREMIUMDISCOUNT_RATE;
    }
	@Override
	double applyDiscount(double totalAmount) {
		// TODO Auto-generated method stub
		return totalAmount* PREMIUMDISCOUNT_RATE;
	}

}
public class 실습과제3 {
	public static void main(String[] args) {
		// 배열에 전자제품과 의류패션 객체 추가
		Item3 note = new Electronics3("노트북", 1500, 24, 23);
		Item3 clothe = new Clothing3("티셔츠", 50, 50, 95);

		// 고객 생성 
		Customer3 regularCustomer = new RegularCustomer3("홍길동");
		Customer3 premiumCustomer = new PremiumCustomer3("강감찬");
		
				
		// 주문 생성 및 계산 (RegularCustomer)
		Order3 regularOrder = new Order3(regularCustomer);
		regularOrder.addItem(note, 1, "240901");
		regularOrder.addItem(clothe, 2, "240902");

		regularOrder.printOrderSummary();
		regularOrder.printDiscountDetails();  // 할인된 내역 출력

		// 주문 생성 및 계산 (PremiumCustomer)
		Order3 premiumOrder = new Order3(premiumCustomer);
		premiumOrder.addItem(note, 1, "240901");
		premiumOrder.addItem(clothe, 2, "240903");

		premiumOrder.printOrderSummary();
		premiumOrder.printDiscountDetails();  // 할인된 내역 출력
	}
}
