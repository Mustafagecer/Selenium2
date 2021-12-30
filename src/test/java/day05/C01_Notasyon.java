package day05;

import org.junit.Test;

public class C01_Notasyon {
    public void ilkTestmethodu(){

        System.out.println("Ilk test methodu");
    }
    //Bu notasyonla birlikte main olmasa bile bu methodu calistirabiliriz
    //JUnit ile siradan methodlari test methodlarina donusturebiliriz

    @Test
    public void notasyonluIlkTest(){
        System.out.println("notosyonlu ilk test methodumuz");

    }

}
