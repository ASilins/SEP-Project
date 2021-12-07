package Model;

import Utils.Sorter;

/**
 * CLass for random tests
 */
public class test
{
  public static void main(String[] args)
  {
    TimeSlot s1 = new TimeSlot(820 , 180, 'm');
    TimeSlot s2 = new TimeSlot(840, 300,  'm');
    TimeSlot s3 = new TimeSlot(820, 90, 'T');
    TimeSlot s4 = new TimeSlot(1000, 90, 'm');



    System.out.println(s1.overLap(s2));
    System.out.println(s1.overLap(s3));
    System.out.println(s1.overLap(s4));
  }
}
