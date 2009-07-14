package com.rubberdroid.droidsweeper;

import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class Droidsweeper extends Activity implements OnClickListener {
	private static final String TAG = "Droidsweeper";
	private HashMap<Integer, Runnable> buttonsActions = new HashMap<Integer, Runnable>();
	public static final String KEY_DIFFICULTY = "difficulty";
	public static final int DIFFICULTY_EASY = 0;
	public static final int DIFFICULTY_SIMPLE = 1;
	public static final int DIFFICULTY_MEDIUM = 2;
	public static final int DIFFICULTY_EXPERT = 3;

	public Droidsweeper() {
		buttonsActions.put(R.id.about_button, new Runnable() {
			@Override
			public void run() {
				Intent i = new Intent(Droidsweeper.this, About.class);
				startActivity(i);
			}
		});

		buttonsActions.put(R.id.new_button, new Runnable() {
			@Override
			public void run() {
				new AlertDialog.Builder(Droidsweeper.this).setTitle(
						R.string.new_game_title).setItems(R.array.difficulty,
						new DialogInterface.OnClickListener() {
							public void onClick(
									DialogInterface dialoginterface, int i) {
								Intent intent = new Intent(Droidsweeper.this,
										Game.class);
								intent.putExtra(Droidsweeper.KEY_DIFFICULTY, i);
								startActivity(intent);
							}
						}).show();
			}
		});

		// case R.id.about_button:
		// Intent i = new Intent(this, About.class);
		// startActivity(i);
		// break;
		// case R.id.new_button:
		// openNewGameDialog();
		// break;
		// case R.id.resume_button:
		// resumeGame();
		// break;
		// case R.id.settings_button:
		// startSettingsView();
		// break;
		// }
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		addButtonsListener();
	}

	private void addButtonsListener() {
		addThisAsClickListenerTo(R.id.resume_button);
		addThisAsClickListenerTo(R.id.new_button);
		addThisAsClickListenerTo(R.id.about_button);
		addThisAsClickListenerTo(R.id.settings_button);
	}

	private void addThisAsClickListenerTo(int viewId) {
		View button = findViewById(viewId);
		button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		buttonsActions.get(v.getId()).run();
	}
}