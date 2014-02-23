package net.pp.jm.tictactoe.activities;

import net.pp.jm.tictactoe.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.l_main);

		View newGameButton = findViewById(R.id.new_game);
		newGameButton.setOnClickListener(this);

		View optionsButton = findViewById(R.id.options);
		optionsButton.setOnClickListener(this);

		View aboutButton = findViewById(R.id.about);
		aboutButton.setOnClickListener(this);

		View ayudaButton = findViewById(R.id.ayuda);
		ayudaButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.new_game: 
			//			TicTacToeModel.getInstance().newGame();
			startActivity(new Intent(this, BoardActivity.class));
			break;
		case R.id.options: 
			startActivity(new Intent(this, OptionsActivity.class));
			break;
		case R.id.about: 
			Toast.makeText(getApplicationContext(),"JMPrieto 2014 ий.",Toast.LENGTH_LONG).show();
			break;
		case R.id.ayuda: 
			startActivity(new Intent(this, HelpActivity.class));
			break;
		default:
			break;
		}
	}

}
