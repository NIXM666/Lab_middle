# NotePad
## 一、获取时间戳，并用日期格式显示：
#### 思路：在PROJECTION中添加时间戳的查询选项，然后继承SimpleCursorAdapter自定义新的适配器MyAdapter，重新定义数据显示形式
#### 实现代码：</br>
private static final String[] PROJECTION = new String[]{  
            NotePad.Notes._ID, // 0
            NotePad.Notes.COLUMN_NAME_TITLE, // 1
            NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE // 2  //时间戳
            };
</br>自定义适配器，以新格式绑定数据
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
        create_time.setText(format.format(new Long(cursor.getString(cursor.getColumnIndex(NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE)))));
    }
</br>
## 二、搜索功能
#### 实现思路：往menu/list_options_menu.xml中添加一个SearchView,然后增加SearchView事件将SearchView的事件绑定放在onCreateOptionsMenu，使用setOnQueryTextListener监听OnQueryText事件，重写OnQueryTextListener接口的两个函数onQueryTextSubmit，onQueryTextChange，参数为搜索内容。
</br>
#### 实现代码：
public void Search(String query){
        Cursor cursor = managedQuery(
                getIntent().getData(),            // Use the default content URI for the provider.
                PROJECTION,                       // Return the note ID、title and createdate for each note.
                "`" + NotePad.Notes.COLUMN_NAME_TITLE + "` like '%" + query + "%'", // 查询语句实现搜索
                null,                             // No where clause, therefore no where column values.
                NotePad.Notes.DEFAULT_SORT_ORDER  // Use the default sort order.
        );
</br>#实现效果截图：
<img src="https://github.com/NIXM666/Lab_middle/blob/master/app/src/main/images/S70521-101518.jpg"></br>
<img src="https://github.com/NIXM666/Lab_middle/blob/master/app/src/main/images/S70521-101554.jpg"></br>
<img src="https://github.com/NIXM666/Lab_middle/blob/master/app/src/main/images/S70521-101559.jpg"></br>
<img src="https://github.com/NIXM666/Lab_middle/blob/master/app/src/main/images/S70521-102251.jpg"></br>
