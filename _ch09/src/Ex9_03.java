public class Ex9_03 {
    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card();

        System.out.println(c1.toString());
        System.out.println(c2.toString());

        System.out.println(c1.kind.equals(c2.kind));
    }
}

class Card{
    String kind;
    int number;

    Card(){
        this("Spade",1);
    }

    Card(String kind, int number){
        this.kind = kind;
        this.number = number;
    }
    // toString의 overriding
    public String toString() {
        return "kind" + kind +", number : "+number;
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Card)) 
            return false;
        Card c = (Card)obj;
        return this.kind.equals(c.kind) && this.number == c.number;
    }
}
