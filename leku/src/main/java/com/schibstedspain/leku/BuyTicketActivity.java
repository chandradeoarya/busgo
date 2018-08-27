package com.schibstedspain.leku;

/**
 * Created by anuj on 20/03/17.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.schibstedspain.leku.R;

/**
 * Created by anuj on 20/03/17.
 */

import java.security.MessageDigest;
import java.util.Formatter;


public class BuyTicketActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyticket);
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("title");
        String address = bundle.getString("address");
        String typeOf = bundle.getString("typeOf");
        TextView txtView = (TextView) findViewById(R.id.textView5);
        txtView.setText(typeOf + "\n" + title);
        TextView txtView1 = (TextView) findViewById(R.id.textView4);
        txtView1.setText(address);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
    }

    public void onClick(View v)
    {
//        Intent intent = new Intent(BuyTicketActivity.this, BuyTicketActivity1.class);
//        startActivity(intent);
//        String s = checksum("HACKATHON2017|198618|100.00|#2&[W<nJ*K\"xO_z");
//        String postData = "MERCHANTCODE=HACKATHON2017&PRN=198618&REQTIMESTAMP=20170321035430958&PURPOSE=BUS&AMOUNT=100.00&";
//        postData += "SUCCESSURL=https://7d92f504.ngrok.io&FAILUREURL=https://7d92f504.ngrok.io&CANCELURL=https://7d92f504.ngrok.io&";
//        postData += "USERNAME=Arya&USERMOBILE=8503993226&USEREMAIL=chandradeoaryaarya@gmail.com&CHECKSUM=";
//        postData += s;
//        String finalUrl = "http://emitrauat.rajasthan.gov.in/payments/v1/init?"+postData;
//        Intent browserIntent = new Intent(android.content.Intent.ACTION_VIEW,
//                Uri.parse(finalUrl));
//        startActivity(browserIntent);

//        WebView myWebView = (WebView) findViewById(R.id.webview);
        //myWebView.loadUrl("http://www.google.com");

//        myWebView.setWebViewClient(new WebViewClient(){
//
//
//            public void onPageStarted(WebView view, String url,
//                                      Bitmap favicon) {
//                super.onPageStarted(view, url, favicon);
//            }
//
//            public boolean shouldOverrideUrlLoading(WebView view,
//                                                    String url) {
//
//                myWebView.postUrl(Base_Url, postData.getBytes());
//
//                return true;
//            }
//
//        });

       // myWebView.postUrl("http://emitrauat.rajasthan.gov.in/payments/v1/init",postData.getBytes());
        ProgressDialog progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                AlertDialog alertDialog = new AlertDialog.Builder(BuyTicketActivity.this).create(); //Read Update
                alertDialog.setTitle("Ticket Booked");


                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alertDialog.show();
                progress.dismiss();
            }
        }, 3000);

    }

    public static String checksum(final String toBeEncryptString) {

        if (toBeEncryptString == null) {
            throw new IllegalArgumentException("To be encrypt string must not be null");
        }

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(toBeEncryptString.getBytes());
            byte byteData[] = md.digest();
            return byteArray2Hex(byteData);
        } catch (Exception ex) {
        }
        return "";
    }

    public static String byteArray2Hex(byte[] bytes) {

        Formatter formatter = null;
        try {
            formatter = new Formatter();
            byte[] arrayOfByte = bytes;
            int j = bytes.length;
            for (int i = 0; i < j; i++) {
                byte b = arrayOfByte[i];
                formatter.format("%02x", new Object[] {
                        Byte.valueOf(b)
                });
            }
            return formatter.toString();

        } finally {
            if(formatter != null) {
                formatter.close();
            }
        }
    }
}
