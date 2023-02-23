package interviewsExercises;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;


/*
 * Given a String with description of different meeting along the week, return the hiest free space between them in minutes and after which meeting it start, 
 * the free space can start on monday 00:01 and finish until sunday at 24:59, in addition a free space can be share it between one day and the next day
 */



public class EncoraIterview {

	public static void main(String[] args) {
		
		String schedule = "Mon 01:00-23:00\r\n"
						+ "Tue 01:00-23:00\r\n"
						+ "Wed 01:00-23:00\r\n"
						+ "Thu 01:00-23:00\r\n"
						+ "Fri 01:00-23:00\r\n"
						+ "Sat 01:00-23:00\r\n"
						+ "Sun 01:00-21:00" ;
			
		Solution s = new Solution(); 
		s.solution(schedule);
	}

	
	static class Solution {
	    
		public long solution(String S) {
			
			List<String> meetings =  Arrays.asList( S.replace("\\r", "").split("\\n") );	    	
			List<Meeting> meetingsObj =  new ArrayList<Meeting>();
			
			long maxDiff = 0l;
			Date temp = new GregorianCalendar(2023, Calendar.JANUARY, 2, 0, 0 ).getTime(); // monday at 00:00 hrs
			Date lastTemp = new GregorianCalendar(2023, Calendar.JANUARY, 8, 24, 00 ).getTime(); // sunday at 24:00 hrs
			
			
			for (String meeting : meetings) {
				meetingsObj.add( new Meeting(meeting) );
			}
			
			meetingsObj.sort( Comparator.comparing( Meeting :: getIni  ) );
			List<Space> e = new ArrayList<Space>();
		
			for (Meeting m : meetingsObj) {
				
				e.add( new Space(temp,  Math.abs( m.getIni().getTime() - temp.getTime()  )  )   );
			  	
				maxDiff = Math.max( Math.abs( m.getIni().getTime() - temp.getTime()  ) , maxDiff);   
				temp = m.getFin();
				
			}	
			
			// one more last iteration for comparing last result with sunday at 24:00
			maxDiff = Math.max( Math.abs( lastTemp.getTime() - temp.getTime()  ) , maxDiff);  
			
			e.add( new Space(temp,  Math.abs( lastTemp.getTime() - temp.getTime()  )  )   );
			
			
			for (Space space : e) {
				if( space.getMinutes() == maxDiff ) {
					
					  Format f = new SimpleDateFormat("EEEE HH:mm");
				      String strResult = f.format(  space.getFecha()  );
					
					System.out.println( "max minutes difference: " + TimeUnit.MINUTES.convert(space.getMinutes(), TimeUnit.MILLISECONDS) + " minutes and is after " + strResult );
				}
			}
			
			
			System.out.println( "max minutes difference: " + TimeUnit.MINUTES.convert(maxDiff, TimeUnit.MILLISECONDS) + " minutes" );
			
	    	return TimeUnit.MINUTES.convert(maxDiff, TimeUnit.MILLISECONDS);
	    }
	}
	
	static class Meeting {

		private Date ini = null; 
		private Date fin = null;
		
		public Meeting(String schedule) {
		
			List<String> hrs =  Arrays.asList( schedule.substring(4).trim().split("-") );	
			
			if(schedule.contains("Mon")) {
				ini = new GregorianCalendar(2023, Calendar.JANUARY, 2, Integer.valueOf( hrs.get(0).split(":")[0]), Integer.valueOf( hrs.get(0).split(":")[1]) ).getTime();
				fin = new GregorianCalendar(2023, Calendar.JANUARY, 2, Integer.valueOf( hrs.get(1).split(":")[0]), Integer.valueOf( hrs.get(1).split(":")[1])).getTime();
					
			}
			else if(schedule.contains("Tue")) {

				ini = new GregorianCalendar(2023, Calendar.JANUARY, 3, Integer.valueOf( hrs.get(0).split(":")[0]), Integer.valueOf( hrs.get(0).split(":")[1]) ).getTime();
				fin = new GregorianCalendar(2023, Calendar.JANUARY, 3, Integer.valueOf( hrs.get(1).split(":")[0]), Integer.valueOf( hrs.get(1).split(":")[1])).getTime();
				
			}
			else if(schedule.contains("Wed")) {
				ini = new GregorianCalendar(2023, Calendar.JANUARY, 4, Integer.valueOf( hrs.get(0).split(":")[0]), Integer.valueOf( hrs.get(0).split(":")[1]) ).getTime();
				fin = new GregorianCalendar(2023, Calendar.JANUARY, 4, Integer.valueOf( hrs.get(1).split(":")[0]), Integer.valueOf( hrs.get(1).split(":")[1])).getTime();
				
			}
			else if(schedule.contains("Thu")) {
				ini = new GregorianCalendar(2023, Calendar.JANUARY, 5, Integer.valueOf( hrs.get(0).split(":")[0]), Integer.valueOf( hrs.get(0).split(":")[1]) ).getTime();
				fin = new GregorianCalendar(2023, Calendar.JANUARY, 5, Integer.valueOf( hrs.get(1).split(":")[0]), Integer.valueOf( hrs.get(1).split(":")[1])).getTime();
				
			}
			else if(schedule.contains("Fri")) {
				ini = new GregorianCalendar(2023, Calendar.JANUARY, 6, Integer.valueOf( hrs.get(0).split(":")[0]), Integer.valueOf( hrs.get(0).split(":")[1]) ).getTime();
				fin = new GregorianCalendar(2023, Calendar.JANUARY, 6, Integer.valueOf( hrs.get(1).split(":")[0]), Integer.valueOf( hrs.get(1).split(":")[1])).getTime();
			}
			else if(schedule.contains("Sat")) {
				ini = new GregorianCalendar(2023, Calendar.JANUARY, 7, Integer.valueOf( hrs.get(0).split(":")[0]), Integer.valueOf( hrs.get(0).split(":")[1]) ).getTime();
				fin = new GregorianCalendar(2023, Calendar.JANUARY, 7, Integer.valueOf( hrs.get(1).split(":")[0]), Integer.valueOf( hrs.get(1).split(":")[1])).getTime();
			}
			else if(schedule.contains("Sun")) {
				ini = new GregorianCalendar(2023, Calendar.JANUARY, 8, Integer.valueOf( hrs.get(0).split(":")[0]), Integer.valueOf( hrs.get(0).split(":")[1]) ).getTime();
				fin = new GregorianCalendar(2023, Calendar.JANUARY, 8, Integer.valueOf( hrs.get(1).split(":")[0]), Integer.valueOf( hrs.get(1).split(":")[1])).getTime();
			}
		}

		public Date getIni() {
			return ini;
		}

		public void setIni(Date ini) {
			this.ini = ini;
		}

		public Date getFin() {
			return fin;
		}

		public void setFin(Date fin) {
			this.fin = fin;
		}
		
	}
	
	static class Space { 
		
		private Date fecha;
		
		private long minutes;
		
		

		public Space(Date fecha, long minutes) {
			this.fecha = fecha;
			this.minutes = minutes;
		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}

		public long getMinutes() {
			return minutes;
		}

		public void setMinutes(long minutes) {
			this.minutes = minutes;
		}
		
	}

}




