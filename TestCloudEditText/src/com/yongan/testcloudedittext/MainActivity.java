package com.yongan.testcloudedittext;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import cn.schope.lightning.view.ContactCloudEditTextImpl;

public class MainActivity extends Activity {
	private ContactCloudEditTextImpl et_user_contact;
	private Button mGetAllStrings, mAddSpan;
	private TextView mShow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mGetAllStrings = (Button) findViewById(R.id.btn_getAllStrings);
		mAddSpan = (Button) findViewById(R.id.btn_addSpan);
		mShow = (TextView) findViewById(R.id.tv_show);
		et_user_contact = (ContactCloudEditTextImpl) findViewById(R.id.et_user_contact);

		mAddSpan.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				et_user_contact.addSpan("张三", "18601111111");
			}
		});
		mGetAllStrings.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				List<String> skks = et_user_contact.getAllReturnStringList();// 获得所有块的字符串集合
				String allStrings = "";
				for (int i = 0; i < skks.size(); i++) {
					allStrings = allStrings + skks.get(i) + ",";
				}
				mShow.setText(allStrings);
			}
		});
	}
}
