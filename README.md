# ZwDialog将自己常用的一些东西集成了一下，以后就懒得写了直接导依赖开心！

#### 1.对话框
![图片1](https://github.com/zengwei123/ZwDialog/blob/master/image/1.gif)
![图片1](https://github.com/zengwei123/ZwDialog/blob/master/image/2.gif)
![图片1](https://github.com/zengwei123/ZwDialog/blob/master/image/3.gif)</br>
```java
   new com.example.zwdialogs.ZwDialogUtil().determine(MainActivity.this, "提醒", "真香警告！", new DetermineListener() {
       @Override
       public void ok() {
           Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
       }
       @Override
       public void no() {
           Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
       }
  })
```
> 确定对话框 `determine(activity,标题，内容，确定按钮取消按钮的回调方法)；`
```java
   String[] strings={"123","123"};
   new com.example.zwdialogs.ZwDialogUtil().select(MainActivity.this, strings, new SelectListener() {
       @Override
       public void itemClick(int position) {
             Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();
       }

       @Override
       public void no() {
              Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
       }
  });
```
> determine(activity,标题，内容，确定按钮取消按钮的回调方法)；
