// 매개변수의 다형성

class Product {
    int price; // 제품 가격
    int bonusPoint; // 제품 구매시 제공되는 보너스

    Product(int price){
        this.price = price;
        bonusPoint = (int)(price / 10.0);
    }
}

class Tv1 extends Product{
    Tv1(){
        super(100); // Tv의 가격을 100만원으로 설정
    }

    public String toString(){return "Tv";} 
}

class Computer extends Product{

    public Computer() {
        super(200);
    }
    public String toString(){return "Computer";}
}


class Buyer {
    int money = 1000; // 소유 금액
    int bonusPoint = 0; // 보너스 점수

    void buy(Product p) {
        if (money < p.price) {
            System.out.println("잔액 부족으로 물건 구매 불가능.");
            return;
        }
        money -= p.price;
        bonusPoint += p.bonusPoint;
        System.out.println(p+ "을/를 구매하였습니다.");
    }
}

public class Ex7_08 {
    public static void main(String[] args) {
        Buyer b = new Buyer();

        b.buy(new Tv1());
        b.buy(new Computer());

        System.out.println("현재 잔금은 " + b.money +"만원입니다.");
        System.out.println("현재 보너스점수는 " + b.bonusPoint +"점입니다.");
    }
}
