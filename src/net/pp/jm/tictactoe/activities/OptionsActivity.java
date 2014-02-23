package net.pp.jm.tictactoe.activities;

import net.pp.jm.tictactoe.R;
import net.pp.jm.tictactoe.ia.TicTacToeModel;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

public class OptionsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.l_options);
		initButton();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.options, menu);
		return true;
	}
	
	private void initButton() { 
		RadioButton easy = (RadioButton) findViewById(R.id.option_easy);
		easy.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				TicTacToeModel.getInstance().setDifficulty(TicTacToeModel.EASY_DIF);
			}
		});
		
		RadioButton medium = (RadioButton) findViewById(R.id.option_medium);
		medium.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				TicTacToeModel.getInstance().setDifficulty(TicTacToeModel.MEDIUM_DIF);
			}
		});
		
		RadioButton hard = (RadioButton) findViewById(R.id.option_hard);
		hard.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				TicTacToeModel.getInstance().setDifficulty(TicTacToeModel.HARD_DIF);
			}
		});
		
		switch (TicTacToeModel.getInstance().getDifficulty()) {
		case TicTacToeModel.EASY_DIF:
			easy.setChecked(true);
			break;
		case TicTacToeModel.MEDIUM_DIF:
			medium.setChecked(true);
			break;
		case TicTacToeModel.HARD_DIF:
			hard.setChecked(true);
			break;
		}
	};

}
