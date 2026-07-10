//package pkg1;

class Myparent{
    private int prv; // 같은 패키지
    int dft; // 같은 패키지
    protected int prt; // 같은 패키지 + 자손(다른 패키지)
    public int pub; // 접근제한 X

    public void MyparentPrint(){
        System.out.println(prv);
        System.out.println(dft);
        System.out.println(prt);
        System.out.println(pub);
    }
}

public class Ex7_05 { // pbulic 클래스의 이름과 소스파일의 이름은 동일해야한다.
    public static void main(String[] args) {
        Myparent p = new Myparent();
        // System.out.println(p.prv);  에러 발생 : prv는 같은 클래스내에서만 가능 이외 범위에선 사용 불가능.
        System.out.println(p.dft); // 가능
        System.out.println(p.prt); // 가능
        System.out.println(p.pub); // 가능
    }
    
}
