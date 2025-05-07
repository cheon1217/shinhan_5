package ch07.sec06.package1;

public class B {
	public void method() {
		A a = new A();        // O
		a.field = "value";    // O
		a.method();           // O
	}
}
