
package podliczto;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Konrad
 */
public class Time {
    
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy ");
    Date currentDate = new Date();
    
    private final String dayInWeek[] = {"Poniedziałek","Wtorek","Środa","Czwartek","Piątek","Sobota","Niedziela"};
    private String currentDay;
    
    public String firstDayOfCurrentWeek;
    public String lastDayOfCurrentWeek;
    private final int dayOfweek;
    long addingDays,subtractsDays;

    
    public Time() {
        this.dayOfweek = Calendar.DAY_OF_WEEK;
        calculateEdgeDays();
    }
    
    public String getToday(){
        currentDay = dayInWeek[dayOfweek-1]+ " ( " + dateFormat.format(currentDate)+")";
        return currentDay;
    }
    
    

    public void calculateEdgeDays(){
        switch(dayOfweek){
            //TODO : MAKE FUNCTION FROM CODE INSIDE CASES!!!@$!
            case 1:
                addingDays=currentDate.getTime()+7*24*60*60*1000;
                firstDayOfCurrentWeek = dateFormat.format(currentDate);
                lastDayOfCurrentWeek = dateFormat.format(new Date(addingDays));
                break;
            case 2:
                addingDays=currentDate.getTime()+6*24*60*60*1000;
                firstDayOfCurrentWeek = dateFormat.format(new Date(currentDate.getTime() - 1 * 24 * 3600 * 1000l  ));
                lastDayOfCurrentWeek = dateFormat.format(new Date(addingDays));
                break;
            case 3:
                addingDays=currentDate.getTime()+5*24*60*60*1000;
                firstDayOfCurrentWeek = dateFormat.format(new Date(currentDate.getTime() - 2 * 24 * 3600 * 1000l  ));
                lastDayOfCurrentWeek = dateFormat.format(new Date(addingDays));
                break;
            case 4:
                addingDays=currentDate.getTime()+4*24*60*60*1000;
                firstDayOfCurrentWeek = dateFormat.format(new Date(currentDate.getTime() - 3 * 24 * 3600 * 1000l  ));
                lastDayOfCurrentWeek = dateFormat.format(new Date(addingDays));
                break;
            case 5:
                addingDays=currentDate.getTime()+3*24*60*60*1000;
                firstDayOfCurrentWeek = dateFormat.format(new Date(currentDate.getTime() - 4 * 24 * 3600 * 1000l  ));
                lastDayOfCurrentWeek = dateFormat.format(new Date(addingDays));
                break;
            case 6:
                addingDays=currentDate.getTime()+2*24*60*60*1000;
                firstDayOfCurrentWeek = dateFormat.format(new Date(currentDate.getTime() - 5 * 24 * 3600 * 1000l  ));
                lastDayOfCurrentWeek = dateFormat.format(new Date(addingDays));
                break;
            case 7:
                addingDays=currentDate.getTime()+6*24*60*60*1000;
                firstDayOfCurrentWeek = dateFormat.format(new Date(currentDate.getTime() - 6 * 24 * 3600 * 1000l  ));
                lastDayOfCurrentWeek = dateFormat.format(currentDate);
                break;
            default:
        }
    
    }
    
}


