import java.io.*;

class Ex8_04 {
    public static void main(String[] args) {
        try {
            File f = createFile("Test2.txt");
            System.out.println(f.getName() + "파일 생성 완료.");

        } catch (Exception e) {
            System.out.println(e.getMessage() + "재입력해 주세요.");
        } // main 메서드 끝
    }
    static File createFile(String fileName) throws Exception {
        if (fileName == null || fileName.equals(""))
            throw new Exception("파일이름 유효하지 않습니다.");
        File f = new File(fileName);
        f.createNewFile();
        return f;
    }
}