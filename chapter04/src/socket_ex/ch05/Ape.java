package socket_ex.ch05;

public class Ape {
	
	static void rs(char a[]) {
		for (int i = 0; i < a.length; i++) {
			
			if (a[i] == 'B') {
				a[i] = 'C';
			} else if (i == a.length - 1) {
				a[i] = a[i - 1];
			} else {
				a[i] = a[i + 1];
			}
		}
	}

	static void pca(char a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}
	
	public static void main(String[] args) {
		char c[] = {'A', 'B', 'D', 'D', 'A', 'B', 'C'};
		rs(c);
		pca(c);
		
		System.out.println("5 + 2 = 34" + 3 + 4);
		System.out.println("5 + 2 = 34" + (3 + 4));
	}
	
}


