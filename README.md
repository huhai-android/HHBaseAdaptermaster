

#1.0.0版本

下面是我的博客地址，demo是集成了RXjava+retrofit+mvp,可以作为基本的代码模板进行开发
https://blog.csdn.net/qq_16177199/article/list/1


#使用方法在根目录的build.gradle中
<pre>
    <code>
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 </code>
</pre>

#在项目中build.gradle添加
<pre>
    <code>
dependencies {
	        implementation 'com.github.huhaiAndroid:HHBaseAdaptermaster:1.0.0'
	}
 </code>
</pre>

#使用方法

#1.继承BaseRecyleViewAdapter peroson是你的beann类
<pre>
    <code>

public class TestAdapter extends BaseRecyleViewAdapter<Person> {
    public TestAdapter(Context context, int layoutId, List<Person> data) {
        super(context, layoutId, data);
    }
    @Override
    protected void convert(BaseViewHolder holder, Person bean) {
        holder.setText(R.id.tv_text, bean.getName());
    }
}

</code>
</pre>

#2.设置数据，监听长按事件级点击事件
<pre>
    <code>

   TestAdapter testAdapter = new TestAdapter(MainActivity.this, R.layout.item, list);
        recyclerView.setAdapter(testAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, OrientationHelper.VERTICAL, false));
        testAdapter.setOnItemClickListner(new OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
            }
        });
        testAdapter.setOnItemLongClickListner(new OnItemLongClickListner() {
            @Override
            public void onItemLongClickListner(View v, int position) {
                Toast.makeText(MainActivity.this, "长按", Toast.LENGTH_SHORT).show();
            }
        });

 </code>
</pre>