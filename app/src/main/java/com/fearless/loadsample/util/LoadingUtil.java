package com.fearless.loadsample.util;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.fearless.loadsample.R;

/**
 * Created by Fearless on 16/8/25.
 */
public class LoadingUtil {
    public static Dialog showLoadDialog(Context context, String message) {
        Dialog mDialog;
        TextView mMessageTv;
        mDialog = new Dialog(context, R.style.dialog_nobackground_theme);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window dialogWindow = mDialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        View view = View.inflate(context, R.layout.profress_layout, null);
        mMessageTv = (TextView) view.findViewById(R.id.load_message_tv);
        mMessageTv.setText(message);
        mDialog.setContentView(view);
        dialogWindow.setGravity(Gravity.CENTER);
//        lp.width = SdkUtil.dp2px(context,80); // 宽度
//        lp.height = SdkUtil.dp2px(context,80); // 高度
//        lp.alpha = 0.5f; // 透明度
        // 当Window的Attributes改变时系统会调用此函数,可以直接调用以应用上面对窗口参数的更改,也可以用setAttributes
        // dialog.onWindowAttributesChanged(lp);
        dialogWindow.setAttributes(lp);
        return mDialog;
    }
}
