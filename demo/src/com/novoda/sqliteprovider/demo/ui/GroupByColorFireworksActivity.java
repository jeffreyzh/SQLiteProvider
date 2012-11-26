package com.novoda.sqliteprovider.demo.ui;

import android.content.Intent;
import android.os.Bundle;

import com.novoda.sqliteprovider.demo.domain.Firework;
import com.novoda.sqliteprovider.demo.domain.Shop;
import com.novoda.sqliteprovider.demo.ui.base.NovodaActivity;

import java.util.List;

public class GroupByColorFireworksActivity extends NovodaActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		List<Firework> fireworks = getApp().getFireworkReader().getFireworksGroupedByColor();
		
		Shop shop = new Shop("Color Shop", "C010R", fireworks);
		
		view(shop);
	}
	
	private void view(Shop shop) {
		Intent intent = new Intent(this, ViewShopActivity.class);
		intent.putExtra(ViewShopActivity.EXTRA_SHOP, shop);
		startActivity(intent);
	}
	
}