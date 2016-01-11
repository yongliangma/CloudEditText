package cn.schope.lightning.view;

import cn.schope.lightning.utils.CheckUtils;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Toast;

//定义一个ContactCloudEditTextImpl继承自CloudEditText，覆写checkInputSpan实现校验
public class ContactCloudEditTextImpl extends CloudEditText {

	public ContactCloudEditTextImpl(Context context) {
		super(context);
	}

	public ContactCloudEditTextImpl(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ContactCloudEditTextImpl(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public boolean checkInputSpan(String showText, String returnText) {
		// 覆写checkInputSpan实现校验，校验成功返回true，校验失败返回false
		if (returnText.contains("+")) {
			Toast.makeText(getContext(), "手机号前请不要加区号", 0).show();
			return false;
		} else {
			boolean result = CheckUtils.isPhoneNumberValid(returnText);
			if (!result) {
				Toast.makeText(getContext(), "请输入一个手机号", 0).show();
			}
			return result;
		}
	}

}
