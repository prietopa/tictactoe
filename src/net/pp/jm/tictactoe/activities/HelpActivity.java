package net.pp.jm.tictactoe.activities;

import net.pp.jm.tictactoe.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class HelpActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.l_help);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.help, menu);
		return true;
	}

}
