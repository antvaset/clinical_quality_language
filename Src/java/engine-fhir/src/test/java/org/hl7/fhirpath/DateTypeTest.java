package org.hl7.fhirpath;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.hl7.fhir.r4.model.DateType;
import org.junit.jupiter.api.Test;

class DateTypeTest {
    @Test
    void dateType() {
        // DateType Month is zero-based (11 == December)
        DateType birthDate = new DateType(1974, 11, 25);
        assertThat(birthDate.getYear(), is(1974));
        assertThat(birthDate.getMonth(), is(11));
        assertThat(birthDate.getDay(), is(25));
    }

    @Test
    void date() {
        // NOTE: DateType uses default GMT
        java.util.Date birthDate = new DateType(1974, 11, 25).getValue();
        GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        calendar.setTime(birthDate);
        assertThat(calendar.get(Calendar.YEAR), is(1974));
        assertThat(calendar.get(Calendar.MONTH), is(11));
        assertThat(calendar.get(Calendar.DAY_OF_MONTH), is(25));
    }
}
