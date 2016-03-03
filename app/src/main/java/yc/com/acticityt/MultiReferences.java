package yc.com.acticityt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import yc.com.androidreview.R;

public class MultiReferences extends AppCompatActivity {
    WeakReference wr;
    Dog obj;
    SoftReference<Object> dogSoft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_references);
        Dog sod = new Dog();
        dogSoft = new SoftReference<Object>(sod);
        sod = null;
        Dog dd = (Dog) dogSoft.get();
        dd.say();
        //
        obj = new Dog();
        wr = new WeakReference(obj);
        obj = null;

        //等待一段时间，obj对象就会被垃圾回收

        if (dogSoft.get()==null) {
            System.out.println("sod 已经被清除了 ");
        } else {
            System.out.println("sod 尚未被清除，其信息是 "+ dogSoft.get().toString());
        }
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dogSoft.get()==null) {
                    System.out.println("sod 已经被清除了 ");
                } else {
                    System.out.println("sod 尚未被清除，其信息是 "+ dogSoft.get().toString());
                    Dog obj = (Dog) dogSoft.get();
                    obj.say();
                }
            }
        });
    }
    public Object testSoftReference(String key){
        Object obj=null;
        Map<String, SoftReference<Object>> map=new HashMap();
        SoftReference<Object> reference=map.get(key);
        if(reference!=null){
            obj=reference.get();
            if(obj!=null){
                return obj;
            }
        }
        obj=new Dog();
        reference=new SoftReference<Object>(obj);
        map.put(key, reference);
        return obj;
    }

}
class Dog{
    public void say()
    {
        Log.i("bbb","www");
    }
}
class Cat{}
