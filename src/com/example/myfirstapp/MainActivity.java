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
	 TextView mTextView; // 定义layout中的 text view 的成员变量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //为Activity设置用户界面
      //layout 文件定义在工程的res/layout/main_activity.xml 文件中
        setContentView(R.layout.activity_main);
        //初始化成员变量TextView 以便之后我们可以操作它
        
      //  mTextView = (TextView) findViewById(R.id.text_message);
        //确保程序运行在Honeycomb 或更高版本上以使用ActionBar APIs

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
       //在主activity中，确保action bar中的app图标别实现按钮行为
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
    /* 当用户点击Send按钮时调用 */
    public void sendMessage(View view) {
    // 做一些相应按钮的操作
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
