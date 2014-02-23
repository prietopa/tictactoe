package net.pp.jm.tictactoe.activities;

import net.pp.jm.tictactoe.R;
import net.pp.jm.tictactoe.ia.TicTacToeController;
import net.pp.jm.tictactoe.ia.TicTacToeModel;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class BoardActivity extends Activity implements OnClickListener {

	private static TicTacToeModel model = TicTacToeModel.getInstance();
	private static TicTacToeController controller = TicTacToeController.getInstance();
	private Button[] buttons;
	
	private void initListeners() {
		buttons = new Button[9];
		buttons[0] = (Button) findViewById(R.id.button11);
		buttons[1] = (Button) findViewById(R.id.button12);
		buttons[2] = (Button) findViewById(R.id.button13);
		buttons[3] = (Button) findViewById(R.id.button21);
		buttons[4] = (Button) findViewById(R.id.button22);
		buttons[5] = (Button) findViewById(R.id.button23);
		buttons[6] = (Button) findViewById(R.id.button31);
		buttons[7] = (Button) findViewById(R.id.button32);
		buttons[8] = (Button) findViewById(R.id.button33);

		for (Button btn : buttons) {
			btn.setOnClickListener(this);
		}

//		findViewById(R.id.human_vs_droid).setOnClickListener(this);
	}

	private void injectionController() {
		controller.setButtons(buttons);
//		controller.setScores((TextView) findViewById(R.id.human_score),
//				(TextView) findViewById(R.id.droid_score));
	}

	private void doMove(Button btn) {
		switch (btn.getId()) {
		case R.id.button11:
			model.doMove(0, 0);
			break;
		case R.id.button12:
			model.doMove(0, 1);
			break;
		case R.id.button13:
			model.doMove(0, 2);
			break;
		case R.id.button21:
			model.doMove(1, 0);
			break;
		case R.id.button22:
			model.doMove(1, 1);
			break;
		case R.id.button23:
			model.doMove(1, 2);
			break;
		case R.id.button31:
			model.doMove(2, 0);
			break;
		case R.id.button32:
			model.doMove(2, 1);
			break;
		case R.id.button33:
			model.doMove(2, 2);
			break;
		}
	}

	private void newRound() {
		model.newRound();
		controller.refreshGame();
	}

	private void newGame() { 
		model.newGame();
		controller.refreshGame();
	}

	private void showAlertDialog(int status) {
		new AlertDialog.Builder(this).setTitle(R.string.message_title)
				.setMessage(status).setNeutralButton("Ok",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dlg, int sumthin) {
								newRound();
							}
						}).show();
	}

	private void showRestartDialog() {
		new AlertDialog.Builder(this).setTitle(R.string.question_title)
				.setMessage(R.string.restart_game).setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dlg, int sumthin) {
								newGame();
							}
						}).setNegativeButton("No", null).show();
	}
	
	private void showWinToastDialog(String msg) {
		Toast.makeText(getApplicationContext(), msg,Toast.LENGTH_LONG).show();
		newRound();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.l_board);
		initListeners();
		injectionController();
		controller.refreshGame();
	} 
	
	public void onClick(View v) {
		if (v instanceof Button) {
			doMove((Button) v);
			controller.refreshGame();
			if (model.getState() == TicTacToeModel.STATE_DRAW)
				showAlertDialog(R.string.draw_game);
			else if (model.getState() == TicTacToeModel.STATE_WIN) {
				if (model.getWinner() == TicTacToeModel.NOUGHT)
//					showAlertDialog(R.string.nought_win_game);
					showWinToastDialog("Los circulos ganan.");
				else if (model.getWinner() == TicTacToeModel.CROSS)
//					showAlertDialog(R.string.cross_win_game);
					showWinToastDialog("Las cruces ganan.");
			}

		} else if (v instanceof ImageView) {
			showRestartDialog();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.board, menu);
		return true;
	}

}
