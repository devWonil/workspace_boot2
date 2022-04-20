package ch01;

//1. 인터페이스를 선언한다
/*
 * @author 홍원일
 * 콜백 메소드 만드는 연습
 * */
public interface ICallbackBtnAction {

	public abstract void clickedAddBtn();
	// 추상메소드 추가
	public abstract void clickedMinusBtn();
	
	public abstract void turnOut100Btn();
	
	void passValue(int result);
}
