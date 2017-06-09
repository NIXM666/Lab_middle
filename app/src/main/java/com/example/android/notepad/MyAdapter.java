package com.example.android.notepad;


import android.content.Context;
import android.database.Cursor;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;

/**
 * Created by 10069 on 2017/5/2.
 */
public class MyAdapter extends SimpleCursorAdapter {
    private Cursor mcursor;
    private Context mcontext;
    private LayoutInflater mInflater;
    public MyAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
        mcursor = c;
        mcontext = context;
    }

    //重写控件绑定数据的函数
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        //super.bindView(view, context, cursor);
        View convertView = null;
        if(view == null){
            convertView = mInflater.inflate(R.layout.noteslist_item,null);
        }else{
            convertView = view;
        }
        TextView title = (TextView) convertView.findViewById(android.R.id.text1);
        TextView create_time = (TextView) convertView.findViewById(R.id.time1);
        title.setText(cursor.getString(cursor.getColumnIndex(NotePad.Notes.COLUMN_NAME_TITLE)));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将时间戳转换成日期格式
        create_time.setText(format.format(
                new Long(cursor.getString(cursor.getColumnIndex(NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE))))
        );
    }
}
