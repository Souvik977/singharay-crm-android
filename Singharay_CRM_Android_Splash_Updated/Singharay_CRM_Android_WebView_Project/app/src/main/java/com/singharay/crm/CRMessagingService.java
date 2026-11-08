package com.singharay.crm;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
public class CRMessagingService extends FirebaseMessagingService {
 @Override public void onMessageReceived(RemoteMessage message) {
  String title = message.getNotification()!=null ? message.getNotification().getTitle() : message.getData().get("title");
  String body = message.getNotification()!=null ? message.getNotification().getBody() : message.getData().get("body");
  if(title==null) title="Singharay CRM - New Job";
  if(body==null) body="আপনার কাছে নতুন Job Assign হয়েছে।";
  NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
  String channel="crm_jobs";
  if(Build.VERSION.SDK_INT>=26){nm.createNotificationChannel(new NotificationChannel(channel,"CRM Job Alerts",NotificationManager.IMPORTANCE_HIGH));}
  Notification n=new NotificationCompat.Builder(this,channel).setSmallIcon(android.R.drawable.ic_dialog_info).setContentTitle(title).setContentText(body).setStyle(new NotificationCompat.BigTextStyle().bigText(body)).setPriority(NotificationCompat.PRIORITY_HIGH).setAutoCancel(true).build();
  nm.notify((int)System.currentTimeMillis(),n);
 }
 @Override public void onNewToken(String token) {
  android.util.Log.i("SingharayFCM","FCM token refreshed: "+token);
 }
}
