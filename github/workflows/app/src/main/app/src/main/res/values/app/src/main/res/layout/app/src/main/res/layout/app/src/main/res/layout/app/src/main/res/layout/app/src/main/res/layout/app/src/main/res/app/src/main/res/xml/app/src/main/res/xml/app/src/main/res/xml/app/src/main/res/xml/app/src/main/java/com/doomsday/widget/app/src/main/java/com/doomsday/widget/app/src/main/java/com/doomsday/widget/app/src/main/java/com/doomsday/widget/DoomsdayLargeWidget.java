package com.doomsday.widget;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;
public class DoomsdayLargeWidget extends AppWidgetProvider {
    public void onUpdate(Context c, AppWidgetManager m, int[] ids) {
        for (int id: ids) {
            RemoteViews v = new RemoteViews(c.getPackageName(), R.layout.widget_large);
            v.setTextViewText(R.id.countdownText, DoomsdayWidgetProvider.getCountdown());
            m.updateAppWidget(id, v);
        }
    }
}
