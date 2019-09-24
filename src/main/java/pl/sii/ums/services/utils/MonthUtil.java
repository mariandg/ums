package pl.sii.ums.services.utils;

//Klasa pomocnicza do pobierania nazwy miesiąca lub liczby porządkowej miesiąca
public class MonthUtil {
	
	public static int getMonthNumberFromName(String monthName) {
		
		int monthNr = 0;
		if(monthName == null) return monthNr;
		
		switch(monthName){
			case "Styczeń": monthNr = 1;break;
			case "Luty": monthNr = 2;break;
			case "Marzec": monthNr = 3;break;
			case "Kwiecień": monthNr = 4;break;
			case "Maj": monthNr = 5;break;
			case "Czerwiec": monthNr = 6;break;
			case "Lipiec": monthNr = 7;break;
			case "Sierpień": monthNr = 8;break;
			case "Wrzesień": monthNr = 9;break;
			case "Pazdziernik": monthNr = 10;break;
			case "Listopad": monthNr = 11;break;
			case "Grudzień": monthNr = 12;break;
			default: monthNr = 0;break;
		}
		return monthNr;		
	}
	
	public static String getMonthNameFromNumber(int monthNumber) {
		
		String monthName = "";
		
		switch(monthNumber){
			case 1: monthName = "Styczeń";break;
			case 2: monthName = "Luty";break;
			case 3: monthName = "Marzec";break;
			case 4: monthName = "Kwiecień";break;
			case 5: monthName = "Maj";break;
			case 6: monthName = "Czerwiec";break;
			case 7: monthName = "Lipiec";break;
			case 8: monthName = "Sierpień";break;
			case 9: monthName = "Wrzesień";break;
			case 10: monthName = "Pazdziernik";break;
			case 11: monthName = "Listopad";break;
			case 12: monthName = "Grudzień";break;
			default: monthName = "";break;
		}
		return monthName;		
	}
}
