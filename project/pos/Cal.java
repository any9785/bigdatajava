package pos;

import java.util.Calendar;

public class Cal {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
        int mon = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);

        //System.out.println("현재시간");
        System.out.println(year + "년 "+ (mon+1)+"월 "+day+"일");
        System.out.println(hour + "시 "+ min+"분 "+sec+"초");    
        System.out.println();
        
		//System.out.println(year + "년의 몇 째 주: " + cal.get(Calendar.WEEK_OF_YEAR));
		//System.out.println(year + "년의 몇 째 주: " + cal.get(Calendar.WEEK_OF_MONTH));
		//System.out.println("오전,오후(0:오전, 1:오후): " + cal.get(Calendar.AM_PM));
		//System.out.println((mon+1) + "월 달의 마지막 날: " + cal.getActualMaximum(Calendar.DATE) ); 

  


	}
}
