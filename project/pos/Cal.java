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

        //System.out.println("����ð�");
        System.out.println(year + "�� "+ (mon+1)+"�� "+day+"��");
        System.out.println(hour + "�� "+ min+"�� "+sec+"��");    
        System.out.println();
        
		//System.out.println(year + "���� �� ° ��: " + cal.get(Calendar.WEEK_OF_YEAR));
		//System.out.println(year + "���� �� ° ��: " + cal.get(Calendar.WEEK_OF_MONTH));
		//System.out.println("����,����(0:����, 1:����): " + cal.get(Calendar.AM_PM));
		//System.out.println((mon+1) + "�� ���� ������ ��: " + cal.getActualMaximum(Calendar.DATE) ); 

  


	}
}
