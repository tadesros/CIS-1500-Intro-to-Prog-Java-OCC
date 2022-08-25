package project3;

public class Main {
    public static void main(String[] args) {


            Geocache myCache = new Geocache(2.0,2.0,"near","book");

            myCache.like();
            myCache.like();

        System.out.println(myCache.getLikeCount());



        }
}