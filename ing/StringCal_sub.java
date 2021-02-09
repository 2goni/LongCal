package test;

public class StringCal_sub implements IStringCal {

	public void docal(StringCalVO vo) {
		String maxinum = vo.getInum1();
		String maxfnum = vo.getFnum1();
		String mininum = vo.getInum2();
		String minfnum = vo.getFnum2();
		int same = 0;
		String sum = "";
		int up = 0;

		for (int i = 0; i < vo.getInum1().length(); i++) {
			same = vo.getInum1().charAt(i) - vo.getInum2().charAt(i);
			if (same > 0) {
				maxinum = vo.getInum1();
				maxfnum = vo.getFnum1();
				mininum = vo.getInum2();
				minfnum = vo.getFnum2();
				break;
			} else if (same < 0) {
				maxinum = vo.getInum2();
				maxfnum = vo.getFnum2();
				mininum = vo.getInum1();
				minfnum = vo.getFnum1();
				vo.setminus(true);
				break;
			}
		}
		// 정수자리 큰수 찾기

		if (vo.getHasdot1() || vo.getHasdot2()) {
			if (same == 0) {
				for (int i = 1; i < vo.getFnum1().length(); i++) {
					same = vo.getFnum1().charAt(i) - vo.getFnum2().charAt(i);
					if (same > 0) {
						maxinum = vo.getInum1();
						maxfnum = vo.getFnum1();
						mininum = vo.getInum2();
						minfnum = vo.getFnum2();
						break;
					} else if (same < 0) {
						maxinum = vo.getInum2();
						maxfnum = vo.getFnum2();
						mininum = vo.getInum1();
						minfnum = vo.getFnum1();
						vo.setminus(true);
						break;
					}
				}
			}
			// 소수자리 큰수 찾기
			for (int i = vo.getFnum1().length() - 1; i > 0; i--) {
				sum = Integer.toString(Character.getNumericValue(maxfnum.charAt(i))
						- Character.getNumericValue(minfnum.charAt(i)) + up);
				if (sum.length() > 1) {
					vo.setResult(Integer.toString(Integer.parseInt(sum) + 10).charAt(0));
					up = -1;
				} else {
					vo.setResult(sum.charAt(0));
					up = 0;
				}
			}
			vo.setResult('.');
		}
		// 소수자리 뺄셈
		for (int i = vo.getInum1().length() - 1; i >= 0; i--) {
			sum = Integer.toString(
					Character.getNumericValue(maxinum.charAt(i)) - Character.getNumericValue(mininum.charAt(i)) + up);
			if (sum.length() > 1) {
				vo.setResult(Integer.toString(Integer.parseInt(sum) + 10).charAt(0));
				up = -1;
			} else {
				vo.setResult(sum.charAt(0));
				up = 0;
			}
		}
		// 정수자리 뺄셈
	}
}