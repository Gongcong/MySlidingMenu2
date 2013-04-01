package com.capinfo.myslidingmenu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.myslidingmenu2.R;

public class UserInfo extends Activity {

	private RelativeLayout callMobile;
	private Button sendMMS;
	private Float x;
	private Float ux;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_info);
		initview();
		initData();
	}

	private void initview() {
		// TODO Auto-generated method stub
		callMobile = (RelativeLayout) findViewById(R.id.user_info_mobilenum);
		sendMMS = (Button) findViewById(R.id.send_mms);
		callMobile.setOnTouchListener(callMobileTouchListener);
		sendMMS.setOnClickListener(sendMMSClickListener);
	}

	private void initData() {
		// TODO Auto-generated method stub

	}

	private View.OnTouchListener callMobileTouchListener = new View.OnTouchListener() {

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				x = event.getX();
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				ux = event.getX();
				if (Math.abs(x - ux) > 20) {
					callMobileAnim(v);
				}
			}
			return false;
		}
	};

	private View.OnClickListener sendMMSClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			String a = "343242342";
			// TODO Auto-generated method stub
			Uri uri = Uri.parse("smsto:" + a);
			Intent it = new Intent(Intent.ACTION_SENDTO, uri);
			// it.putExtra("sms_body", "The SMS text");
			startActivity(it);
		}
	};

	/**
	 * @param v
	 */
	private void callMobileAnim(View v) {
		final Animation animation = (Animation) AnimationUtils.loadAnimation(
				v.getContext(), R.anim.item_anim);
		animation.setAnimationListener(new AnimationListener() {
			public void onAnimationStart(Animation animation) {
			}

			public void onAnimationRepeat(Animation animation) {
			}

			public void onAnimationEnd(Animation animation) {
				animation.cancel();
			}
		});
		v.startAnimation(animation);

	}

}
