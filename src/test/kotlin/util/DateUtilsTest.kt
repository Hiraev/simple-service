package util

import model.Date
import org.junit.Assert
import org.junit.Test

class DateUtilsTest {

    @Test
    fun toDateTest() {
        // Regular year
        Assert.assertEquals(
                Date.of(1, 1, 2019),
                DateUtils.toDate(1, 2019)
        )
        Assert.assertEquals(
                Date.of(31, 1, 2019),
                DateUtils.toDate(31, 2019)
        )
        Assert.assertEquals(
                Date.of(1, 2, 2019),
                DateUtils.toDate(32, 2019)
        )
        Assert.assertEquals(
                Date.of(28, 2, 2019),
                DateUtils.toDate(59, 2019)
        )
        Assert.assertEquals(
                Date.of(1, 3, 2019),
                DateUtils.toDate(60, 2019)
        )
        Assert.assertEquals(
                Date.of(31, 12, 2019),
                DateUtils.toDate(365, 2019)
        )

        // Leap year
        Assert.assertEquals(
                Date.of(1, 1, 2020),
                DateUtils.toDate(1, 2020)
        )
        Assert.assertEquals(
                Date.of(31, 1, 2020),
                DateUtils.toDate(31, 2020)
        )
        Assert.assertEquals(
                Date.of(1, 2, 2020),
                DateUtils.toDate(32, 2020)
        )
        Assert.assertEquals(
                Date.of(28, 2, 2020),
                DateUtils.toDate(59, 2020)
        )
        Assert.assertEquals(
                Date.of(29, 2, 2020),
                DateUtils.toDate(60, 2020)
        )
        Assert.assertEquals(
                Date.of(1, 3, 2020),
                DateUtils.toDate(61, 2020)
        )
        Assert.assertEquals(
                Date.of(30, 12, 2020),
                DateUtils.toDate(365, 2020)
        )
        Assert.assertEquals(
                Date.of(31, 12, 2020),
                DateUtils.toDate(366, 2020)
        )

    }

    @Test
    fun daysBetweenTest() {
        Assert.assertEquals(
                0,
                DateUtils.daysBetween(
                        Date.of(1, 1, 2020),
                        Date.of(1, 1, 2020)
                )
        )
        Assert.assertEquals(
                30,
                DateUtils.daysBetween(
                        Date.of(1, 1, 2020),
                        Date.of(31, 1, 2020)
                )
        )
        Assert.assertEquals(
                31,
                DateUtils.daysBetween(
                        Date.of(1, 1, 2020),
                        Date.of(1, 2, 2020)
                )
        )
        Assert.assertEquals(
                60,
                DateUtils.daysBetween(
                        Date.of(1, 1, 2020),
                        Date.of(1, 3, 2020)
                )
        )
        Assert.assertEquals(
                59,
                DateUtils.daysBetween(
                        Date.of(1, 1, 2019),
                        Date.of(1, 3, 2019)
                )
        )
        Assert.assertEquals(
                365,
                DateUtils.daysBetween(
                        Date.of(1, 1, 2019),
                        Date.of(1, 1, 2020)
                )
        )
        Assert.assertEquals(
                366,
                DateUtils.daysBetween(
                        Date.of(1, 1, 2020),
                        Date.of(1, 1, 2021)
                )
        )
        Assert.assertEquals(
                1827,
                DateUtils.daysBetween(
                        Date.of(1, 1, 2020),
                        Date.of(1, 1, 2025)
                )
        )
    }

}
