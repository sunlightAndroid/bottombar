# 简单好用的底部导航栏bottombar

## 使用步骤：

* 添加依赖：
> implementation 'com.github.sunlightAndroid:bottombar:2.0.0'

* xml布局文件中引入：
~~~
<com.eric.bottombarlibrary.view.tab.BottomTab
        android:id="@+id/bottomTab"
        android:layout_width="match_parent"
        android:layout_height="52dp"
        android:layout_gravity="bottom"
        android:background="#ffffff"  />      
  ~~~      

  
* 代码中设置：
~~~
   mBottomtab.initTab(R.color.bottom_tab_normal_text_bg, R.color.bottom_tab_select_text_bg); //每个tab字体的默认与选中状态的颜色
 
   mBottomtab
                .addTab(new TabModel.Builder()
                        .addTabText("首页")
                        .addTabNormalIcon(R.mipmap.ic_top_normal)
                        .addTabSelectedIcon(R.mipmap.ic_top_pressed)
                        .build())
                .addTab(new TabModel.Builder()
                        .addTabText("我的任务")
                        .addTabNormalIcon(R.mipmap.ic_mission_normal)
                        .addTabSelectedIcon(R.mipmap.ic_mission_pressed)
                        .build())

                .addTab(new TabModel.Builder()
                        .addTabText("个人中心")
                        .addTabNormalIcon(R.mipmap.ic_mine_normal)
                        .addTabSelectedIcon(R.mipmap.ic_mine_pressed)
                        .build())
                .setOnTabItemClickListener(new BottomTab.onTabItemClickListener() {
                    @Override
                    public void onTabItemClick(int position) {
                        switch (position) {
                            case 0:
                                Toast.makeText(MainActivity.this, "首页", Toast.LENGTH_SHORT).show();
                                break;

                            case 1:
                                Toast.makeText(MainActivity.this, "我的任务", Toast.LENGTH_SHORT).show();
                                break;

                            case 2:
                                Toast.makeText(MainActivity.this, "个人中心", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
                
                 //  mBottomtab.updataTab(1); // 切到某个tab ， 默认是0
   
