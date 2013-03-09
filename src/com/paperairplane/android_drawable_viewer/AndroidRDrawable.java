package com.paperairplane.android_drawable_viewer;
import android.app.Activity;  
import android.content.Context;  
import android.os.Bundle;  
import android.view.*;  
import android.widget.*;  
import android.widget.AdapterView.*;  
  
public class AndroidRDrawable extends Activity {  
      
    private AndroidRDrawable ard=this;  
    private LinearLayout mainView=null;  
    private TextView tv=null;  
    private GridView gv=null;  
    private int id=0x01080000;  
      
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        mainView=new LinearLayout(this);  
        mainView.setOrientation(LinearLayout.VERTICAL);  
        tv=new TextView(this);  
        tv.setText("这里显示图标名称和id及其尺寸");  
        gv_init();  
        mainView.addView(tv);  
        mainView.addView(gv);  
        setContentView(mainView);  
    }  
      
    /*gv初始化*/  
    void gv_init(){  
        gv=new GridView(this);  
        GridView.LayoutParams lp=new GridView.LayoutParams(-1,-1);  
        gv.setLayoutParams(lp);  
        gv.setNumColumns(GridView.AUTO_FIT);  
        gv.setVerticalSpacing(10);  
        gv.setHorizontalSpacing(10);  
        gv.setAdapter(new ImageAdapter(this));  
        gv.setFocusableInTouchMode(true);  
        gv.setOnItemClickListener(new OnItemClickListener(){  
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {  
                tv.setText("图标名称："+ard.getResources().getResourceEntryName(0x01080000+arg2)+"\n");  
                tv.append("图标Id：0x"+Integer.toHexString(0x10800000+arg2)+"\n");  
                tv.append("图标大小:"+arg1.getWidth()+"x"+arg1.getHeight()+"\n");  
            }  
        });  
        gv.setOnItemSelectedListener(new OnItemSelectedListener(){  
            public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {  
                tv.setText("图标名称："+ard.getResources().getResourceEntryName(0x01080000+arg2)+"\n");  
                tv.append("图标Id：0x"+Integer.toHexString(0x10800000+arg2)+"\n");  
                tv.append("图标大小:"+arg1.getWidth()+"x"+arg1.getHeight()+"\n");  
            }  
            public void onNothingSelected(AdapterView<?> arg0) {  
              
            }  
        });  
    }  
      
    class MyThread extends Thread{  
          
    }  
      
    /*ImageAdapter*/  
    public class ImageAdapter extends BaseAdapter {  
  
        private Context context;  
          
        public ImageAdapter(Context c) {context = c;}  
          
        public int getCount() {return 152;}  
        public Object getItem(int position) {return position;}  
        public long getItemId(int position) {return position;}  
  
        public View getView(int position, View convertView, ViewGroup parent) {  
            ImageView iv = new ImageView(context);  
            iv.setLayoutParams(new GridView.LayoutParams(-2,-2));  
            id=0x01080000+position;  
            iv.setImageResource(id);  
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);  
            return iv;  
        }  
    }  
}  
