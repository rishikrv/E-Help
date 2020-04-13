package com.ehelp.service.recivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import static com.ehelp.service.home.dialog;

//import static com.keshav.networkchangereceiverexample.MainActivity.dialog;

public class NetworkChangeReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        try
        {
            if (isOnline(context)) {
                dialog(true);
                Log.e("keshav", "Online Connect Intenet ");
//                Toast.makeText(context, "Internet Connected", Toast.LENGTH_SHORT).show();
            } else {
                dialog(false);
                Log.e("keshav", "Conectivity Failure !!! ");

//                Toast.makeText(context, "Internet Connection Lost", Toast.LENGTH_SHORT).show();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            //should check null because in airplane mode it will be null
            return (netInfo != null && netInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }
}