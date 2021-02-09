package test;

public class StringCal {
	IStringCal sc;
	StringCalVO vo;
	StringCal(String[] args){
		vo = new StringCalVO(args);
		/*if(args[1].equals("add")) {
			sc = new StringCal_add(vo);
		}else if(args[1].equals("sub")) {
			sc = new StringCal_sub(vo);
		}
		
		sc.docal(args); */
		System.out.println(vo.getFnum1());
	}
}
