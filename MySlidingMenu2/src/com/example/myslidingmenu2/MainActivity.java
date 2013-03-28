package com.example.myslidingmenu2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.myslidingmenu2.view.MySlidingMenuView;
import com.ldm.myslidingmenu2.R;

public class MainActivity extends Activity implements OnClickListener{
	
	private View[] myAs = new View[5];//����
	private int selView = -1;//��ѡ�е�View��myAs�е�����
	
	private MySlidingMenuView slidingMenu;
	
	ListView list1;	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		init();
	}

	private void init() {
		
		slidingMenu = (MySlidingMenuView) findViewById(R.id.sliding_menu);
		//ʹ�ø�����ʽ������������
		//slidingMenu.setlSlidingMenuState(MySlidingMenuView.SLIDING_MENU_COVER);
		slidingMenu.setlSlidingMenuState(MySlidingMenuView.SLIDING_MENU_TILE);
		findViewById(R.id.btn1).setOnClickListener(this);
		findViewById(R.id.btn2).setOnClickListener(this);
		findViewById(R.id.btn3).setOnClickListener(this);
		findViewById(R.id.btn4).setOnClickListener(this);
		findViewById(R.id.btn5).setOnClickListener(this);
		
		//��ʼ�����沼��
		myAs[0] = findViewById(R.id.myActivity1);
		
		list1 = (ListView) myAs[0].findViewById(R.id.list1);
		
		List<Map<String, String>> data = new ArrayList<Map<String,String>>();
		for (int i = 0; i < 30; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("k", "�����б�����б�����б�����б����");
			data.add(map);
		}
		ListAdapter adapter = new SimpleAdapter(this, data, android.R.layout.simple_list_item_1, new String[]{"k"}, new int[]{android.R.id.text1});
		list1.setAdapter(adapter);
		
		myAs[1] = findViewById(R.id.myActivity2);
		myAs[2] = findViewById(R.id.myActivity3);
		
		myAs[3] = findViewById(R.id.myActivity4);
		myAs[4] = findViewById(R.id.myActivity5);
		
		myAs[0].setVisibility(View.VISIBLE);//Ĭ����ʾ��һҳ
		selView = 0;//��������
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			startActivity1();
			break;
		case R.id.btn2:
			startActivity2();
			break;
		case R.id.btn3:
			startActivity3();
			break;
		case R.id.btn4:
			startActivity4();
			break;
		case R.id.btn5:
			startActivity5();
			break;
		default:
			break;
		}
	}

	/**
	 * ���ݾ������������Ӧ�Ĵ���
	 * �˴�Ӧ����service��
	 * Ϊ�˷��� �Ҿͷ�����
	 */
	private void startActivity1(){
		switchView(selView, 0);
		slidingMenu.closeMenu();//�رղ˵�
	}

	private void startActivity2(){
		switchView(selView, 1);
		slidingMenu.closeMenu();
	}
	
	private void startActivity3(){
		switchView(selView, 2);
		slidingMenu.closeMenu();
	}
	
	private void startActivity4(){
		switchView(selView, 3);
		slidingMenu.closeMenu();
	}
	
	private void startActivity5(){
		switchView(selView, 4);
		slidingMenu.closeMenu();
	}
	
	/**
	 * �л����沼����ʾ�����Ը���������ʡ��
	 */
	private void switchView(final int oldIndex, final int newIndex) {
		if(oldIndex != -1){
			myAs[oldIndex].setVisibility(View.GONE);
		}
		myAs[newIndex].setVisibility(View.VISIBLE);
		selView = newIndex;//ά��ѡ�в�������
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			System.out.println("---------------openmenu111111");
			slidingMenu.openMenu();
		} else if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0 && !MySlidingMenuView.menuclose) {
			slidingMenu.closeMenu();
			return false;
		}
				
		return super.onKeyDown(keyCode, event);
	}
	
	
	
}
