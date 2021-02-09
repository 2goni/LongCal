package test;

public class StringCal_add implements IStringCal{
	
	public void docal(StringCalVO vo) {
		String sum ="";
		int up = 0;
		if(vo.getHasdot1() || vo.getHasdot2()) { 
			for(int i=vo.getFnum1().length()-1; i>0; i--) {
				sum = Integer.toString(Character.getNumericValue(vo.getFnum1().charAt(i)) + Character.getNumericValue(vo.getFnum2().charAt(i))+up);
				if(sum.length() > 1) {
					vo.setResult(sum.charAt(1));
					up = 1;
				}else {
					vo.setResult(sum.charAt(0));
					up = 0;
				}
			}
			vo.setResult('.');
		}
		//소수 덧셈
		for(int i=vo.getInum1().length()-1; i>=0; i--) {
			sum = Integer.toString(Character.getNumericValue(vo.getInum1().charAt(i)) + Character.getNumericValue(vo.getInum2().charAt(i))+up);
			if(sum.length() > 1) {
				vo.setResult(sum.charAt(1));
				up = 1;
			}else {
				vo.setResult(sum.charAt(0));
				up = 0;
			}
		}
		
		if(up == 1) {
			vo.setResult('1');
		}
		//정수 덧셈
	}
}