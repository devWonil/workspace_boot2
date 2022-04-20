<<<<<<< HEAD
package tenco.com.test_18;

/*
 * default 를 사용하면 인터페이스도 몸체가 있는 메소드를 만들 수 있다
 * 다중 상속이 안되기 때문에 추가 되었다
 * 어댑터 패턴보다는 좀 더 유연한 코드를 작성할 수 있다*/
public interface Moveable {
	void left();
	void right();
	public abstract void up();
	default public void down() {};
}
=======
package tenco.com.test_18;

/*
 * default 를 사용하면 인터페이스도 몸체가 있는 메소드를 만들 수 있다
 * 다중 상속이 안되기 때문에 추가 되었다
 * 어댑터 패턴보다는 좀 더 유연한 코드를 작성할 수 있다*/
public interface Moveable {
	void left();
	void right();
	public abstract void up();
	default public void down() {};
}
>>>>>>> f387059aedb0ba26e67604abb4a430ff086cc0af
