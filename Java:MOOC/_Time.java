/*
 * AP CS MOOC
 * Term 2 - Assignment 1: Time
 * A class which represents the time of day in hours and seconds.
 */

public class Time
{
    private int hour;
    private int minute;     

    /* Complete required constructors and methods here */

    /*
    *Default constructor that sets time to 1200.  
    */ 
    public Time()
    {
        this.hour=12;
        this.minute=0;
    }

    /*
    * If h is between 1 and 23 inclusive, set the hour to h. 
    * Otherwise, set the hour to 0. If m is between 0 and 59 inclusive, 
    * set the minutes to m. Otherwise, set the minutes to 0. 
    */ 
    public Time(int h, int m)
    {
        if(h>=1&&h<=23)
        {
            this.hour=h;
        }
        else
        {
            this.hour=0;
        }
        if(m>=0&&m<=59)
        {
            minute=m;
        }
        else
        {
            this.minute=0;
        }
    }

    /* Returns the time as a String of length 4 in the format: 0819. 
    * Notice that if the hour or minute is one digit, it should 
    * print a zero first. For example, 6 should print as 06.
    */
    public String toString()
    {
        String a;
        String b;

        a=this.hour+"";
        if(a.length()==1)
            a="0".concat(a);

        b=this.minute+"";
        if(b.length()==1)
            b="0".concat(b);

        return a.concat(b);
    }
     
    /*
    * Returns the time as a String converted from military time 
    * to standard time. For example, 0545 becomes 5:45 am and 
    * 1306 becomes 1:06 pm.
    */ 
    public String convert()
    {
        String suffix=" am";
        int h=this.hour;
        if(h>=12){
            suffix=" pm";
            h-=12;
        }
        if(h==0)h=12;
        String m=this.minute+"";
        if(m.length()==1)
            m="0".concat(m);


        return Integer.toString(h)+":"+m+suffix;
    }
     
    /*
     * Advances the time by one minute. 
     * Remember that 60 minutes = 1 hour. 
     * Therefore, if your time was 0359, and you add one minute, 
     * it becomes 0400. 2359 should increment to 0000.
     */ 
    public void increment()
    {
        this.minute++;
        if(this.minute==60){
            this.minute=0;
            this.hour++;
            if(hour==24){
                hour=0;
            }
        }
    }

}