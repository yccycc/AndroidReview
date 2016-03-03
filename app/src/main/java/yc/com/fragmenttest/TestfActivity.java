package yc.com.fragmenttest;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import yc.com.androidreview.R;

public class TestfActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_testf);
		findViewById(R.id.btn).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.forreplacing, new BlankFragment()).addToBackStack(null);
                fragmentTransaction.commit();
			}
		});
	}
}
