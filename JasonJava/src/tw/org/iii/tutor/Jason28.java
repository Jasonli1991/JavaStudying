package tw.org.iii.tutor;

public class Jason28 {

	public static void main(String[] args) {
//		Brad281 obj1 = new Brad281(2);
//		Brad282 obj2 = new Brad282();
		Brad283 obj3 = new Brad283();
	}

}
class  Brad281 extends Object{
	Brad281(int a) {
		//不寫的話自動呼叫 super();
		System.out.println("Brad281(int)");
	}
}

//所有建構式的{}中第一道敘述句的第一件事都必須呼叫父類別並初始化
class  Brad282 extends Brad281{
	Brad282() {
		super(3);
		System.out.println("Brad282()");
	}
}

class Brad283 extends Brad282 {
	Brad283() {
//		super();
		System.out.println("Brad283()");
	}
}
