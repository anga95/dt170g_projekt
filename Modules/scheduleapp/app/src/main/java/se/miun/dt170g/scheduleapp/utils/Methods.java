package se.miun.dt170g.scheduleapp.utils;

import android.icu.util.Calendar;

public class Methods {
    public static int getDaysInMonth(int monthIndex) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, monthIndex);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
