package klimapps;
import java.util.Date;
/**
 * Created by Leko on 2019-07-04.
 */
public class IndexPrefix {
 //   public Date date = new Date();

//    public static void main(String[] args) {
//        Date d=new Date();
//
//
//        System.out.println("The month number is: " + getMonthNumber() );
//        System.out.println("Two last digits of the year are: " + getTwoLastDigitsOfTheYear());
//    }


    public static int getTwoLastDigitsOfTheYear() {
        Date date = new Date();
        int twoLastDigits = date.getYear()-100;
        return  twoLastDigits;
    }
    public static int getMonthNumber() {
        Date date = new Date();
        int monthNumber = date.getMonth()+1;
        return monthNumber;
    }

    public static String dateToIndexPrefix() {
      Integer year = getTwoLastDigitsOfTheYear();
      Integer month = getMonthNumber();
        String indexPrefix = year.toString() +"-"+ month.toString()+"-";
        return indexPrefix;
    }



}
