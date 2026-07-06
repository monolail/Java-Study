class Tv{
    String color;
    boolean power;
    int channel;

    void power() { power = !power; }
    void channelup() { channel += 1; }
    void channeldown() { channel -= 1; }


}

public class Ex06_2 {
    public static void main(String[] args) {
        Tv myTv = new Tv();
        myTv.color = "black";
        myTv.channel = 7;
        myTv.power();
        myTv.channelup();

        System.out.println("The current channel is " + myTv.channel);
    }
}
