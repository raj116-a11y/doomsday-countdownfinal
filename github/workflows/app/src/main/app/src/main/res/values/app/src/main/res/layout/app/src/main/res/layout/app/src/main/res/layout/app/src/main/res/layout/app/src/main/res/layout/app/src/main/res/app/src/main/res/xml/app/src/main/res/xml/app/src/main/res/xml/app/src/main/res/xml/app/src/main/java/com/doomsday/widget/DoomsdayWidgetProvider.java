package com.doomsday.widget;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;
import java.util.Calendar;
import java.util.TimeZone;

public class DoomsdayWidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int id : appWidgetIds) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_medium);
            views.setTextViewText(R.id.countdownText, getCountdown());
            appWidgetManager.updateAppWidget(id, views);
        }
    }
    public static String getCountdown() {
        Calendar target = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        target.set(2026, 11, 17, 0, 0, 0);
        long diff = target.getTimeInMillis() - System.currentTimeMillis();
        if (diff < 0) diff = 0;
        long days = diff / (24*60*60*1000);
        long hours = (diff % (24*60*60*1000)) / (60*60*1000);
        long mins = (diff % (60*60*1000)) / (60*1000);
        long secs = (diff % (60*1000)) / 1000;
        return String.format("%02d DAYS : %02d HOURS : %02d MINS : %02d SEC", days, hours, mins, secs);
    }
}
