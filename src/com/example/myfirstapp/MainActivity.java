package com.example.myfirstapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	 public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	 TextView mTextView; // ����layout�е� text view �ĳ�Ա����

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //ΪActivity�����û�����
      //layout �ļ������ڹ��̵�res/layout/main_activity.xml �ļ���
        setContentView(R.layout.activity_main);
        //��ʼ����Ա����TextView �Ա�֮�����ǿ��Բ�����
        
      //  mTextView = (TextView) findViewById(R.id.text_message);
        //ȷ������������Honeycomb ����߰汾����ʹ��ActionBar APIs

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
       //����activity�У�ȷ��action bar�е�appͼ���ʵ�ְ�ť��Ϊ
                ActionBar actionBar = getActionBar();
                actionBar.setHomeButtonEnabled(false);
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    /* ���û����Send��ťʱ���� */
    public void sendMessage(View view) {
    // ��һЩ��Ӧ��ť�Ĳ���
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	 startActivity(intent);
    }
    
    
    @Override
    public void onDestroy() {
        super.onDestroy();  // Always call the superclass

        // Stop method tracing that the activity started during onCreate()
        android.os.Debug.stopMethodTracing();
    }
}
