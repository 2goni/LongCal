public class StringCal {
	IStringCal sc;
	StringCalVO vo;
	char op;

	StringCal(String[] args) {
		vo = new StringCalVO(args);
		// 연산 판단
		if (args[1].equals("add")) {
			sc = new StringCal_add();
			op = '+';
		} else if (args[1].equals("sub")) {
			sc = new StringCal_sub();
			op = '-';
		}

		sc.docal(vo);
		zerodel();
		view();
	}

	// 결과창 출력 메소드
	void view() {
		int dash = vo.getInum1().length() + vo.getFnum1().length() + 2;
		if (vo.getminus()) {
			vo.setResult('-');
		}
		int tab = vo.getResult().length() - (vo.getInum1().length() + vo.getFnum1().length());
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

	// 앞뒤 0지우기 메소드
	void zerodel() {
		for (int i = 0; i < vo.getResult().length(); i++) {
			if (vo.getResult().charAt(i) != '0' || i == vo.getInum1().length() - 1) {
				break;
			}
			vo.delResultI();
		}
		if (vo.getHasdot1() || vo.getHasdot1()) {
			int j = vo.getResult().length();
			for (int i = j - 1; i > 0; i--) {
				if (vo.getResult().charAt(i) == '.') {
					vo.delResultF(i + 2);
					break;
				}
				if (vo.getResult().charAt(i) != '0') {
					vo.delResultF(i + 1);
					break;
				}
			}
		}
	}
}