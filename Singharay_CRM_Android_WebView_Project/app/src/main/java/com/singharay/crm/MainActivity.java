package com.singharay.crm;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
public class MainActivity extends Activity {
 private WebView web;
 @Override public void onCreate(Bundle b){super.onCreate(b); web=new WebView(this); setContentView(web);
  WebSettings s=web.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true); s.setDatabaseEnabled(true); s.setGeolocationEnabled(true);
  web.setWebViewClient(new WebViewClient()); web.setWebChromeClient(new WebChromeClient(){
   @Override public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback cb){cb.invoke(origin,true,false);}
   @Override public void onPermissionRequest(PermissionRequest request){request.grant(request.getResources());}
  });
  web.loadUrl("https://singharay-crm.web.app");
 }
 @Override public void onBackPressed(){if(web!=null&&web.canGoBack())web.goBack();else super.onBackPressed();}
}
