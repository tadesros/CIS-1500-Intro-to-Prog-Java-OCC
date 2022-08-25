package project3;

import static org.junit.jupiter.api.Assertions.*;

class GeocacheTest {
    @org.junit.jupiter.api.Test
    void testConstructorAndGets() {
        //AAA convention

        //Arrange - set up the variables we need to test
        double expectedLatitude = 1.2223;
        double expectedLongitude = 3.2222;
        String expectedHint = "Nearby";
        String expectedItem = "Book";
        int expectedLikeCount = 0;

        //Act - call the code we are testing & get the values
        Geocache geocache = new Geocache(expectedLatitude,expectedLongitude,
                                         expectedHint,expectedItem);
        //Get Values
        double actualLatitude = geocache.getLatitude();
        double actualLongitude = geocache.getLongitude();
        String actualHint = geocache.getHint();
        String actualItem = geocache.getItem();
        int actualLikeCount = geocache.getLikeCount();

        //Assert - check values
        assertEquals(expectedLatitude,actualLatitude);
        assertEquals(expectedLongitude,actualLongitude);
        assertEquals(expectedHint,actualHint);
        assertEquals(expectedItem,actualItem);
        assertEquals(expectedLikeCount,actualLikeCount);
    }

    @org.junit.jupiter.api.Test
    void setItem() {
        //Arrange
        Geocache geocache = new Geocache(1.23,2.33,
                "By House", "Book");
        //Act    - call the code we are testing & get the values
        geocache.setItem("New Item");
        //Assert - check values
        assertEquals("New Item",geocache.getItem());
    }

    @org.junit.jupiter.api.Test
    void like() {
        //Arrange
        Geocache geocache = new Geocache(1.23,2.33,
                "By House", "Book");
        //Act    - call the code we are testing & get the values
        geocache.like();
        //Assert - check values
        assertEquals(1,geocache.getLikeCount());
    }

}