package com.example.isweixin;
import utils.XmppConnection;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnViewChangeListener,
		OnClickListener {
	private final String TAG = "MainActivity";
	private MyScrollLayout mScrollLayout;
	private LinearLayout[] mImageViews;
	private int mViewCount;
	private int mCurSel;// ��ǰѡ��Ľ���
	private ImageView set;
	private ImageView add;

	private TextView liaotian;
	private TextView faxian;
	private TextView tongxunlu;

	private boolean isOpen = false;

	private ListView listview1;
	private ListView listview2;
	private LinearLayout addfriend;
	// �Զ���ĵ�������
	SelectPicPopupWindow menuWindow; // ������
	SelectAddPopupWindow menuWindow2; // ������
	ArrayList<ContactP> hcList = new ArrayList<ContactP>();
	ContactAdapter hc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		//登陆
		XmppConnection.getInstance().login("test1","a");
		addfriend = (LinearLayout) findViewById(R.id.addfriend);
		liaotian = (TextView) findViewById(R.id.liaotian);
		faxian = (TextView) findViewById(R.id.faxian);
		tongxunlu = (TextView) findViewById(R.id.tongxunlu);

		listview1 = (ListView) findViewById(R.id.listView1);
		listview2 = (ListView) findViewById(R.id.listView2);

		HuihuaAdapter ha = new HuihuaAdapter(this, getHuahui()); 
		listview1.setAdapter(ha);
		listview1.setCacheColorHint(0);

		hc = new ContactAdapter(this, getContact());
		listview2.setAdapter(hc);
		listview2.setCacheColorHint(0);

		mScrollLayout = (MyScrollLayout) findViewById(R.id.ScrollLayout);
		// ���top2�������
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lllayout);
		mViewCount = mScrollLayout.getChildCount();
		// ���θ�top2���������¼�
		mImageViews = new LinearLayout[mViewCount];
		for (int i = 0; i < mViewCount; i++) {
			mImageViews[i] = (LinearLayout) linearLayout.getChildAt(i);
			mImageViews[i].setEnabled(true);
			mImageViews[i].setOnClickListener(this);
			mImageViews[i].setTag(i);
		}
		mCurSel = 1;
		mImageViews[mCurSel].setEnabled(false);
		mScrollLayout.SetOnViewChangeListener(this);

		set = (ImageView) findViewById(R.id.set);
		add = (ImageView) findViewById(R.id.add);

		set.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				uploadImage(MainActivity.this);
			}
		});
		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				uploadImage2(MainActivity.this);
			}
		});
		addfriend.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,Addfriend.class);
				startActivity(intent);
				
			}
		});
	}
	public void addcontact(String name)
	{
		ContactP cc = new ContactP();
		cc.setTxPath(R.drawable.abc_ab_bottom_solid_dark_holo+"");
		cc.setName(name);
		hcList.add(cc);
		hc.notifyDataSetChanged();
	}
	public void removecontact(String name)
	{
		ContactP cc = new ContactP();
		cc.setTxPath(R.drawable.abc_ab_bottom_solid_dark_holo+"");
		cc.setName(name);
		hcList.remove(cc);
		hc.notifyDataSetChanged();
	}
	private ArrayList<ContactP> getContact() {
		
		ContactP c0 = new ContactP();
		c0.setTxPath(R.drawable.bind_mcontact_reco_friends + "");
		c0.setName("�����");

		ContactP c1 = new ContactP();
		c1.setTxPath(R.drawable.brand_default_head + "");
		c1.setName("΢�Ų����˺�");

		ContactP c2 = new ContactP();
		c2.setTxPath(R.drawable.bind_qq_icon + "");
		c2.setName("QQ�Ŷ�");

		ContactP c3 = new ContactP();
		c3.setTxPath(R.drawable.icon + "");
		c3.setName("΢���Ŷ�");

		ContactP c4 = new ContactP();
		c4.setTxPath(R.drawable.xiaohei + "");
		c4.setName("С��");

		ContactP c5 = new ContactP();
		c5.setTxPath(R.drawable.voip_camerachat + "");
		c5.setName("��������");

		ContactP c6 = new ContactP();
		c6.setTxPath(R.drawable.searadd_icon + "");
		c6.setName("ɵ�Ʋ���");

		ContactP c7 = new ContactP();
		c7.setTxPath(R.drawable.personactivity_cover_heart + "");
		c7.setName("Ф��");

		ContactP c8 = new ContactP();
		c8.setTxPath(R.drawable.headshow2 + "");
		c8.setName("��������");

		ContactP c9 = new ContactP();
		c9.setTxPath(R.drawable.headshow3 + "");
		c9.setName("EatEvery");

		ContactP c10 = new ContactP();
		c10.setTxPath(R.drawable.headshow4 + "");
		c10.setName("����");

		ContactP c11 = new ContactP();
		c11.setTxPath(R.drawable.headshow5 + "");
		c11.setName("������");

		ContactP c12 = new ContactP();
		c12.setTxPath(R.drawable.headshow6 + "");
		c12.setName("Diacker");

		ContactP c13 = new ContactP();
		c13.setTxPath(R.drawable.headshow1 + "");
		c13.setName("����");

		hcList.add(c0);
		hcList.add(c1);
		hcList.add(c2);
		hcList.add(c3);
		hcList.add(c4);
		hcList.add(c5);
		hcList.add(c6);
		hcList.add(c7);
		hcList.add(c8);
		hcList.add(c9);
		hcList.add(c10);
		hcList.add(c11);
		hcList.add(c12);
		hcList.add(c13);

		return hcList;
	}

	private ArrayList<HuiHua> getHuahui() {
		ArrayList<HuiHua> hhList = new ArrayList<HuiHua>();
		HuiHua h1 = new HuiHua();
		h1.setTxPath(R.drawable.icon + "");
		h1.setName1("Ф��");
		h1.setLastContent("����Ψһһ���������");
		h1.setLastTime("���� 18:00");

		HuiHua h2 = new HuiHua();
		h2.setTxPath(R.drawable.xiaohei + "");
		h2.setName1("С��");
		h2.setLastContent("�Ҵ�������ĺڰ��У���ϲ�����ɹ��������");
		h2.setLastTime("���� 17:40");

		HuiHua h3 = new HuiHua();
		h3.setTxPath(R.drawable.searadd_icon + "");
		h3.setName1("ɵ�Ʋ���");
		h3.setLastContent("ɵ�Ʋ��ޣ�վ�����¸ҵ�ߣ");
		h3.setLastTime("���� 17:00");

		HuiHua h4 = new HuiHua();
		h4.setTxPath(R.drawable.voip_camerachat + "");
		h4.setName1("���ٵ�����");
		h4.setLastContent("�Ӵ˲��ٵ����ޣ���Ҫ������");
		h4.setLastTime("���� 16:22");

		HuiHua h5 = new HuiHua();
		h5.setTxPath(R.drawable.headshow2 + "");
		h5.setName1("��������");
		h5.setLastContent("�紵�ú����£���Ʈ�����ϱߵ����");
		h5.setLastTime("���� 16:11");

		HuiHua h6 = new HuiHua();
		h6.setTxPath(R.drawable.headshow3 + "");
		h6.setName1("EatEvery");
		h6.setLastContent("Don't look me, I will eat you, Are you know");
		h6.setLastTime("���� 15:08");

		HuiHua h7 = new HuiHua();
		h7.setTxPath(R.drawable.headshow4 + "");
		h7.setName1("����");
		h7.setLastContent("û����ô��Čţ��Ͳ�ҪװB");
		h7.setLastTime("���� 15:01");

		HuiHua h8 = new HuiHua();
		h8.setTxPath(R.drawable.headshow5 + "");
		h8.setName1("������");
		h8.setLastContent("�Ҿ�����ôһ���ˣ�����ϲ��һ���ˣ������ǲ���һ����");
		h8.setLastTime("���� 14:50");

		HuiHua h9 = new HuiHua();
		h9.setTxPath(R.drawable.headshow6 + "");
		h9.setName1("Diacker");
		h9.setLastContent("this is very good fill");
		h9.setLastTime("���� 14:00");

		HuiHua h0 = new HuiHua();
		h0.setTxPath(R.drawable.headshow1 + "");
		h0.setName1("����漱");
		h0.setLastContent("���Ǹ�ϲ���͵��ˣ���������һ��Ҫ�������ҵ����֣��ٸ���˵��");
		h0.setLastTime("���� 12:00");

		hhList.add(h1);
		hhList.add(h2);
		hhList.add(h3);
		hhList.add(h4);
		hhList.add(h5);
		hhList.add(h6);
		hhList.add(h7);
		hhList.add(h8);
		hhList.add(h9);
		hhList.add(h0);
		return hhList;
	}

	public void uploadImage(final Activity context) {
		menuWindow = new SelectPicPopupWindow(MainActivity.this, itemsOnClick);
		// ��ʾ����
		View view = MainActivity.this.findViewById(R.id.set);
		// ��������ƫ����
		int xoffInPixels = menuWindow.getWidth() - view.getWidth() + 10;
		menuWindow.showAsDropDown(view, -xoffInPixels, 0);
	}

	public void uploadImage2(final Activity context) {
		menuWindow2 = new SelectAddPopupWindow(MainActivity.this, itemsOnClick2);
		// ��ʾ����
		View view = MainActivity.this.findViewById(R.id.set);
		// ��������ƫ����
		int xoffInPixels = menuWindow2.getWidth() - view.getWidth() + 10;
		menuWindow2.showAsDropDown(view, -xoffInPixels, 0);
	}

	// Ϊ��������ʵ�ּ�����
	private OnClickListener itemsOnClick = new OnClickListener() {

		public void onClick(View v) {
			menuWindow.dismiss();
		}
	};

	// Ϊ��������ʵ�ּ�����
	private OnClickListener itemsOnClick2 = new OnClickListener() {

		public void onClick(View v) {
			menuWindow2.dismiss();
		}
	};

	private void setCurPoint(int index) {
		if (index < 0 || index > mViewCount - 1 || mCurSel == index) {
			return;
		}
		mImageViews[mCurSel].setEnabled(true);
		mImageViews[index].setEnabled(false);
		mCurSel = index;

		if (index == 0) {
			liaotian.setTextColor(0xff228B22);
			faxian.setTextColor(Color.BLACK);
			tongxunlu.setTextColor(Color.BLACK);
		} else if (index == 1) {
			liaotian.setTextColor(Color.BLACK);
			faxian.setTextColor(0xff228B22);
			tongxunlu.setTextColor(Color.BLACK);
		} else {
			liaotian.setTextColor(Color.BLACK);
			faxian.setTextColor(Color.BLACK);
			tongxunlu.setTextColor(0xff228B22);
		}
	}

	@Override
	public void OnViewChange(int view) {
		// TODO Auto-generated method stub
		setCurPoint(view);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int pos = (Integer) (v.getTag());
		setCurPoint(pos);
		mScrollLayout.snapToScreen(pos);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_MENU)) {
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
