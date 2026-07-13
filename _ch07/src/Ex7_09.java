class Product2 {
    int price; // 제품 가격
    int bonusPoint; // 제품 구매시 제공되는 보너스

    Product2(int price){
        this.price = price;
        bonusPoint = (int)(price / 10.0);
    }

    Product2() {} // 기본 생성자
}

class Tv2 extends Product2{
    Tv2(){
        super(100); // Tv의 가격을 100만원으로 설정
    }

    public String toString(){return "Tv2";} 
}

class Computer2 extends Product2{

    Computer2() {
        super(200);
    }
    public String toString(){return "Computer2";}
}

class Audio2 extends Product2{

    Audio2() {
        super(50);
    }
    public String toString(){return "Audio2";}
}

class Buyer2 {
    int money = 1000; // 소유 금액
    int bonusPoint = 0; // 보너스 점수
    int i = 0;
    Product2[] cart = new Product2[10];

    void buy(Product2 p) {
        if (money < p.price) {
            System.out.println("잔액 부족으로 물건 구매 불가능.");
            return;
        }
        money -= p.price;
        bonusPoint += p.bonusPoint;
        cart[i++] = p;
        System.out.println(p+ "을/를 구매하였습니다.");
    }

    void summary(){
        int sum = 0;
        String itemlist = "";

        for (int i =0; i<cart.length;i++){
            if (cart[i]==null) break;
            sum += cart[i].price;
        }
        System.out.println("구매 물품 총 금액은 " + sum +"만원입니다.");
        System.out.println("구매 물품 종류는 " + itemlist +"만원입니다.");
    }
}

public class Ex7_09 {
    public static void main(String[] args) {
        Buyer2 b = new Buyer2();

        b.buy(new Tv2());
        b.buy(new Computer2());
        b.buy(new Audio2());
        b.summary();
    }
}
