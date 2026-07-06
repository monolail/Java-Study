public class Ex06_3 {

    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card();

        c1.kind = "Heart";
        c1.number = 7;

        c2.kind = "Spade";
        c2.number = 4;

        System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
        System.out.println("c2은 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");
        

        // 클래스 변수는 모든 인스턴스가 공유하므로, c1과 c2의 width와 height는 동일하다.
        Card.width = 50;
        Card.height = 125;

        System.out.println("카드 크기 변화 후 : " + "c1은 (" + c1.width + ", " + c1.height + ")이며, c2은 (" + c2.width + ", " + c2.height + ")");
    }


    
}

class Card{

    String kind;
    int number;
    static int width = 100;
    static int height = 250;

}