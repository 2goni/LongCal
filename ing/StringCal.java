package test;
/*
 * 뷰출력
 * 
 * 
 */
public class StringCal {
	IStringCal sc;
	StringCalVO vo;
	int rst;
	char op;

	StringCal(String[] args) {
		vo = new StringCalVO(args);
		if (args[1].equals("add")) {
			sc = new StringCal_add();
			op = '+';
		} else if (args[1].equals("sub")) {
			sc = new StringCal_sub();
			op = '-';
		}
		// 연산 판단

		sc.docal(vo);
		// 연산
		zerodel();
		// 앞뒤 0지우기
		view();
		// 뷰 출력
	}

	void view() {
		int dash = vo.getInum1().length() + vo.getFnum1().length() + 2;
		int tab = rst - (vo.getInum1().length() + vo.getFnum1().length());
		if(vo.getminus()) {
			vo.setResult('-');
		}
		System.out.println("  " + vo.getInum1() + vo.getFnum1());
		System.out.println(op + " " + vo.getInum2() + vo.getFnum2());
		for (int i = 0; i < dash; i++) {
			System.out.print("-");
		}
		System.out.println();
		for (int i = 2; i > tab; i--) {
			System.out.print(" ");
		}
		System.out.println(vo.getResult());
	}

	void zerodel() {
		rst = vo.getResult().length();
		for (int i = 0; i < vo.getInum1().length(); i++) {
			if (vo.getResult().charAt(i) != '0' || i == vo.getInum1().length() - 1) {
				vo.delResultI(i);
				break;
			}
		}
		if (vo.getHasdot1() || vo.getHasdot1()) {
			int j = vo.getResult().length();
			for (int i = j - 1; i > 0; i--) {
				if (vo.getResult().charAt(i) != '0') {
					vo.delResultF(i+1);
					if(vo.getResult().charAt(i) == '.'){
						vo.delResultF(i);
					} 
					break;
				}
			}
		}
	}
}