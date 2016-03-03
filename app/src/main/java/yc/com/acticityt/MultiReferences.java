package yc.com.acticityt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import yc.com.androidreview.R;

public class MultiReferences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_references);
        SoftReference<Object> dogSoft = new SoftReference<Object>(new Dog());
        Dog dd = (Dog) dogSoft.get();
        dd.say();
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
