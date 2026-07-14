public class Ex7_11 {
    public static void main(String[] args){
    //    Unit[] group = { new Marine(),new Tank(),new DropShip()};
        Unit[] group = new Unit[3];
        group[0] = new Marine();
        group[1] = new Tank();
        group[2] = new DropShip();
        // group의 타입은 Unit[], group[0], group[1], group[2]의 타입은 Unit
        for (int i = 0; i<group.length;i++){group[i].move(100,200);}
    }
}

abstract class Unit {
    int x,y;
    abstract void move(int x,int y);
    void stop(){}
}

class Marine extends Unit{
    void move(int x, int y){
        System.out.println("Marine[x = "+ x +", y = "+y+"]");
    }
    void stimPack(){}
}

class Tank extends Unit{
    void move(int x, int y){
        System.out.println("Tank[x = "+x+",y = "+y+"]");
    }
    void changeMode(){}
}

class DropShip extends Unit{
    void move(int x, int y){
        System.out.println("DropShip[x = "+x+",y = "+y+"]");
    }
    void load(){}
    void unload(){}
}