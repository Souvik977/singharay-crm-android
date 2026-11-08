package com.singharay.crm;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.graphics.drawable.GradientDrawable;

public class MainActivity extends Activity {
 private WebView web;
 private final int BLUE = Color.rgb(24,65,120);
 @Override public void onCreate(Bundle b){
  super.onCreate(b);
  showSplash();
  new Handler().postDelayed(new Runnable(){ public void run(){ showLoginSite(); }}, 2500);
 }
 private void showSplash(){
  LinearLayout layout=new LinearLayout(this);
  layout.setGravity(Gravity.CENTER);
  layout.setOrientation(LinearLayout.VERTICAL);
  layout.setBackgroundColor(Color.WHITE);
  ImageView logo=new ImageView(this);
  try { logo.setImageDrawable(android.graphics.drawable.Drawable.createFromStream(getAssets().open("singharay_logo.png"),null)); } catch(Exception e){}
  logo.setScaleType(ImageView.ScaleType.FIT_CENTER);
  LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams((int)(getResources().getDisplayMetrics().widthPixels*.72),(int)(getResources().getDisplayMetrics().widthPixels*.72));
  layout.addView(logo,lp);
  android.widget.TextView title=new android.widget.TextView(this);
  title.setText("Singharay CRM");
  title.setTextColor(BLUE); title.setTextSize(24); title.setGravity(Gravity.CENTER); title.setTypeface(null,1);
  LinearLayout.LayoutParams tp=new LinearLayout.LayoutParams(-2,-2); tp.topMargin=18; layout.addView(title,tp);
  android.widget.TextView sub=new android.widget.TextView(this);
  sub.setText("Home Appliances Repair & Service");
  sub.setTextColor(Color.DKGRAY); sub.setTextSize(13); sub.setGravity(Gravity.CENTER);
  layout.addView(sub);
  setContentView(layout);
 }
 private void showLoginSite(){
  web=new WebView(this); setContentView(web);
  WebSettings s=web.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true); s.setDatabaseEnabled(true); s.setGeolocationEnabled(true);
  web.setWebViewClient(new WebViewClient()); web.setWebChromeClient(new WebChromeClient(){
   @Override public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback cb){cb.invoke(origin,true,false);}
   @Override public void onPermissionRequest(PermissionRequest request){request.grant(request.getResources());}
  });
  web.loadUrl("https://singharay-crm.web.app");
 }
 @Override public void onBackPressed(){if(web!=null&&web.canGoBack())web.goBack();else super.onBackPressed();}
}
