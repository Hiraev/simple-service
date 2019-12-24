package util

import model.Date
import org.junit.Assert
import org.junit.Test

class DateTest {

    @Test
    fun comparingTest() {
        Assert.assertTrue(Date.of(1, 1, 1999) < Date.of(2, 1, 1999))
        Assert.assertTrue(Date.of(1, 1, 1999) < Date.of(1, 2, 1999))
        Assert.assertTrue(Date.of(1, 1, 1999) < Date.of(1, 1, 2000))
        Assert.assertTrue(Date.of(1, 1, 2000) == Date.of(1, 1, 2000))
    }

    @Test
    fun toStringThatTeachersWantTest() {
        Assert.assertEquals(
                "01/01/2019",
                Date.of(1, 1, 2019).toStringThatTeachersWant()
        )
        Assert.assertEquals(
                "21/01/2019",
                Date.of(21, 1, 2019).toStringThatTeachersWant()
        )
        Assert.assertEquals(
                "21/12/2019",
                Date.of(21, 12, 2019).toStringThatTeachersWant()
        )
    }

    @Test
    fun parseDateTest() {
        Assert.assertEquals(
                Date.of(1, 1, 1999),
                Date.parseDate("01011999")
        )
        Assert.assertEquals(
                Date.of(11, 11, 1999),
                Date.parseDate("11111999")
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun parseDateWithIllegalArgumentTest() {
        Assert.assertEquals(
                Date.of(1, 1, 1999),
                Date.parseDate("1011999")
        )
    }

}
