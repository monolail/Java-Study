
enum Direction {
    EAST, WEST, SOUTH, NORTH
}

public class Ex12_06 {
    public static void main(String[] args) {
        Direction d1 = Direction.EAST; // 열거형 타입. 상수이름
        Direction d2 = Enum.valueOf(Direction.class, "WEST"); // 열거형 타입. 상수이름
        Direction d3 = Direction.valueOf("SOUTH"); // 열거형 타입. 상
        
        System.out.println("d1=" + d1);
        System.out.println("d2=" + d2);
        System.out.println("d3=" + d3);

        System.out.println("d1==d2 ? " + (d1==d2));
        System.out.println("d1==d3 ? " + (d1==d3));
        System.out.println("d1.equals(d3) ? " + d1.equals(d3));
        System.out.println("d1.compareTo(d3) ? " + d1.compareTo(d3));
        
        switch(d1) {
            case EAST: // Direction.East라고 쓸 수 없다. 
                        // 이유 : switch문에서 case에 들어가는 값은 상수여야 하는데, Direction.EAST는 상수가 아니기 때문이다.
                System.out.println("The direction is EAST.");
                break;
            case WEST:
                System.out.println("The direction is WEST.");
                break;
            case SOUTH:
                System.out.println("The direction is SOUTH.");
                break;
            case NORTH:
                System.out.println("The direction is NORTH.");
                break;
        }

        // 열거형 멤버 추가
        Direction[] dArr = Direction.values();
        for(Direction d : dArr) {
            System.out.println(d.name() + " : " + d.ordinal());
        }
        System.out.println("ordinal=" + d1.ordinal());

        
    }
}
