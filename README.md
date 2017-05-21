# NotePad
## 一、获取时间戳，并用日期格式显示：
#### 思路：在PROJECTION中添加时间戳的查询选项，然后继承SimpleCursorAdapter自定义新的适配器MyAdapter，重新定义数据显示形式
#### 实现代码：</br>
<img src="https://github.com/NIXM666/Lab_middle/blob/master/app/src/main/images/time.png"></br>
自定义适配器，以新格式绑定数据
<img src="https://github.com/NIXM666/Lab_middle/blob/master/app/src/main/images/myadapter.png"></br>
## 二、搜索功能
#### 实现思路：往menu/list_options_menu.xml中添加一个SearchView,然后增加SearchView事件将SearchView的事件绑定放在onCreateOptionsMenu，使用setOnQueryTextListener监听OnQueryText事件，重写OnQueryTextListener接口的两个函数onQueryTextSubmit，onQueryTextChange，参数为搜索内容。
#### 实现代码：
<img src="https://github.com/NIXM666/Lab_middle/blob/master/app/src/main/images/searchview.png"></br>
<img src="https://github.com/NIXM666/Lab_middle/blob/master/app/src/main/images/search.png">
# 实现效果截图：
<img src="https://github.com/NIXM666/Lab_middle/blob/master/app/src/main/images/S70521-101518.jpg"></br>
<img src="https://github.com/NIXM666/Lab_middle/blob/master/app/src/main/images/S70521-101554.jpg"></br>
<img src="https://github.com/NIXM666/Lab_middle/blob/master/app/src/main/images/S70521-101559.jpg"></br>
<img src="https://github.com/NIXM666/Lab_middle/blob/master/app/src/main/images/S70521-102251.jpg"></br>
