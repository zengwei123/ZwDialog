# ZwDialog将自己常用的一些东西集成了一下，以后就懒得写了直接导依赖开心！

### 1.对话框
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
> #### 确定对话框 `determine(activity,标题，内容，确定按钮取消按钮的回调方法)；`
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
> #### 列表对话框 `select(activity,字符串集合或者数组,item按钮和取消按钮的回调方法)；`

```java
new com.example.zwdialogs.ZwDialogUtil().littie(MainActivity.this,2,"#eecccccc");
```
> #### 加载对话框 `littie(activity,第几种对话框样式,背景颜色)；`  使用的是lottie这个库，随便找了4种，值分别是[0,1,2,3]

### 2.获取屏幕的宽高
```java
new ZWindowSizeUtils().getScreenWidth(1f);  //屏幕的宽度
new ZWindowSizeUtils().getScreenHeight(1f);  //屏幕的高度
```
> #### 这个应该都看的懂，参数就是百分比

### 3.权限获取  
```java
public class MainActivity extends AppCompatActivity {
    private ZwPermissions zwPermissions;
    private  String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_PHONE_STATE};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**权限判断**/
        zwPermissions=new ZwPermissions(this, permissions,getPackageName(), new DetermineListener() {
            @Override
            public void ok() {
                Toast.makeText(MainActivity.this, "权限获取成功", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void no() {
                finish();
            }
        });
        zwPermissions.initPermission();
    }

    /**获取权限**/
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        zwPermissions.ZwRequestPermissionsResult(requestCode,permissions,grantResults);
    }
}
```
> #### 只是自己简单的集成了一下，写成了一个工具类并没有做什么其他的东西，简单的就这么使用就是了，记得在配置文件中配置

### 4.SharedPreferences工具类  
![图片1](https://github.com/zengwei123/ZwDialog/blob/master/image/1.png)</br>
![图片1](https://github.com/zengwei123/ZwDialog/blob/master/image/2.png)</br>

> #### 看图使用

### 5.图标文字
![图片1](https://github.com/zengwei123/ZwDialog/blob/master/image/3.png)</br>

> #### 经常使用这个，所以也集成了一下，就是是配了个文字图库其他，图标代码去下面这里链接看，下下来然后打开Html
https://github.com/zengwei123/ZwDialog/tree/master/image/font

### 6.获取指定大小的图片，和获取屏幕宽高中最小的 看图使用
![图片1](https://github.com/zengwei123/ZwDialog/blob/master/image/4.png)</br>

### 7.属性动画
```java
//参数介绍
/**
*  控件
*  动画执行时间
*  动画延迟时间
*  动画循环次数
*  动画循环模式
*  什么属性动画
*  属性值
*/
ZwUtil.AnimatorFloat(button,1000,0,0,-1,"scaleY",1f,0.5f);
```
> #### 不熟悉动画的可以去我博客看看
https://zengwei123.github.io/2016/11/25/Android%E5%8A%A8%E7%94%BB/
https://zengwei123.github.io/2016/11/27/Android%E5%8A%A8%E7%94%BB2/

依赖导入
module app
`implementation 'com.github.zengwei123:ZwDialog:1.6'`
projiec
allprojects {
    repositories {
       ...
        maven { url 'https://jitpack.io' }
        ...
    }
}


































