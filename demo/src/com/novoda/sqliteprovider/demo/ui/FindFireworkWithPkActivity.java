package com.novoda.sqliteprovider.demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.novoda.sqliteprovider.demo.R;
import com.novoda.sqliteprovider.demo.domain.Firework;
import com.novoda.sqliteprovider.demo.ui.base.NovodaActivity;
import com.novoda.sqliteprovider.demo.ui.util.FromXML;

public class FindFireworkWithPkActivity extends NovodaActivity {

	private EditText primaryKeyEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_firework_with_pk);
		
		primaryKeyEditText = (EditText) findViewById(R.id.find_firework_with_pk_input_primary_key);
	}
	
	@FromXML
	public void onFindFireworkWithPkClick(View button){
		if(userHasEnteredSomething()){
			try {
				int primaryKey = getPrimaryKey();

				Firework firework = getApp().getFireworkReader().getFirework(primaryKey);
				
				view(firework);
			} catch (NumberFormatException e) {
				Toast.makeText(this, "Primary Key should be an Int", Toast.LENGTH_SHORT).show();
			}
		}
	}

	private boolean userHasEnteredSomething() {
		return !TextUtils.isEmpty(primaryKeyEditText.getText());
	}
	
	private int getPrimaryKey() throws NumberFormatException {
		return Integer.parseInt(primaryKeyEditText.getText().toString());
	}
	
	private void view(Firework firework) {
		Intent intent = new Intent(this, FireworkActivity.class);
		intent.putExtra(FireworkActivity.EXTRA_FIREWORK, firework);
		startActivity(intent);
	}
}
